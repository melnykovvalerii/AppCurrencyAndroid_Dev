package com.allerates.appforyou.request.api;

import com.allerates.appforyou.model.Reg;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 16.10.2018.
 */

public interface RegWithMail {
    @POST("/wp-json/AddNewExUser/v2/")
    Observable<Reg> mValue(@Query("user_name") String userName, @Query("ExMail") String exMail, @Query("ExPassword") String exPassword);
   // Call<Reg> mValue(@Query("user_name") String userName, @Query("ExMail") String exMail, @Query("ExPassword") String exPassword);

}
