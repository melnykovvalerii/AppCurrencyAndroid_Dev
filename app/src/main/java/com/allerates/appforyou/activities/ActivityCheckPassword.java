package com.allerates.appforyou.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.Example;
import com.allerates.appforyou.request.UserDataList;
import com.allerates.appforyou.request.api.GetDataUser;
import com.allerates.appforyou.request.api.SendVerMail;
import com.allerates.appforyou.sql.DatabaseHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.support.constraint.Constraints.TAG;

/**
 * Created by rikmen00@gmail.com on 01.03.2019.
 */


public class ActivityCheckPassword extends AppCompatActivity {

    public Toolbar toolbar;
    private GetDataUser getDataUser;
    public Button send;
    private Intent accountsIntent;
    private User user;
    private String stActiveKey, stPassword, stMail, stName;
    @BindView(R.id.title) TextView tvTitle;
    @BindView(R.id.send) Button btnSend;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_mail);

        unbinder = ButterKnife.bind(this);

        getDataUser = Common.getUserDate();
        send = (Button) findViewById(R.id.send);
        user = new User();
        btnSend.setEnabled(false);// for def

        if(getIntent().getExtras().getString("email") != null){
            stMail = getIntent().getExtras().getString("email");
        }else {
            stMail = null;
        }
        if(getIntent().getExtras().getString("name") != null){
            stName = getIntent().getExtras().getString("name");
        }else {
            stName = null;
        }

        if(getIntent().getExtras().getString("active_key") != null){
            stActiveKey = getIntent().getExtras().getString("active_key");
        }else {
            stActiveKey = null;
        }

        if(getIntent().getExtras().getString("password") != null){
            stPassword = getIntent().getExtras().getString("password");
        }else {
            stPassword = null;
        }
        user.setEmail(stMail);
        user.setName(stName);
        user.setId(stActiveKey);
        user.setPassword(stPassword);

        sendConf(btnSend, ActivityCheckPassword.this, user);
    }
    @OnClick(R.id.send)
    public void onButClick(View view) {
        //sendConf(btnSend, ActivityCheckPassword.this, user);
        isConfirmed(user.getId());
    }
    private void isConfirmed(String auth) {

        final ProgressDialog mDialog = new ProgressDialog(ActivityCheckPassword.this);
        mDialog.setMessage(getResources().getString(R.string.txt_plz_wait));
        mDialog.setCancelable(false);
        mDialog.show();

        getDataUser.sendKey(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserDataList>() {
                               @Override
                               public void accept(com.allerates.appforyou.request.UserDataList userDataList) throws Exception {
                                   if(userDataList.getQueryContent().get(0).getActivateUser() != null){
                                       String sConf = userDataList.getQueryContent().get(0).getActivateUser();
                                       if(sConf.equals("1")){
                                           DatabaseHelper databaseHelper;
                                           databaseHelper = new DatabaseHelper(getApplicationContext());
                                           databaseHelper.addUser(user);
                                           databaseHelper.setUserLogedIn(true, getApplicationContext());
                                           accountsIntent = new Intent(getApplicationContext(), MainActivity.class);
                                           startActivity(accountsIntent);
                                       }else {
                                           Toast.makeText(getApplicationContext(), "Mail not confirmed. Go to the e-mail and click on the link.", Toast.LENGTH_LONG).show();
                                       }
                                   }

                                   mDialog.dismiss();
                               }
                           },
                        throwable -> {
                            Toast.makeText(this, "Error " + throwable, Toast.LENGTH_LONG).show();
                            Log.e("TAG", "Mail not confirmed. Go to the e-mail and click on the link." + throwable);
                            mDialog.dismiss();
                        });
    }



    public void sendConf(final Button btnSend, final Context context, final User user){
        final ProgressDialog mDialog = new ProgressDialog(context);
        mDialog.setMessage(context.getString(R.string.wait_string));
        mDialog.setCancelable(false);
        mDialog.show();

        SendVerMail mSendVerMail;
        mSendVerMail = Common.sendVerMail();
        mSendVerMail.mValue(user.getEmail(), user.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Example>() {
                               @Override
                               public void accept(@NonNull Example example) throws Exception {
                                   if (example.getStatus().equals("success")) {
                                       tvTitle.setText(example.getMessage().toString());

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
                            Log.e(TAG, "Error: " + throwable);
                            mDialog.dismiss();
                        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ActivityCheckPassword.this, RegisterActivity.class);
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

