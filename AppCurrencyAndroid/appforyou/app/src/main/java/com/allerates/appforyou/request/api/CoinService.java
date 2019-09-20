package com.allerates.appforyou.request.api;

import com.allerates.appforyou.model.Coin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rikmen on 01.06.2018.
 */

public interface CoinService {
        @GET("data/price")
    Call<Coin> calculateValue(@Query("fsym") String from, @Query("tsyms") String to);
}
