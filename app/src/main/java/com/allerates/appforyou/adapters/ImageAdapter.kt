package com.allerates.appforyou.adapters


import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.allerates.appforyou.R


class ImageAdapter(private val mContext: Activity, private val partsList: Array<String>) : BaseAdapter() {

    override fun getCount() = partsList.size

    override fun getItem(position: Int) = null

    override fun getItemId(position: Int) = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: mContext.layoutInflater
                .inflate(R.layout.cellgrid, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.full_image_view)
        val textView = view.findViewById<TextView>(R.id.textpart)

        getImageFromCur(partsList, imageView, position, textView)
        return view
    }

    private fun getImageFromCur(parts: Array<String>, imageView: ImageView, position: Int, textCurrency: TextView) {
        val imgId =
        when (parts[position]) {
            mContext.getString(R.string.btc_string) ->
                R.mipmap.ic_btc
            mContext.getString(R.string.etc_string) ->
                R.mipmap.ic_etc
            mContext.getString(R.string.xrp_string) ->
                R.mipmap.ic_xrp
            mContext.getString(R.string.eth_string) ->
                R.mipmap.ic_eth
            mContext.getString(R.string.aur_string) ->
                R.mipmap.ic_aur
            mContext.getString(R.string.dash_string) ->
                R.mipmap.ic_dash
            mContext.getString(R.string.maid_string) ->
                R.mipmap.ic_maid
            mContext.getString(R.string.ltc_string) ->
                R.mipmap.ic_ltc
            mContext.getString(R.string.xmr_string) ->
                R.mipmap.ic_xmr
            mContext.getString(R.string.xem_string) ->
                R.mipmap.ic_xem
            else -> R.mipmap.eur//
        }
        imageView.setBackgroundResource(imgId)
        textCurrency.text = parts[position]
    }
}