package com.allerates.appforyou.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.allerates.appforyou.R;
import com.allerates.appforyou.fragment.ConverterFragment;
import com.allerates.appforyou.fragment.SearchPlaceOnMapFragment;
import com.allerates.appforyou.fragment.ShowCurrencyFragment;
import com.allerates.appforyou.sql.DatabaseHelper;
import com.allerates.appforyou.widget.TouchableWrapper;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TouchableWrapper.UpdateMapAfterUserInterection {
    public static int currentItem;
    private DatabaseHelper databaseHelper;
    private Menu menu;
    private Intent accountsIntent;
    private boolean isFirsFrag;
    private Toolbar toolbar;
    private Fragment fragment;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);
        init();
        changeFragment(new ShowCurrencyFragment(),  menu.findItem(R.id.nav_gallery), 2131296509);
    }

//
//   // click event with source view params
//    @OnClick(R.id.float_btn)
//    public void onButtonClick(View view) {
//        try {
//        accountsIntent = new Intent(getApplicationContext(), SettingActivity.class);
//        startActivity(accountsIntent);
//        finish();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void init() {

        isFirsFrag = false;
        ButterKnife.bind(this, this);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        menu = navigationView.getMenu();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.back_log));
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        setColorTitleDraw();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Создадим новый фрагмент
        fragment = null;
        Class fragmentClass = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean isSetTitle = true;
        if(currentItem == 0 || currentItem != id) {
            if (id == R.id.nav_gallery) {
                fragment = new ShowCurrencyFragment();
                //  fragmentClass = SecondFragment.class;
            } else if (id == R.id.nav_slideshow) {
                fragment = new ConverterFragment();
            } else if (id == R.id.nav_manage) {
                fragment = new SearchPlaceOnMapFragment();
            } else if (id == R.id.nav_share) {
                isSetTitle = false;
            } else if (id == R.id.nav_send) {
                isSetTitle = false;
            } else if (id == R.id.nav_title) {
                isSetTitle = false;
            } else if (id == R.id.tv_cur) {
                isSetTitle = false;
            }

            changeFragment(fragment, item, id);
            isFirsFrag = false;
        }
        return true;
    }

    public void changeFragment(Fragment fragment, MenuItem item, int id){
        try {
        //replacing the fragment
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.app_bar_main2, fragment);
            ft.commit();
        }
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке
        setTitle(item.getTitle());
        drawer.closeDrawer(GravityCompat.START);

        currentItem = id;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     *          Create the application menu
     */
    @Override
    public void onBackPressed() {
        if (!isFirsFrag) {
            changeFragment(new ShowCurrencyFragment(),  menu.findItem(R.id.nav_gallery), 2131296509);
            isFirsFrag = true;
        }else {
            openQuitDialog();
        }
        //super.onBackPressed();
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
                databaseHelper = new DatabaseHelper(getApplicationContext());
                databaseHelper.setUserLogedIn(false, MainActivity.this);
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

    /**
     *  Call a dialog to confirm exit
     */
    private void setColorTitleDraw() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        MenuItem tools = menu.findItem(R.id.nav_title);
        SpannableString s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
        tools.setTitle(s);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void openQuitDialog() {
        try {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(MainActivity.this);
        quitDialog.setTitle(getString(R.string.exit_string));
        quitDialog.setPositiveButton(getString(R.string.yes_string), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        quitDialog.setNegativeButton(getString(R.string.no_string), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        quitDialog.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    // Map Activity must implement this interface
    public interface UpdateMapAfterUserInterection {
        public void onUpdateMapAfterUserInterection();
    }

    @Override
    public void onUpdateMapAfterUserInterection() {
        Log.d(getClass().toString(), "Tagg");
    }
}
