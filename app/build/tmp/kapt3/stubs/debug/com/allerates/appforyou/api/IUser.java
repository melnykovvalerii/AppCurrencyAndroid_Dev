package com.allerates.appforyou.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u0006H\'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\n\u001a\u00020\u0006H\'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u0006H\'\u00a8\u0006\r"}, d2 = {"Lcom/allerates/appforyou/api/IUser;", "", "addUserToDB", "Lretrofit2/Call;", "Lcom/google/gson/JsonElement;", "name", "", "email", "password", "isMailConfirm", "authKey", "sendConfirmMail", "mail", "app_debug"})
public abstract interface IUser {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.POST(value = "AddNewExUser/v2/")
    public abstract retrofit2.Call<com.google.gson.JsonElement> addUserToDB(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "user_name")
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "ExMail")
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "ExPassword")
    java.lang.String password);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "mail_send/v2")
    public abstract retrofit2.Call<com.google.gson.JsonElement> sendConfirmMail(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "active_mail")
    java.lang.String mail, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "active_key")
    java.lang.String authKey);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "simple_check_mail/v2")
    public abstract retrofit2.Call<com.google.gson.JsonElement> isMailConfirm(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "auth_key")
    java.lang.String authKey);
}