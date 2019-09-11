package com.allerates.appforyou.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 c2\u00020\u0001:\u0001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\fH\u0002J\n\u0010F\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010G\u001a\u00020DH\u0002J\u0018\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020DH\u0002J\u000e\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020OJ \u0010P\u001a\u00020D2\u0006\u0010Q\u001a\u00020K2\u0006\u0010R\u001a\u00020K2\u0006\u0010S\u001a\u00020TH\u0014J\b\u0010U\u001a\u00020DH\u0016J\u0012\u0010V\u001a\u00020D2\b\u0010W\u001a\u0004\u0018\u00010XH\u0014J\u0010\u0010Y\u001a\u00020D2\u0006\u0010Z\u001a\u00020XH\u0014J\u000e\u0010[\u001a\u00020D2\u0006\u0010N\u001a\u00020OJ\u000e\u0010\\\u001a\u00020D2\u0006\u0010N\u001a\u00020OJ\u0010\u0010]\u001a\u00020D2\u0006\u0010^\u001a\u00020\fH\u0002J\b\u0010_\u001a\u00020DH\u0002J\u000e\u0010`\u001a\u00020D2\u0006\u0010N\u001a\u00020OJ\u000e\u0010a\u001a\u00020D2\u0006\u0010N\u001a\u00020OJ\u0012\u0010b\u001a\u00020K2\b\u0010S\u001a\u0004\u0018\u00010\nH\u0003R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u0010R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020*X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010R\u001a\u00102\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\u001a\u00105\u001a\u00020\u001bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR \u00108\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u000e\"\u0004\b:\u0010\u0010R \u0010;\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000e\"\u0004\b=\u0010\u0010R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010@\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0081\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u000e\"\u0004\bB\u0010\u0010\u00a8\u0006d"}, d2 = {"Lcom/allerates/appforyou/activities/SettingActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "avatarImageView", "Landroid/widget/ImageView;", "getAvatarImageView", "()Landroid/widget/ImageView;", "setAvatarImageView", "(Landroid/widget/ImageView;)V", "bitmap", "Landroid/graphics/Bitmap;", "cryptoCurrencyNames", "", "getCryptoCurrencyNames$app_debug", "()Ljava/lang/String;", "setCryptoCurrencyNames$app_debug", "(Ljava/lang/String;)V", "defaultCurrencyButton", "Landroid/widget/Button;", "getDefaultCurrencyButton", "()Landroid/widget/Button;", "setDefaultCurrencyButton", "(Landroid/widget/Button;)V", "downArrow", "getDownArrow$app_debug", "setDownArrow$app_debug", "emailEditText", "Landroid/widget/EditText;", "getEmailEditText", "()Landroid/widget/EditText;", "setEmailEditText", "(Landroid/widget/EditText;)V", "haventPicked", "getHaventPicked$app_debug", "setHaventPicked$app_debug", "imageByteArray", "", "imgStr", "nameEditText", "getNameEditText", "setNameEditText", "notificationSwith", "Landroid/widget/Switch;", "getNotificationSwith", "()Landroid/widget/Switch;", "setNotificationSwith", "(Landroid/widget/Switch;)V", "numberCheckSimpl", "getNumberCheckSimpl$app_debug", "setNumberCheckSimpl$app_debug", "passwordEditText", "getPasswordEditText", "setPasswordEditText", "phoneEditText", "getPhoneEditText", "setPhoneEditText", "stMoney", "getStMoney$app_debug", "setStMoney$app_debug", "txtYouSelected", "getTxtYouSelected$app_debug", "setTxtYouSelected$app_debug", "userLocalDatabase", "Landroid/content/SharedPreferences;", "wentWrong", "getWentWrong$app_debug", "setWentWrong$app_debug", "decBase64ToImage", "", "baseSiFor", "decodeImageToBase64", "fillFormFromSetting", "getResizedBitmap", "image", "maxSize", "", "initToolbar", "logoutClick", "v", "Landroid/view/View;", "onActivityResult", "reqCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSaveInstanceState", "outState", "saveClick", "setAvatarClick", "setCoin2MoneySource", "coinName", "setCurrentCurrency", "setModeNotificationsClick", "setNewCurrencyClick", "sizeOf", "Companion", "app_debug"})
public final class SettingActivity extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public android.widget.ImageView avatarImageView;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText nameEditText;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText phoneEditText;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText emailEditText;
    @org.jetbrains.annotations.NotNull()
    public android.widget.EditText passwordEditText;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Switch notificationSwith;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button defaultCurrencyButton;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755266)
    private java.lang.String cryptoCurrencyNames;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755328)
    private java.lang.String txtYouSelected;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755278)
    private java.lang.String downArrow;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755333)
    private java.lang.String wentWrong;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755166)
    private java.lang.String haventPicked;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755177)
    private java.lang.String stMoney;
    @org.jetbrains.annotations.Nullable()
    @butterknife.BindString(value = 2131755203)
    private java.lang.String numberCheckSimpl;
    private android.graphics.Bitmap bitmap;
    private android.content.SharedPreferences userLocalDatabase;
    private java.lang.String imgStr;
    private byte[] imageByteArray;
    private static final int RESULT_LOAD_IMG = 2;
    public static final com.allerates.appforyou.activities.SettingActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ImageView getAvatarImageView() {
        return null;
    }
    
    public final void setAvatarImageView(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getNameEditText() {
        return null;
    }
    
    public final void setNameEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getPhoneEditText() {
        return null;
    }
    
    public final void setPhoneEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getEmailEditText() {
        return null;
    }
    
    public final void setEmailEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getPasswordEditText() {
        return null;
    }
    
    public final void setPasswordEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Switch getNotificationSwith() {
        return null;
    }
    
    public final void setNotificationSwith(@org.jetbrains.annotations.NotNull()
    android.widget.Switch p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getDefaultCurrencyButton() {
        return null;
    }
    
    public final void setDefaultCurrencyButton(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCryptoCurrencyNames$app_debug() {
        return null;
    }
    
    public final void setCryptoCurrencyNames$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTxtYouSelected$app_debug() {
        return null;
    }
    
    public final void setTxtYouSelected$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDownArrow$app_debug() {
        return null;
    }
    
    public final void setDownArrow$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWentWrong$app_debug() {
        return null;
    }
    
    public final void setWentWrong$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHaventPicked$app_debug() {
        return null;
    }
    
    public final void setHaventPicked$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStMoney$app_debug() {
        return null;
    }
    
    public final void setStMoney$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNumberCheckSimpl$app_debug() {
        return null;
    }
    
    public final void setNumberCheckSimpl$app_debug(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void fillFormFromSetting() {
    }
    
    public final void setModeNotificationsClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void setNewCurrencyClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void saveClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void setAvatarClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void logoutClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final void setCurrentCurrency() {
    }
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.HONEYCOMB_MR1)
    private final int sizeOf(android.graphics.Bitmap data) {
        return 0;
    }
    
    /**
     * * reduces the size of the image
     *     * @param image
     *     * @param maxSize
     *     * @return
     */
    private final android.graphics.Bitmap getResizedBitmap(android.graphics.Bitmap image, int maxSize) {
        return null;
    }
    
    private final java.lang.String decodeImageToBase64() {
        return null;
    }
    
    private final void decBase64ToImage(java.lang.String baseSiFor) {
    }
    
    @java.lang.Override()
    protected void onSaveInstanceState(@org.jetbrains.annotations.NotNull()
    android.os.Bundle outState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int reqCode, int resultCode, @org.jetbrains.annotations.NotNull()
    android.content.Intent data) {
    }
    
    private final void initToolbar() {
    }
    
    private final void setCoin2MoneySource(java.lang.String coinName) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    public SettingActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/allerates/appforyou/activities/SettingActivity$Companion;", "", "()V", "RESULT_LOAD_IMG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}