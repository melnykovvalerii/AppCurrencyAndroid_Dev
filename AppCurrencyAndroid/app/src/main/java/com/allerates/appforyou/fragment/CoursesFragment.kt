package com.allerates.appforyou.fragment

import android.os.Bundle
import android.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import com.allerates.appforyou.R
import com.allerates.appforyou.adapters.CoursesAdapter
import com.allerates.appforyou.helpers.Setting
import com.allerates.appforyou.helpers.getCryptAPI
import com.allerates.appforyou.helpers.showToast
import com.allerates.appforyou.model.CryptCoin
import com.allerates.appforyou.model.CryptCourses
import com.allerates.appforyou.model.getPairsCoin
import com.google.gson.Gson
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoursesFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    val cryptCourses = listOf(
            CryptCoin(R.drawable.btc, 0.000000, "BTC"),
            CryptCoin(R.drawable.aur, 0.000000, "AUR"),
            CryptCoin(R.drawable.xem, 0.000000, "XEM"),
            CryptCoin(R.drawable.dash, 0.000000, "DASH"),
            CryptCoin(R.drawable.ltc, 0.000000, "LTC"),
            CryptCoin(R.drawable.maid, 0.000000, "MAID"),
            CryptCoin(R.drawable.eth, 0.000000, "ETH"),
            CryptCoin(R.drawable.xmr, 0.000000, "XMR"),
            CryptCoin(R.drawable.xrp, 0.000000, "XRP"),
            CryptCoin(R.drawable.etc, 0.000000, "ETC")
    )
    lateinit var swipeRefreshLayout: SwipeRefreshLayout
    lateinit var listView: ListView
    var currentCurrency = "UAH"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val parent = inflater.inflate(R.layout.content_course, null)

        currentCurrency = Setting(activity).defaultMoney.get()
        listView = parent.findViewById(R.id.course_list)
        swipeRefreshLayout = parent.findViewById(R.id.swipe_refresh_layout)
        swipeRefreshLayout.setOnRefreshListener(this)
        listView.adapter =
                CoursesAdapter(activity, cryptCourses, currentCurrency)
        val button = parent.findViewById<Button>(R.id.set_currency_button)
        button.setOnClickListener {
            setCurrencyClick(button)
        }

        return parent
    }

    override fun onStart() {
        super.onStart()
        loadCourses()
    }

    override fun onRefresh() {
        loadCourses()
    }

    private fun loadCourses() {
        swipeRefreshLayout.isRefreshing = true
        val call =
                getCryptAPI().getCourses(currentCurrency, "XEM,MAID,ETH,DASH,XMR,LTC,BTC,XRP,ETC,AUR")

        call.enqueue(object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                if (response.isSuccessful) {
                    val result = response.body()!!

                    try {
                        val obj = Gson().fromJson(result.toString(), CryptCourses::class.java)
                        cryptCourses[0].price = obj.BTC
                        cryptCourses[1].price = obj.AUR
                        cryptCourses[2].price = obj.XEM
                        cryptCourses[3].price = obj.DASH
                        cryptCourses[4].price = obj.LTC
                        cryptCourses[5].price = obj.MAID
                        cryptCourses[6].price = obj.ETH
                        cryptCourses[7].price = obj.XMR
                        cryptCourses[8].price = obj.XRP
                        cryptCourses[9].price = obj.ETC
                        listView.adapter = CoursesAdapter(activity, cryptCourses, currentCurrency)
                        swipeRefreshLayout.isRefreshing = false
                    } catch (e: Exception) { }
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) =
                    showToast(activity, t.message.toString())
        })
    }

    private fun setCurrencyClick(v: View) {
        val variants = mutableListOf<String>()
        getPairsCoin().forEach {
            variants.add("${it.name} (${it.shortName})")
        }

        AlertDialog.Builder(activity)
                .setTitle("Currency")
                .setItems(variants.toTypedArray()) { dialog, index ->
                    (v as Button).text = getPairsCoin()[index].shortName
                    currentCurrency = getPairsCoin()[index].shortName
                    loadCourses()
                    dialog.dismiss()
                }
                .create().show()
    }


}
