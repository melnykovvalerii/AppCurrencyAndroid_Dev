package com.allerates.appforyou.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.allerates.appforyou.R;
import com.allerates.appforyou.activities.DialogActivity;
import com.allerates.appforyou.helpers.IOHelper;
import com.allerates.appforyou.model.City;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Rikmen on 02.07.2018.
 */

public class AddFragment extends Fragment implements View.OnClickListener {
    private static final int GALLERY_PICK = 1;
    private static final int DIALOG_PICK = 2;
    private int hour;
    private int min;
    private String stCurrency = "";
    private static final int LAYOUT = R.layout.add_layout;
    private City city;
    private double mLongitudeDoub;
    private double mLatitudeDoub;
    private View view;
    private boolean isWeekButton = false;
    private String[] stArr = new String[0];

    private String stSite, stNumber, stAddress, stAbout, stMinSum,
            stDaysOfTheWeek2, stDaysOfTheWeek, stSpinnerCurrency, stTime, stPayMeth;
    private Calendar calendar;
    private Context context;
    private Menu menu;
    private Button btnSelected;
    private Button btnDash, btnLtc, btnEtc, btnEth, btnXrp, btnXmr, btnBtc, btnMaid, btnXem, btnAur;
    private int intDash, intLtc, intEtc, intEth, intXrp, intXmr, intBtc, intMaid, intXem, intAur;

    @BindString(R.string.def_string) String defString;
    @BindString(R.string.txt_currency_is_not) String currencyIsNot;
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

    @BindView(R.id.btn_from_day_week) Button fromDayWeek;
    @BindView(R.id.to_day_week) Button toDayWeek;
    @BindView(R.id.create_btn) Button createBtn;
    @BindView(R.id.btn_currency) Button tvCurrencyBtn;
    @BindView(R.id.btn_to_time) Button btnToTime;
    @BindView(R.id.btn_from_time) Button btnFromTime;

    @BindView(R.id.txt_to_time) TextView toTime;
    @BindView(R.id.tv_address) TextView fromTime;
    @BindView(R.id.tv_to_time) TextView tvToTime;

