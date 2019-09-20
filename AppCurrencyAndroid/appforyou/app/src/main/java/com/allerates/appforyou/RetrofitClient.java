package com.allerates.appforyou;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rikmen on 01.06.2018.
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getApiClient(String baseURL) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        return retrofit;
    }

}
