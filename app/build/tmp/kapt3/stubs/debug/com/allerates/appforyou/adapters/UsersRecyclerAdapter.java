package com.allerates.appforyou.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/allerates/appforyou/adapters/UsersRecyclerAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/allerates/appforyou/adapters/UsersRecyclerAdapter$UserViewHolder;", "listUsers", "", "Lcom/allerates/appforyou/model/User;", "(Ljava/util/List;)V", "getListUsers", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "UserViewHolder", "app_debug"})
public final class UsersRecyclerAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.allerates.appforyou.adapters.UsersRecyclerAdapter.UserViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.allerates.appforyou.model.User> listUsers = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.allerates.appforyou.adapters.UsersRecyclerAdapter.UserViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.allerates.appforyou.adapters.UsersRecyclerAdapter.UserViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.allerates.appforyou.model.User> getListUsers() {
        return null;
    }
    
    public UsersRecyclerAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.allerates.appforyou.model.User> listUsers) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/allerates/appforyou/adapters/UsersRecyclerAdapter$UserViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/allerates/appforyou/adapters/UsersRecyclerAdapter;Landroid/view/View;)V", "textViewEmail", "Landroid/support/v7/widget/AppCompatTextView;", "getTextViewEmail", "()Landroid/support/v7/widget/AppCompatTextView;", "setTextViewEmail", "(Landroid/support/v7/widget/AppCompatTextView;)V", "textViewName", "getTextViewName", "setTextViewName", "textViewPassword", "getTextViewPassword", "setTextViewPassword", "app_debug"})
    public final class UserViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private android.support.v7.widget.AppCompatTextView textViewName;
        @org.jetbrains.annotations.NotNull()
        private android.support.v7.widget.AppCompatTextView textViewEmail;
        @org.jetbrains.annotations.NotNull()
        private android.support.v7.widget.AppCompatTextView textViewPassword;
        
        @org.jetbrains.annotations.NotNull()
        public final android.support.v7.widget.AppCompatTextView getTextViewName() {
            return null;
        }
        
        public final void setTextViewName(@org.jetbrains.annotations.NotNull()
        android.support.v7.widget.AppCompatTextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.support.v7.widget.AppCompatTextView getTextViewEmail() {
            return null;
        }
        
        public final void setTextViewEmail(@org.jetbrains.annotations.NotNull()
        android.support.v7.widget.AppCompatTextView p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.support.v7.widget.AppCompatTextView getTextViewPassword() {
            return null;
        }
        
        public final void setTextViewPassword(@org.jetbrains.annotations.NotNull()
        android.support.v7.widget.AppCompatTextView p0) {
        }
        
        public UserViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}