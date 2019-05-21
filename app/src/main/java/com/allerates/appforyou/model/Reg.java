package com.allerates.appforyou.model;

/**
 * Created by rikmen00@gmail.com on 16.10.2018.
 */


public class Reg {

    public Reg() {
    }
    public Reg(String auth_key) {
        this.auth_key = auth_key;
    }

    public String getAuth_key() {
        return auth_key;
    }

    public void setAuth_key(String auth_key) {
        this.auth_key = auth_key;
    }

    private String auth_key;

}
