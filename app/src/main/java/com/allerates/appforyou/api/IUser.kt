package com.allerates.appforyou.api

import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface IUser {
    //sign up with email
    @POST("AddNewExUser/v2/")
    fun addUserToDB(@Query("user_name") name: String,
                    @Query("ExMail") email: String,
                    @Query("ExPassword") password: String): Call<JsonElement>

    //send mail on user email
    @GET("mail_send/v2")
    fun sendConfirmMail(@Query("active_mail") email: String,
                        @Query("active_key") authKey: String): Call<JsonElement>

    //is user confirm email
    @GET("simple_check_mail/v2")
    fun isMailConfirm(@Query("auth_key") authKey: String): Call<JsonElement>

    //sign in with email
    @GET("device_login/v2")
    fun signInWithMail(
            @Query("ExMail") email: String,
            @Query("ExPassword") password: String): Call<JsonElement>
}