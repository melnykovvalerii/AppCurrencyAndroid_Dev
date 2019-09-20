package com.allerates.appforyou.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.allerates.appforyou.widget.TouchableWrapper;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by Rikmen on 26.06.2018.
 */

public class MySupportMapFragment extends SupportMapFragment {
    public View mOriginalContentView;
    public TouchableWrapper mTouchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        try{
        mOriginalContentView = super.onCreateView(inflater, parent, savedInstanceState);
        mTouchView = new TouchableWrapper(getActivity());
        mTouchView.addView(mOriginalContentView);
        return mTouchView;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public View getView() {
        return mOriginalContentView;
    }
}

