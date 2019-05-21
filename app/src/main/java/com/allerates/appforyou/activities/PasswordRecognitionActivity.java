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
import android.widget.TextView;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.helpers.InputValidation;
import com.allerates.appforyou.request.Example;
import com.allerates.appforyou.request.api.SetUserPass;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

public class PasswordRecognitionActivity extends AppCompatActivity {
    @BindView(R.id.send) Button btnSend;
    @BindView(R.id.title) TextView tvTitle;

    private CheckConnection checkConnection;
    private Unbinder unbinder;
    private InputValidation inputValidation;
    private TextInputEditText edEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.activity_password_recognition);
        unbinder = ButterKnife.bind(this);

        edEmail = (TextInputEditText) findViewById(R.id.ed_email);
        inputValidation =  new InputValidation(getApplicationContext());
        checkConnection = new CheckConnection();
    }
    @OnClick(R.id.send)
    public void onButClick(View view) {
        if(edEmail != null){
            if (inputValidation.isInputEditTextEmail(getApplicationContext(), edEmail, getString(R.string.error_message_email))){
                if (checkConnection.isOnline(getApplicationContext())) {
                    sendConf(btnSend, PasswordRecognitionActivity.this, edEmail.getText().toString());
                }else {
                    checkConnection.makeToastConnection(PasswordRecognitionActivity.this);
                }
            } else {
                Toast.makeText(PasswordRecognitionActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(PasswordRecognitionActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
        }
    }


    public void openActivity(){
        Intent intent = new Intent(PasswordRecognitionActivity.this, ActivitySetPassword.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra("stMail", edEmail.getText().toString());
        startActivity(intent);
        overridePendingTransition(R.anim.open_main, R.anim.close_next);
    }
    public void sendConf(final Button btnSend, final Context context, final String userMail){
        final ProgressDialog mDialog = new ProgressDialog(context);
        mDialog.setMessage(context.getString(R.string.wait_string));
        mDialog.setCancelable(false);
        mDialog.show();

        SetUserPass mSetUserPass;
        mSetUserPass = Common.setUserPass();
        mSetUserPass.mValue(userMail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Example>() {
                               @Override
                               public void accept(@NonNull Example example) throws Exception {
                                   if (example.getStatus().equals("success")) {
                                       tvTitle.setText(example.getMessage().toString());
                                       Toast.makeText(
                                               PasswordRecognitionActivity.this,
                                               example.getMessage().toString(),
                                               Toast.LENGTH_SHORT).show();
                                       openActivity();
                                       mDialog.dismiss();
                                       btnSend.setEnabled(true);
                                   }else {
                                       Toast.makeText(context, example.getMessage(), Toast.LENGTH_LONG).show();
                                       btnSend.setEnabled(true);
                                       mDialog.dismiss();
                                   }
                               }
                           },
                        throwable -> {
                            Toast.makeText(context, "Failed to send email", Toast.LENGTH_LONG).show();
                            Log.e(TAG, "Error: " + throwable);
                            mDialog.dismiss();
                        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(PasswordRecognitionActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.open_main, R.anim.close_next);
    }

    @Override
    public void onDestroy() {
        try {
            super.onDestroy();
            unbinder.unbind();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
