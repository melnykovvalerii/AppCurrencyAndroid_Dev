package com.allerates.appforyou.fragment


import android.os.Bundle
import android.app.Fragment
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.allerates.appforyou.R
import com.allerates.appforyou.helpers.Setting
import com.allerates.appforyou.helpers.getCryptAPI
import com.allerates.appforyou.helpers.showToast
import com.allerates.appforyou.model.CryptCoin
import com.allerates.appforyou.model.getEmptyCoinCourses
import com.allerates.appforyou.model.getPairsCoin
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ConvertFragment : Fragment() {

    lateinit var cryptCourses: List<CryptCoin>

    lateinit var fromDATA: EditText
    lateinit var result: TextView

    lateinit var coinToCoin: ImageView
    lateinit var coinToMoney: ImageView
    lateinit var moneyToMoney: ImageView

    lateinit var fromButton: Button
    lateinit var toButton: Button
    var isFromMoney = false
    var isToMoney = false
    var modeConvert = 1

    var more = "▼"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val parent = inflater.inflate(R.layout.content_calculator, null)

        coinToCoin = parent.findViewById(R.id.coin_to_coin)
        coinToMoney = parent.findViewById(R.id.coin_to_money)
        moneyToMoney = parent.findViewById(R.id.money_to_money)

        fromButton = parent.findViewById(R.id.from_button)
        toButton = parent.findViewById(R.id.to_button)

        cryptCourses = getEmptyCoinCourses()
        initVariants(1)

        moneyToMoney.setOnClickListener {
            setMoneyToMoneyModeClick(moneyToMoney)
        }

        coinToCoin.setOnClickListener {
            setCoinToCoinModeClick(coinToCoin)
        }

        coinToMoney.setOnClickListener {
            setCoinToMoneyClick(coinToMoney)
        }

        fromDATA = parent.findViewById(R.id.from_data)
        result = parent.findViewById(R.id.result_view)

        val setFromCurrency = parent.findViewById<Button>(R.id.from_button)
        val setToButton = parent.findViewById<Button>(R.id.to_button)
        setFromCurrency.setOnClickListener {
            setFromCurrencyClick(setFromCurrency)
        }
        setToButton.setOnClickListener {
            setToCurrencyClick(setToButton)
        }

        val convertButton = parent.findViewById<Button>(R.id.convert)
        convertButton.setOnClickListener {
            startConvertClick(convertButton)
        }

        return parent
    }

    private fun setMoneyToMoneyModeClick(v: View) {
        coinToMoney.setBackgroundResource(R.drawable.coinmoney2)
        coinToCoin.setBackgroundResource(R.drawable.coin2)
        moneyToMoney.setBackgroundResource(R.drawable.money1)

        initVariants(2)
    }

    private fun setCoinToMoneyClick(v: View) {
        coinToMoney.setBackgroundResource(R.drawable.coinmoney1)
        coinToCoin.setBackgroundResource(R.drawable.coin2)
        moneyToMoney.setBackgroundResource(R.drawable.money2)

        initVariants(3)
    }

    private fun setCoinToCoinModeClick(v: View) {
        coinToMoney.setBackgroundResource(R.drawable.coinmoney2)
        coinToCoin.setBackgroundResource(R.drawable.coin1)
        moneyToMoney.setBackgroundResource(R.drawable.money2)

        initVariants(1)
    }

    private fun initVariants(mode: Int) {
        modeConvert = mode
        when (mode) {
            1 -> {
                isFromMoney = false
                isToMoney = false
            }
            2 -> {
                isFromMoney = true
                isToMoney = true
            }
            3 -> {
                isFromMoney = false
                isToMoney = true
            }
        }

        if (isFromMoney)
            fromButton.text = Setting(activity!!.applicationContext).defaultMoney.get()
        else
            fromButton.text = "BTC"

        if (isToMoney)
            toButton.text = Setting(activity!!.applicationContext).defaultMoney.get()
        else
            toButton.text = "LTC"
    }

    private fun startConvertClick(v: View) {
        val data = fromDATA.text.toString()
        try {
            val number = data.toInt()
            val call = getCryptAPI().getCourses(
                    fromButton.text.toString(),
                    toButton.text.toString())

            call.enqueue(object : Callback<JsonElement> {
                override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                    if (response.isSuccessful) {
                        val resul = response.body()!!
                        Log.e("karman", resul.toString())
                        try {
                            val courseIndex = resul.toString().indexOf(":")
                            var course = resul.toString().substring(courseIndex + 1)
                            course = course.substring(0, course.length - 1)
                            result.text = (number * course.toDouble()).toString()
                        } catch (e: Exception) { }
                    }
                }

                override fun onFailure(call: Call<JsonElement>, t: Throwable) =
                        showToast(activity!!, t.message.toString())
            })
        } catch (e: Exception) { }
    }

    private fun setFromCurrencyClick(v: View) {
        if (isFromMoney) showDialogMoney(v as Button)
        else showDialogCoin(v as Button)
    }

    private fun showDialogMoney(button: Button) {
        val variants = mutableListOf<String>()
        getPairsCoin().forEach {
            variants.add("${it.name} (${it.shortName})")
        }

        AlertDialog.Builder(activity!!)
                .setTitle("Currency")
                .setItems(variants.toTypedArray()) { dialog, index ->
                    button.text = getPairsCoin()[index].shortName
                    dialog.dismiss()
                }
                .create().show()
    }

    private fun showDialogCoin(button: Button) {
        val variants = mutableListOf<String>()
        cryptCourses.forEach {
            variants.add(it.shortName)
        }

        AlertDialog.Builder(activity!!)
                .setTitle("Currency")
                .setItems(variants.toTypedArray()) { dialog, index ->
                    button.text = variants[index]
                    dialog.dismiss()
                }
                .create().show()
    }

    private fun setToCurrencyClick(v: View) {
        if (isToMoney) showDialogMoney(v as Button)
        else showDialogCoin(v as Button)
    }

}
