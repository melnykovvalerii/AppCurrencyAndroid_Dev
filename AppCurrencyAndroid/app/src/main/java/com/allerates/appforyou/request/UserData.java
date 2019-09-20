package com.allerates.appforyou.request;

/**
 * Created by rikmen00@gmail.com on 04.12.2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserData {

    @SerializedName("ExUserID")
    @Expose
    private String exUserID;
    @SerializedName("ExMail")
    @Expose
    private String exMail;
    @SerializedName("ExPassword")
    @Expose
    private String exPassword;
    @SerializedName("ExName")
    @Expose
    private String exName;
    @SerializedName("auth_key")
    @Expose
    private String authKey;
    @SerializedName("img_content")
    @Expose
    private String exImage;
    @SerializedName("ExBlobImage")
    @Expose
    private String exBlobImage;
    @SerializedName("ExForKey")
    @Expose
    private Object exForKey;
    @SerializedName("SurName")
    @Expose
    private String surName;
    @SerializedName("UserPhone")
    @Expose
    private String userPhone;
    @SerializedName("MainCurrency")
    @Expose
    private String mainCurrency;

    public String getActivateUser() {
        return activateUser;
    }

    public void setActivateUser(String activateUser) {
        this.activateUser = activateUser;
    }

    @SerializedName("ActivateUser")
    @Expose
    private String activateUser;

    public String getExUserID() {
        return exUserID;
    }

    public void setExUserID(String exUserID) {
        this.exUserID = exUserID;
    }

    public String getExMail() {
        return exMail;
    }

    public void setExMail(String exMail) {
        this.exMail = exMail;
    }

    public String getExPassword() {
        return exPassword;
    }

    public void setExPassword(String exPassword) {
        this.exPassword = exPassword;
    }

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getExImage() {
        return exImage;
    }

    public void setExImage(String exImage) {
        this.exImage = exImage;
    }

    public String getExBlobImage() {
        return exBlobImage;
    }

    public void setExBlobImage(String exBlobImage) {
        this.exBlobImage = exBlobImage;
    }

    public Object getExForKey() {
        return exForKey;
    }

    public void setExForKey(Object exForKey) {
        this.exForKey = exForKey;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getMainCurrency() {
        return mainCurrency;
    }

    public void setMainCurrency(String mainCurrency) {
        this.mainCurrency = mainCurrency;
    }

}