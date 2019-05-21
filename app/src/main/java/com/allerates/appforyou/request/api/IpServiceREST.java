package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.LocationREST;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 30.10.2018.
 */

public interface IpServiceREST {
    @GET("/wp-json/take_ip/v2")
    Call<LocationREST> defineCurrency(@Query("ip_adress") String ip_adress);
}

