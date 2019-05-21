package com.allerates.appforyou.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.helpers.InputValidation;
import com.allerates.appforyou.request.Example;
import com.allerates.appforyou.request.api.SetUserPassCode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class ActivitySetPassword extends AppCompatActivity {

    @BindView(R.id.send) Button btnSend;
    @BindView(R.id.ed_password) TextInputEditText edPassword;
    @BindView(R.id.ed_password2) TextInputEditText edPassword2;
    @BindView(R.id.ed_code) TextInputEditText edCode;
    private CheckConnection checkConnection;
    private Unbinder unbinder;
    private InputValidation inputValidation;
    private String sEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_set_password);
        unbinder = ButterKnife.bind(this);
        if(getIntent().getExtras().getString("stMail") != null){
            sEmail = getIntent().getExtras().getString("stMail");
        }else {
            sEmail = null;
        }

        inputValidation = new InputValidation(getApplicationContext());
        checkConnection = new CheckConnection();
    }

    @OnClick(R.id.send)
    public void onButClick(View view) {
        if (edCode != null) {
            if (inputValidation.isInputEditTextMatches(edPassword2, edPassword, getString(R.string.error_password_match))) {
                if (checkConnection.isOnline(getApplicationContext())) {
                    sendConf(btnSend, ActivitySetPassword.this, sEmail, edPassword.getText().toString());
                } else {
                    checkConnection.makeToastConnection(ActivitySetPassword.this);
                }
            } else {
                Toast.makeText(ActivitySetPassword.this, getString(R.string.error_password_match), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(ActivitySetPassword.this, "Enter code", Toast.LENGTH_SHORT).show();
        }
    }


    public void sendConf(final Button btnSend, final Context context, final String userMail, final String sPassword) {
        final ProgressDialog mDialog = new ProgressDialog(context);
        mDialog.setMessage(context.getString(R.string.wait_string));
        mDialog.setCancelable(false);
        mDialog.show();
        String sCode = null;
        if(edCode != null){
            sCode = edCode.getText().toString();
        }
        SetUserPassCode mSetUserPassCode;
        mSetUserPassCode = Common.setUserPassCode();
        mSetUserPassCode.mValue(userMail, sCode, sPassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer <Example>() {
                               @Override
                               public void accept(@NonNull Example example) throws Exception {
                                   if (example.getStatus().equals("success")) {
                                       Toast.makeText(
                                               ActivitySetPassword.this,
                                               example.getMessage().toString(),
                                               Toast.LENGTH_SHORT).show();
                                       Intent accountsIntent = new Intent(getApplicationContext(), LoginActivity.class);
                                       startActivity(accountsIntent);
                                       mDialog.dismiss();
                                       btnSend.setEnabled(true);
                                   } else {
                                       Toast.makeText(context, example.getMessage(), Toast.LENGTH_LONG).show();
                                       btnSend.setEnabled(true);
                                       mDialog.dismiss();
                                   }
                               }
                           },
                        throwable -> {
                            Toast.makeText(context, "Failed to send code", Toast.LENGTH_LONG).show();
                            Log.e(TAG, "Error: " + throwable);
                            mDialog.dismiss();
                        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ActivitySetPassword.this, PasswordRecognitionActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.open_main, R.anim.close_next);
    }

    @Override
    public void onDestroy() {
        try {
            super.onDestroy();
            unbinder.unbind();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}