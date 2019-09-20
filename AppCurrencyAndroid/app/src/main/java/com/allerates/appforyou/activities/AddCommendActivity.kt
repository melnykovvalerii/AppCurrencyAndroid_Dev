package com.allerates.appforyou.activities


import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.EditText
import android.widget.RatingBar
import com.allerates.appforyou.R
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.allerates.appforyou.helpers.getPointAPI
import com.allerates.appforyou.helpers.showToast
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddCommendActivity:
        AppCompatActivity(),
        RatingBar.OnRatingBarChangeListener {

    @BindView(R.id.ratingBar)
    lateinit var ratingBar: RatingBar
    @BindView(R.id.ed_about)
    lateinit var edAbout: EditText
    var pointId = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_commend)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        ButterKnife.bind(this)

        pointId = intent.getIntExtra("stUniqueID", -1)
    }

    override fun onRatingChanged(ratingBar: RatingBar, rating: Float, fromUser: Boolean) {
        ratingBar.rating = rating
        showToast(this, "rating: $rating")
    }

    @OnClick(R.id.create_btn)
    fun onB(v: View) {
        val stringCom = edAbout.text.toString()
        var numStars = ratingBar.numStars

        if (stringCom.length < 500) {
            if (numStars > 5)
                numStars = 5
            else if (numStars < 1)
                numStars = 1
            setCommend(numStars.toString(), stringCom, pointId)
        } else
            showToast(this, "comment length should not exceed 500")
    }

    private fun setCommend(rating: String, comment: String, auth_key: Int) {
        val dialog = AlertDialog.Builder(this)
                .setMessage(R.string.wait_string)
                .setCancelable(false)
                .create()

        dialog.show()

        val call = getPointAPI().sendComment(comment, rating.toInt(), auth_key)
        call.enqueue(object : Callback<JsonElement> {
            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                if (response.isSuccessful) {
                    val result = response.body()!!
                    if (result.toString().contains("comment on point success")) {
                        dialog.dismiss()
                        showToast(this@AddCommendActivity, "Commend added!")
                        finish()
                    } else
                        showToast(this@AddCommendActivity, "try again")
                }
            }

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                showToast(this@AddCommendActivity,
                        "no internet connection!${t.message}")
                dialog.dismiss()
            }
        })
    }

}
