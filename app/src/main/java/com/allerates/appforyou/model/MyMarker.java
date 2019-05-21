package com.allerates.appforyou.model;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Rikmen on 17.07.2018.
 */

public class MyMarker {
        private final LatLng mPosition;
        private String mTitle;
        private String mSnippet;
        private String mUniqueID;

        public String getStUniqueID() {
            return mUniqueID;
        }

        public void setStUniqueID(String stUniqueID) {
            this.mUniqueID = stUniqueID;
        }

        public MyMarker(double lat, double lng) {
            mPosition = new LatLng(lat, lng);
            mTitle = null;
            mSnippet = null;
            mUniqueID = null;
        }

        public MyMarker(double lat, double lng, String title, String snippet, String stUniqueID) {
            mPosition = new LatLng(lat, lng);
            mTitle = title;
            mSnippet = snippet;
            mUniqueID = stUniqueID;
        }

        public LatLng getPosition() {
            return mPosition;
        }

        public String getTitle() { return mTitle; }

        public String getSnippet() { return mSnippet; }


        public void setTitle(String title) {
            mTitle = title;
        }

        public void setSnippet(String snippet) {
            mSnippet = snippet;
        }
}
