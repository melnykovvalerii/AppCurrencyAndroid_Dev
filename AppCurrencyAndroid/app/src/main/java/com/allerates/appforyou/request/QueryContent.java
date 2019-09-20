package com.allerates.appforyou.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueryContent {

    @SerializedName("ExUserID")
    @Expose
    private String exUserID;
    @SerializedName("ExMail")
    @Expose
    private String exMail;
    @SerializedName("ExName")
    @Expose
    private String exName;
    @SerializedName("SurName")
    @Expose
    private String surName;
    @SerializedName("ExImage")
    @Expose
    private String exImage;
    @SerializedName("UserPhone")
    @Expose
    private String userPhone;
    @SerializedName("MainCurrency")
    @Expose
    private String mainCurrency;
    @SerializedName("auth_key")
    @Expose
    private String authKey;
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

    public String getExName() {
        return exName;
    }

    public void setExName(String exName) {
        this.exName = exName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getExImage() {
        return exImage;
    }

    public void setExImage(String exImage) {
        this.exImage = exImage;
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

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getActivateUser() {
        return activateUser;
    }

    public void setActivateUser(String activateUser) {
        this.activateUser = activateUser;
    }

}
