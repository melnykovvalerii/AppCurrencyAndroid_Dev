package com.allerates.appforyou.activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.IOHelper;
import com.allerates.appforyou.model.City;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by Rikmen on 02.07.2018.
 */

public class AddLabelActivity extends AppCompatActivity {
    private static final int GALLERY_PICK = 1;
    private static final int DIALOG_PICK = 2;
    private MaterialSpinner spinnerDaysOfTheWeek2, spinnerDaysOfTheWeek, toSpinnerCurrency;
    private City city;
    private String[] day = {"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Вс"};
    private String[] paymentMethods = {"Картой", "Платёж", "Мобильный телефон", "Почта России"};
//    private String[] coin = {"BTC", "ETH", "ETC", "XRP", "LTC", "XMR", "DASH", "MAID", "AUR", "XEM"};
    private TimePicker mTimePicker;
    private static boolean isFrom = true;
    private double mLongitudeDoub;
    private double mLatitudeDoub;

    @BindViews({
            R.id.cb_1, R.id.cb_2,
            R.id.cb_3, R.id.cb_4,
            R.id.cb_5, R.id.cb_6,
            R.id.cb_7, R.id.cb_8,
            R.id.cb_9 })
    List<CheckBox> cbList = new ArrayList<>();

    private String stSite, stNumber, stAddress, stAbout, stAdditionalInformation, stMinSum,
            stDaysOfTheWeek2, stDaysOfTheWeek, stSpinnerCurrency, stTime;
    private Calendar calendar;

