package com.allerates.appforyou.activities;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.fragment.ConverterFragment;
import com.allerates.appforyou.fragment.ScheduleFragment;
import com.allerates.appforyou.fragment.SearchPlaceOnMapFragment;
import com.allerates.appforyou.fragment.ShowCurrencyFragment;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.UserDataList;
import com.allerates.appforyou.request.api.GetDataUser;
import com.allerates.appforyou.sql.DatabaseHelper;
import com.allerates.appforyou.widget.TouchableWrapper;

import butterknife.BindString;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, TouchableWrapper.UpdateMapAfterUserInterection {
    public static int currentItem;
    private CheckConnection checkConnection;
    private DatabaseHelper databaseHelper;
    private NavigationView navigationView;
    private Menu menu;
    private Intent accountsIntent;
    private boolean isFirsFrag;
    private Toolbar toolbar;
    private Fragment fragment;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private TextView tvName;
    private TextView tvGmail;
    private CircleImageView imgUser;
    private Intent intent;
    private GetDataUser getDataUser;
    private String id;
    private byte[] imageByteArray;
    private User user;
    @BindString(R.string.txt_error_colon) String txtErrorColon;
    @BindString(R.string.txt_def_id_user) String defIdUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);
        init();

        changeFragment(new ShowCurrencyFragment(),  menu.findItem(R.id.nav_gallery), 2131296509);
    }

//   // click event with source view params
//    @OnClick(R.id.float_btn)
//    public void onButtonClick(View view) {
//        try {
//        accountsIntent = new Intent(getApplicationContext(), UserDataList.class);
//        startActivity(accountsIntent);
//        finish();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void getViewFromDraw() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //View headerView = LayoutInflater.from(this).inflate(R.layout.nav_header_main, navigationView, false);

        View header = navigationView.getHeaderView(0);
        tvName = (TextView) header.findViewById(R.id.tv_name);
        tvGmail = (TextView) header.findViewById(R.id.tv_gmail);
        imgUser = (de.hdodenhof.circleimageview.CircleImageView) header.findViewById(R.id.img_user);

    }
    public User getSt() {
        DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(getApplicationContext());
        return databaseHelper.getUser();

    }
    public void setDataUser() {
        user = new User();
        user = getSt();
        id = user.getId();
        if(id == null){
            id = defIdUser;
        }
        if(isInternet()){
            getDataOfUser(id);
        }
    }
    private boolean isInternet() {
        if (checkConnection.isOnline(getApplicationContext())) {
            return true;
        }else {
            checkConnection.makeToastConnection(this);
            return false;
        }
    }

    private void getDataOfUser(String auth) {
        final ProgressDialog mDialog = new ProgressDialog(MainActivity.this);
        mDialog.setMessage(getResources().getString(R.string.txt_plz_wait));
        mDialog.setCancelable(false);
        mDialog.show();

        getDataUser.sendKey(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserDataList>() {
                               @Override
                               public void accept(com.allerates.appforyou.request.UserDataList userDataList) throws Exception {
                                   // mDialog.dismiss();
                                   if(userDataList.getQueryContent().get(0).getExName() != null){
                                       tvName.setText(userDataList.getQueryContent().get(0).getExName());
                                   }
                                   if(userDataList.getQueryContent().get(0).getExMail() != null){
                                       tvGmail.setText(userDataList.getQueryContent().get(0).getExMail());
                                   }
                                   if(userDataList.getImgContent() != null){
                                       decBase64ToImage(userDataList.getImgContent());

                                       // userDataList.getQueryContent().get(1);

                                       // imgToBase64();
                                   }
                                   mDialog.dismiss();
                               }
                           },
                        throwable -> {
                            Log.e("TAG", txtErrorColon + throwable);
                            mDialog.dismiss();
                        });
    }

    public void decBase64ToImage(String baseSiFor) {
        // decode base64 string to image
        imageByteArray = Base64.decode(baseSiFor, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.length);
        imgUser.setImageBitmap(decodedImage);
    }

    public void init() {
        ButterKnife.bind(this);
        getViewFromDraw();
        isFirsFrag = false;
        ButterKnife.bind(this, this);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
        menu = navigationView.getMenu();
        getDataUser = Common.getUserDate();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.back_log));
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        checkConnection = new CheckConnection();
        setColorTitleDraw();
        setDataUser();
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
        // Create a new fragment
        fragment = null;
        Class fragmentClass = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        boolean isSetTitle = true;
        if(currentItem == 0 || currentItem != id) {
            if (id == R.id.nav_gallery) {
                fragment = new ShowCurrencyFragment();
            // fragmentClass = SecondFragment.class;
            } else if (id == R.id.nav_slideshow) {
                fragment = new ConverterFragment();
            } else if (id == R.id.nav_manage) {
                fragment = new SearchPlaceOnMapFragment();
            } else if (id == R.id.nav_schedule) {
                fragment = new ScheduleFragment();
            } else if (id == R.id.nav_share) {
                isSetTitle = false;
                // поделиться приложением
                Intent sendInt = new Intent(Intent.ACTION_SEND);
                sendInt.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
                sendInt.putExtra(Intent.EXTRA_TEXT, "Привет, советую скачать это приложение\n\"" + getString(R.string.app_name)
                        + "\" \n https://play.google.com/store/apps/developer?id=%D0%90%D0%BD%D0%BD%D0%B0%20%D0%93%D1%83%D0%BB%D0%B0%D0%BA=");
                // важный момент, нужно добавить ?id= в конце для нормального отображения ссылки
                sendInt.setType("text/plain");
                startActivity(Intent.createChooser(sendInt, "Поделиться"));
                overridePendingTransition(R.anim.open_next, R.anim.close_next);
            } else if (id == R.id.nav_send) {
                isSetTitle = false;
                intent = new Intent(MainActivity.this, ActivityContactUs.class);
                startActivity(intent);
                overridePendingTransition(R.anim.open_next, R.anim.close_next);
            }

            if(isSetTitle){
                changeFragment(fragment, item, id);
            }
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


    private void setColorTitleDraw() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        MenuItem toolsCur = menu.findItem(R.id.tv_cur);
        toolsCur.setEnabled(false);

        MenuItem tools = menu.findItem(R.id.nav_title);


        setCurrentCurrency();

        SpannableString s = new SpannableString(tools.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);

        tools.setTitle(s);

        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setCurrentCurrency() {
        Menu menu = navigationView.getMenu();
        MenuItem toolsCur = menu.findItem(R.id.tv_cur);
        SharedPreferences userLocalDatabase;
        userLocalDatabase = getSharedPreferences(DatabaseHelper.getSpName(), 0);
        final String coinName = userLocalDatabase.getString(getString(R.string.money_string), null);
        toolsCur.setTitle(String.format("%s%s", coinName," ▼" ));
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
