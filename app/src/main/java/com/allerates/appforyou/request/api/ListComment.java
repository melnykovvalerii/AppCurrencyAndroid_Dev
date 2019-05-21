package com.allerates.appforyou.request.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 19.02.2019.
 */


public interface ListComment {
        @GET("/wp-json/point_all_comment/v2")
        Observable <com.allerates.appforyou.request.ListComment> getListComment(@Query("auth_key") String auth_key);
}
