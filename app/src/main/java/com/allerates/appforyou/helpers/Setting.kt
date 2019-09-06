package com.allerates.appforyou.helpers

import android.content.Context
import com.afollestad.rxkprefs.Pref
import com.afollestad.rxkprefs.RxkPrefs
import com.afollestad.rxkprefs.rxkPrefs


class Setting(val context: Context) {

    private val fileName = "setting"
    private var pref: RxkPrefs

    var defaultMoney: Pref<String>
    var isLogged: Pref<Boolean>
    var userLogin: Pref<String>
    var userMail: Pref<String>
    var userPassword: Pref<String>
    var authKey: Pref<String>


    init {
        pref = rxkPrefs(context, fileName)

        defaultMoney = pref.string("money")
        isLogged = pref.boolean("is_logged")
        userLogin = pref.string("login")
        userMail = pref.string("email")
        userPassword = pref.string("password")
        authKey = pref.string("aut_key")
    }
}