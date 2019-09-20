package com.allerates.appforyou.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allerates.appforyou.widget.TouchableWrapper
import com.google.android.gms.maps.SupportMapFragment


class MySupportMapFragment:
        SupportMapFragment() {

    var mOriginalContentView: View? = null
    lateinit var mTouchView: TouchableWrapper

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View? {
        return try {
            mOriginalContentView = super.onCreateView(inflater, parent, savedInstanceState)
            mTouchView = TouchableWrapper(activity)
            mTouchView.addView(mOriginalContentView)
            mTouchView
        } catch (e: Exception) {
            null
        }

    }

    override fun getView() = mOriginalContentView
}
