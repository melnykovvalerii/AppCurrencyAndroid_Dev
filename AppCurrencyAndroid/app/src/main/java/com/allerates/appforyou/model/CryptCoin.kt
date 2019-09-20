package com.allerates.appforyou.model

import com.allerates.appforyou.R

class CryptCoin(var imageId: Int, var price: Double, var shortName: String)

fun getEmptyCoinCourses() = listOf(
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