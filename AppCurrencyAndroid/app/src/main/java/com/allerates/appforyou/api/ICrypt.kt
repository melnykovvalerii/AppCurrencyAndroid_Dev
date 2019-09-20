package com.allerates.appforyou.api

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ICrypt {

    @GET("crypto_info/v2")
    fun getCourses(@Query("currency") currency: String,
                   @Query("comparison") comparison: String): Call<JsonElement>
}