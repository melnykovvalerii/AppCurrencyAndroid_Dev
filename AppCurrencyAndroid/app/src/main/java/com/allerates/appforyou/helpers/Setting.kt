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
    var phone: Pref<String>
    var userLogin: Pref<String>
    var userMail: Pref<String>
    var userPassword: Pref<String>
    var authKey: Pref<String>
    var isShowNotofications: Pref<Boolean>


    init {
        pref = rxkPrefs(context, fileName)

        defaultMoney = pref.string("money", "UAH")
        isLogged = pref.boolean("is_logged")
        phone = pref.string("phone")
        userLogin = pref.string("login")
        userMail = pref.string("email")
        userPassword = pref.string("password")
        authKey = pref.string("aut_key")
        isShowNotofications = pref.boolean("is_show_notifications")
    }

    fun deleteUserData() {
        defaultMoney.set("UAH")
        isLogged.set(false)
        phone.set("")
        userLogin.set("")
        userMail.set("")
        userPassword.set("")
        authKey.set("")
        isShowNotofications.set(true)
    }
}