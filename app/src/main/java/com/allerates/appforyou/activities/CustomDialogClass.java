package com.allerates.appforyou.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.allerates.appforyou.R;

/**
 * Created by rikmen00@gmail.com on 14.02.2019.
 */


public class CustomDialogClass extends Dialog implements android.view.View.OnClickListener {

    public Activity activity;
    public Dialog d;
    public Button no, btn_yes;

    public CustomDialogClass(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.activity = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_to_setting);
        btn_yes = (Button) findViewById(R.id.btn_yes);
        btn_yes.setOnClickListener(this);
        no = (Button) findViewById(R.id.btn_no);
        no.setOnClickListener(this);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onClick(View v) {
        try {
        switch (v.getId()) {
            case R.id.btn_yes:
                activity.finish();
                Intent accountsIntent = new Intent(activity, SettingActivity.class);
                activity.startActivity(accountsIntent);
                activity.finish();
                break;
            case R.id.btn_no:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
        } catch (Exception ignored) {
        }
    }
}