package com.allerates.appforyou.activities

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.*
import com.allerates.appforyou.model.ConfirmMailResult
import com.allerates.appforyou.model.ActivateUser
import com.google.gson.Gson
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Response


class ConfirmMailActivity : AppCompatActivity() {

    lateinit var mailTextView: TextView
    lateinit var timerProgressBar: ProgressBar

    var isChecked = true

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_mail)

        timerProgressBar = findViewById(R.id.timerBar)
        mailTextView = findViewById(R.id.title)
        mailTextView.text =
                "${getString(R.string.confirm_email)}\n${intent.getStringExtra("mail")}"
    }

    fun sendConfirmMailClick(v: View) {
        v.isEnabled = false
        v.setBackgroundColor(Color.GRAY)
        isChecked = true

        val call = getUserAPI().sendConfirmMail(
                intent.getStringExtra("mail"),
                intent.getStringExtra("auth_key")
        )

        startTimer(v)
        call.enqueue(object : retrofit2.Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    try {
                        val obj =
                                Gson().fromJson(result.toString(), ConfirmMailResult::class.java)
                        showToast(this@ConfirmMailActivity, obj.message)
                        runConfirmChecker()
                    } catch (e: Exception) {
                        showToast(this@ConfirmMailActivity, "server not answered")
                    }
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) =
                    showToast(this@ConfirmMailActivity, t.message!!)
        })
    }

    private fun startTimer(v: View) {
        timerProgressBar.visible(true)
        val handler = Handler {
            v.isEnabled
            v.setBackgroundResource(R.drawable.my_button_bg_sign)
            timerProgressBar.visible(false)
            isChecked = false
            true
        }

        Thread(Runnable {
            for (seconds in 0..59) {
                if (seconds == 59)
                    handler.sendEmptyMessage(0)
                timerProgressBar.progress = seconds
                Thread.sleep(1000)
            }
        }).start()
    }

    private fun runConfirmChecker() {
        val call = getUserAPI().isMailConfirm(intent.getStringExtra("auth_key"))

        call.enqueue(object : retrofit2.Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    try {
                        if(Gson().fromJson(result.toString(), ActivateUser::class.java).ActivateUser) {
                            Setting(this@ConfirmMailActivity).isLogged.set(true)
                            startActivity(MainActivity::class.java)
                        } else
                            runConfirmChecker()
                    } catch (e: Exception) {
                        runConfirmChecker()
                    }
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                if (isChecked) {
                    showToast(this@ConfirmMailActivity, t.message!!)
                    runConfirmChecker()
                }
            }
        })
    }
}