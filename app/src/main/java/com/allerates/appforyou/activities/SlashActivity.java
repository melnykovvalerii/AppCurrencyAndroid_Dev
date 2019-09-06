package com.allerates.appforyou.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SlashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int secondsDelayed = 3;
        Toast.makeText(this, "old start activity code run", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SlashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, secondsDelayed * 1000);
    }
}
