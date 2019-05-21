package com.allerates.appforyou.value;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rikmen on 06.06.2018.
 */

public class Data {

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("close")
    @Expose
    private String close;

    @SerializedName("high")
    @Expose
    private String high;

    @SerializedName("low")
    @Expose
    private String low;

    @SerializedName("open")
    @Expose
    private String open;


    @SerializedName("volumefrom")
    @Expose
    private String volumefrom;

    @SerializedName("volumeto")
    @Expose
    private String volumeto;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getVolumefrom() {
        return volumefrom;
    }

    public void setVolumefrom(String volumefrom) {
        this.volumefrom = volumefrom;
    }

    public String getVolumeto() {
        return volumeto;
    }

    public void setVolumeto(String volumeto) {
        this.volumeto = volumeto;
    }



    @Override
    public String toString() {
        return "Data{" +
                "time='" + time + '\'' +
                ", close='" + close + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", open='" + open + '\'' +
                ", volumefrom='" + volumefrom + '\'' +
                ", volumeto='" + volumeto + '\'' +
                '}';
    }
}
