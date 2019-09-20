package com.allerates.appforyou.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rikmen00@gmail.com on 26.10.2018.
 */


public class Coin {


    @SerializedName("GBP")
    @Expose
    private String GBP;

    @SerializedName("BTC")
    @Expose
    private String BTC;

    @SerializedName("EUR")
    @Expose
    private String EUR;

    @SerializedName("USD")
    @Expose
    private String USD;

    @SerializedName("XRP")
    @Expose
    private String XRP;

    @SerializedName("ETH")
    @Expose
    private String ETH;

    @SerializedName("ETC")
    @Expose
    private String ETC;

    @SerializedName("DASH")
    @Expose
    private String DASH;

    @SerializedName("MAID")
    @Expose
    private String MAID;

    @SerializedName("XEM")
    @Expose
    private String XEM;

    @SerializedName("AUR")
    @Expose
    private String AUR;

    @SerializedName("LTC")
    @Expose
    private String LTC;

    @SerializedName("XMR")
    @Expose
    private String XMR;


    public String getXRP() {
        return XRP;
    }

    public void setXRP(String XRP) {
        this.XRP = XRP;
    }


    public String getGBP() {
        return GBP;
    }

    public void setGBP(String GBP) {
        this.GBP = GBP;
    }

    public String getEUR() {
        return EUR;
    }

    public void setEUR(String EUR) {
        this.EUR = EUR;
    }

    public String getUSD() {
        return USD;
    }

    public void setUSD(String USD) {
        this.USD = USD;
    }
    public String getBTC() {
        return BTC;
    }

    public void setBTC(String BTC) {
        this.BTC = BTC;
    }

    public String getETH() {
        return ETH;
    }

    public void setETH(String ETH) {
        this.ETH = ETH;
    }

    public String getETC() {
        return ETC;
    }

    public void setETC(String ETC) {
        this.ETC = ETC;
    }

    public String getDASH() {
        return DASH;
    }

    public void setDASH(String DASH) {
        this.DASH = DASH;
    }

    public String getMAID() {
        return MAID;
    }

    public void setMAID(String MAID) {
        this.MAID = MAID;
    }

    public String getXEM() {
        return XEM;
    }

    public void setXEM(String XEM) {
        this.XEM = XEM;
    }

    public String getAUR() {
        return AUR;
    }

    public void setAUR(String AUR) {
        this.AUR = AUR;
    }

    public String getLTC() {
        return LTC;
    }

    public void setLTC(String LTC) {
        this.LTC = LTC;
    }

    public String getXMR() {
        return XMR;
    }

    public void setXMR(String XMR) {
        this.XMR = XMR;
    }



}
