package com.allerates.appforyou.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.InputValidation;
import com.allerates.appforyou.model.Ip;
import com.allerates.appforyou.model.Reg;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.LocationREST;
import com.allerates.appforyou.request.api.IpServiceGet;
import com.allerates.appforyou.request.api.IpServiceREST;
import com.allerates.appforyou.request.api.RegWithMail;
import com.allerates.appforyou.sql.DatabaseHelper;
import com.allerates.appforyou.utils.Utils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;
    private TextInputEditText textInputEditTextName;
    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextInputEditText textInputEditTextConfirmPassword;
    private TextView textView4;
    private AppCompatButton appCompatButtonRegister;
    private AppCompatTextView appCompatTextViewLoginLink;
    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;
    private User user;

    private String id;
    private SharedPreferences userLocalDatabase;
    public static String ipString;
    private static final String SP_NAME = "userDetails";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void getCountry(User user, boolean isCheck, String ip, final Context context){
        // s = "109.254.254.81";
        IpServiceREST mService;
        try {
            mService = Common.getCurrentSer();
            mService.defineCurrency(ip).enqueue(new Callback<LocationREST>() {
                @Override
                public void onResponse(Call<LocationREST> call, Response<LocationREST> response) {
                    String code = response.body().getGeopluginCurrencyCode();
                    initUserLocalDatabase(context);
                    SharedPreferences.Editor spEditor = userLocalDatabase.edit();
                    spEditor.putString("money", code); // for def currency
                    spEditor.commit();
//                    RegisterActivity registerActivity = new RegisterActivity();
//                    registerActivity.openActivity(context);
                    Intent accountsIntent;
                    if(isCheck){
                        accountsIntent = new Intent(context, MainActivity.class);
                        startActivity(accountsIntent);
                    }else {
                        accountsIntent = new Intent(context, ActivityCheckPassword.class);
                        accountsIntent.putExtra("active_key", user.getId());
                        accountsIntent.putExtra("email", user.getEmail());
                        accountsIntent.putExtra("name", user.getName());
                        accountsIntent.putExtra("password", user.getPassword());
                        startActivity(accountsIntent);
                    }
                }

                @Override
                public void onFailure(Call<LocationREST> call, Throwable t) {
                    Log.e("ERROR", t.getMessage());
                    initUserLocalDatabase(context);
                    SharedPreferences.Editor spEditor = userLocalDatabase.edit();
                    spEditor.putString("money", context.getString(R.string.def_currency)); // for def currency
                    spEditor.commit();
                    openActivity(context);
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void initUserLocalDatabase(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void getIpAddress(boolean isCheck, final User user, final Context context){
        IpServiceGet mServiceIp;
        mServiceIp = Common.getIpService();
        mServiceIp.getIP().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                try {
                    if(response.body().getIp() != null){
                        String ip = response.body().getIp(); // getIpAddress
                        getCountry(user, isCheck, ip, context);
                    }else {
                        getCountry(user, isCheck,"109.254.254.81", context);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                    getCountry(user, isCheck, "109.254.254.81", context);
                }
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                String ip = context.getString(R.string.def_ip); // defIp
                getCountry(user, isCheck, ip,  context);
            }
        });
    }

    private void initViews() {
        try {
        textView4 = (TextView) findViewById(R.id.textView4);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

        ipString = Utils.getIPAddress(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This trimLastCharacter is to initialize listeners
     */
    private void initListeners() {
        try {
        appCompatButtonRegister.setOnClickListener(this);
        appCompatTextViewLoginLink.setOnClickListener(this);
        textView4.setOnClickListener(this);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This trimLastCharacter is to initialize objects to be used
     */
    private void initObjects() {
        try {
        inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(activity);
        user = new User();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This implemented trimLastCharacter is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        try {
        switch (v.getId()) {
            case R.id.textView4:
                finish();
                break;

            case R.id.appCompatButtonRegister:
                appCompatButtonRegister.setEnabled(false);
                postDataToSQLite(appCompatButtonRegister);
                break;

            case R.id.appCompatTextViewLoginLink:
                finish();
                break;
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This trimLastCharacter is to validate the input text fields and post data to SQLite
     */
    private void verifyValidity() {
        try {
            if (!inputValidation.isInputEditTextFilled(getApplicationContext(), textInputEditTextName, getString(R.string.error_message_name))) {
                return;
            }
            if (!inputValidation.isInputEditTextEmail(getApplicationContext(), textInputEditTextEmail, getString(R.string.error_message_email))) {
                return;
            }
            if (!inputValidation.isInputEditTextFilled(getApplicationContext(), textInputEditTextPassword, getString(R.string.error_message_password))) {
                return;
            }
            if (!inputValidation.isInputEditTextMatches(textInputEditTextPassword, textInputEditTextConfirmPassword,
                    getString(R.string.error_password_match))) {
                return;
            }
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    private void postDataToSQLite(AppCompatButton appCompatButtonRegister) {
        try {
        verifyValidity();
        if(Common.isGetReq){
            // databaseHelper.setUserLogedIn(true, getApplicationContext());
            // databaseHelper.getReg(getApplicationContext(), "MyName", "myMailwdwww@gmail.com", "myPassword");

            // if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {
            String name, email, password;
            name = textInputEditTextName.getText().toString().trim();
            email = textInputEditTextEmail.getText().toString().trim();
            password = textInputEditTextPassword.getText().toString().trim();

            getRegTest(appCompatButtonRegister, RegisterActivity.this, name, email, password);

            // Snack Bar to show success message that record saved successfully
            // Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            // emptyInputEditText();
//        } else {
//            // Snack Bar to show error message that record already exists
//            Toast.makeText(this, getString(R.string.error_email_exists), Toast.LENGTH_LONG).show();
//            appCompatButtonRegister.setEnabled(true);
//        }
        }else {
            appCompatButtonRegister.setEnabled(true);
        }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void getRegTest(final AppCompatButton appCompatButtonRegister, final Context context, final String exName, final String exMail, final String exPassword){

        final ProgressDialog mDialog = new ProgressDialog(context);
        mDialog.setMessage(context.getString(R.string.wait_string));
        mDialog.setCancelable(false);
        mDialog.show();
        user = new User();
        DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(context);

        RegWithMail mRegWithMail;
        mRegWithMail = Common.getReg();
        mRegWithMail.mValue(exName, exMail, exPassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Reg>() {
                               @Override
                               public void accept(@NonNull Reg reg) throws Exception {
                                   id = reg.getAuth_key();
                                   if(id != null){

                                       user.setName(exName);
                                       user.setEmail(exMail);
                                       user.setPassword(exPassword);
                                       user.setId(id);
                                       getIpAddress(false, user, context);
//                                       databaseHelper.addUser(user);
//                                       databaseHelper.setUserLogedIn(true, context);
                                       appCompatButtonRegister.setEnabled(true);
                                       mDialog.dismiss();
                                   } else {
                                       appCompatButtonRegister.setEnabled(true);

                                       Toast.makeText(context, "This mail is already registered.",
                                               Toast.LENGTH_LONG).show();
                                       mDialog.dismiss();
                                   }
                               }
                           },
                        throwable -> {
                            Log.e(TAG, "Error: " + throwable);
                            mDialog.dismiss();
                        });
    }
    public void openActivity(Context context) {
        //try {
        Intent accountsIntent = new Intent(context, MainActivity.class);
        startActivity(accountsIntent);
        //finish();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * This trimLastCharacter is to empty all input edit text
     */

    private void emptyInputEditText() {
        try {
        textInputEditTextName.setText(null);
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        textInputEditTextConfirmPassword.setText(null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
