package com.allerates.appforyou.helpers

import android.content.Context
import android.content.Intent
import android.support.design.widget.TextInputEditText
import android.view.View
import android.widget.Toast
import com.allerates.appforyou.api.IUser
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val TAG = "karman"

fun Context.startActivity(activity_name: Class<*>) =
    startActivity(Intent(this, activity_name))

fun showToast(context: Context, id: Int) =
    Toast.makeText(context, context.getString(id), Toast.LENGTH_SHORT).show()

fun showToast(context: Context, text: String) =
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()


const val BASE_URL = "http://www.look-studio.com/wp-json/"



fun getDefaultRetrofit(): Retrofit {
    val gson = GsonBuilder()
            .setLenient()
            .create()

    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}

fun getUserAPI() = getDefaultRetrofit().create(IUser::class.java)

fun View.visible(isVisible: Boolean) =
        if (isVisible) this.visibility = View.VISIBLE
        else this.visibility = View.INVISIBLE


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

fun isValidJson(json: String, className: Class<*>): Boolean {
    return try {
        Gson().fromJson(json, className)
        true
    } catch (e: Exception) {
        false
    }
}