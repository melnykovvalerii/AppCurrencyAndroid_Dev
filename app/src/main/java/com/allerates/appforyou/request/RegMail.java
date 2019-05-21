package com.allerates.appforyou.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegMail {

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