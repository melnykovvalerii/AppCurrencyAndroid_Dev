package com.allerates.appforyou.request.api;

import com.allerates.appforyou.model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Rikmen on 18.06.2018.
 */

public interface IpServiceGet {
    @GET("/")
    Call<Ip> getIP();
}
