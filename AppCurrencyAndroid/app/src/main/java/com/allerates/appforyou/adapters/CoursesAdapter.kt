package com.allerates.appforyou.adapters


import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.format
import com.allerates.appforyou.model.CryptCoin
import com.squareup.picasso.Picasso


class CoursesAdapter(val context: Activity, val crypts: List<CryptCoin>, val currency: String):
        ArrayAdapter<CryptCoin>(context, 0, crypts) {

    inner class ViewHolder {
        lateinit var image: ImageView
        lateinit var mainCurrencyTextView: TextView
        lateinit var courseTextView: TextView
        lateinit var cryptNameTextView: TextView
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?:
            context.layoutInflater.inflate(R.layout.info_list_value, null)

        val holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            holder.mainCurrencyTextView = view.findViewById(R.id.from_txt)
            holder.image = view.findViewById(R.id.currency_img)
            holder.courseTextView = view.findViewById(R.id.course_value)
            holder.cryptNameTextView = view.findViewById(R.id.to_txt)
            view.tag = holder
        } else
            holder = convertView.tag as ViewHolder

        Picasso.with(context)
                .load(crypts[position].imageId)
                .into(holder.image)

        holder.cryptNameTextView.text = crypts[position].shortName
        holder.mainCurrencyTextView.text = "1 $currency"
        holder.courseTextView.text = crypts[position].price.format(6)

        return view
    }
}