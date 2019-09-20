package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.Point;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 31.10.2018.
 */

public interface GetPoint {
    @GET("/wp-json/all_point_info/v2")
    Observable<List<Point>> mValue(@Query("auth_key") String auth_key);
}
