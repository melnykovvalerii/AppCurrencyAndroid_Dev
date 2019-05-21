package com.allerates.appforyou.request;

/**
 * Created by rikmen00@gmail.com on 04.12.2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDataList {

    @SerializedName("query_content")
    @Expose
    private List<UserData> queryContent = null;

    @SerializedName("img_content")
    @Expose
    private String imgContent;

    public List<UserData> getQueryContent() {
        return queryContent;
    }

    public void setQueryContent(List<UserData> queryContent) {
        this.queryContent = queryContent;
    }

    public String getImgContent() {
        return imgContent;
    }

    public void setImgContent(String imgContent) {
        this.imgContent = imgContent;
    }
}
