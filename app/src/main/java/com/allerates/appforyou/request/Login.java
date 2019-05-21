package com.allerates.appforyou.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Login {

    @SerializedName("query_content")
    @Expose
    private List<QueryContent> queryContent = null;
    @SerializedName("img_content")
    @Expose
    private String imgContent;

    public List<QueryContent> getQueryContent() {
        return queryContent;
    }

    public void setQueryContent(List<QueryContent> queryContent) {
        this.queryContent = queryContent;
    }

    public String getImgContent() {
        return imgContent;
    }

    public void setImgContent(String imgContent) {
        this.imgContent = imgContent;
    }

}


