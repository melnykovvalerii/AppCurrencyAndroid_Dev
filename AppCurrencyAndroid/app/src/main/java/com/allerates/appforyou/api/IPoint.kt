package com.allerates.appforyou.api

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface IPoint {

    @POST("point_comment/v2/")
    fun sendComment(@Query("user_comment") comment: String,
                    @Query("point_rating") rating: Int,
                    @Query("place_id") id: Int): Call<JsonElement>
}