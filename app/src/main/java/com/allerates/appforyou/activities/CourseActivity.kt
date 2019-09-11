package com.allerates.appforyou.activities


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ListView
import com.allerates.appforyou.R
import com.allerates.appforyou.adapters.CoursesAdapter
import com.allerates.appforyou.helpers.Setting
import com.allerates.appforyou.helpers.getCryptAPI
import com.allerates.appforyou.helpers.showToast
import com.allerates.appforyou.model.CryptCoin
import com.allerates.appforyou.model.CryptCourses
import com.google.gson.Gson
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.support.v7.app.AlertDialog
import android.widget.Button
import com.allerates.appforyou.model.getPairsCoin


class CourseActivity : AppCompatActivity() {

    val cryptCourses = listOf(
            CryptCoin(R.drawable.btc, 0.000010, "BTC"),
            CryptCoin(R.drawable.aur, 0.648000, "AUR"),
            CryptCoin(R.drawable.xem, 0.833300, "XEM"),
            CryptCoin(R.drawable.dash, 0.000433, "DASH"),
            CryptCoin(R.drawable.ltc, 0.000684, "LTC"),
            CryptCoin(R.drawable.maid, 0.311600, "MAID"),
            CryptCoin(R.drawable.eth, 0.000289, "ETH"),
            CryptCoin(R.drawable.xmr, 0.000743, "XMR"),
            CryptCoin(R.drawable.xrp, 0.120500, "XRP"),
            CryptCoin(R.drawable.etc, 0.009048, "ETC")
    )
    lateinit var listView: ListView
    var currentCurrency = "UAH"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_course)

        currentCurrency = Setting(this).defaultMoney.get()
        listView = findViewById(R.id.course_list)
        listView.adapter =
                CoursesAdapter(this, cryptCourses, currentCurrency)

        loadCourses()
    }

    private fun loadCourses() {
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
                        listView.adapter = CoursesAdapter(this@CourseActivity, cryptCourses, currentCurrency)
                    } catch (e: Exception) { }
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) =
                showToast(this@CourseActivity, t.message.toString())
        })
    }

    fun setCurrencyClick(v: View) {
        val variants = mutableListOf<String>()
        getPairsCoin().forEach {
            variants.add("${it.name} (${it.shortName})")
        }

        AlertDialog.Builder(this)
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
//todo back press
//todo listener in draw items and account
//todo get courses to listview
//todo set currency
//fixme toolbar text