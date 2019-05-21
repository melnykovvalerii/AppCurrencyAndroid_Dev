package com.allerates.appforyou.request.api;

import com.allerates.appforyou.value.Histoday;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rikmen on 05.06.2018.
 */

public interface CoinHistoryDay {
    @GET("data/histoday")
    Call<Histoday> getValue(@Query("fsym") String fsym, @Query("tsym") String tsym, @Query("limit") String limit);
}
