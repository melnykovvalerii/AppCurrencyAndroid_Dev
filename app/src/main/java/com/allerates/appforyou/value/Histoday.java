package com.allerates.appforyou.value;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Rikmen on 05.06.2018.
 */

public class Histoday {
    public ArrayList<Data> getData() {
        return data;
    }

    @SerializedName("Data")
    @Expose
    private ArrayList<Data> data;

    @SerializedName("Type")
    @Expose
    private String type;

    @SerializedName("Response")
    @Expose
    private String response;

    @SerializedName("Aggregated")
    @Expose
    private String aggregated;

    @SerializedName("TimeTo")
    @Expose
    private String timeTo;

    @SerializedName("TimeFrom")
    @Expose
    private String timeFrom;

    @SerializedName("FirstValueInArray")
    @Expose
    private String firstValueInArray;

    @SerializedName("ConversionType")
    @Expose
    private ConversionType conversionType;


    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getAggregated() {
        return aggregated;
    }

    public void setAggregated(String aggregated) {
        this.aggregated = aggregated;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getFirstValueInArray() {
        return firstValueInArray;
    }

    public void setFirstValueInArray(String firstValueInArray) {
        this.firstValueInArray = firstValueInArray;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }



//
//
//    private String time;
//    private String close;
//    private String high;
//    private String low;
//    private String open;
//    private String Type;
//    private String Response;
//    private String Aggregated;
//
//
//
//    public String getTYPE() {
//        return Type;
//    }
//
//    public String getAGGREGATED() {
//        return Aggregated;
//    }
//    public String getRESPONSE() {
//        return Response;
//    }
//
//    public String getDATA() {
//        return data;
//    }
//
//    private String data;
//
//    public String getTime() {
//        return time;
//    }
//
//    public String getClose() {
//        return close;
//    }
//
//    public String getHigh() {
//        return high;
//    }
//
//    public String getLow() {
//        return low;
//    }
//
//    public String getOpen() {
//        return open;
//    }
//
//    public String getVolumefrom() {
//        return volumefrom;
//    }
//
//    public String getVolumeto() {
//        return volumeto;
//    }
//
//    private String volumefrom;
//    private String volumeto;
}
