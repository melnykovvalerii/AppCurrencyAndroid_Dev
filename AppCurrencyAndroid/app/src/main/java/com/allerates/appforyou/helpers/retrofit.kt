package com.allerates.appforyou.helpers

import com.allerates.appforyou.api.ICrypt
import com.allerates.appforyou.api.IPoint
import com.allerates.appforyou.api.IUser
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://www.look-studio.com/wp-json/"

fun getDefaultRetrofit(): Retrofit {
    val gson = GsonBuilder()
            .setLenient()
            .create()

    return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}

fun getUserAPI() = getDefaultRetrofit().create(IUser::class.java)

fun getCryptAPI() = getDefaultRetrofit().create(ICrypt::class.java)

fun getPointAPI() = getDefaultRetrofit().create(IPoint::class.java)