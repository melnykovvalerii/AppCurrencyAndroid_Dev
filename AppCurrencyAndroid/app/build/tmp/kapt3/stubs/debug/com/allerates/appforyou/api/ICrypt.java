package com.allerates.appforyou.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'\u00a8\u0006\b"}, d2 = {"Lcom/allerates/appforyou/api/ICrypt;", "", "getCourses", "Lretrofit2/Call;", "Lcom/google/gson/JsonElement;", "currency", "", "comparison", "app_debug"})
public abstract interface ICrypt {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "crypto_info/v2")
    public abstract retrofit2.Call<com.google.gson.JsonElement> getCourses(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "currency")
    java.lang.String currency, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "comparison")
    java.lang.String comparison);
}