    @BindView(R.id.ed_site) EditText edSite;
    @BindView(R.id.ed_number) EditText edNumber;
    @BindView(R.id.ed_min_sum) EditText edMinSum;
    @BindView(R.id.ed_address) EditText edAddress;
    @BindView(R.id.ed_about) EditText edAbout;
    @BindString(R.string.txt_crypto_currency_names) String cryptoCurrencyNames;
    @BindString(R.string.txt_you_selected) String txtYouSelected;
    @BindString(R.string.txt_down_arrow) String downArrow;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
        super.onCreate(savedInstanceState);
        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);
        init();
        //setDataToSpinners();
        //setListeners();
        Bundle bundle = this.getArguments();
        if(bundle != null){
            // handle your code here.
            mLatitudeDoub = bundle.getDouble(txtLatitude);
            mLongitudeDoub = bundle.getDouble(txtLongitude);
        }
        showTime(hour, min);
        } catch (Throwable t) {

        }
        return view;
    }

    private int isCheckDash(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.dash1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.dash2);
            i = 1;
        }
        return i;
    }
    private int isCheckAur(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.aur1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.aur2);
            i = 1;
        }
        return i;
    }
    private int isCheckXem(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.xem1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.xem2);
            i = 1;
        }
        return i;
    }
    private int isCheckMaid(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.maid1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.maid2);
            i = 1;
        }
        return i;
    }
    private int isCheckBtc(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.btc1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.btc2);
            i = 1;
        }
        return i;
    }
    private int isCheckXmr(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.xmr1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.xmr2);
            i = 1;
        }
        return i;
    }
    private int isCheckXrp(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.xrp1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.xrp2);
            i = 1;
        }
        return i;
    }
    private int isCheckEth(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.eth1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.eth2);
            i = 1;
        }
        return i;
    }
    private int isCheckEtc(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.etc1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.etc2);
            i = 1;
        }
        return i;
    }
    private int isCheckLtc(int i, Button button) {
        if(i == 1){
            button.setBackgroundResource(R.drawable.ltc1);
            i = 0;
        }else {
            button.setBackgroundResource(R.drawable.ltc2);
            i = 1;
        }
        return i;
    }
    private String checkChosenCurrency() {
        stArr = getResources().getStringArray(R.array.crypto_currency_names);
        if(intDash == 1){stCurrency += "," + stArr[6];}
        if(intLtc == 1){stCurrency += "," + stArr[4];}
        if(intEtc == 1){stCurrency += "," + stArr[2];}
        if(intEth == 1){stCurrency += "," + stArr[1];}
        if(intXrp == 1){stCurrency += "," + stArr[3];}
        if(intXmr == 1){stCurrency += "," + stArr[5];}
        if(intBtc == 1){stCurrency += "," + stArr[0];}
        if(intMaid == 1){stCurrency += "," + stArr[7];}
        if(intXem == 1){stCurrency += "," + stArr[9];}
        if(intAur == 1){stCurrency += "," + stArr[8];}

        return removeFirstChar(stCurrency);
    }
    private void checkBtn(Button button) {
        if(button == btnDash){
            intDash = isCheckDash(intDash, btnDash);
        }else if(button == btnLtc){
            intLtc = isCheckLtc(intLtc, btnLtc);
        }else if(button == btnEtc){
            intEtc = isCheckEtc(intEtc, btnEtc);
        }else if(button == btnEth){
            intEth = isCheckEth(intEth, btnEth);
        }else if(button == btnXrp){
            intXrp = isCheckXrp(intXrp, btnXrp);
        }else if(button == btnXmr){
            intXmr = isCheckXmr(intXmr, btnXmr);
        }else if(button == btnBtc){
            intBtc = isCheckBtc(intBtc, btnBtc);
        }else if(button == btnMaid){
            intMaid = isCheckMaid(intMaid, btnMaid);
        }else if(button == btnXem){
            intXem = isCheckXem(intXem, btnXem);
        }else if(button == btnAur) {
            intAur = isCheckAur(intAur, btnAur);
        }
    }

    // click event with source view params
    @OnClick(R.id.create_btn)
    public void onButtonClick(View view) {
        checkForValidation();
    }

    @OnClick(R.id.to_day_week)
    public void onButDayWeek(View view) {
        btnSelected = (Button) getActivity().findViewById(R.id.to_day_week);
        isWeekButton = true;
        startDialog(4);
    }
    @OnClick(R.id.btn_from_day_week)
    public void onBtnFromDayWeek(View view) {
        isWeekButton = true;
        btnSelected = (Button) getActivity().findViewById(R.id.btn_from_day_week);
        startDialog(4);
    }
    @OnClick(R.id.btn_to_time)
    public void onBtnTvToTime(View view) {
        isWeekButton = false;
        btnSelected = (Button) getActivity().findViewById(R.id.btn_to_time);
        startDialog(5);
    }
    @OnClick(R.id.btn_from_time)
    public void onBtnFromTime(View view) {
        isWeekButton = false;
        btnSelected = (Button) getActivity().findViewById(R.id.btn_from_time);
        startDialog(6);
    }
    @OnClick(R.id.btn_currency)
    public void onBtnPayMeth(View view) {
        isWeekButton = false;
        btnSelected = (Button) getActivity().findViewById(R.id.btn_currency);
        startDialog(7);
    }

    private void checkForValidation() {

        stSite = edSite.getText().toString();
        stNumber = edNumber.getText().toString();
        stAddress = edAddress.getText().toString();
        stAbout = edAbout.getText().toString();
        stMinSum = edMinSum.getText().toString();
        stPayMeth = tvCurrencyBtn.getText().toString();

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
        }else if (TextUtils.isEmpty(edMinSum.getText().toString())){
            showToast(txtTheMinimumAmount);
            anim(edMinSum);
            setFocus(edMinSum);
        }else if (TextUtils.isEmpty(edMinSum.getText().toString())){
            showToast(txtTheMinimumAmount);
            anim(edMinSum);
            setFocus(edMinSum);
        }else {
            stDaysOfTheWeek = removeSecondChar(fromDayWeek.getText().toString());
            stDaysOfTheWeek2 =  removeSecondChar(toDayWeek.getText().toString());
            stSpinnerCurrency = tvCurrencyBtn.getText().toString();
            String stfromTime = (String)  btnFromTime.getText();
            String stToTime = (String)  btnToTime.getText();

            stTime =  removeSecondChar(stfromTime) + " - " + removeSecondChar(stToTime);

            String stUniqueID = UUID.randomUUID().toString();

            city = new City(stSite, stNumber , stAddress, stAbout, stMinSum, stDaysOfTheWeek2, stDaysOfTheWeek, removeSecondChar(stPayMeth),
                    checkChosenCurrency(), Double.toString(mLatitudeDoub), Double.toString(mLongitudeDoub), stUniqueID, stTime);
            writeExternalStoragePrivateFile(city);

            changeFragment();
//            MainActivity mainActivity = new MainActivity();
//            mainActivity.changeFragment(new ShowCurrencyFragment(),  menu.findItem(R.id.nav_gallery), 2131296509);

           //openActivity(MainActivity.class);

            //readExternalStoragePrivateFile();
        }
    }
    public String removeSecondChar(String str) {
        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
    public String removeFirstChar(String s){
        if(stCurrency != null && stCurrency.length() > 0){
            return s.substring(1);
        }else {
            return null;
        }
    }
    public void changeFragment(){
        //replacing the fragment
        SearchPlaceOnMapFragment fragment = new SearchPlaceOnMapFragment();
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.app_bar_main2, fragment);
            ft.commit();
        }
