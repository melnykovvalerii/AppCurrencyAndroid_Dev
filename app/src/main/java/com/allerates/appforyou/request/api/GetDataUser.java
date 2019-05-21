package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.UserDataList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 04.12.2018.
 */

public interface GetDataUser {
 @GET("/wp-json/auth_login/v2")
 Observable<UserDataList> sendKey(@Query("auth_key") String authKey);
}
