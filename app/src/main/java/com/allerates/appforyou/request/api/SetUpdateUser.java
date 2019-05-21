package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.UpData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by rikmen00@gmail.com on 26.12.2018.
 */

public interface SetUpdateUser {
    @POST("/posts")
    @FormUrlEncoded
    Call<UpData> savePost(@Field("user_name") String user_name,
                          @Field("second_name") String second_name,
                          @Field("user_phone") String user_phone,
                          @Field("user_mail") String user_mail,
                          @Field("main_currency") String main_currency,
                          @Field("auth_key") String auth_key,
                          @Field("up_password") String up_password,
                          @Field("up_image") String up_image);

}
//https://www.look-studio.com//wp-json/update_user/v2?user_name=Dimasik&second_name=Dimas&user_phone=1231231231&user_mail=danndyxz@mail.ru&main_currency=Еврики&auth_key=96i4y7nr29zbykra8as7&up_password=weqw11&up_image=base64

