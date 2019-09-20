package com.allerates.appforyou.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001\u001a\u000e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005\u001a\u001a\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b\u00a8\u0006\f"}, d2 = {"isNotExistBadChars", "", "editText", "Landroid/support/design/widget/TextInputEditText;", "isMail", "Landroid/widget/EditText;", "isPhone", "isValidJson", "json", "", "className", "Ljava/lang/Class;", "app_debug"})
public final class FormValidationKt {
    
    public static final boolean isNotExistBadChars(@org.jetbrains.annotations.NotNull()
    android.support.design.widget.TextInputEditText editText, boolean isMail) {
        return false;
    }
    
    public static final boolean isNotExistBadChars(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText, boolean isMail) {
        return false;
    }
    
    public static final boolean isPhone(@org.jetbrains.annotations.NotNull()
    android.widget.EditText editText) {
        return false;
    }
    
    public static final boolean isValidJson(@org.jetbrains.annotations.NotNull()
    java.lang.String json, @org.jetbrains.annotations.NotNull()
    java.lang.Class<?> className) {
        return false;
    }
}