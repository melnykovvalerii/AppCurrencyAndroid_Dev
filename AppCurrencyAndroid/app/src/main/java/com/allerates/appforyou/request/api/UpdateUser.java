package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.UpData;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 10.12.2018.
 */

public interface UpdateUser {
    @FormUrlEncoded
    @POST("/wp-json/update_user/v2")
    Observable<UpData> sendData(@Query("user_name") String userName, @Query("user_phone") String userPhone, @Query("user_mail") String userMail, @Query("main_currency") String mainCurrency, @Query("auth_key") String authKey, @Query("up_password") String userPassword, @Nullable @Field("up_image") String userImage);
}
// https://www.look-studio.com//wp-json/update_user/v2?user_name=Dimasik&second_name=Dimas&user_phone=1231231231&user_mail=danndyxz@mail.ru&main_currency=Еврики&auth_key=96i4y7nr29zbykra8as7&up_password=weqw11&up_image=base64