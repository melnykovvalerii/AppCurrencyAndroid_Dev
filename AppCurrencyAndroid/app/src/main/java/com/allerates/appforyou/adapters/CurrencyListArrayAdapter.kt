package com.allerates.appforyou.adapters


import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.allerates.appforyou.R
import com.allerates.appforyou.activities.DialogActivity


class CurrencyListArrayAdapter(val context: Activity, val list: List<DialogActivity.Currency>):
        ArrayAdapter<DialogActivity.Currency>(context, R.layout.activity_countrycode_row, list) {

    class ViewHolder {
        var name: TextView? = null
        var flag: ImageView? = null
        var linearLayout: LinearLayout? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?:
            context.layoutInflater.inflate(R.layout.activity_countrycode_row, null)

        val holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            holder.name = view.findViewById(R.id.name)
            holder.flag = view.findViewById(R.id.flag)
            holder.linearLayout = view.findViewById(R.id.lin_di)
            view.tag = holder
        } else
            holder = convertView.tag as ViewHolder

        holder.name!!.text = list[position].name
        holder.flag!!.setImageDrawable(list[position].flag)
        holder.linearLayout!!.layoutParams = LinearLayout.LayoutParams(1000, LinearLayout.LayoutParams.MATCH_PARENT)
        return view
    }
}
