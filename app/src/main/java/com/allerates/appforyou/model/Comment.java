package com.allerates.appforyou.model;

/**
 * Created by rikmen00@gmail.com on 19.02.2019.
 */
public class Comment {
    private String exUserID;
    private String exName;
    private String userCommentID;
    private String textComment;
    private String rating;

    public Comment(String exUserID, String exName, String userCommentID, String textComment, String rating) {
        this.exUserID = exUserID;
        this.exName = exName;
        this.userCommentID = userCommentID;
        this.textComment = textComment;
        this.rating = rating;
    }

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