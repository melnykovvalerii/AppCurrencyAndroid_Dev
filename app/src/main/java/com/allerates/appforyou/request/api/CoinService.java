package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.Coin;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Rikmen on 01.06.2018.
 */

public interface CoinService {
        @GET("data/price")
        Observable<Coin> calculateValue(@Query("fsym") String from, @Query("tsyms") String to);
}
