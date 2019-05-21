package com.allerates.appforyou.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.UpData;
import com.allerates.appforyou.request.UserDataList;
import com.allerates.appforyou.request.api.GetDataUser;
import com.allerates.appforyou.request.api.SetUpdateUser;
import com.allerates.appforyou.request.api.UpdateUser;
import com.allerates.appforyou.sql.DatabaseHelper;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class SettingActivity extends AppCompatActivity {
    private static final int RESULT_LOAD_IMG = 2;
    @BindString(R.string.txt_crypto_currency_names) String cryptoCurrencyNames;
    @BindString(R.string.txt_you_selected) String txtYouSelected;
    @BindString(R.string.txt_down_arrow) String downArrow;
    @BindString(R.string.wrong) String wentWrong;
    @BindString(R.string.txt_def_id_user) String defIdUser;
    @BindString(R.string.havent_picked) String haventPicked;
    @BindString(R.string.money) String stMoney;
    @BindString(R.string.number_check_simpl) String numberCheckSimpl;
    @BindString(R.string.txt_suc_updated) String txtSucUpdated;
    @BindString(R.string.txt_not_correct) String txtNotCorrect;
    @BindString(R.string.txt_failed_to_up) String txtFailedToUp;
    @BindString(R.string.txt_error_colon) String txtErrorColon;
    @BindView(R.id.ed_name) EditText edName;
    @BindView(R.id.ed_password) EditText edPassword;
    //@BindView(R.id.ed_surname) EditText edSurname;
    @BindView(R.id.ed_phone) EditText edPhone;
    @BindView(R.id.check_act) CheckBox checkAct;
    @BindView(R.id.ed_email) EditText edEmail;
    @BindView(R.id.add_photo) ImageView imgUser;
    @BindView(R.id.def_img) View def_img;
    @BindView(R.id.btn_currency) Button btnCurrency;
    @BindView(R.id.create_btn) Button BtnCreate;
    private String stPassword, stName, stSurname, stEmail, stPhone, stCurrency;
    private String id;
    private Bitmap bitmap;
    private SharedPreferences userLocalDatabase;
    private GetDataUser getDataUser;
    private UpdateUser upUser;
    private SetUpdateUser setUpdateUser;
    private CheckConnection checkConnection;
    private User user;
    private String imgStr;
    private byte[] imageByteArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  try {
        setContentView(R.layout.fragment_setting);
        init();
        initToolbar();

//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }

    private String getCurrentCurrency() {
    try {
        userLocalDatabase = getSharedPreferences(DatabaseHelper.getSpName(), 0);
        return userLocalDatabase.getString(getString(R.string.money_string), null);
    } catch (Exception e) {
    e.printStackTrace();
    return null;
    }
    }
    private void setCurrentCurrency() {
        final String coinName = getCurrentCurrency();
        btnCurrency.setText(String.format("%s%s", coinName, downArrow));
    }
    private void init() {
        checkConnection = new CheckConnection();
        getDataUser = Common.getUserDate();
        upUser = Common.setUserDate();
        setUpdateUser = Common.setUpdateUser();

        ButterKnife.bind(this);
        setCurrentCurrency();
        setDataUser();

        //setTextInView();
    }

    @OnClick(R.id.btn_currency)
    public void onB(View view) {
        startDialog();
    }

    @OnClick(R.id.add_photo)
    public void onImg(View view) {
        pickUpPhoto();
    }

    @OnClick(R.id.create_btn)
    public void sendData(View view) {
        getFromEd();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR1)
    protected int sizeOf(Bitmap data) {
        int tempData;
        if(data == null){
            tempData = 0;
        }else {
            tempData = data.getByteCount();
        }
        return tempData;
    }
    /**
     * reduces the size of the image
     * @param image
     * @param maxSize
     * @return
     */
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float)width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }

    public String decodeImageToBase64() {
        String temp;
        try{
            int sizeImg;
            // bitmap = BitmapFactory.decodeResource(getResources(), imgUser.getId());
            bitmap = ((BitmapDrawable) imgUser.getDrawable()).getBitmap();

            sizeImg = sizeOf(bitmap);

            if(sizeImg > 1000000){
                bitmap = getResizedBitmap(bitmap, 500);
            }
            // R.drawable.images is image for my ImageView
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
            imageByteArray = stream.toByteArray();
            imgStr = Base64.encodeToString(imageByteArray, 0);
            // get img
            temp = imgStr;
        }catch (Exception e){
            temp = null;
        }

        return temp;
    }
    public void decBase64ToImage(String baseSiFor) {
        // decode base64 string to image
        imageByteArray = Base64.decode(baseSiFor, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);
        imgUser.setImageBitmap(decodedImage);
    }
    public void pickUpPhoto() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, RESULT_LOAD_IMG);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Clear the Activity's bundle of the subsidiary fragments' bundles.
        outState.clear();
    }


    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent data) {
        super.onActivityResult(reqCode, resultCode, data);
        if (reqCode == 1 && resultCode == Activity.RESULT_OK) {
            String currencyCode = data.getStringExtra(cryptoCurrencyNames);
            setSource(btnCurrency, currencyCode);
            setCoin2MoneySource(currencyCode);
            Toast.makeText(this, txtYouSelected + currencyCode, Toast.LENGTH_LONG).show();
        }

        if (reqCode == 2 && resultCode == Activity.RESULT_OK) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imgUser.setImageBitmap(selectedImage);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(SettingActivity.this, wentWrong, Toast.LENGTH_LONG).show();
            }
        }else {
            Toast.makeText(SettingActivity.this, haventPicked, Toast.LENGTH_LONG).show();
        }
    }

    private void setSource(Button btnConvert, String selString) {
        try {
            btnConvert.setText(selString + downArrow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startDialog() {
        final Intent intent = new Intent(this, DialogActivity.class);
        intent.putExtra(numberCheckSimpl, 3);
        startActivityForResult(intent, 1);
    }
    private void setFocus(View view) {
        view.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    private void getFromEd() {
        if (getStringEd(edPassword) != null) {
            stPassword = getStringEd(edPassword);
            if (getStringEd(edName) != null) {
                stName = getStringEd(edName);
                if (getStringEd(edEmail) != null) {
                    stEmail = getStringEd(edEmail);
                        if (getStringEd(edPhone) != null) {
                            stPhone = getStringEd(edPhone);
                            if (id == null) {
                                id = defIdUser;
                            }
                            if (isInternet()) {
                                setDataOfUser(id);
                            }
                        }
                }
            }
        }
    }

    private void upDataOfUser(String auth) {
        final ProgressDialog mDialog = new ProgressDialog(SettingActivity.this);
        mDialog.setMessage(getResources().getString(R.string.txt_plz_wait));
        mDialog.setCancelable(false);
        mDialog.show();
        getFromEd();



//        setUpdateUser.savePost(stName, stSurname, stPhone, stEmail, stCurrency, id, stPassword, stUpImage)                   .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<UpData>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//
//                    }
//
//                    @Override
//                    public void onNext(UpData upData) {
//                        if(upData.getData().equals("user date update now")){
//
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
    }
    private void setDataOfUser(String auth) {
        String stImgBase;
        stImgBase = decodeImageToBase64();
        final ProgressDialog mDialog = new ProgressDialog(SettingActivity.this);
        mDialog.setMessage(getResources().getString(R.string.txt_plz_wait));
        mDialog.setCancelable(false);
        mDialog.show();
        stCurrency = getCurrentCurrency();
            upUser.sendData(stName , stPhone, stEmail, stCurrency , auth, stPassword , stImgBase)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UpData>() {
                               @Override
                               public void accept(com.allerates.appforyou.request.UpData upData) throws Exception {
                                   if(upData.getMessage() != null){
                                       if(upData.getMessage().equals("all user date are update")){
                                           Toast.makeText(getApplicationContext(), txtSucUpdated, Toast.LENGTH_SHORT).show();
                                       }else {
                                           Toast.makeText(getApplicationContext(), txtNotCorrect, Toast.LENGTH_SHORT).show();
                                       }
                                   }else {
                                      // Toast.makeText(getApplicationContext(), "try again", Toast.LENGTH_SHORT).show();
                                   }
                                   mDialog.dismiss();
                               }
                           },
                        throwable -> {
                            Toast.makeText(getApplicationContext(), txtFailedToUp + txtErrorColon + throwable , Toast.LENGTH_SHORT).show();
                            Log.e("TAG", txtErrorColon + throwable);
                            mDialog.dismiss();
                        });
    }

    private String getStringEd(EditText editText) {
        String retSt = null;
         if(editText.getText() != null && editText.getText().length() > 1){
             retSt = editText.getText().toString();
             }else {
                 setFocus(editText);
             }
             return retSt;
    }

    private void getDataOfUser(String auth) {
        final ProgressDialog mDialog = new ProgressDialog(SettingActivity.this);
        mDialog.setMessage(getResources().getString(R.string.txt_plz_wait));
        mDialog.setCancelable(false);
        mDialog.show();

        getDataUser.sendKey(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserDataList>() {
                       @Override
                       public void accept(com.allerates.appforyou.request.UserDataList userDataList) throws Exception {
                       // mDialog.dismiss();
                       if(userDataList.getQueryContent().get(0).getUserPhone() != null){
                           edPhone.setText(userDataList.getQueryContent().get(0).getUserPhone());
                       }
                       if(userDataList.getQueryContent().get(0).getActivateUser() != null){
                           isActivate(userDataList.getQueryContent().get(0).getActivateUser());
                       }
                       if(userDataList.getQueryContent().get(0).getExPassword() != null){
                           edPassword.setText(userDataList.getQueryContent().get(0).getExPassword());
                       }
                       if(userDataList.getQueryContent().get(0).getExName() != null){
                           edName.setText(userDataList.getQueryContent().get(0).getExName());
                       }
                       if(userDataList.getQueryContent().get(0).getExMail() != null){
                           edEmail.setText(userDataList.getQueryContent().get(0).getExMail());
                       }
//                       if(userDataList.getQueryContent().get(0).getSurName() != null){
//                           edSurname.setText(userDataList.getQueryContent().get(0).getSurName());
//                       }
                       if(userDataList.getImgContent() != null){
                           decBase64ToImage(userDataList.getImgContent());

                       // userDataList.getQueryContent().get(1);

                       // imgToBase64();
                       }
                           mDialog.dismiss();
                       }
                   },
                throwable -> {
                    Toast.makeText(this, "Error " + throwable, Toast.LENGTH_LONG).show();
                    Log.e("TAG", txtErrorColon + throwable);
                    mDialog.dismiss();
                });
    }

    private void isActivate(String activateUser) {
        if(activateUser.equals("1")){
            checkAct.setChecked(true);
            checkAct.setText("confirmed");
        }
    }

    private boolean isInternet() {
        if (checkConnection.isOnline(getApplicationContext())) {
            return true;
        }else {
            checkConnection.makeToastConnection(this);
            return false;
        }
    }

    public User getSt() {
        DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(getApplicationContext());
        return databaseHelper.getUser();

    }

    public void setTextInView() {
        if(user.getName() != null){
            edName.setText(user.getName());
        }
        if(user.getEmail() != null){
            edEmail.setText(user.getEmail());
        }
//        if(user.getName() != null){
//            edSurname.setText(user.getName());
//        }
    }
    public void setDataUser() {
        user = new User();
        user = getSt();
        id = user.getId();
        if(id == null){
            id = defIdUser;
        }
        if(isInternet()){
            getDataOfUser(id);
        }
    }

    private void initToolbar() {
        try {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.setting);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void setCoin2MoneySource(String coinName) {
        try {
            userLocalDatabase = getApplicationContext().getSharedPreferences(DatabaseHelper.getSpName(), 0);
            SharedPreferences.Editor spEditor = userLocalDatabase.edit();
            spEditor.putString(stMoney, coinName);
            spEditor.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Tracked depression back
     */
    @Override
    public void onBackPressed() {
        try {
        super.onBackPressed();
        Intent intent = new Intent(SettingActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }//onBackPressed
}
