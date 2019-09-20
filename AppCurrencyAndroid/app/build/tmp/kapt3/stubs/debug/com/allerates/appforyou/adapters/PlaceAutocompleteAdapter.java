package com.allerates.appforyou.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001.B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u001a\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u0007H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010\'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0007H\u0016J\"\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010,\u001a\u00020-H\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006/"}, d2 = {"Lcom/allerates/appforyou/adapters/PlaceAutocompleteAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/allerates/appforyou/adapters/PlaceAutocompleteAdapter$PlaceAutocomplete;", "Landroid/widget/Filterable;", "mContext", "Landroid/content/Context;", "resource", "", "mGoogleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "mBounds", "Lcom/google/android/gms/maps/model/LatLngBounds;", "mPlaceFilter", "Lcom/google/android/gms/location/places/AutocompleteFilter;", "(Landroid/content/Context;ILcom/google/android/gms/common/api/GoogleApiClient;Lcom/google/android/gms/maps/model/LatLngBounds;Lcom/google/android/gms/location/places/AutocompleteFilter;)V", "getMBounds", "()Lcom/google/android/gms/maps/model/LatLngBounds;", "setMBounds", "(Lcom/google/android/gms/maps/model/LatLngBounds;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "getMGoogleApiClient", "()Lcom/google/android/gms/common/api/GoogleApiClient;", "getMPlaceFilter", "()Lcom/google/android/gms/location/places/AutocompleteFilter;", "mResultList", "Ljava/util/ArrayList;", "getMResultList", "()Ljava/util/ArrayList;", "setMResultList", "(Ljava/util/ArrayList;)V", "getAutocomplete", "constraint", "", "getCount", "getFilter", "Landroid/widget/Filter;", "getItem", "position", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "PlaceAutocomplete", "app_debug"})
public final class PlaceAutocompleteAdapter extends android.widget.ArrayAdapter<com.allerates.appforyou.adapters.PlaceAutocompleteAdapter.PlaceAutocomplete> implements android.widget.Filterable {
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.allerates.appforyou.adapters.PlaceAutocompleteAdapter.PlaceAutocomplete> mResultList;
    @org.jetbrains.annotations.NotNull()
    private android.content.Context mContext;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.gms.common.api.GoogleApiClient mGoogleApiClient = null;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.maps.model.LatLngBounds mBounds;
    @org.jetbrains.annotations.NotNull()
    private final com.google.android.gms.location.places.AutocompleteFilter mPlaceFilter = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.ArrayList<com.allerates.appforyou.adapters.PlaceAutocompleteAdapter.PlaceAutocomplete> getMResultList() {
        return null;
    }
    
    public final void setMResultList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.allerates.appforyou.adapters.PlaceAutocompleteAdapter.PlaceAutocomplete> p0) {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.allerates.appforyou.adapters.PlaceAutocompleteAdapter.PlaceAutocomplete getItem(int position) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.widget.Filter getFilter() {
        return null;
    }
    
    private final java.util.ArrayList<com.allerates.appforyou.adapters.PlaceAutocompleteAdapter.PlaceAutocomplete> getAutocomplete(java.lang.CharSequence constraint) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable()
    android.view.View convertView, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getMContext() {
        return null;
    }
    
    public final void setMContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.common.api.GoogleApiClient getMGoogleApiClient() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.maps.model.LatLngBounds getMBounds() {
        return null;
    }
    
    public final void setMBounds(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.LatLngBounds p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.location.places.AutocompleteFilter getMPlaceFilter() {
        return null;
    }
    
    public PlaceAutocompleteAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context mContext, int resource, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.api.GoogleApiClient mGoogleApiClient, @org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.LatLngBounds mBounds, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.location.places.AutocompleteFilter mPlaceFilter) {
        super(null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/allerates/appforyou/adapters/PlaceAutocompleteAdapter$PlaceAutocomplete;", "", "placeId", "", "description", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "getDescription", "()Ljava/lang/CharSequence;", "setDescription", "(Ljava/lang/CharSequence;)V", "getPlaceId", "setPlaceId", "toString", "", "app_debug"})
    public static final class PlaceAutocomplete {
        @org.jetbrains.annotations.NotNull()
        private java.lang.CharSequence placeId;
        @org.jetbrains.annotations.NotNull()
        private java.lang.CharSequence description;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.CharSequence getPlaceId() {
            return null;
        }
        
        public final void setPlaceId(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.CharSequence getDescription() {
            return null;
        }
        
        public final void setDescription(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence p0) {
        }
        
        public PlaceAutocomplete(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence placeId, @org.jetbrains.annotations.NotNull()
        java.lang.CharSequence description) {
            super();
        }
    }
}