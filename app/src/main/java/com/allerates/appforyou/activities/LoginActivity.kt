package com.allerates.appforyou.activities

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.allerates.appforyou.Common
import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.*
import com.allerates.appforyou.model.RegEmail
import com.allerates.appforyou.model.User
import com.allerates.appforyou.model.UserInfoResult
import com.allerates.appforyou.request.UserDataList
import com.allerates.appforyou.request.api.GetDataUser
import com.allerates.appforyou.sql.DatabaseHelper
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.GraphRequest
import com.facebook.Profile
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.Gson
import com.google.gson.JsonElement
import org.json.JSONException
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    private var mAuth: FirebaseAuth? = null
    private var callbackManager: CallbackManager? = null

    //views
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText

    private var appCompatButtonLogin: Button? = null

    private var checkConnection: CheckConnection? = null

    private var inputValidation: InputValidation? = null
    private var databaseHelper: DatabaseHelper? = null

    private var mGoogleSignInClient: GoogleSignInClient? = null
    private var mGoogleBtn: SignInButton? = null

    private var name: String? = null
    private var email: String? = null
    private var user: User? = null
    private var id: String? = null
    private var mAuthStateListener: FirebaseAuth.AuthStateListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
        initComponents()
    }

    override fun onStart() {
        super.onStart()
        if (isUserSignIn())
            startActivity(MainActivity::class.java)
    }

    private fun initComponents() {
        //init views
        emailEditText = findViewById(R.id.textInputEditTextEmail)
        passwordEditText = findViewById(R.id.textInputEditTextPassword)


        //хрен знает че инициализирует, переписать
        FirebaseApp.initializeApp(this)
        mAuth = FirebaseAuth.getInstance()
        mAuthStateListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            if (firebaseAuth.currentUser != null)
                startActivity(AccountActivity::class.java)
        }
        //databaseHelper = DatabaseHelper(this)
        inputValidation = InputValidation(this)
        checkConnection = CheckConnection()
        user = User()


        //init fb
        try {
            FacebookSdk.sdkInitialize(applicationContext)
            // вход устанавливаем с кастомной кнопки
            callbackManager = CallbackManager.Factory.create()
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }


        //init google
        try {
            mGoogleBtn = findViewById<View>(R.id.googleBtn) as SignInButton
            val googleConfig = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.def_web_client_id))
                    .requestServerAuthCode(getString(R.string.def_web_client_id))
                    .requestEmail()
                    .build()
            mGoogleSignInClient = GoogleSignIn.getClient(this, googleConfig)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setFacebookData(loginResult: LoginResult) {
        try {
            val request = GraphRequest.newMeRequest(loginResult.accessToken)
            { _, response ->
                try {
                    email = response.jsonObject.getString(resources.getString(R.string.txt_email))
                    name = response.jsonObject.getString(resources.getString(R.string.txt_first_name))
                    postDataToSQLite(email, email, name, email)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
            val parameters = Bundle()
            parameters.putString(resources.getString(R.string.txt_fields), resources.getString(R.string.txt_some_fields))
            request.parameters = parameters
            request.executeAsync()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun toGoogleClick(btn: View) {
        if (checkConnection!!.isOnline(applicationContext)) {
            try {
                val signInIntent = mGoogleSignInClient!!.signInIntent
                startActivityForResult(signInIntent, 1)
            } catch (e: Exception) {
                Log.e(TAG, e.message)
            }
            (btn as Button).isEnabled = false
        } else
            checkConnection!!.makeToastConnection(this)
    }

    fun toFacebookClick(v: View) {
        if (checkConnection!!.isOnline(applicationContext)) {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email", "public_profile"))
            LoginManager.getInstance().registerCallback(callbackManager!!, object : FacebookCallback<LoginResult> {
                override fun onSuccess(loginResult: LoginResult) {
                    setFacebookData(loginResult)
                    showToast(this@LoginActivity, "FB sign ok!")
                }

                override fun onCancel() =
                        showToast(this@LoginActivity, R.string.txt_cancer_fb)

                override fun onError(error: FacebookException) {
                    showToast(this@LoginActivity, R.string.txt_error)
                    Log.d(TAG, "fb error: $error")
                }
            })
        } else
            checkConnection!!.makeToastConnection(this@LoginActivity)
    }

    private fun refreshIdToken() =
        mGoogleSignInClient!!.silentSignIn()
                .addOnCompleteListener(this) { task -> handleSignInResult(task) }

    // [START handle_sign_in_result]
    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            // TODO(developer): send ID Token to server and validate
            showToast(this, account.idToken!!)
        } catch (e: ApiException) {
            Log.e(TAG, "handleSignInResult:error", e)
        }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        try {
            callbackManager!!.onActivityResult(requestCode, resultCode, data)

            if (requestCode == 1) {
                // [START get_id_token]
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                handleSignInResult(task)
                refreshIdToken()

                val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
                if (!result.isSuccess)
                    showToast(this, R.string.txt_authentication_error)
            }
        } catch (e: Exception) {
            Log.e(TAG, e.message)
        }
    }


    private fun postDataToSQLite(auth: String?, email: String?, name: String?, password: String?) {
        try {
            if (!databaseHelper!!.checkUser(email)) {
                user!!.name = name
                user!!.email = email
                user!!.password = password
                user!!.id = auth
                databaseHelper!!.addUser(user!!)
                showToast(this, R.string.success_message)
            } else {
                databaseHelper!!.setUserLogedIn(true, applicationContext)
                showToast(this, R.string.error_email_exists)
            }
            clearForm()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun toRecoveryPasswordClick(v: View) = startActivity(PasswordRecoveryActivity::class.java)

    fun toSignUpClick(v: View) = startActivity(SignUpActivity::class.java)

    fun toSignInClick(v: View) {
        if (!isFormValid())
            return

        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        val call = getUserAPI().signInWithMail(email, password)

        call.enqueue(object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    if (isValidJson(result.toString(), UserInfoResult::class.java)) {

                        //startActivity()
                    }
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) =
                    showToast(this@LoginActivity, t.message!!)
        })
    }

    private fun isFormValid(): Boolean {
        if (!isNotExistBadChars(emailEditText, true))
            emailEditText.error = "Bad chars"
        else if (!isNotExistBadChars(passwordEditText, false))
            passwordEditText.error = "Bad chars"
        else if (emailEditText.length() !in 3..30)
            emailEditText.error = "Length must be in 3..30 chars"
        else if (passwordEditText.length() !in 5..15)
            passwordEditText.error = "Lenght must be in 5..15 chars"
        else
            return true
        return false
    }


    /**
     * This trimLastCharacter is to validate the input text fields and verify login credentials from SQLite
     */
    private fun verifyFromSQLite(eMail: String?, password: String?, number: Int) {
        var eMail = eMail
        var password = password
        try {
            when (number) {
                1 -> {
                    if (!inputValidation!!.isInputEditTextFilled(applicationContext, emailEditText, getString(R.string.error_message_email)))
                        return
                    if (!inputValidation!!.isInputEditTextEmail(applicationContext, emailEditText, getString(R.string.error_message_email)))
                        return
                    if (!inputValidation!!.isInputEditTextFilled(applicationContext, passwordEditText, getString(R.string.error_message_email)))
                        return

                    eMail = emailEditText.text.toString().trim { it <= ' ' }
                    password = passwordEditText.text.toString().trim { it <= ' ' }
                }
                2 -> { }
                else -> println(resources.getString(R.string.txt_inv_number))
            }
            getLog(appCompatButtonLogin, applicationContext, eMail!!, password!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun getLog(appCompatButtonRegister: Button?,
               context: Context, exMail: String, exPassword: String) {
        user = User()

        val mDialog = ProgressDialog(this)
        mDialog.setMessage(getString(R.string.wait_string))
        mDialog.setCancelable(false)
        mDialog.show()

        val mLogWithMail = Common.LogWithMail()
        mLogWithMail.mValue(exMail, exPassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ login ->

                    id = login.queryContent[0].authKey
                    if (id != null) {
                        user!!.name = login.queryContent[0].exName
                        user!!.email = exMail
                        user!!.password = exPassword
                        user!!.id = id

                        isConfirmed(user!!)
                        appCompatButtonRegister!!.isEnabled = true
                        mDialog.dismiss()
                    } else {
                        appCompatButtonRegister!!.isEnabled = true
                        Toast.makeText(context,
                                "The user is not registered or details are not right",
                                Toast.LENGTH_LONG).show()
                        mDialog.dismiss()
                    }
                },
                        { throwable ->
                            Log.e(TAG, "Error: $throwable")
                            mDialog.dismiss()
                        })
    }

    @SuppressLint("CheckResult")
    private fun isConfirmed(mUser: User) {

        val mDialog = ProgressDialog(this)
        mDialog.setMessage(resources.getString(R.string.txt_plz_wait))
        mDialog.setCancelable(false)
        mDialog.show()

        val getDataUser = Common.getUserDate()
        getDataUser.sendKey(mUser.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { userDataList ->
                    val accountsIntent: Intent
                    if (userDataList.queryContent[0].activateUser != null) {
                        val sConf = userDataList.queryContent[0].activateUser
                        if (sConf == "1") {
                            val databaseHelper = DatabaseHelper(applicationContext)
                            databaseHelper.addUser(mUser)
                            databaseHelper.setUserLogedIn(true, applicationContext)
                            Setting(this).defaultMoney.set(getString(R.string.def_currency))
                            startActivity(MainActivity::class.java)
                        } else {
                            accountsIntent = Intent(applicationContext, ActivityCheckPassword::class.java)
                            accountsIntent.putExtra("active_key", mUser.id)
                            accountsIntent.putExtra("email", mUser.email)
                            accountsIntent.putExtra("name", mUser.name)
                            accountsIntent.putExtra("password", mUser.password)
                            Setting(this).defaultMoney.set(getString(R.string.def_currency))
                            startActivity(accountsIntent)
                            showToast(this, "Mail not confirmed")
                        }
                    }
                    mDialog.dismiss()
                }, Consumer
                { throwable ->
                    showToast(this, "Error $throwable")
                    Log.e(TAG, "Mail not confirmed. $throwable")
                    mDialog.dismiss()
                })
    }

    private fun clearForm() {
        emailEditText.text.clear()
        passwordEditText.text.clear()
    }

    private fun isUserSignIn() = Setting(this).isLogged.get()
}
