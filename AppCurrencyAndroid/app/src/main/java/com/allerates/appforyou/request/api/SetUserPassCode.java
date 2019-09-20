package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 14.03.2019.
 */


public interface SetUserPassCode {
    @GET("/wp-json/password_from_mail/v2")
    Observable<Example> mValue(@Query("user_mail") String userMail, @Query("reset_pass_key") String resetPassKey, @Query("user_pass") String userPass);
}
