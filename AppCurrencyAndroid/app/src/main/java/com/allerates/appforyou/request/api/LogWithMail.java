package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.Login;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 25.10.2018.
 */


public interface LogWithMail {
    @GET("/wp-json/device_login/v2")
    Observable<Login> mValue(@Query("ExMail") String exMail, @Query("ExPassword") String exPassword);
}
