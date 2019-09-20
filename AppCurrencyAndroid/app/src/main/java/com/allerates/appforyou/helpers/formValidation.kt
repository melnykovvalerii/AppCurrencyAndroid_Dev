package com.allerates.appforyou.helpers

import android.support.design.widget.TextInputEditText
import android.widget.EditText
import com.google.gson.Gson

fun isNotExistBadChars(editText: TextInputEditText, isMail: Boolean): Boolean {
    val text = editText.text.toString()

    val bigAlph = 'A'..'Z'
    val smallAlph = 'a'..'z'
    val mailChars = listOf('@', '.')

    for (item in text) {
        if (bigAlph.contains(item)
                || smallAlph.contains(item)
                || item.isDigit()
                || (isMail && mailChars.contains(item)))
            continue
        return false
    }
    return true
}

fun isNotExistBadChars(editText: EditText, isMail: Boolean): Boolean {
    val text = editText.text.toString()

    val bigAlph = 'A'..'Z'
    val smallAlph = 'a'..'z'
    val mailChars = listOf('@', '.')

    for (item in text) {
        if (bigAlph.contains(item)
                || smallAlph.contains(item)
                || item.isDigit()
                || (isMail && mailChars.contains(item)))
            continue
        return false
    }
    return true
}

fun isPhone(editText: EditText): Boolean {
    val goodChars = '0'..'9'
    editText.text.toString().forEach {
        if (!goodChars.contains(it)) return false
    }
    return true
}

fun isValidJson(json: String, className: Class<*>): Boolean {
    return try {
        Gson().fromJson(json, className)
        true
    } catch (e: Exception) {
        false
    }
}