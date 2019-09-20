package com.allerates.appforyou.fragment


import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.allerates.appforyou.Common
import com.allerates.appforyou.R
import com.allerates.appforyou.activities.DialogActivity
import com.allerates.appforyou.helpers.IOHelper
import com.allerates.appforyou.model.Point
import java.io.File
import java.io.IOException
import java.util.Calendar
import java.util.UUID
import android.app.Activity.RESULT_OK
import butterknife.*
import com.allerates.appforyou.helpers.showToast
import kotlinx.android.synthetic.main.add_layout.*
import kotlinx.android.synthetic.main.add_layout.view.*

class AddFragment:
        Fragment(),
        View.OnClickListener {
    override fun onClick(p: View) {
        onSaveClick(p as Button)
        showToast(activity!!, "lolfds")
    }

    //EditTexts
    @BindView(R.id.tv_add_new_exchange) lateinit var urlEditText: EditText
    @BindView(R.id.ed_number) lateinit var phoneEditText: EditText
    @BindView(R.id.ed_address) lateinit var placeEditText: EditText
    @BindView(R.id.ed_min_sum) lateinit var minSumEditText: EditText
    @BindView(R.id.ed_about) lateinit var commentEditText: EditText

    private val availableCrypts = mutableListOf<String>()

    lateinit var binder: Unbinder
    private var hour: Int = 0
    private var min: Int = 0
    private var stCurrency = ""
    private val point: Point? = null
    private var mLongitudeDoub = 0.0
    private var mLatitudeDoub = 0.0
    private var isWeekButton = false
    private var stArr = arrayOfNulls<String>(0)
    private var stSite: String? = null
    private var stPhone: String? = null
    private var stAddress: String? = null
    private var stAbout: String? = null
    private var stMinSum: String? = null
    private var stToDaysOfTheWeek: String? = null
    private var stFromDaysOfTheWeek: String? = null
    private var stFromTime: String? = null
    private var stToTime: String? = null
    private val stPayMethBtn: String? = null
    private var stPayMeth: String? = null
    private var stCash: String? = null
    private var stCard: String? = null
    private var stMailCash: String? = null
    private var calendar: Calendar? = null
    private val menu: Menu? = null
    private var btnSelected: Button? = null
    private val intCash: Int = 0
    private val intCard: Int = 0
    private val intMailCash: Int = 0
    private var numbPaymentMethod: Int = 0
    @BindString(R.string.def_string)
    internal var defString: String? = null
    @BindString(R.string.txt_currency_is_not)
    internal var currencyIsNot: String? = null
    @BindString(R.string.txt_select_image)
    internal var txtSelectImage: String? = null
    @BindString(R.string.txt_comma)
    internal var txtComma: String? = null
    @BindString(R.string.txt_left_square_brackets)
    internal var txtLeftSquareBrackets: String? = null
    @BindString(R.string.txt_right_square_brackets)
    internal var txtRightSquareBrackets: String? = null
    @BindString(R.string.txt_latitude)
    internal var txtLatitude: String? = null
    @BindString(R.string.txt_longitude)
    internal var txtLongitude: String? = null
    @BindString(R.string.def_string_one_space)
    internal var defStringOneSpace: String? = null
    @BindString(R.string.txt_map_file)
    internal var txtMapFile: String? = null
    @BindString(R.string.txt_dot)
    internal var txtDot: String? = null
    @BindString(R.string.colon)
    internal var txtColon: String? = null
    @BindString(R.string.txt_am)
    internal var txtAm: String? = null
    @BindString(R.string.txt_pm)
    internal var txtPm: String? = null
    @BindString(R.string.txt_empty)
    internal var txtEmpty: String? = null
    @BindString(R.string.required_field)
    internal var requiredField: String? = null
    @BindString(R.string.the_number)
    internal var theNumber: String? = null
    @BindString(R.string.txt_field)
    internal var txtField: String? = null
    @BindString(R.string.txt_the_minimum_amount)
    internal var txtTheMinimumAmount: String? = null
    @BindString(R.string.st_additional_information)
    internal var txtAdditionalInformation: String? = null
    @BindString(R.string.txt_about_currency_exchange)
    internal var txtAboutCurrencyExchange: String? = null
    @BindString(R.string.txt_address)
    internal var txtAdress: String? = null
    @BindString(R.string.txt_the_phone_number)
    internal var txtThePhoneNumber: String? = null
    @BindString(R.string.def_string)
    internal var format: String? = null
    @BindString(R.string.txt_site)
    internal var txtSite: String? = null

    @BindView(R.id.btn_from_day_week)
    internal var fromDayWeek: Button? = null
    @BindView(R.id.to_day_week)
    internal var toDayWeek: Button? = null
    @BindView(R.id.create_btn)
    internal var createBtn: Button? = null
    @BindView(R.id.btn_currency)
    internal var btnPayMethBtn: Button? = null
    @BindView(R.id.btn_to_time)
    internal var btnToTime: Button? = null
    @BindView(R.id.btn_from_time)
    internal var btnFromTime: Button? = null

    @BindView(R.id.txt_to_time)
    internal var toTime: TextView? = null
    @BindView(R.id.tv_address)
    internal var fromTime: TextView? = null
    @BindView(R.id.tv_to_time)
    internal var tvToTime: TextView? = null
    @BindView(R.id.ed_number)
    internal var edNumber: EditText? = null
    @BindView(R.id.ed_address)
    internal var edAddress: EditText? = null
    @BindView(R.id.ed_about)
    internal var edAbout: EditText? = null
    @BindString(R.string.txt_crypto_currency_names)
    internal var cryptoCurrencyNames: String? = null
    @BindString(R.string.payment_method_number)
    internal var paymentMethodNumber: String? = null
    @BindString(R.string.txt_you_selected)
    internal var txtYouSelected: String? = null
    @BindString(R.string.txt_down_arrow)
    internal var downArrow: String? = null

    @BindString(R.string.txt_mail_cash)
    internal var txtMailCash: String? = null
    @BindString(R.string.txt_card_check)
    internal var txtCardCheck: String? = null
    @BindString(R.string.txt_cash)
    internal var txtCash: String? = null

    private val isExternalStorageReadable: Boolean
        get() {
            val state = Environment.getExternalStorageState()
            return Environment.MEDIA_MOUNTED == state || Environment.MEDIA_MOUNTED_READ_ONLY == state
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreate(savedInstanceState)

        val view = inflater.inflate(R.layout.add_layout, null)
        binder = ButterKnife.bind(this, view)

        init(view)
        //setDataToSpinners();
        //setListeners();
        if (arguments != null) {
            mLatitudeDoub = arguments!!.getDouble(txtLatitude)
            mLongitudeDoub = arguments!!.getDouble(txtLongitude)
        }
        showTime(hour, min)
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binder.unbind()
    }

    private fun editAvailableList(button: Button, idContain: Int, idNotContain: Int, name: String) {
        if (availableCrypts.contains(name)) {
            availableCrypts.remove(name)
            button.setBackgroundResource(idNotContain)
        } else {
            availableCrypts.add(name)
            button.setBackgroundResource(idContain)
        }
    }

    @OnClick(R.id.btn_dash)
    fun onSaveClick(button: Button) {
        when (button.id) {
            R.id.btn_dash -> editAvailableList(button, R.drawable.dash1, R.drawable.dash2, "DASH")
            R.id.btn_maid -> editAvailableList(button, R.drawable.maid1, R.drawable.maid2, "MAID")
            R.id.btn_ltc -> editAvailableList(button, R.drawable.ltc1, R.drawable.ltc2, "LTC")
            R.id.btn_etc -> editAvailableList(button, R.drawable.etc1, R.drawable.etc2, "ETC")
            R.id.btn_eth -> editAvailableList(button, R.drawable.eth1, R.drawable.eth2, "ETH")
            R.id.btn_xrp -> editAvailableList(button, R.drawable.xrp1, R.drawable.xrp2, "XRP")
            R.id.btn_xmr -> editAvailableList(button, R.drawable.xmr1, R.drawable.xmr2, "XMR")
            R.id.btn_btc -> editAvailableList(button, R.drawable.btc1, R.drawable.btc2, "BTC")
            R.id.btn_xem -> editAvailableList(button, R.drawable.xem1, R.drawable.xem2, "XEM")
            R.id.btn_aur -> editAvailableList(button, R.drawable.aur1, R.drawable.aur2, "AUR")
        }
        showToast(activity!!, "fire")
    }

    private fun checkChosenPaymentMethod(btnString: String, numbPaymentMethod: Int) {
        try {
            when (numbPaymentMethod) {
                2 -> {
                    stCash = "1"
                    stMailCash = "0"
                    stCard = "0"
                }
                1 -> {
                    stMailCash = "1"
                    stCard = "0"
                    stCash = "0"
                }
                0 -> {
                    stCard = "1"
                    stMailCash = "0"
                    stCash = "0"
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    //create point with params
    @OnClick(R.id.create_btn)
    fun onButtonClick(v: View) = checkForValidation()

    @OnClick(R.id.to_day_week)
    fun onButDayWeek(v: View) {
        btnSelected = activity!!.findViewById(R.id.to_day_week)
        isWeekButton = true
        startDialog(4)
    }

    @OnClick(R.id.btn_from_day_week)
    fun onBtnFromDayWeek(view: View) {
        try {
            isWeekButton = true
            btnSelected = activity!!.findViewById<View>(R.id.btn_from_day_week) as Button
            startDialog(4)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @OnClick(R.id.btn_to_time)
    fun onBtnTvToTime(view: View) {
        try {
            isWeekButton = false
            btnSelected = activity!!.findViewById<View>(R.id.btn_to_time) as Button
            startDialog(6)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @OnClick(R.id.btn_from_time)
    fun onBtnFromTime(view: View) {
        try {
            isWeekButton = false
            btnSelected = activity!!.findViewById<View>(R.id.btn_from_time) as Button
            startDialog(5)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    @OnClick(R.id.btn_currency)
    fun onBtnPayMeth(view: View) {
        try {
            isWeekButton = false
            btnSelected = activity!!.findViewById<View>(R.id.btn_currency) as Button
            startDialog(7)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun checkForValidation() {
        try {
            stSite = urlEditText.text.toString()
            stPhone = edNumber!!.text.toString()
            stAddress = edAddress!!.text.toString()
            stAbout = edAbout!!.text.toString()
            stMinSum = minSumEditText.text.toString()
            stPayMeth = btnPayMethBtn!!.text.toString()

            // check for validity of the specified data
            if (TextUtils.isEmpty(urlEditText.text.toString()) || !urlEditText.text.toString().contains(txtDot!!)) {
                showToast(txtSite)
                setFocus(urlEditText)
                anim(urlEditText)
            } else if (TextUtils.isEmpty(edNumber!!.text.toString()) || !edNumber!!.text.toString().isInt()) {
                if (edNumber!!.text.toString().length == 11) {
                    showToast(txtThePhoneNumber)
                    setFocus(edNumber!!)
                    anim(edNumber!!)
                }
            } else if (TextUtils.isEmpty(edAddress!!.text.toString())) {
                showToast(txtAdress)
                anim(edAddress!!)
                setFocus(edAddress!!)
            } else if (TextUtils.isEmpty(minSumEditText.text.toString())) {
                showToast(txtTheMinimumAmount)
                anim(minSumEditText)
                setFocus(minSumEditText)
            } else if (TextUtils.isEmpty(minSumEditText.text.toString())) {
                showToast(txtTheMinimumAmount)
                anim(minSumEditText)
                setFocus(minSumEditText)
            } else {
                if (minSumEditText.text.toString().isInt(10)) {
                    stFromDaysOfTheWeek = removeSecondChar(fromDayWeek!!.text.toString())
                    stToDaysOfTheWeek = removeSecondChar(toDayWeek!!.text.toString())
                    stPayMeth = btnPayMethBtn!!.text.toString()
                    checkChosenPaymentMethod(stPayMeth!!, numbPaymentMethod)
                    stFromTime = btnFromTime!!.text as String
                    stToTime = btnToTime!!.text as String

                    val stUniqueID = UUID.randomUUID().toString()
                    //            point = new Point(stSite, stPhone, stAddress, stAbout, stMinSum, stToDaysOfTheWeek, stFromDaysOfTheWeek, removeSecondChar(stPayMeth), checkChosenCurrency(), Double.toString(mLatitudeDoub), Double.toString(mLongitudeDoub), stUniqueID);
                    //  writeExternalStoragePrivateFile(point);// временно
                    //   setPoint(point);
                    createPoint(point)

                    //            MainActivity mainActivity = new MainActivity();
                    //            mainActivity.changeFragment(new ShowCurrencyFragment(),  menu.findItem(R.id.nav_gallery), 2131296509);

                    //openActivity(MainActivity.class);

                    //readExternalStoragePrivateFile();
                } else {
                    showToastIncInt(txtTheMinimumAmount)
                    anim(minSumEditText)
                    setFocus(minSumEditText)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    // на создание точки
    private fun createPoint(point: Point?) {
        try {
            val setPoint = Common.setPoint()
            //setPoint.mSetPoint(stSite, stPhone, mLatitudeDoub.toString(), mLongitudeDoub.toString(), stFromDaysOfTheWeek, stFromTime, stMinSum, stCash, intBtc.toString(), intEth.toString(), intMaid.toString(), intXmr.toString(), intXrp.toString(), intXem.toString(), intDash.toString(), intLtc.toString(), intAur.toString(), intEtc.toString(), stToDaysOfTheWeek, stToTime, stAbout, stCard, stMailCash, stAddress)
            //        .enqueue(object : Callback<List<AuthKey>> {
            //            override fun onResponse(call: Call<List<AuthKey>>, response: Response<List<AuthKey>>) {
            //                if (response.code() == 200 && response.body() != null) {
            //                    val stKey = response.body()!![0].authKey
            //                    if (stKey != null) {
            //                        showToast(context!!, "Point successfully created")
            //                        changeFragment()
            //                    } else
            //                        showToast(context!!, "$response Unable to create point")
            //                }
            //            }
            //
            //            override fun onFailure(call: Call<List<AuthKey>>, t: Throwable) {
            //                if (t.cause != null)
            //                    showToast(context!!, "Unable to create point" + t.cause!!.message)
            //                else
            //                    showToast(context!!, "Unable to create point. Message error not found.")
            //            }
            //        })
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun removeSecondChar(str: String?): String? {
        if (!str.isNullOrEmpty())
            return str.substring(0, str.length - 1)
        return str
    }

    private fun removeFirstChar(s: String): String? =
        if (!stCurrency.isNullOrEmpty())
            s.substring(1)
        else
            null

    private fun setFocus(view: View) {
        view.requestFocus()
        val imm = activity!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    //    public String getStringFromCB(){
    //            for (int i = 0; i < cbList.size(); i++) {
    //                if(cbList.get(i).isChecked()) {
    //                    stCurrency += cbList.get(i).getText().toString() + txtComma + defStringOneSpace;
    //                }
    //            }
    //        return removeLastChar(stCurrency);
    //    }

    fun anim(view: View) {
        try {
            val incorrectShake = AnimationUtils.loadAnimation(activity, R.anim.incorrect_shake)
            createBtn!!.startAnimation(incorrectShake)
            view.startAnimation(incorrectShake)
            view.startAnimation(incorrectShake)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun readExternalStoragePrivateFile(): String? {
        //We have to request the permission
        var str: String? = null
        if (isExternalStorageReadable) {
            val dirPics = activity!!.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
            val f = File(dirPics, txtMapFile!!)

            try {
                str = IOHelper.stringFromFile(f)
                // Toast.makeText(this, "str = " + str, Toast.LENGTH_SHORT).show();
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        return str
    }


    fun writeExternalStoragePrivateFile(cit: Point) {
        var oldData = readExternalStoragePrivateFile()
        //requires permission
        val dirPics = activity!!.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS) //deleted when app uninstalls
        val f = File(dirPics, txtMapFile!!)
        // if there is data rewrite them
        if (oldData != null) {
            oldData = oldData.replace(txtLeftSquareBrackets!!, defString!!)
            oldData = oldData.replace(txtRightSquareBrackets!!, defString!!)
            IOHelper.writeToFile(f, txtLeftSquareBrackets + cit.toString() + txtComma + oldData + txtRightSquareBrackets)
            //IOHelper.writeToFile(f, cit.toString() + oldData);
        } else {
            val s = cit.toString()
            IOHelper.writeToFile(f, txtLeftSquareBrackets + s + txtRightSquareBrackets)
        }
    }

    private fun showToast(txtFild: String?) =
        Toast.makeText(activity, txtField + txtFild + txtEmpty + requiredField, Toast.LENGTH_SHORT).show()

    private fun showToastIncInt(txtFild: String?) =
        Toast.makeText(activity, txtField + txtFild + txtEmpty + theNumber, Toast.LENGTH_SHORT).show()

    private fun init(view: View) {
        try {
            calendar = Calendar.getInstance()


            btn_maid.setOnClickListener(this)
            //view.findViewById<Button>(R.id.btn_maid).setOnClickListener(this)
            //btn_dash.setOnClickListener(this)
            //btn_ltc.setOnClickListener(this)
            //btnEtc.setOnClickListener(this)
            //btnEth.setOnClickListener(this)
            //btnXrp.setOnClickListener(this)
            //btnXmr.setOnClickListener(this)
            //btnBtc.setOnClickListener(this)
            //btnMaid.setOnClickListener(this)
            //btnXem.setOnClickListener(this)
            //btnAur.setOnClickListener(this)

            hour = calendar!!.get(Calendar.HOUR_OF_DAY)
            min = calendar!!.get(Calendar.MINUTE)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun showTime(hour: Int, min: Int) {
        var hour = hour
        try {
            when {
                hour == 0 -> {
                    hour += 12
                    format = txtAm
                }
                hour == 12 -> format = txtPm
                hour > 12 -> {
                    hour -= 12
                    format = txtPm
                }
                else -> format = txtAm
            }
            //        if(isFrom){
            //            fromTime.setText(new StringBuilder().append(hour).append(txtColon).append(min)
            //                    .append(defStringOneSpace).append(format));
            //        } else {
            //            toTime.setText(new StringBuilder().append(hour).append(txtColon).append(min)
            //                    .append(defStringOneSpace).append(format));
            //        }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun startDialog(numberToCheck: Int) {
        val intent = Intent(activity, DialogActivity::class.java)
        intent.putExtra("numberCheck", numberToCheck)
        startActivityForResult(intent, DIALOG_PICK)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        try {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == DIALOG_PICK && resultCode == RESULT_OK) {
                val currencyCode = data!!.getStringExtra(cryptoCurrencyNames)
                numbPaymentMethod = data.getIntExtra(paymentMethodNumber, 0)
                setSource(btnSelected, currencyCode)
                showToast(activity!!, txtYouSelected!! + currencyCode)
            }
            if (requestCode == GALLERY_PICK && resultCode == RESULT_OK && null != data) {
                val selectedImage = data.data
                val filePathColumn = arrayOf(MediaStore.Images.Media.DATA)

                val cursor = activity!!.contentResolver.query(selectedImage!!,
                        filePathColumn, null, null, null)
                cursor!!.moveToFirst()

                val columnIndex = cursor.getColumnIndex(filePathColumn[0])
                val picturePath = cursor.getString(columnIndex)
                cursor.close()

                val imageView = activity!!.findViewById<ImageView>(R.id.image)
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath))
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun setSource(btnConvert: Button?, selString: String) {
        try {
            btnConvert!!.text = selString + downArrow!!
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // click event with source view params
    @OnClick(R.id.add_photo)
    fun onButClick(v: View) {
        try {
            val galleryIntent = Intent()
            galleryIntent.type = "image/*"
            galleryIntent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(Intent.createChooser(galleryIntent, txtSelectImage), GALLERY_PICK)

            //                CropImage.activity()
            //                        .setGuidelines(CropImageView.Guidelines.ON)
            //                        .start(AccountSettingsActivity.this);
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun String.isInt(): Boolean {
        return try {
            this.toInt()
            true
        } catch (e: Exception) {
            false
        }
    }

    private fun String.isInt(radix: Int): Boolean {
        if (this.isInt()) {
            val digit = this.toInt()
            if (Character.digit(digit, radix) < 0)
                return false
            return true
        }
        return false
    }

    companion object {
        private const val GALLERY_PICK = 1
        private const val DIALOG_PICK = 2
    }
}
