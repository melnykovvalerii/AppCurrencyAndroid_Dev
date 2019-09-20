package com.allerates.appforyou.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0002J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0016J\u0010\u0010\'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001eH\u0002R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006)"}, d2 = {"Lcom/allerates/appforyou/fragment/CoursesFragment;", "Landroid/app/Fragment;", "Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;", "()V", "cryptCourses", "", "Lcom/allerates/appforyou/model/CryptCoin;", "getCryptCourses", "()Ljava/util/List;", "currentCurrency", "", "getCurrentCurrency", "()Ljava/lang/String;", "setCurrentCurrency", "(Ljava/lang/String;)V", "listView", "Landroid/widget/ListView;", "getListView", "()Landroid/widget/ListView;", "setListView", "(Landroid/widget/ListView;)V", "swipeRefreshLayout", "Landroid/support/v4/widget/SwipeRefreshLayout;", "getSwipeRefreshLayout", "()Landroid/support/v4/widget/SwipeRefreshLayout;", "setSwipeRefreshLayout", "(Landroid/support/v4/widget/SwipeRefreshLayout;)V", "loadCourses", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onRefresh", "onStart", "setCurrencyClick", "v", "app_debug"})
public final class CoursesFragment extends android.app.Fragment implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.allerates.appforyou.model.CryptCoin> cryptCourses = null;
    @org.jetbrains.annotations.NotNull()
    public android.support.v4.widget.SwipeRefreshLayout swipeRefreshLayout;
    @org.jetbrains.annotations.NotNull()
    public android.widget.ListView listView;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentCurrency;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.allerates.appforyou.model.CryptCoin> getCryptCourses() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v4.widget.SwipeRefreshLayout getSwipeRefreshLayout() {
        return null;
    }
    
    public final void setSwipeRefreshLayout(@org.jetbrains.annotations.NotNull()
    android.support.v4.widget.SwipeRefreshLayout p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.ListView getListView() {
        return null;
    }
    
    public final void setListView(@org.jetbrains.annotations.NotNull()
    android.widget.ListView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentCurrency() {
        return null;
    }
    
    public final void setCurrentCurrency(@org.jetbrains.annotations.NotNull()
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
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onRefresh() {
    }
    
    private final void loadCourses() {
    }
    
    private final void setCurrencyClick(android.view.View v) {
    }
    
    public CoursesFragment() {
        super();
    }
}