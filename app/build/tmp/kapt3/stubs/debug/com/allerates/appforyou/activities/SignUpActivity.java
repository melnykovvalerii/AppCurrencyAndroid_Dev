package com.allerates.appforyou.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/allerates/appforyou/activities/SignUpActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "confirmPasswordEditText", "Landroid/support/design/widget/TextInputEditText;", "emailEditText", "nameEditText", "passwordEditText", "isFormValid", "", "isNotExistBadChars", "editText", "isMail", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "toSignInClick", "v", "Landroid/view/View;", "toSignUpClick", "button", "app_debug"})
public final class SignUpActivity extends android.support.v7.app.AppCompatActivity {
    private android.support.design.widget.TextInputEditText nameEditText;
    private android.support.design.widget.TextInputEditText emailEditText;
    private android.support.design.widget.TextInputEditText passwordEditText;
    private android.support.design.widget.TextInputEditText confirmPasswordEditText;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void toSignInClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    public final void toSignUpClick(@org.jetbrains.annotations.NotNull()
    android.view.View button) {
    }
    
    private final boolean isFormValid() {
        return false;
    }
    
    private final boolean isNotExistBadChars(android.support.design.widget.TextInputEditText editText, boolean isMail) {
        return false;
    }
    
    public SignUpActivity() {
        super();
    }
}