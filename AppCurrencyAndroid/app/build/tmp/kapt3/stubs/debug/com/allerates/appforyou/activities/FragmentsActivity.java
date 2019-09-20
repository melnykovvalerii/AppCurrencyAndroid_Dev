package com.allerates.appforyou.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020-2\u0006\u00101\u001a\u000202H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'\u00a8\u00063"}, d2 = {"Lcom/allerates/appforyou/activities/FragmentsActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Landroid/support/design/widget/NavigationView$OnNavigationItemSelectedListener;", "()V", "converterFragment", "Lcom/allerates/appforyou/fragment/ConvertFragment;", "getConverterFragment", "()Lcom/allerates/appforyou/fragment/ConvertFragment;", "setConverterFragment", "(Lcom/allerates/appforyou/fragment/ConvertFragment;)V", "coursesFragment", "Lcom/allerates/appforyou/fragment/CoursesFragment;", "getCoursesFragment", "()Lcom/allerates/appforyou/fragment/CoursesFragment;", "setCoursesFragment", "(Lcom/allerates/appforyou/fragment/CoursesFragment;)V", "drawer", "Landroid/support/v4/widget/DrawerLayout;", "getDrawer", "()Landroid/support/v4/widget/DrawerLayout;", "setDrawer", "(Landroid/support/v4/widget/DrawerLayout;)V", "navigationView", "Landroid/support/design/widget/NavigationView;", "getNavigationView", "()Landroid/support/design/widget/NavigationView;", "setNavigationView", "(Landroid/support/design/widget/NavigationView;)V", "scheduleFragment", "Lcom/allerates/appforyou/fragment/ScheduleFragment;", "getScheduleFragment", "()Lcom/allerates/appforyou/fragment/ScheduleFragment;", "setScheduleFragment", "(Lcom/allerates/appforyou/fragment/ScheduleFragment;)V", "searchPlaceOnMapFragment", "Lcom/allerates/appforyou/fragment/SearchPlaceOnMapFragment;", "getSearchPlaceOnMapFragment", "()Lcom/allerates/appforyou/fragment/SearchPlaceOnMapFragment;", "setSearchPlaceOnMapFragment", "(Lcom/allerates/appforyou/fragment/SearchPlaceOnMapFragment;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "app_debug"})
public final class FragmentsActivity extends android.support.v7.app.AppCompatActivity implements android.support.design.widget.NavigationView.OnNavigationItemSelectedListener {
    @org.jetbrains.annotations.NotNull()
    public com.allerates.appforyou.fragment.CoursesFragment coursesFragment;
    @org.jetbrains.annotations.NotNull()
    public com.allerates.appforyou.fragment.ConvertFragment converterFragment;
    @org.jetbrains.annotations.NotNull()
    public com.allerates.appforyou.fragment.ScheduleFragment scheduleFragment;
    @org.jetbrains.annotations.NotNull()
    public com.allerates.appforyou.fragment.SearchPlaceOnMapFragment searchPlaceOnMapFragment;
    @org.jetbrains.annotations.NotNull()
    public android.support.design.widget.NavigationView navigationView;
    @org.jetbrains.annotations.NotNull()
    public android.support.v4.widget.DrawerLayout drawer;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.allerates.appforyou.fragment.CoursesFragment getCoursesFragment() {
        return null;
    }
    
    public final void setCoursesFragment(@org.jetbrains.annotations.NotNull()
    com.allerates.appforyou.fragment.CoursesFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.allerates.appforyou.fragment.ConvertFragment getConverterFragment() {
        return null;
    }
    
    public final void setConverterFragment(@org.jetbrains.annotations.NotNull()
    com.allerates.appforyou.fragment.ConvertFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.allerates.appforyou.fragment.ScheduleFragment getScheduleFragment() {
        return null;
    }
    
    public final void setScheduleFragment(@org.jetbrains.annotations.NotNull()
    com.allerates.appforyou.fragment.ScheduleFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.allerates.appforyou.fragment.SearchPlaceOnMapFragment getSearchPlaceOnMapFragment() {
        return null;
    }
    
    public final void setSearchPlaceOnMapFragment(@org.jetbrains.annotations.NotNull()
    com.allerates.appforyou.fragment.SearchPlaceOnMapFragment p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.design.widget.NavigationView getNavigationView() {
        return null;
    }
    
    public final void setNavigationView(@org.jetbrains.annotations.NotNull()
    android.support.design.widget.NavigationView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.support.v4.widget.DrawerLayout getDrawer() {
        return null;
    }
    
    public final void setDrawer(@org.jetbrains.annotations.NotNull()
    android.support.v4.widget.DrawerLayout p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    public FragmentsActivity() {
        super();
    }
}