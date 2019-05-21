package com.allerates.appforyou.helpers;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by Rikmen on 09.07.2018.
 */

public class CheckConnection {


    public void makeToastConnection(Activity activity) {
        Toast.makeText(activity, "Проверьте подключение к интернету", Toast.LENGTH_SHORT).show();
    }

    public boolean isOnline(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
