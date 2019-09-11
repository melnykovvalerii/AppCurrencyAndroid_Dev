package com.allerates.appforyou.activities


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.allerates.appforyou.R
import android.widget.EditText
import com.allerates.appforyou.helpers.*
import com.allerates.appforyou.model.BasicResult
import com.google.gson.Gson
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UpdatePasswordActivity : AppCompatActivity() {

    lateinit var codeEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)
        setContentView(R.layout.activity_set_password)

        codeEditText = findViewById(R.id.ed_code)
        passwordEditText = findViewById(R.id.ed_password)
        confirmPasswordEditText = findViewById(R.id.ed_password2)
    }

    fun setPasswordClick(v: View) {
        v.isEnabled = false

        if (codeEditText.text.isNullOrEmpty()) {
            codeEditText.error = "Fill code"
            return
        }
        if (isNotExistBadChars(codeEditText, false)) {
            codeEditText.error = "Code have bad chars"
            return
        }

        if (passwordEditText.text.isNullOrEmpty()) {
            passwordEditText.error = "Fill code"
            return
        }
        if (isNotExistBadChars(passwordEditText, false)) {
            passwordEditText.error = "Password have bad chars"
            return
        }

        if (passwordEditText.text.toString() != confirmPasswordEditText.text.toString()) {
            confirmPasswordEditText.error = "Password incorrect"
            return
        }


        val call = getUserAPI().setPassword(
                intent.getStringExtra("email"),
                codeEditText.text.toString(),
                passwordEditText.text.toString())

        call.enqueue(object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                v.isEnabled = true
                if (response.isSuccessful) {
                    val result = response.body()!!

                    try {
                        val obj =
                                Gson().fromJson(result.toString(), BasicResult::class.java)
                        Setting(this@UpdatePasswordActivity).userPassword.set(passwordEditText.text.toString())
                        startActivity(LoginActivity::class.java)
                    } catch (e: Exception) {
                        codeEditText.error = "Incorrect code"
                    }
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                v.isEnabled = true
                showToast(this@UpdatePasswordActivity, "no internet connection!${t.message}")
            }
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, PasswordRecoveryActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        overridePendingTransition(R.anim.open_main, R.anim.close_next)
    }

}