package com.allerates.appforyou.activities;

import android.widget.Toast;

import com.allerates.appforyou.R;
import com.allerates.appforyou.model.MyItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import org.json.JSONException;

import java.io.InputStream;
import java.util.List;

public class ClusteringDemoActivity extends BaseDemoActivity {

    private ClusterManager<MyItem> mClusterManager;
    @Override
    protected void startDemo() {
        try {
        getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(51.503186, -0.126446), 10));

        mClusterManager = new ClusterManager<>(this, getMap());
        getMap().setOnCameraIdleListener(mClusterManager);

        final CameraPosition[] mPreviousCameraPosition = {null};
        getMap().setOnCameraIdleListener(() -> {
            CameraPosition position = getMap().getCameraPosition();
            if(mPreviousCameraPosition[0] == null || mPreviousCameraPosition[0].zoom != position.zoom) {
                mPreviousCameraPosition[0] = getMap().getCameraPosition();
                mClusterManager.cluster();
            }
        });

        try {
            readItems();
        } catch (JSONException e) {
            Toast.makeText(this, "Problem reading list of markers.", Toast.LENGTH_LONG).show();
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void readItems() throws JSONException {
        try {
        InputStream inputStream = getResources().openRawResource(R.raw.radar_search);
        List<MyItem> items = new MyItemReader().read(inputStream);
        mClusterManager.addItems(items);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}