package com.allerates.appforyou.request;

/**
 * Created by rikmen00@gmail.com on 02.11.2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthKey {

    @SerializedName("auth_key")
    @Expose
    private String authKey;

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

}