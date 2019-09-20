package com.allerates.appforyou.activities


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.getUserAPI
import com.allerates.appforyou.helpers.isNotExistBadChars
import com.allerates.appforyou.helpers.showToast
import com.allerates.appforyou.model.SendRecoveryMailResult
import com.google.gson.Gson
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PasswordRecoveryActivity: AppCompatActivity() {

    lateinit var emailEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme_NoActionBar)
        setContentView(R.layout.activity_password_recognition)

        emailEditText = findViewById(R.id.ed_email)
    }

    fun sendResetMailClick(v: View) {
        when {
            emailEditText.text.isNullOrEmpty() ->
                emailEditText.error = "Fill email"
            isNotExistBadChars(emailEditText, true) ->
                emailEditText.error = "Email have bad chars"
            else -> {
                val call =
                        getUserAPI().sendRecoveryMail(emailEditText.text.toString())

                call.enqueue(object : Callback<JsonElement> {
                    override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                        if (response.isSuccessful) {
                            val result = response.body()!!
                            try {
                                val obj =
                                        Gson().fromJson(result.toString(), SendRecoveryMailResult::class.java)
                                val intent = Intent(this@PasswordRecoveryActivity, UpdatePasswordActivity::class.java)
                                intent.putExtra("email", emailEditText.text.toString())
                                startActivity(intent)
                            } catch (e: Exception) {
                                showToast(this@PasswordRecoveryActivity, "server not answered")
                            }
                        }
                    }

                    override fun onFailure(call: Call<JsonElement>, t: Throwable) =
                            showToast(this@PasswordRecoveryActivity,
                                    "no internet connection!${t.message}")
                })
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        overridePendingTransition(R.anim.open_main, R.anim.close_next)
    }

}
