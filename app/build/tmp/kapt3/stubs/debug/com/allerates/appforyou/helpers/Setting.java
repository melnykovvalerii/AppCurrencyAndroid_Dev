package com.allerates.appforyou.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010%\u001a\u00020&R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0014\u0010\u000bR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000b\u00a8\u0006\'"}, d2 = {"Lcom/allerates/appforyou/helpers/Setting;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "authKey", "Lcom/afollestad/rxkprefs/Pref;", "", "getAuthKey", "()Lcom/afollestad/rxkprefs/Pref;", "setAuthKey", "(Lcom/afollestad/rxkprefs/Pref;)V", "getContext", "()Landroid/content/Context;", "defaultMoney", "getDefaultMoney", "setDefaultMoney", "fileName", "isLogged", "", "setLogged", "isShowNotofications", "setShowNotofications", "phone", "getPhone", "setPhone", "pref", "Lcom/afollestad/rxkprefs/RxkPrefs;", "userLogin", "getUserLogin", "setUserLogin", "userMail", "getUserMail", "setUserMail", "userPassword", "getUserPassword", "setUserPassword", "deleteUserData", "", "app_debug"})
public final class Setting {
    private final java.lang.String fileName = "setting";
    private com.afollestad.rxkprefs.RxkPrefs pref;
    @org.jetbrains.annotations.NotNull()
    private com.afollestad.rxkprefs.Pref<java.lang.String> defaultMoney;
    @org.jetbrains.annotations.NotNull()
    private com.afollestad.rxkprefs.Pref<java.lang.Boolean> isLogged;
    @org.jetbrains.annotations.NotNull()
    private com.afollestad.rxkprefs.Pref<java.lang.String> phone;
    @org.jetbrains.annotations.NotNull()
    private com.afollestad.rxkprefs.Pref<java.lang.String> userLogin;
    @org.jetbrains.annotations.NotNull()
    private com.afollestad.rxkprefs.Pref<java.lang.String> userMail;
    @org.jetbrains.annotations.NotNull()
    private com.afollestad.rxkprefs.Pref<java.lang.String> userPassword;
    @org.jetbrains.annotations.NotNull()
    private com.afollestad.rxkprefs.Pref<java.lang.String> authKey;
    @org.jetbrains.annotations.NotNull()
    private com.afollestad.rxkprefs.Pref<java.lang.Boolean> isShowNotofications;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.String> getDefaultMoney() {
        return null;
    }
    
    public final void setDefaultMoney(@org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.Boolean> isLogged() {
        return null;
    }
    
    public final void setLogged(@org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.String> getPhone() {
        return null;
    }
    
    public final void setPhone(@org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.String> getUserLogin() {
        return null;
    }
    
    public final void setUserLogin(@org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.String> getUserMail() {
        return null;
    }
    
    public final void setUserMail(@org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.String> getUserPassword() {
        return null;
    }
    
    public final void setUserPassword(@org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.String> getAuthKey() {
        return null;
    }
    
    public final void setAuthKey(@org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.afollestad.rxkprefs.Pref<java.lang.Boolean> isShowNotofications() {
        return null;
    }
    
    public final void setShowNotofications(@org.jetbrains.annotations.NotNull()
    com.afollestad.rxkprefs.Pref<java.lang.Boolean> p0) {
    }
    
    public final void deleteUserData() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public Setting(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
}