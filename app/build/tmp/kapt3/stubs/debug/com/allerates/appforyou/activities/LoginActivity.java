package com.allerates.appforyou.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J*\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\fH\u0002J\u0016\u0010&\u001a\u00020\u001f2\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\b\u0010*\u001a\u00020\u001fH\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u001dH\u0003J\b\u0010-\u001a\u00020.H\u0002J \u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000204H\u0016J\u0012\u00105\u001a\u00020\u001f2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u00020\u001fH\u0014J0\u00109\u001a\u00020\u001f2\b\u0010:\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\f2\b\u0010;\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010<\u001a\u0010\u0012\f\u0012\n =*\u0004\u0018\u00010)0)0(H\u0002J\u0010\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@H\u0002J\u000e\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020CJ\u000e\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020CJ\u000e\u0010F\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020CJ\u000e\u0010G\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020CJ\u000e\u0010H\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020CJ$\u0010I\u001a\u00020\u001f2\b\u0010J\u001a\u0004\u0018\u00010\f2\b\u0010;\u001a\u0004\u0018\u00010\f2\u0006\u0010K\u001a\u000201H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/allerates/appforyou/activities/LoginActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "appCompatButtonLogin", "Landroid/widget/Button;", "callbackManager", "Lcom/facebook/CallbackManager;", "checkConnection", "Lcom/allerates/appforyou/helpers/CheckConnection;", "databaseHelper", "Lcom/allerates/appforyou/sql/DatabaseHelper;", "email", "", "emailEditText", "Landroid/support/design/widget/TextInputEditText;", "id", "inputValidation", "Lcom/allerates/appforyou/helpers/InputValidation;", "mAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "mAuthStateListener", "Lcom/google/firebase/auth/FirebaseAuth$AuthStateListener;", "mGoogleBtn", "Lcom/google/android/gms/common/SignInButton;", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "name", "passwordEditText", "user", "Lcom/allerates/appforyou/model/User;", "clearForm", "", "getLog", "appCompatButtonRegister", "context", "Landroid/content/Context;", "exMail", "exPassword", "handleSignInResult", "completedTask", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "initComponents", "isConfirmed", "mUser", "isUserSignIn", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "postDataToSQLite", "auth", "password", "refreshIdToken", "kotlin.jvm.PlatformType", "setFacebookData", "loginResult", "Lcom/facebook/login/LoginResult;", "toFacebookClick", "v", "Landroid/view/View;", "toGoogleClick", "btn", "toRecoveryPasswordClick", "toSignInClick", "toSignUpClick", "verifyFromSQLite", "eMail", "number", "app_debug"})
public final class LoginActivity extends android.support.v7.app.AppCompatActivity {
    private com.google.firebase.auth.FirebaseAuth mAuth;
    private com.facebook.CallbackManager callbackManager;
    private android.support.design.widget.TextInputEditText emailEditText;
    private android.support.design.widget.TextInputEditText passwordEditText;
    private android.widget.Button appCompatButtonLogin;
    private com.allerates.appforyou.helpers.CheckConnection checkConnection;
    private com.allerates.appforyou.helpers.InputValidation inputValidation;
    private com.allerates.appforyou.sql.DatabaseHelper databaseHelper;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    private com.google.android.gms.common.SignInButton mGoogleBtn;
    private java.lang.String name;
    private java.lang.String email;
    private com.allerates.appforyou.model.User user;
    private java.lang.String id;
    private com.google.firebase.auth.FirebaseAuth.AuthStateListener mAuthStateListener;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onStart() {
    }
    
    private final void initComponents() {
    }
    
    private final void setFacebookData(com.facebook.login.LoginResult loginResult) {
    }
    
    public final void toGoogleClick(@org.jetbrains.annotations.NotNull()
    android.view.View btn) {
    }
    
    public final void toFacebookClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    private final com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> refreshIdToken() {
        return null;
    }
    
    private final void handleSignInResult(com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> completedTask) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.NotNull()
    android.content.Intent data) {
    }
    
    private final void postDataToSQLite(java.lang.String auth, java.lang.String email, java.lang.String name, java.lang.String password) {
    }
    
    public final void toRecoveryPasswordClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void toSignUpClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void toSignInClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    /**
     * * This trimLastCharacter is to validate the input text fields and verify login credentials from SQLite
     */
    private final void verifyFromSQLite(java.lang.String eMail, java.lang.String password, int number) {
    }
    
    private final void getLog(android.widget.Button appCompatButtonRegister, android.content.Context context, java.lang.String exMail, java.lang.String exPassword) {
    }
    
    @android.annotation.SuppressLint(value = {"CheckResult"})
    private final void isConfirmed(com.allerates.appforyou.model.User mUser) {
    }
    
    private final void clearForm() {
    }
    
    private final boolean isUserSignIn() {
        return false;
    }
    
    public LoginActivity() {
        super();
    }
}