package com.allerates.appforyou.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.allerates.appforyou.R;
import com.allerates.appforyou.sql.DatabaseHelper;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends AppCompatActivity {
    String[] money = {"USD", "EUR", "GBP"};
    @BindString(R.string.txt_crypto_currency_names) String cryptoCurrencyNames;
    @BindString(R.string.txt_you_selected) String txtYouSelected;
    @BindString(R.string.txt_down_arrow) String downArrow;
    @BindView(R.id.btn_currency) Button btnCurrency;
    private SharedPreferences userLocalDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
        setContentView(R.layout.fragment_setting);
        init();
        initToolbar();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_currency)
    public void onB(View view) {
        startDialog();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String currencyCode = data.getStringExtra(cryptoCurrencyNames);
            setSource(btnCurrency, currencyCode);
            setCoin2MoneySource(currencyCode);
            Toast.makeText(this, txtYouSelected + currencyCode, Toast.LENGTH_LONG).show();
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
        intent.putExtra("numberCheck", 3);
        startActivityForResult(intent, 1);
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
            spEditor.putString("money", coinName);
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
