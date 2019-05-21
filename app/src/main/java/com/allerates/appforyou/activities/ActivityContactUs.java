package com.allerates.appforyou.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.allerates.appforyou.R;


public class ActivityContactUs extends AppCompatActivity {

    public Toolbar toolbar;
    private EditText body;
    public Button send;
    private Intent accountsIntent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        body = (EditText) findViewById(R.id.body);
        send = (Button) findViewById(R.id.send);
        initToolbar();
    }

    public void SendBtn(View v) {
        if(body.getText().toString().length() < 1){
            Toast.makeText(this, getString(R.string.required_field), Toast.LENGTH_LONG).show();
        }else {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("plain/text");
            intent.putExtra(Intent.EXTRA_EMAIL,
                    new String[] { getResources().getString(R.string.email_address2) });

            intent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));

            String body_email = body.getText().toString() + "\n\n Сообщение отправлено с приложения Crypto Exchange";
            intent.putExtra(Intent.EXTRA_TEXT, body_email);
            startActivityForResult(Intent.createChooser(intent, "Send email..."), 100);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ActivityContactUs.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        overridePendingTransition(R.anim.open_main, R.anim.close_next);
    }

    // инициализация Toolbar
    private void initToolbar() {
        toolbar = (Toolbar)findViewById(R.id.toolbar_high_level_activity);
        toolbar.setBackgroundColor(getResources().getColor(R.color.back_log));
        toolbar.setTitle(R.string.str_contact);
        setSupportActionBar(toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                Intent intent;
                //noinspection SimplifiableIfStatement
                switch(id) {
                    case android.R.id.home:
                        // app icon in action bar clicked; go home
                        intent = new Intent(ActivityContactUs.this, MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        startActivity(intent);
                        overridePendingTransition(R.anim.open_main, R.anim.close_next);
                        break;
                }
                return true;
            }
        });
        toolbar.inflateMenu(R.menu.menu_top);
    }// initToolbar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    /**
     *           The listener clicks the menu item
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            //noinspection SimplifiableIfStatement
            switch(id) {
                case R.id.account:
                    accountsIntent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(accountsIntent);
                    finish();
                    break;
                case R.id.setting:
                    accountsIntent = new Intent(getApplicationContext(), SettingActivity.class);
                    startActivity(accountsIntent);
                    finish();
                    break;
                case R.id.map:
                    accountsIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(accountsIntent);
                    finish();
                    break;
            }
            return super.onOptionsItemSelected(item);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
