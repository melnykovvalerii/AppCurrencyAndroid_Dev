package com.allerates.appforyou.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001:\u0001\u0014B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\bJ\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/allerates/appforyou/adapters/CurrencyListArrayAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/allerates/appforyou/activities/DialogActivity$Currency;", "Lcom/allerates/appforyou/activities/DialogActivity;", "context", "Landroid/app/Activity;", "list", "", "(Landroid/app/Activity;Ljava/util/List;)V", "getContext", "()Landroid/app/Activity;", "getList", "()Ljava/util/List;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "ViewHolder", "app_debug"})
public final class CurrencyListArrayAdapter extends android.widget.ArrayAdapter<com.allerates.appforyou.activities.DialogActivity.Currency> {
    @org.jetbrains.annotations.NotNull()
    private final android.app.Activity context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.allerates.appforyou.activities.DialogActivity.Currency> list = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable()
    android.view.View convertView, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Activity getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.allerates.appforyou.activities.DialogActivity.Currency> getList() {
        return null;
    }
    
    public CurrencyListArrayAdapter(@org.jetbrains.annotations.NotNull()
    android.app.Activity context, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.allerates.appforyou.activities.DialogActivity.Currency> list) {
        super(null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/allerates/appforyou/adapters/CurrencyListArrayAdapter$ViewHolder;", "", "()V", "flag", "Landroid/widget/ImageView;", "getFlag", "()Landroid/widget/ImageView;", "setFlag", "(Landroid/widget/ImageView;)V", "linearLayout", "Landroid/widget/LinearLayout;", "getLinearLayout", "()Landroid/widget/LinearLayout;", "setLinearLayout", "(Landroid/widget/LinearLayout;)V", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "setName", "(Landroid/widget/TextView;)V", "app_debug"})
    public static final class ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView name;
        @org.jetbrains.annotations.Nullable()
        private android.widget.ImageView flag;
        @org.jetbrains.annotations.Nullable()
        private android.widget.LinearLayout linearLayout;
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ImageView getFlag() {
            return null;
        }
        
        public final void setFlag(@org.jetbrains.annotations.Nullable()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.LinearLayout getLinearLayout() {
            return null;
        }
        
        public final void setLinearLayout(@org.jetbrains.annotations.Nullable()
        android.widget.LinearLayout p0) {
        }
        
        public ViewHolder() {
            super();
        }
    }
}