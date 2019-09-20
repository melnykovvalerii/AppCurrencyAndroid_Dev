package com.allerates.appforyou.activities


import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.*
import com.allerates.appforyou.model.UserInfoResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {

    //views
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar!!.hide()
    }

    private fun initGoogleAuthComponent() {

    }

    fun toGoogleClick(btn: View) {
    }

    fun toFacebookClick(v: View) {}

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

    private fun clearForm() {
        emailEditText.text.clear()
        passwordEditText.text.clear()
    }
}
