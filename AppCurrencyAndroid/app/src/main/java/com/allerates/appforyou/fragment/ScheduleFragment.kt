package com.allerates.appforyou.fragment

import android.os.Bundle
import android.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.allerates.appforyou.R
import android.webkit.WebView


class ScheduleFragment: Fragment(){

    lateinit var webView: WebView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.schedule_fragment, null)

        webView = view.findViewById(R.id.webView)
        webView.loadUrl("file:///android_asset/schedule.html")
        webView.settings.javaScriptEnabled = true
        return view
    }

}
