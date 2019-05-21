package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 01.03.2019.
 */

public interface SendVerMail {
    @GET("/wp-json/mail_send/v2/")
    Observable<Example> mValue(@Query("active_mail") String activeNail, @Query("active_key") String activeKey);
}