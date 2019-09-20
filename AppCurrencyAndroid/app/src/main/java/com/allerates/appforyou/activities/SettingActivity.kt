package com.allerates.appforyou.activities


import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Base64
import android.view.View
import android.widget.*
import com.allerates.appforyou.R
import com.allerates.appforyou.sql.DatabaseHelper
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import butterknife.BindString
import com.allerates.appforyou.helpers.Setting
import com.allerates.appforyou.helpers.isNotExistBadChars
import com.allerates.appforyou.helpers.isPhone


class SettingActivity : AppCompatActivity() {

    //form
    lateinit var avatarImageView: ImageView
    lateinit var nameEditText: EditText
    lateinit var phoneEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var notificationSwith: Switch
    lateinit var defaultCurrencyButton: Button


    @BindString(R.string.txt_crypto_currency_names)
    internal var cryptoCurrencyNames: String? = null
    @BindString(R.string.txt_you_selected)
    internal var txtYouSelected: String? = null
    @BindString(R.string.txt_down_arrow)
    internal var downArrow: String? = null
    @BindString(R.string.wrong)
    internal var wentWrong: String? = null
    @BindString(R.string.havent_picked)
    internal var haventPicked: String? = null
    @BindString(R.string.money)
    internal var stMoney: String? = null
    @BindString(R.string.number_check_simpl)
    internal var numberCheckSimpl: String? = null
    private var bitmap: Bitmap? = null
    private var userLocalDatabase: SharedPreferences? = null
    private var imgStr: String? = null
    private var imageByteArray: ByteArray? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_setting)

        avatarImageView = findViewById(R.id.def_img)
        nameEditText = findViewById(R.id.ed_name)
        phoneEditText = findViewById(R.id.ed_phone)
        emailEditText = findViewById(R.id.ed_email)
        passwordEditText = findViewById(R.id.ed_password)
        notificationSwith = findViewById(R.id.check_act)
        defaultCurrencyButton = findViewById(R.id.btn_currency)

        initToolbar()
        fillFormFromSetting()

        //todo: check email activ
        //todo: 2 buttons, currency button, email checker
    }

    private fun fillFormFromSetting() {
        val setting = Setting(this)
        nameEditText.setText(setting.userLogin.get())
        phoneEditText.setText(setting.phone.get())
        emailEditText.setText(setting.userMail.get())
        defaultCurrencyButton.text = setting.defaultMoney.get()
        notificationSwith.isChecked = setting.isShowNotofications.get()
        //todo first load activate from setting, second load from server
    }

    fun setModeNotificationsClick(v: View) =
        Setting(this).isShowNotofications.set((v as Switch).isChecked)

    //не смотрел что будет
    fun setNewCurrencyClick(v: View) {
        val intent = Intent(this, DialogActivity::class.java)
        intent.putExtra(numberCheckSimpl, 3)
        startActivityForResult(intent, 1)
    }

    fun saveClick(v: View) {
        //validating form

        //name
        if (nameEditText.text.isEmpty()) {
            nameEditText.error = "Fill name"
            return
        } else if (isNotExistBadChars(nameEditText, false)) {
            nameEditText.error = "Name have bad chars"
            return
        }

        //phone
        if (!isPhone(phoneEditText)) {
            phoneEditText.error = "Use else digits"
            return
        }

        //email
        if (emailEditText.text.isEmpty()) {
            emailEditText.error = "Must be not null"
            return
        }
        if (isNotExistBadChars(emailEditText, true)) {
            emailEditText.error = "Email have bad chars"
            return
        }

        //password
        if (isNotExistBadChars(passwordEditText, false)) {
            passwordEditText.error = "Password have bad chars"
            return
        }

        //todo password edit

        val name = nameEditText.text.toString()
        val phone = phoneEditText.text.toString()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

    }

    fun setAvatarClick(v: View) {
        val photoPickerIntent = Intent(Intent.ACTION_PICK)
        photoPickerIntent.type = "image/*"
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG)
    }

    fun logoutClick(v: View) {
        Setting(this).deleteUserData()
        finish()
    }








    private fun setCurrentCurrency() {
        val coinName = Setting(this).defaultMoney.get()
        defaultCurrencyButton.text = String.format("%s%s", coinName, downArrow)
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    private fun sizeOf(data: Bitmap?): Int {
        val tempData: Int
        if (data == null) {
            tempData = 0
        } else {
            tempData = data.byteCount
        }
        return tempData
    }

    /**
     * reduces the size of the image
     * @param image
     * @param maxSize
     * @return
     */
    private fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap {
        var width = image.width
        var height = image.height

        val bitmapRatio = width.toFloat() / height.toFloat()
        if (bitmapRatio > 1) {
            width = maxSize
            height = (width / bitmapRatio).toInt()
        } else {
            height = maxSize
            width = (height * bitmapRatio).toInt()
        }
        return Bitmap.createScaledBitmap(image, width, height, true)
    }

    private fun decodeImageToBase64(): String? {
        var temp: String?
        try {
            val sizeImg: Int = sizeOf(bitmap)
            // bitmap = BitmapFactory.decodeResource(getResources(), imgUser.getId());
            ////////////////bitmap = (imgUser!!.drawable as BitmapDrawable).bitmap

            if (sizeImg > 1000000) {
                bitmap = getResizedBitmap(bitmap!!, 500)
            }
            // R.drawable.images is image for my ImageView
            val stream = ByteArrayOutputStream()
            bitmap!!.compress(Bitmap.CompressFormat.PNG, 90, stream)
            imageByteArray = stream.toByteArray()
            imgStr = Base64.encodeToString(imageByteArray, 0)
            // get img
            temp = imgStr
        } catch (e: Exception) {
            temp = null
        }

        return temp
    }

    private fun decBase64ToImage(baseSiFor: String) {
        // decode base64 string to image
        imageByteArray = Base64.decode(baseSiFor, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray!!.size)
        //////////////////imgUser!!.setImageBitmap(decodedImage)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.clear()
    }

    override fun onActivityResult(reqCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(reqCode, resultCode, data)
        if (reqCode == 1 && resultCode == Activity.RESULT_OK) {
            val currencyCode = data.getStringExtra(cryptoCurrencyNames)
            /////////////setSource(btnCurrency, currencyCode)
            setCoin2MoneySource(currencyCode)
            Toast.makeText(this, txtYouSelected!! + currencyCode, Toast.LENGTH_LONG).show()
        }

        if (reqCode == 2 && resultCode == Activity.RESULT_OK) {
            try {
                val imageUri = data.data
                val imageStream = contentResolver.openInputStream(imageUri!!)
                val selectedImage = BitmapFactory.decodeStream(imageStream)
                //////////////////imgUser!!.setImageBitmap(selectedImage)

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Toast.makeText(this@SettingActivity, wentWrong, Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this@SettingActivity, haventPicked, Toast.LENGTH_LONG).show()
        }
    }

    private fun initToolbar() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setTitle(R.string.setting)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))
    }

    private fun setCoin2MoneySource(coinName: String) {
        try {
            userLocalDatabase = applicationContext.getSharedPreferences(DatabaseHelper.getSpName(), 0)
            val spEditor = userLocalDatabase!!.edit()
            spEditor.putString(stMoney, coinName)
            spEditor.apply()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    companion object {
        private const val RESULT_LOAD_IMG = 2
    }
}
