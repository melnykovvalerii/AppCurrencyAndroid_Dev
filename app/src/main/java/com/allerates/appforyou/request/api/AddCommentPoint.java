package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.Comments;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 12.02.2019.
 */

public interface AddCommentPoint {
    @GET("/wp-json/device_login/v2")
    Observable <Comments> mValue(@Query("rating") String exMail, @Query("comment") String exPassword,
                                 @Query("comment") String auth_key);
}
