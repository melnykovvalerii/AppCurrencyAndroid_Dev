package com.allerates.appforyou.activities


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.showToast


class ActivityContactUs: AppCompatActivity() {

    lateinit var body: EditText
    lateinit var send: Button

    public override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_us)

        body = findViewById(R.id.body)
        send = findViewById(R.id.send)
        initToolbar()
    }

    fun SendBtn(v: View) {
        if (body.text.toString().isEmpty())
            showToast(this, R.string.required_field)
        else {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "plain/text"
            intent.putExtra(Intent.EXTRA_EMAIL,
                    arrayOf(resources.getString(R.string.email_address2)))

            intent.putExtra(Intent.EXTRA_SUBJECT, resources.getString(R.string.app_name))

            val bodyEmail = body.text.toString() + "\n\n Сообщение отправлено с приложения Crypto Exchange"
            intent.putExtra(Intent.EXTRA_TEXT, bodyEmail)
            startActivityForResult(Intent.createChooser(intent, "Send email..."), 100)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        startActivity(intent)
        overridePendingTransition(R.anim.open_main, R.anim.close_next)
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar_high_level_activity)
        toolbar.setBackgroundResource(R.color.back_log)
        toolbar.setTitle(R.string.str_contact)
        setSupportActionBar(toolbar)

        toolbar.setOnMenuItemClickListener { item ->
            val id = item.itemId
            if (id == android.R.id.home) {
                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(intent)
                overridePendingTransition(R.anim.open_main, R.anim.close_next)
            }
            true
        }
        toolbar.inflateMenu(R.menu.menu_top)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_top, menu)
        return true
    }

}
