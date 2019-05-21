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

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.activities.DialogActivity;
import com.allerates.appforyou.helpers.IOHelper;
import com.allerates.appforyou.model.Point;
import com.allerates.appforyou.request.AuthKey;
import com.allerates.appforyou.request.api.SetPoint;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Rikmen on 02.07.2018.
 */

public class AddFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "AddFragment";
    private static final int GALLERY_PICK = 1;
    private static final int DIALOG_PICK = 2;
    private int hour;
    private int min;
    private String stCurrency = "";
    private static final int LAYOUT = R.layout.add_layout;
    private Point point;
    private double mLongitudeDoub;
    private double mLatitudeDoub;
    private View view;
    private boolean isWeekButton = false;
    private String[] stArr = new String[0];
    private String stSite, stPhone, stAddress, stAbout, stMinSum,
            stToDaysOfTheWeek, stFromDaysOfTheWeek, stFromTime, stToTime, stPayMethBtn, stPayMeth, stCash, stCard, stMailCash;

    private Calendar calendar;
    private Context context;
    private Menu menu;
    private Button btnSelected;
    private Button btnDash, btnLtc, btnEtc, btnEth, btnXrp, btnXmr, btnBtc, btnMaid, btnXem, btnAur;
    private int intCash, intCard, intMailCash, intDash, intLtc, intEtc, intEth, intXrp, intXmr, intBtc, intMaid, intXem, intAur;
    private int numbPaymentMethod;
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
    @BindString(R.string.the_number) String theNumber;
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
    @BindView(R.id.btn_currency) Button btnPayMethBtn;
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
    @BindString(R.string.payment_method_number) String paymentMethodNumber;
    @BindString(R.string.txt_you_selected) String txtYouSelected;
    @BindString(R.string.txt_down_arrow) String downArrow;

    @BindString(R.string.txt_mail_cash) String txtMailCash;
    @BindString(R.string.txt_card_check) String txtCardCheck;
    @BindString(R.string.txt_cash) String txtCash;

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
    //<item>Card</item>
