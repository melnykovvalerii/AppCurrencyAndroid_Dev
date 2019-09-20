package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.RegisterIp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Rikmen on 14.06.2018.
 */
public interface IpService {
    @GET("/{ip}")
    Call<RegisterIp> defineCurrency(@Path("ip") String ip, @Query("access_key") String from);
}
