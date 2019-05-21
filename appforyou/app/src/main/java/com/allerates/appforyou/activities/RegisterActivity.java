package com.allerates.appforyou.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.TextView;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.InputValidation;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.api.IpService;
import com.allerates.appforyou.sql.DatabaseHelper;
import com.allerates.appforyou.utils.Utils;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RegisterActivity.this;

    private NestedScrollView nestedScrollView;

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
    private IpService mService;
    public static String ipString;

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


    private void initViews() {
        try {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textView4 = (TextView) findViewById(R.id.textView4);

        textInputEditTextName = (TextInputEditText) findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);
        textInputEditTextConfirmPassword = (TextInputEditText) findViewById(R.id.textInputEditTextConfirmPassword);

        appCompatButtonRegister = (AppCompatButton) findViewById(R.id.appCompatButtonRegister);

        appCompatTextViewLoginLink = (AppCompatTextView) findViewById(R.id.appCompatTextViewLoginLink);

        mService = Common.getCurrentService();
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
                postDataToSQLite();
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
    private void postDataToSQLite() {
        try {
        if (!inputValidation.isInputEditTextFilled(getApplicationContext(), textInputEditTextName, getString(R.string.error_message_name))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(getApplicationContext(), textInputEditTextEmail, getString(R.string.error_message_email))) {
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

        if (!databaseHelper.checkUser(textInputEditTextEmail.getText().toString().trim())) {

            user.setName(textInputEditTextName.getText().toString().trim());
            user.setEmail(textInputEditTextEmail.getText().toString().trim());
            user.setPassword(textInputEditTextPassword.getText().toString().trim());

            databaseHelper.addUser(user);
            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();

            databaseHelper.setUserLogedIn(true, getApplicationContext());
            databaseHelper.getIpAddress(textInputEditTextEmail.getText().toString().trim(), getApplicationContext());

        } else {
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void openActivity(Context context, String email) {
        try {
        Intent accountsIntent = new Intent(context, MainActivity.class);
        accountsIntent.putExtra("EMAIL", email);
        context.startActivity(accountsIntent);
        } catch(Exception e) {
            e.printStackTrace();
        }
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