//        <item>Mail</item>
//        <item>Cash</item>
    private void checkChosenPaymentMethod(String btnString, int numbPaymentMethod) {
        try {
        if(numbPaymentMethod == 2){
            stCash = "1";
            stMailCash = "0";
            stCard = "0";
                }else if(numbPaymentMethod == 1){
                    stMailCash = "1";
                    stCard = "0";
                    stCash = "0";
                        }else if(numbPaymentMethod == 0){
                            stCard = "1";
                            stMailCash = "0";
                            stCash = "0";
                        }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // click event with source view params
    @OnClick(R.id.create_btn)
    public void onButtonClick(View view) {
        try {
        checkForValidation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.to_day_week)
    public void onButDayWeek(View view) {
        try {
        btnSelected = (Button) getActivity().findViewById(R.id.to_day_week);
        isWeekButton = true;
        startDialog(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @OnClick(R.id.btn_from_day_week)
    public void onBtnFromDayWeek(View view) {
        try {
        isWeekButton = true;
        btnSelected = (Button) getActivity().findViewById(R.id.btn_from_day_week);
        startDialog(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @OnClick(R.id.btn_to_time)
    public void onBtnTvToTime(View view) {
        try {
        isWeekButton = false;
        btnSelected = (Button) getActivity().findViewById(R.id.btn_to_time);
        startDialog(6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @OnClick(R.id.btn_from_time)
    public void onBtnFromTime(View view) {
        try {
        isWeekButton = false;
        btnSelected = (Button) getActivity().findViewById(R.id.btn_from_time);
        startDialog(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @OnClick(R.id.btn_currency)
    public void onBtnPayMeth(View view) {
        try {
        isWeekButton = false;
        btnSelected = (Button) getActivity().findViewById(R.id.btn_currency);
        startDialog(7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkForValidation() {
        try {
        stSite = edSite.getText().toString();
        stPhone = edNumber.getText().toString();
        stAddress = edAddress.getText().toString();
        stAbout = edAbout.getText().toString();
        stMinSum = edMinSum.getText().toString();
        stPayMeth = btnPayMethBtn.getText().toString();

        // check for validity of the specified data
        if (TextUtils.isEmpty(edSite.getText().toString()) || !edSite.getText().toString().contains(txtDot)){
            showToast(txtSite);
            setFocus(edSite);
            anim(edSite);
        }else if (TextUtils.isEmpty(edNumber.getText().toString()) || !isInteger(edNumber.getText().toString())){
            if(edNumber.getText().toString().length() == 11){
                showToast(txtThePhoneNumber);
                setFocus(edNumber);
                anim(edNumber);
            }
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
            if(isInteger(edMinSum.getText().toString(), 10)){
                stFromDaysOfTheWeek = removeSecondChar(fromDayWeek.getText().toString());
                stToDaysOfTheWeek =  removeSecondChar(toDayWeek.getText().toString());
                stPayMeth = btnPayMethBtn.getText().toString();
                checkChosenPaymentMethod(stPayMeth, numbPaymentMethod);
                stFromTime = (String)  btnFromTime.getText();
                stToTime = (String)  btnToTime.getText();

                String stUniqueID = UUID.randomUUID().toString();
//            point = new Point(stSite, stPhone, stAddress, stAbout, stMinSum, stToDaysOfTheWeek, stFromDaysOfTheWeek, removeSecondChar(stPayMeth), checkChosenCurrency(), Double.toString(mLatitudeDoub), Double.toString(mLongitudeDoub), stUniqueID);
                //  writeExternalStoragePrivateFile(point);// временно
                //   setPoint(point);
                setPointWith(point);

//            MainActivity mainActivity = new MainActivity();
//            mainActivity.changeFragment(new ShowCurrencyFragment(),  menu.findItem(R.id.nav_gallery), 2131296509);

                //openActivity(MainActivity.class);

                //readExternalStoragePrivateFile();
            }else {
                showToastIncInt(txtTheMinimumAmount);
                anim(edMinSum);
                setFocus(edMinSum);
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }

//    private void setPoint(Point point) {
//        SetPoint setPoint;
//        setPoint = Common.setPoint();
//        String stUniqueID = UUID.randomUUID().toString();
//        setPoint.mSetPoint(stSite, stPhone,  Double.toString(mLatitudeDoub), Double.toString(mLongitudeDoub), stFromDaysOfTheWeek + stToDaysOfTheWeek, stTime, stMinSum, "true", "true","true","true","true","true","true", "true")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<AuthKey>() {
//                               @Override
//                               public void accept(AuthKey authKey) throws Exception {
//                                   String stKey = authKey.getAuthKey();
//                                   if(stKey != null){
//                                       Toast.makeText(getContext(), "Point successfully created",
//                                               Toast.LENGTH_LONG).show();
//                                       //changeFragment();
//                                    } else {
//                                       Toast.makeText(getContext(), "Unable to create point",
//                                               Toast.LENGTH_LONG).show();
//                                   }
//                               }
//                           },
//                        throwable -> Log.e(TAG, "Error: " + throwable));
//    }
    // http://www.look-studio.com/wp-json/NewMapPoint/v2?site_curency=dddd&phone_currency_place=12345678101&new_point_Sh=13.123672&new_point_Dl=46.123123&day_work=12&time_work=12&minimal_amount=234&card=1&BTC=1&ETH=1&MAID=1&XMR=1&XRP=1&XEM=1&DASH=1&LT%D0%A1=1&AUR=1&ETC=1&day_work_end=%D0%9F%D0%BE%D1%80%D0%B0

    // на создание точки
    private void setPointWith(Point point) {
        try {
        SetPoint setPoint;
        setPoint = Common.setPoint();
        setPoint.mSetPoint(stSite, stPhone,  Double.toString(mLatitudeDoub), Double.toString(mLongitudeDoub), stFromDaysOfTheWeek , stFromTime, stMinSum, stCash, intToString(intBtc), intToString(intEth), intToString(intMaid), intToString(intXmr),intToString(intXrp),intToString(intXem),intToString(intDash), intToString(intLtc), intToString(intAur), intToString(intEtc), stToDaysOfTheWeek , stToTime, stAbout, stCard, stMailCash, stAddress)
                .enqueue(new Callback <List<AuthKey>>() {
            @Override
            public void onResponse(Call<List<AuthKey>> call, Response <List<AuthKey>> response) {
                if (response.code() == 200 && response.body() != null) {
                    String stKey = response.body().get(0).getAuthKey();
                    if (stKey != null) {
                        Toast.makeText(getContext(), "Point successfully created",
                                Toast.LENGTH_LONG).show();
                        changeFragment();
                    } else {
                        Toast.makeText(getContext(), response + " Unable to create point",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<AuthKey>> call, Throwable t) {
                try {
                    if (t.getCause() != null) {
                        Toast.makeText(getContext(), "Unable to create point" + t.getCause().getMessage(),
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "Unable to create point." + " Message error not found",
                                Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getContext(), "Message error not found",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String intToString(int i) {
        return Integer.toString(i);
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
        try {
        //replacing the fragment
        SearchPlaceOnMapFragment fragment = new SearchPlaceOnMapFragment();
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.app_bar_main2, fragment);
            ft.commit();
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFocus(View view) {
        try {
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
        Animation incorrect_shake = AnimationUtils.loadAnimation(getActivity(), R.anim.incorrect_shake);
        createBtn.startAnimation(incorrect_shake);
        view.startAnimation(incorrect_shake);
        view.startAnimation(incorrect_shake);
        } catch (Exception e) {
            e.printStackTrace();
        }
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


    public void writeExternalStoragePrivateFile(Point cit) {
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
    private void showToastIncInt(String txtFild) {
        Toast.makeText(getActivity(),  txtField + txtFild + txtEmpty + theNumber, Toast.LENGTH_SHORT).show();
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
        try{
        final Intent intent = new Intent(getActivity(), DialogActivity.class);
        intent.putExtra("numberCheck", numberToCheck);
        startActivityForResult(intent, DIALOG_PICK);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            numbPaymentMethod = data.getIntExtra(paymentMethodNumber, 0);
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
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
