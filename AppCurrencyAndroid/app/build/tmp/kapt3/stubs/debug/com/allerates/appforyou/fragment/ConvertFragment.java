package com.allerates.appforyou.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\'H\u0002J&\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u00020?2\u0006\u0010J\u001a\u00020BH\u0002J\u0010\u0010K\u001a\u00020?2\u0006\u0010J\u001a\u00020BH\u0002J\u0010\u0010L\u001a\u00020?2\u0006\u0010J\u001a\u00020BH\u0002J\u0010\u0010M\u001a\u00020?2\u0006\u0010J\u001a\u00020BH\u0002J\u0010\u0010N\u001a\u00020?2\u0006\u0010J\u001a\u00020BH\u0002J\u0010\u0010O\u001a\u00020?2\u0006\u0010P\u001a\u00020\u0014H\u0002J\u0010\u0010Q\u001a\u00020?2\u0006\u0010P\u001a\u00020\u0014H\u0002J\u0010\u0010R\u001a\u00020?2\u0006\u0010J\u001a\u00020BH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001a\u0010/\u001a\u000200X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000206X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018\u00a8\u0006S"}, d2 = {"Lcom/allerates/appforyou/fragment/ConvertFragment;", "Landroid/app/Fragment;", "()V", "coinToCoin", "Landroid/widget/ImageView;", "getCoinToCoin", "()Landroid/widget/ImageView;", "setCoinToCoin", "(Landroid/widget/ImageView;)V", "coinToMoney", "getCoinToMoney", "setCoinToMoney", "cryptCourses", "", "Lcom/allerates/appforyou/model/CryptCoin;", "getCryptCourses", "()Ljava/util/List;", "setCryptCourses", "(Ljava/util/List;)V", "fromButton", "Landroid/widget/Button;", "getFromButton", "()Landroid/widget/Button;", "setFromButton", "(Landroid/widget/Button;)V", "fromDATA", "Landroid/widget/EditText;", "getFromDATA", "()Landroid/widget/EditText;", "setFromDATA", "(Landroid/widget/EditText;)V", "isFromMoney", "", "()Z", "setFromMoney", "(Z)V", "isToMoney", "setToMoney", "modeConvert", "", "getModeConvert", "()I", "setModeConvert", "(I)V", "moneyToMoney", "getMoneyToMoney", "setMoneyToMoney", "more", "", "getMore", "()Ljava/lang/String;", "setMore", "(Ljava/lang/String;)V", "result", "Landroid/widget/TextView;", "getResult", "()Landroid/widget/TextView;", "setResult", "(Landroid/widget/TextView;)V", "toButton", "getToButton", "setToButton", "initVariants", "", "mode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setCoinToCoinModeClick", "v", "setCoinToMoneyClick", "setFromCurrencyClick", "setMoneyToMoneyModeClick", "setToCurrencyClick", "showDialogCoin", "button", "showDialogMoney", "startConvertClick", "app_debug"})
public final class ConvertFragment extends android.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public java.util.List<com.allerates.appforyou.model.CryptCoin> cryptCourses;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText fromDATA;
    @org.jetbrains.annotations.NotNull()
    public android.widget.TextView result;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ImageView coinToCoin;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ImageView coinToMoney;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ImageView moneyToMoney;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button fromButton;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button toButton;
    private boolean isFromMoney;
    private boolean isToMoney;
    private int modeConvert;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String more;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.allerates.appforyou.model.CryptCoin> getCryptCourses() {
        return null;
    }
    
    public final void setCryptCourses(@org.jetbrains.annotations.NotNull()
    java.util.List<com.allerates.appforyou.model.CryptCoin> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getFromDATA() {
        return null;
    }
    
    public final void setFromDATA(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.TextView getResult() {
        return null;
    }
    
    public final void setResult(@org.jetbrains.annotations.NotNull()
    android.widget.TextView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getCoinToCoin() {
        return null;
    }
    
    public final void setCoinToCoin(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getCoinToMoney() {
        return null;
    }
    
    public final void setCoinToMoney(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getMoneyToMoney() {
        return null;
    }
    
    public final void setMoneyToMoney(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getFromButton() {
        return null;
    }
    
    public final void setFromButton(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getToButton() {
        return null;
    }
    
    public final void setToButton(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    public final boolean isFromMoney() {
        return false;
    }
    
    public final void setFromMoney(boolean p0) {
    }
    
    public final boolean isToMoney() {
        return false;
    }
    
    public final void setToMoney(boolean p0) {
    }
    
    public final int getModeConvert() {
        return 0;
    }
    
    public final void setModeConvert(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMore() {
        return null;
    }
    
    public final void setMore(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void setMoneyToMoneyModeClick(android.view.View v) {
    }
    
    private final void setCoinToMoneyClick(android.view.View v) {
    }
    
    private final void setCoinToCoinModeClick(android.view.View v) {
    }
    
    private final void initVariants(int mode) {
    }
    
    private final void startConvertClick(android.view.View v) {
    }
    
    private final void setFromCurrencyClick(android.view.View v) {
    }
    
    private final void showDialogMoney(android.widget.Button button) {
    }
    
    private final void showDialogCoin(android.widget.Button button) {
    }
    
    private final void setToCurrencyClick(android.view.View v) {
    }
    
    public ConvertFragment() {
        super();
    }
}