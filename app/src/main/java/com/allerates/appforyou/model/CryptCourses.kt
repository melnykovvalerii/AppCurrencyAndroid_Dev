package com.allerates.appforyou.model

class CryptCourses (
    val MAID: Double,
    val XEM: Double,
    val ETH: Double,
    val DASH: Double,
    val XMR: Double,
    val LTC: Double,
    val BTC: Double,
    val XRP: Double,
    val ETC: Double,
    var AUR: Double
)

class RealCoin (
        var name: String,
        var shortName: String
)

fun getPairsCoin(): Array<RealCoin> {
    return arrayOf(
            RealCoin("United States", "USD"),
            RealCoin("Euro Member", "EUR"),
            RealCoin("United Kingdom", "GBP"),
            RealCoin("Japan", "JPY"),
            RealCoin("China", "CNY"),
            RealCoin("Russia", "RUB"),
            RealCoin("Australia", "AUD"),
            RealCoin("Canada", "CAD"),
            RealCoin("Poland", "PLN"),
            RealCoin("Singapore", "SGD"),
            RealCoin("Switzerland", "CHF"),
            RealCoin("India", "INR"),
            RealCoin("Brazil", "BRL"),
            RealCoin("South Africa", "ZAR"),
            RealCoin("Korea (South)", "KRW"),
            RealCoin("Viet Nam", "VND"),
            RealCoin("Sweden", "SEK"),
            RealCoin("Thailand", "THB"),
            RealCoin("Israel", "ILS"),
            RealCoin("Philippines", "PHP"),
            RealCoin("Ukraine", "UAH"),
            RealCoin("Indonesia", "IDR"),
            RealCoin("Czech Republic", "CZK"),
            RealCoin("Mexico", "MXN"),
            RealCoin("Denmark", "DKK"),
            RealCoin("Chile", "CLP"),
            RealCoin("Malaysia", "MYR"),
            RealCoin("Nigeria", "NGN"),
            RealCoin("Hungary", "HUF"),
            RealCoin("Mauritius", "MUR"),
            RealCoin("Romania", "RON"),
            RealCoin("Argentina", "ARS")
    )
}
//todo make this in database
//todo more country