    @BindString(R.string.def_string) String defString;
    @BindString(R.string.txt_select_image) String txtSelectImage;
    @BindString(R.string.txt_comma) String txtComma;
    @BindString(R.string.txt_left_square_brackets) String txtLeftSquareBrackets;
    @BindString(R.string.txt_right_square_brackets) String txtRightSquareBrackets;
    @BindString(R.string.txt_latitude) String txtLatitude;
    @BindString(R.string.txt_longitude) String txtLongitude;
    @BindString(R.string.def_string_one_space) String defStringOneSpace;
    @BindString(R.string.txt_map_file) String txtMapFile;
    @BindString(R.string.txt_dot) String txtDot;
    @BindString(R.string.colon) String txtColon;
    @BindString(R.string.txt_am) String txtAm;
    @BindString(R.string.txt_pm) String txtPm;
    @BindString(R.string.txt_empty) String txtEmpty;
    @BindString(R.string.required_field) String requiredField;
    @BindString(R.string.txt_field) String txtField;
    @BindString(R.string.txt_the_minimum_amount) String txtTheMinimumAmount;
    @BindString(R.string.st_additional_information) String txtAdditionalInformation;
    @BindString(R.string.txt_about_currency_exchange) String txtAboutCurrencyExchange;
    @BindString(R.string.txt_address) String txtAdress;
    @BindString(R.string.txt_the_phone_number) String txtThePhoneNumber;
    @BindString(R.string.def_string) String format;
    @BindString(R.string.txt_site) String txtSite;
    @BindView(R.id.from_day_week) TextView fromTime;
    @BindView(R.id.txt_to_time) TextView toTime;
    @BindView(R.id.create_btn) Button createBtn;
    @BindView(R.id.ed_site) EditText edSite;
    @BindView(R.id.ed_number) EditText edNumber;
    @BindView(R.id.ed_min_sum) EditText edMinSum;
    @BindView(R.id.ed_address) EditText edAddress;
    @BindView(R.id.ed_about) EditText edAbout;
    @BindView(R.id.ed_additional_information) EditText edAdditionalInformation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_lable_activity);
        try {
        init();
        setDataToSpinners();
        setListeners();

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int min = calendar.get(Calendar.MINUTE);

        ButterKnife.bind(this);
        mLatitudeDoub = getIntent().getExtras().getDouble(txtLatitude);
        mLongitudeDoub = getIntent().getExtras().getDouble(txtLongitude);
        showTime(hour, min);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void setListeners() {
        try {
        spinnerDaysOfTheWeek.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, item, Snackbar.LENGTH_LONG).show();
            }
        });

        toSpinnerCurrency.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, item, Snackbar.LENGTH_LONG).show();
            }
        });


        calendar = Calendar.getInstance();

        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                showTime(hourOfDay, minute);
            }
        });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    // click event with source view params
    @OnClick(R.id.create_btn)
    public void onButtonClick(View view) {
        checkForValidation();
    }

    @OnCheckedChanged(R.id.switch_from_to)
    void onGenderSelected(CompoundButton button, boolean isChecked) {
        isFrom = !isChecked;
        //do your stuff.
    }
    private void checkForValidation() {
        try {
        stSite = edSite.getText().toString();
        stNumber = edNumber.getText().toString();
        stAddress = edAddress.getText().toString();
        stAbout = edAbout.getText().toString();
        stAdditionalInformation = edAdditionalInformation.getText().toString();
        stMinSum = edMinSum.getText().toString();

        // check for validity of the specified data
        if (TextUtils.isEmpty(edSite.getText().toString()) || !edSite.getText().toString().contains(txtDot)){
                showToast(txtSite);
                setFocus(edSite);
                anim(edSite);
        }else if (TextUtils.isEmpty(edNumber.getText().toString()) || !isInteger(edNumber.getText().toString())){
            showToast(txtThePhoneNumber);
            setFocus(edNumber);
            anim(edNumber);
        }else if (TextUtils.isEmpty(edAddress.getText().toString())){
            showToast(txtAdress);
            anim(edAddress);
            setFocus(edAddress);
        }else if (TextUtils.isEmpty(edAbout.getText().toString())){
            showToast(txtAboutCurrencyExchange);
            anim(edAbout);
            setFocus(edAbout);
        }else if (TextUtils.isEmpty(edAdditionalInformation.getText().toString())){
            showToast(txtAdditionalInformation);
            anim(edAdditionalInformation);
            setFocus(edAdditionalInformation);
        }else if (TextUtils.isEmpty(edMinSum.getText().toString())){
            showToast(txtTheMinimumAmount);
            anim(edMinSum);
            setFocus(edMinSum);
        }else if (TextUtils.isEmpty(edMinSum.getText().toString())){
            showToast(txtTheMinimumAmount);
            anim(edMinSum);
            setFocus(edMinSum);
        }else {
            stDaysOfTheWeek = spinnerDaysOfTheWeek.getItems().get(spinnerDaysOfTheWeek.getSelectedIndex()).toString();
            stDaysOfTheWeek2 = spinnerDaysOfTheWeek2.getItems().get(spinnerDaysOfTheWeek2.getSelectedIndex()).toString();
            stSpinnerCurrency = toSpinnerCurrency.getItems().get(toSpinnerCurrency.getSelectedIndex()).toString();
            String stfromTime = (String)  fromTime.getText();
            String stToTime = (String)  toTime.getText();

            stTime = defStringOneSpace + stfromTime + defStringOneSpace + " - " + defStringOneSpace + stToTime;

            String stUniqueID = UUID.randomUUID().toString();

            city = new City(stSite, stNumber , stAddress, stAbout,
                     stMinSum, stDaysOfTheWeek2, stDaysOfTheWeek, stSpinnerCurrency,
                    getStringFromCB(), Double.toString(mLatitudeDoub), Double.toString(mLongitudeDoub), stUniqueID, stTime);
            writeExternalStoragePrivateFile(city);

            openActivity(MainActivity.class);
            //readExternalStoragePrivateFile();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void setFocus(View view) {
        try {
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String getStringFromCB(){
        try {
        String stCurrency = null;
        for (int i = 0; i < cbList.size(); i++) {
            if(cbList.get(i).isChecked()) {
                stCurrency += cbList.get(i).getText().toString() + txtComma + defStringOneSpace;
            }
        }
        return removeLastChar(stCurrency);
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String removeLastChar(String str) {
        try {
        if(str != null){
            if(str.length() != 0){
                return str.substring(0, str.length() - 2);
            }else {
                return str;
            }
        }else {
            return str;
        }
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void anim(View view){
        try {
        Animation incorrect_shake = AnimationUtils.loadAnimation(this, R.anim.incorrect_shake);
        createBtn.startAnimation(incorrect_shake);
        view.startAnimation(incorrect_shake);
        view.startAnimation(incorrect_shake);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public String readExternalStoragePrivateFile() {
        try {
        //We have to request the permission
        String str = null;
        if (isExternalStorageReadable()) {
            File dirPics = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File f = new File(dirPics, txtMapFile);

            try {
                str = IOHelper.stringFromFile(f);
               // Toast.makeText(this, "str = " + str, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void writeExternalStoragePrivateFile(City cit) {
        try {
        String oldData = readExternalStoragePrivateFile();
        //requires permission
        File dirPics = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS); //deleted when app uninstalls
        File f = new File(dirPics, txtMapFile);
        // if there is data rewrite them
        if(oldData != null){
            oldData = oldData.replace(txtLeftSquareBrackets, defString);
            oldData = oldData.replace(txtRightSquareBrackets, defString);
            IOHelper.writeToFile(f, txtLeftSquareBrackets + cit.toString() + txtComma + oldData + txtRightSquareBrackets);
            //IOHelper.writeToFile(f, cit.toString() + oldData);
        }else {
            String s = cit.toString();
            IOHelper.writeToFile(f, txtLeftSquareBrackets + s + txtRightSquareBrackets);
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
            return true;

        return false;
    }

    private void showToast(String txtFild) {
        Toast.makeText(AddLabelActivity.this,  txtField + txtFild + txtEmpty + requiredField, Toast.LENGTH_SHORT).show();
    }

    private void init() {
        try {
        spinnerDaysOfTheWeek = (MaterialSpinner) findViewById(R.id.spinner_days_of_the_week);
        spinnerDaysOfTheWeek2 = (MaterialSpinner) findViewById(R.id.spinner_days_of_the_week2);
        toSpinnerCurrency = (MaterialSpinner) findViewById(R.id.spinner_currency);
        mTimePicker = (TimePicker) findViewById(R.id.work_time);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void showTime(int hour, int min) {
        try {
        if (hour == 0) {
            hour += 12;
            format = txtAm;
        } else if (hour == 12) {
            format = txtPm;
        } else if (hour > 12) {
            hour -= 12;
            format = txtPm;
        } else {
            format = txtAm;
        }
        if(isFrom){
            fromTime.setText(new StringBuilder().append(hour).append(txtColon).append(min)
                .append(defStringOneSpace).append(format));
            } else {
                toTime.setText(new StringBuilder().append(hour).append(txtColon).append(min)
                        .append(defStringOneSpace).append(format));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    private void setDataToSpinners() {
        try {
        spinnerDaysOfTheWeek.setItems(day);
        spinnerDaysOfTheWeek2.setItems(day);
        toSpinnerCurrency.setItems(paymentMethods);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

        if (requestCode == GALLERY_PICK && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) findViewById(R.id.image);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    // click event with source view params
    @OnClick(R.id.add_photo)
    public void onButClick(View view) {
        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(galleryIntent, txtSelectImage), GALLERY_PICK);

//                CropImage.activity()
//                        .setGuidelines(CropImageView.Guidelines.ON)
//                        .start(AccountSettingsActivity.this);
    }

    /**
     * Tracked depression back
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        try {
        Intent intent = new Intent(AddLabelActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }//onBackPressed

    public void openActivity(Class someClass){
        try {
        Intent intent = new Intent(AddLabelActivity.this, someClass );
        startActivity(intent);
        finish();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
