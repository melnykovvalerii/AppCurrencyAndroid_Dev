package com.allerates.appforyou.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.allerates.appforyou.R
import com.allerates.appforyou.api.IUser
import com.allerates.appforyou.model.RegEmail
import com.allerates.appforyou.helpers.*
import com.google.gson.Gson
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpActivity : AppCompatActivity() {

    //views
    private lateinit var nameEditText: TextInputEditText
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var confirmPasswordEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar!!.hide()

        nameEditText = findViewById(R.id.textInputEditTextName)
        emailEditText = findViewById(R.id.textInputEditTextEmail)
        passwordEditText = findViewById(R.id.textInputEditTextPassword)
        confirmPasswordEditText = findViewById(R.id.textInputEditTextConfirmPassword)
    }

    fun toSignInClick(v: View) = finish()

    fun toSignUpClick(button: View) {
        if (!isFormValid())
            return
        button.isEnabled = false

        val login = nameEditText.text.toString()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        val call =
                getDefaultRetrofit().create(IUser::class.java).addUserToDB(login, email, password)

        call.enqueue(object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    val setting = Setting(this@SignUpActivity)
                    setting.userLogin.set(login)
                    setting.userMail.set(email)
                    setting.userPassword.set(password)
                    try {
                        val obj = Gson().fromJson(result.toString(), RegEmail::class.java)
                        setting.authKey.set(obj.auth_key)
                        val intent = Intent(this@SignUpActivity, ConfirmMailActivity::class.java)
                        intent.putExtra("mail", email)
                        intent.putExtra("auth_key", obj.auth_key)
                        startActivity(intent)
                    } catch (e: Exception) {
                        showToast(this@SignUpActivity, "server not answered")
                    }
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) =
                showToast(this@SignUpActivity, "no internet connection!${t.message}")
        })
    }

    private fun isFormValid(): Boolean {
        if (!isNotExistBadChars(nameEditText, false))
            nameEditText.error = "Bad chars"
        else if (!isNotExistBadChars(emailEditText, true))
            emailEditText.error = "Bad chars"
        else if (!isNotExistBadChars(passwordEditText, false))
            passwordEditText.error = "Bad chars"
        else if (!isNotExistBadChars(confirmPasswordEditText, false))
            passwordEditText.error = "Bad chars"
        else if (emailEditText.length() !in 3..30)
            emailEditText.error = "Length must be in 3..30 chars"
        else if (passwordEditText.length() !in 5..15)
            passwordEditText.error = "Lenght must be in 5..15 chars"
        else if (confirmPasswordEditText.text.toString() != passwordEditText.text.toString())
            confirmPasswordEditText.error = "Passwords is not coincide"
        else
            return true
        return false
    }

}