package com.allerates.appforyou.value;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ConversionType {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("conversionSymbol")
    @Expose
    private String conversionSymbol;


    @Override
    public String toString() {
        return "ConversionType{" +
                "type='" + type + '\'' +
                ", conversionSymbol='" + conversionSymbol + '\'' +
                '}';
    }


}
