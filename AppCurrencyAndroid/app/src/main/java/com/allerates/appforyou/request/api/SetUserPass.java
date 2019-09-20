package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.Example;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 13.03.2019.
 */


public interface SetUserPass {
    @GET("/wp-json/reset_user_pass/v2")
    Observable<Example> mValue(@Query("user_mail") String userMail);
}
