package com.allerates.appforyou.helpers

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.EditText
import android.widget.Toast

val TAG = "karman"

fun Context.startActivity(activity_name: Class<*>) =
    startActivity(Intent(this, activity_name))

fun showToast(context: Context, id: Int) =
    Toast.makeText(context, context.getString(id), Toast.LENGTH_SHORT).show()

fun showToast(context: Context, text: String) =
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()

fun View.visible(isVisible: Boolean) =
        if (isVisible) this.visibility = View.VISIBLE
        else this.visibility = View.INVISIBLE

fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

fun EditText.string() = this.text.toString()