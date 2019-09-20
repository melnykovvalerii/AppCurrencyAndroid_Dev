package com.allerates.appforyou.activities


import com.allerates.appforyou.model.MyItem
import org.json.JSONArray
import org.json.JSONException
import java.io.InputStream
import java.util.ArrayList
import java.util.Scanner


class MyItemReader {

    val REGEX_INPUT_BOUNDARY_BEGINNING = "\\A"

    @Throws(JSONException::class)
    fun read(inputStream: InputStream): List<MyItem>? {
        try {
            val items = ArrayList<MyItem>()
            val json = Scanner(inputStream).useDelimiter(REGEX_INPUT_BOUNDARY_BEGINNING).next()
            val array = JSONArray(json)
            for (i in 0 until array.length()) {
                var title: String? = null
                var snippet: String? = null
                var stUniqueID: String? = null
                val obj = array.getJSONObject(i)
                val lat = obj.getDouble("lat")
                val lng = obj.getDouble("lng")
                if (!obj.isNull("title"))
                    title = obj.getString("title")
                if (!obj.isNull("snippet"))
                    snippet = obj.getString("snippet")
                if (!obj.isNull("stUniqueID"))
                    stUniqueID = obj.getString("stUniqueID")
                items.add(MyItem(lat, lng, title, snippet, stUniqueID))
            }
            return items
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }

    }

}
