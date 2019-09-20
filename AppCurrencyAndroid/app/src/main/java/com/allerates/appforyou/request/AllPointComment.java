package com.allerates.appforyou.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllPointComment {

    @SerializedName("ExUserID")
    @Expose
    private String exUserID;
    @SerializedName("ExName")
    @Expose
    private String exName;
    @SerializedName("UserCommentID")
    @Expose
    private String userCommentID;
    @SerializedName("Text_Comment")
    @Expose
    private String textComment;
    @SerializedName("rating")
    @Expose
    private String rating;

    public String getExUserID() {
        return exUserID;
    }

    public void setExUserID(String exUserID) {
        this.exUserID = exUserID;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getUserCommentID() {
        return userCommentID;
    }

    public void setUserCommentID(String userCommentID) {
        this.userCommentID = userCommentID;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

}