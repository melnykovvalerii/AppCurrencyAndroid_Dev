package com.allerates.appforyou;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rikmen on 01.06.2018.
 */

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getApiClient(String baseURL) {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.create();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .client(okHttpClient)
                .build();


        return retrofit;
    }

}
