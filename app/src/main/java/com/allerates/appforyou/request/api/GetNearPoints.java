package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.PointNear;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 20.03.2019.
 */

public interface GetNearPoints {
    @GET("/wp-json/take_my_ip/v2")
    Observable<PointNear> sendKey(@Query("comparison") String comparison);
}