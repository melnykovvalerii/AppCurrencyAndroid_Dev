package com.allerates.appforyou.model;

/**
 * Created by melardev on 5/21/2017.
 */

public class Point {
    private String latitude, longitude, stSite, stNumber, stAddress, stAbout;
    private String stMinSum, stDaysOfTheWeek, stDaysOfTheWeek2, stSpinnerCurrency, stPaymentMethods, stUniqueID, stTime;

    public Point(String stSite, String stNumber, String stAddress, String stAbout,
                 String stMinSum, String stDaysOfTheWeek, String stDaysOfTheWeek2,
                 String stSpinnerCurrency, String stPaymentMethods,
                 String latitude, String longitude, String stUniqueID, String stTime) {
        this.stSite = stSite;
        this.stTime = stTime;
        this.stNumber = stNumber;
        this.stAddress = stAddress;
        this.stAbout = stAbout;
        this.stMinSum = stMinSum;
        this.latitude = latitude;
        this.longitude = longitude;
        this.stDaysOfTheWeek = stDaysOfTheWeek;
        this.stDaysOfTheWeek2 = stDaysOfTheWeek2;
        this.stSpinnerCurrency = stSpinnerCurrency;
        this.stPaymentMethods = stPaymentMethods;
        this.stUniqueID = stUniqueID;
    }
    public String getStDaysOfTheWeek2(){return stDaysOfTheWeek2;}
    public void setStDaysOfTheWeek2(String stDaysOfTheWeek2) {this.stDaysOfTheWeek2 = stDaysOfTheWeek2;}
    public String getStTime(){return stTime;}
    public void setStTime(String stTime) {this.stTime = stTime;}
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getStSite() {
        return stSite;
    }
    public void setStSite(String stSite) {
        this.stSite = stSite;
    }
    public String getStNumber() {
        return stNumber;
    }
    public void setStNumber(String stNumber) {
        this.stNumber = stNumber;
    }
    public String getStAddress() {
        return stAddress;
    }
    public void setStAddress(String stAddress) {
        this.stAddress = stAddress;
    }
    public String getStAbout() {
        return stAbout;
    }
    public void setStAbout(String stAbout) {
        this.stAbout = stAbout;
    }
    public String getStDaysOfTheWeek() {
        return stDaysOfTheWeek;
    }
    public String getStUniqueID() {return stUniqueID;}
    public void setStDaysOfTheWeek(String stDaysOfTheWeek) {this.stDaysOfTheWeek = stDaysOfTheWeek;}
    public String getStMinSum() {
        return stMinSum;
    }
    public void setStMinSum(String stMinSum) {
        this.stMinSum = stMinSum;
    }
    public void setStUniqueID(String stUniqueID) {
        this.stUniqueID = stUniqueID;
    }


    @Override
    public String toString() {
        return "{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", stSite='" + stSite + '\'' +
                ", stNumber='" + stNumber + '\'' +
                ", stAddress='" + stAddress + '\'' +
                ", stAbout='" + stAbout + '\'' +
                ", stMinSum='" + stMinSum + '\'' +
                ", stDaysOfTheWeek='" + stDaysOfTheWeek + '\'' +
                ", stDaysOfTheWeek2='" + stDaysOfTheWeek2 + '\'' +
                ", stSpinnerCurrency='" + stSpinnerCurrency + '\'' +
                ", stPaymentMethods='" + stPaymentMethods + '\'' +
                ", stTime='" + stTime + '\'' +
                ", stUniqueID='" + stUniqueID + '\'' +
                "}";
    }

}
