package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.UserDataList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 12.03.2019.
 */


public interface GetDataUserGoogle {
    @GET("/wp-json/fa_token_handler/v2")
    Observable<UserDataList> sendKey(@Query("ios_token") String iosToken);
}
