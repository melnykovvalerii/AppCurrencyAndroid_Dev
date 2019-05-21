package com.allerates.appforyou.model;

import android.content.Context;

import com.allerates.appforyou.Common;

/**
 * Created by Rikmen on 05.06.2018.
 */

public class Article {
    private String title;
    private String genre;
    private String year;
    private String from;
    private String to;
    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }


    public String getImage() {
        return showData(getFrom());
    }


    private String showData(String coinName){

        if(coinName.equals("BTC")){
            return Common.BTC_IMAGE;
        }else if(coinName.equals("ETC")){
            return Common.ETC_IMAGE;
        }else if(coinName.equals("LTC")){
            return (Common.LTC_IMAGE);
        }else if(coinName.equals("ETH")){
            return Common.ETH_IMAGE;
        }else if(coinName.equals("XRP")){
            return Common.XRP_IMAGE;
        }else if(coinName.equals("AUR")){
            return Common.AUR_IMAGE;
        }else if(coinName.equals("DASH")){
            return Common.DASH_IMAGE;
        }else if(coinName.equals("MAID")){
            return Common.MAID_IMAGE;
        }else if(coinName.equals("XMR")){
            return Common.XMR_IMAGE;
        }else if(coinName.equals("XEM")){
            return Common.XEM_IMAGE;
        }else {
            return null;
        }
    }
    public Article() {
    }

    public Article(String title, String genre, String year, String from, String to) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.genre = genre;
        this.year = year;
    }

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {this.year = year;}
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
}