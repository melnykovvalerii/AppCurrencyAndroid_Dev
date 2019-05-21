package com.allerates.appforyou.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.helpers.MyWebViewClient;

import butterknife.ButterKnife;

/**
 * Created by rikmen00@gmail.com on 21.12.2018.
 */

public class ScheduleFragment extends Fragment {

    private static final int LAYOUT = R.layout.schedule_fragment;
    private View view;
    private WebView webView;
    private CheckConnection checkConnection;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
            view = inflater.inflate(LAYOUT, container, false);
            ButterKnife.bind(this, view);
            init();
            showData();

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return view;
    }//onCreateView

    private void showData(){
        if (checkConnection.isOnline(view.getContext())) {
            showValue();
        }else {
            checkConnection.makeToastConnection(getActivity());
        }
    }

    private void init(){
        try {
            checkConnection = new CheckConnection();
            webView = (WebView)view.findViewById(R.id.webView);
            webView.loadUrl("file:///android_asset/schedule.html");
            webView.setWebViewClient(new MyWebViewClient());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void showValue() {
        try {
            // включаем поддержку JavaScript
            webView.getSettings().setJavaScriptEnabled(true);
            // указываем страницу загрузки

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
