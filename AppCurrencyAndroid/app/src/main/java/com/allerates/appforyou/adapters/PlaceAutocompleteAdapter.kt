package com.allerates.appforyou.adapters

import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.allerates.appforyou.R
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.places.AutocompleteFilter
import com.google.android.gms.location.places.Places
import com.google.android.gms.maps.model.LatLngBounds
import java.util.ArrayList
import java.util.concurrent.TimeUnit


class PlaceAutocompleteAdapter(
        var mContext: Context,
        resource: Int,
        val mGoogleApiClient: GoogleApiClient,
        var mBounds: LatLngBounds?,
        val mPlaceFilter: AutocompleteFilter):
        ArrayAdapter<PlaceAutocompleteAdapter.PlaceAutocomplete>(mContext, resource), Filterable {

    var mResultList: ArrayList<PlaceAutocomplete>? = null

    init {
        mResultList = ArrayList()
    }

    override fun getCount() = mResultList!!.size

    override fun getItem(position: Int) = mResultList!![position]

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val results = FilterResults()
                if (constraint != null) {
                    mResultList = getAutocomplete(constraint)
                    if (mResultList != null) {
                        results.values = mResultList
                        results.count = mResultList!!.size
                    } else
                        mResultList = ArrayList()
                }
                return results
            }

            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                if (results != null && results.count > 0)
                    (mContext as Activity).runOnUiThread { notifyDataSetChanged() }
                else
                    notifyDataSetInvalidated()
            }
        }
    }

    private fun getAutocomplete(constraint: CharSequence?): ArrayList<PlaceAutocomplete>? {
        if (mGoogleApiClient.isConnected) {
            val results = Places.GeoDataApi
                    .getAutocompletePredictions(mGoogleApiClient, constraint!!.toString(),
                            mBounds, mPlaceFilter)

            val autocompletePredictions = results
                    .await(60, TimeUnit.SECONDS)

            val status = autocompletePredictions.status
            if (!status.isSuccess) {
                autocompletePredictions.release()
                return null
            }

            val iterator = autocompletePredictions.iterator()
            val resultList = ArrayList<PlaceAutocomplete>(autocompletePredictions.count)
            while (iterator.hasNext()) {
                val prediction = iterator.next()
                resultList.add(PlaceAutocomplete(prediction.placeId!!,
                        prediction.getFullText(StyleSpan(Typeface.BOLD))))
            }

            autocompletePredictions.release()
            return resultList
        }
        return null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView
                ?: (mContext as Activity).layoutInflater.inflate(R.layout.google_places_search_items, null)
        view.findViewById<TextView>(R.id.tv_google_suggestions).text =
                mResultList!![position].description
        return view
    }

    class PlaceAutocomplete(var placeId: CharSequence, var description: CharSequence) {
        override fun toString() = description.toString()
    }
}