//        MainActivity mainActivity = new MainActivity();
//        NavigationView navigationView = (NavigationView) mainActivity.findViewById(R.id.nav_view);
//        menu = navigationView.getMenu();
//        MenuItem item = menu.findItem(R.id.nav_gallery);
//        int id =  2131296509;
//        // Выделяем выбранный пункт меню в шторке
//        item.setChecked(true);
//        // Выводим выбранный пункт в заголовке
////        setTitle(item.getTitle());
//        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);

 //       currentItem = id;
    }

    private void setFocus(View view) {
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

//    public String getStringFromCB(){
//            for (int i = 0; i < cbList.size(); i++) {
//                if(cbList.get(i).isChecked()) {
//                    stCurrency += cbList.get(i).getText().toString() + txtComma + defStringOneSpace;
//                }
//            }
//        return removeLastChar(stCurrency);
//    }

    public String removeLastChar(String str) {
        if(str != null){
            if(str.length() != 0){
                return str.substring(0, str.length() - 1);
            }else {
                return str;
            }
        }else {
            return str;
        }
    }

    public void anim(View view){
        Animation incorrect_shake = AnimationUtils.loadAnimation(getActivity(), R.anim.incorrect_shake);
        createBtn.startAnimation(incorrect_shake);
        view.startAnimation(incorrect_shake);
        view.startAnimation(incorrect_shake);
    }


    public String readExternalStoragePrivateFile() {
        //We have to request the permission
        String str = null;
        if (isExternalStorageReadable()) {
            File dirPics = getActivity().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File f = new File(dirPics, txtMapFile);

            try {
                str = IOHelper.stringFromFile(f);
                // Toast.makeText(this, "str = " + str, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str;
    }


    public void writeExternalStoragePrivateFile(City cit) {
        String oldData = readExternalStoragePrivateFile();
        //requires permission
        File dirPics = getActivity().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS); //deleted when app uninstalls
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
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
            return true;

        return false;
    }

    private void showToast(String txtFild) {
        Toast.makeText(getActivity(),  txtField + txtFild + txtEmpty + requiredField, Toast.LENGTH_SHORT).show();
    }

    private void init() {
        try {
            calendar = Calendar.getInstance();
            btnDash = (Button) view.findViewById(R.id.btn_dash);
            btnLtc = (Button) view.findViewById(R.id.btn_ltc);
            btnEtc = (Button) view.findViewById(R.id.btn_etc);
            btnEth = (Button) view.findViewById(R.id.btn_eth);
            btnXrp = (Button) view.findViewById(R.id.btn_xrp);
            btnXmr = (Button) view.findViewById(R.id.btn_xmr);
            btnBtc = (Button) view.findViewById(R.id.btn_btc);
            btnMaid = (Button) view.findViewById(R.id.btn_maid);
            btnXem = (Button) view.findViewById(R.id.btn_xem);
            btnAur = (Button) view.findViewById(R.id.btn_aur);

            btnDash.setOnClickListener(this);
            btnLtc.setOnClickListener(this);
            btnEtc.setOnClickListener(this);
            btnEth.setOnClickListener(this);
            btnXrp.setOnClickListener(this);
            btnXmr.setOnClickListener(this);
            btnBtc.setOnClickListener(this);
            btnMaid.setOnClickListener(this);
            btnXem.setOnClickListener(this);
            btnAur.setOnClickListener(this);

            context = getActivity().getApplicationContext();
            hour = calendar.get(Calendar.HOUR_OF_DAY);
            min = calendar.get(Calendar.MINUTE);
        } catch (Exception e) {
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
//        if(isFrom){
//            fromTime.setText(new StringBuilder().append(hour).append(txtColon).append(min)
//                    .append(defStringOneSpace).append(format));
//        } else {
//            toTime.setText(new StringBuilder().append(hour).append(txtColon).append(min)
//                    .append(defStringOneSpace).append(format));
//        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startDialog(int numberToCheck) {
        final Intent intent = new Intent(getActivity(), DialogActivity.class);
        intent.putExtra("numberCheck", numberToCheck);
        startActivityForResult(intent, DIALOG_PICK);
    }

    private void setTextBtn(Button btnSelected, String currencyCode) {
        btnSelected.setText(currencyCode);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == DIALOG_PICK && resultCode == Activity.RESULT_OK) {
            String currencyCode = data.getStringExtra(cryptoCurrencyNames);
            setSource(btnSelected, currencyCode);
            Toast.makeText(getActivity(), txtYouSelected + currencyCode, Toast.LENGTH_LONG).show();
            }
        if (requestCode == GALLERY_PICK && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView imageView = (ImageView) getActivity().findViewById(R.id.image);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setSource(Button btnConvert, String selString) {
        try {
            btnConvert.setText(selString + downArrow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // click event with source view params
    @OnClick(R.id.add_photo)
    public void onButClick(View view) {
        try{
        Intent galleryIntent = new Intent();
        galleryIntent.setType("image/*");
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(Intent.createChooser(galleryIntent, txtSelectImage), GALLERY_PICK);

//                CropImage.activity()
//                        .setGuidelines(CropImageView.Guidelines.ON)
//                        .start(AccountSettingsActivity.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    public void openActivity(Class someClass){
//        Intent intent = new Intent(AddLabelActivity.this, someClass );
//        startActivity(intent);
//        finish();
//    }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_dash: checkBtn(btnDash); break;
            case R.id.btn_ltc: checkBtn(btnLtc); break;
            case R.id.btn_etc: checkBtn(btnEtc); break;
            case R.id.btn_eth: checkBtn(btnEth); break;
            case R.id.btn_xrp: checkBtn(btnXrp); break;
            case R.id.btn_xmr: checkBtn(btnXmr); break;
            case R.id.btn_btc: checkBtn(btnBtc); break;
            case R.id.btn_maid: checkBtn(btnMaid); break;
            case R.id.btn_xem: checkBtn(btnXem); break;
            case R.id.btn_aur: checkBtn(btnAur); break;
        }
    }
}
