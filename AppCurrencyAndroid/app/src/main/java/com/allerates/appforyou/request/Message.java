package com.allerates.appforyou.request;

/**
 * Created by rikmen00@gmail.com on 01.03.2019.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("Error 511")
    @Expose
    private String error511;

    public String getError511() {
        return error511;
    }

    public void setError511(String error511) {
        this.error511 = error511;
    }

}