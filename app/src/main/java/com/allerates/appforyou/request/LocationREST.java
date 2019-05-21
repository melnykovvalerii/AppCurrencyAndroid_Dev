package com.allerates.appforyou.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class LocationREST {

        @SerializedName("geoplugin_request")
        @Expose
        private String geopluginRequest;
        @SerializedName("geoplugin_status")
        @Expose
        private Integer geopluginStatus;
        @SerializedName("geoplugin_delay")
        @Expose
        private String geopluginDelay;
        @SerializedName("geoplugin_credit")
        @Expose
        private String geopluginCredit;
        @SerializedName("geoplugin_city")
        @Expose
        private String geopluginCity;
        @SerializedName("geoplugin_region")
        @Expose
        private String geopluginRegion;
        @SerializedName("geoplugin_regionCode")
        @Expose
        private String geopluginRegionCode;
        @SerializedName("geoplugin_regionName")
        @Expose
        private String geopluginRegionName;
        @SerializedName("geoplugin_areaCode")
        @Expose
        private String geopluginAreaCode;
        @SerializedName("geoplugin_dmaCode")
        @Expose
        private String geopluginDmaCode;
        @SerializedName("geoplugin_countryCode")
        @Expose
        private String geopluginCountryCode;
        @SerializedName("geoplugin_countryName")
        @Expose
        private String geopluginCountryName;
        @SerializedName("geoplugin_inEU")
        @Expose
        private Integer geopluginInEU;
        @SerializedName("geoplugin_euVATrate")
        @Expose
        private Boolean geopluginEuVATrate;
        @SerializedName("geoplugin_continentCode")
        @Expose
        private String geopluginContinentCode;
        @SerializedName("geoplugin_continentName")
        @Expose
        private String geopluginContinentName;
        @SerializedName("geoplugin_latitude")
        @Expose
        private String geopluginLatitude;
        @SerializedName("geoplugin_longitude")
        @Expose
        private String geopluginLongitude;
        @SerializedName("geoplugin_locationAccuracyRadius")
        @Expose
        private String geopluginLocationAccuracyRadius;
        @SerializedName("geoplugin_timezone")
        @Expose
        private String geopluginTimezone;
        @SerializedName("geoplugin_currencyCode")
        @Expose
        private String geopluginCurrencyCode;
        @SerializedName("geoplugin_currencySymbol")
        @Expose
        private String geopluginCurrencySymbol;
        @SerializedName("geoplugin_currencySymbol_UTF8")
        @Expose
        private String geopluginCurrencySymbolUTF8;
        @SerializedName("geoplugin_currencyConverter")
        @Expose
        private Double geopluginCurrencyConverter;

        public String getGeopluginRequest() {
            return geopluginRequest;
        }

        public void setGeopluginRequest(String geopluginRequest) {
            this.geopluginRequest = geopluginRequest;
        }

        public Integer getGeopluginStatus() {
            return geopluginStatus;
        }

        public void setGeopluginStatus(Integer geopluginStatus) {
            this.geopluginStatus = geopluginStatus;
        }

        public String getGeopluginDelay() {
            return geopluginDelay;
        }

        public void setGeopluginDelay(String geopluginDelay) {
            this.geopluginDelay = geopluginDelay;
        }

        public String getGeopluginCredit() {
            return geopluginCredit;
        }

        public void setGeopluginCredit(String geopluginCredit) {
            this.geopluginCredit = geopluginCredit;
        }

        public String getGeopluginCity() {
            return geopluginCity;
        }

        public void setGeopluginCity(String geopluginCity) {
            this.geopluginCity = geopluginCity;
        }

        public String getGeopluginRegion() {
            return geopluginRegion;
        }

        public void setGeopluginRegion(String geopluginRegion) {
            this.geopluginRegion = geopluginRegion;
        }

        public String getGeopluginRegionCode() {
            return geopluginRegionCode;
        }

        public void setGeopluginRegionCode(String geopluginRegionCode) {
            this.geopluginRegionCode = geopluginRegionCode;
        }

        public String getGeopluginRegionName() {
            return geopluginRegionName;
        }

        public void setGeopluginRegionName(String geopluginRegionName) {
            this.geopluginRegionName = geopluginRegionName;
        }

        public String getGeopluginAreaCode() {
            return geopluginAreaCode;
        }

        public void setGeopluginAreaCode(String geopluginAreaCode) {
            this.geopluginAreaCode = geopluginAreaCode;
        }

        public String getGeopluginDmaCode() {
            return geopluginDmaCode;
        }

        public void setGeopluginDmaCode(String geopluginDmaCode) {
            this.geopluginDmaCode = geopluginDmaCode;
        }

        public String getGeopluginCountryCode() {
            return geopluginCountryCode;
        }

        public void setGeopluginCountryCode(String geopluginCountryCode) {
            this.geopluginCountryCode = geopluginCountryCode;
        }

        public String getGeopluginCountryName() {
            return geopluginCountryName;
        }

        public void setGeopluginCountryName(String geopluginCountryName) {
            this.geopluginCountryName = geopluginCountryName;
        }

        public Integer getGeopluginInEU() {
            return geopluginInEU;
        }

        public void setGeopluginInEU(Integer geopluginInEU) {
            this.geopluginInEU = geopluginInEU;
        }

        public Boolean getGeopluginEuVATrate() {
            return geopluginEuVATrate;
        }

        public void setGeopluginEuVATrate(Boolean geopluginEuVATrate) {
            this.geopluginEuVATrate = geopluginEuVATrate;
        }

        public String getGeopluginContinentCode() {
            return geopluginContinentCode;
        }

        public void setGeopluginContinentCode(String geopluginContinentCode) {
            this.geopluginContinentCode = geopluginContinentCode;
        }

        public String getGeopluginContinentName() {
            return geopluginContinentName;
        }

        public void setGeopluginContinentName(String geopluginContinentName) {
            this.geopluginContinentName = geopluginContinentName;
        }

        public String getGeopluginLatitude() {
            return geopluginLatitude;
        }

        public void setGeopluginLatitude(String geopluginLatitude) {
            this.geopluginLatitude = geopluginLatitude;
        }

        public String getGeopluginLongitude() {
            return geopluginLongitude;
        }

        public void setGeopluginLongitude(String geopluginLongitude) {
            this.geopluginLongitude = geopluginLongitude;
        }

        public String getGeopluginLocationAccuracyRadius() {
            return geopluginLocationAccuracyRadius;
        }

        public void setGeopluginLocationAccuracyRadius(String geopluginLocationAccuracyRadius) {
            this.geopluginLocationAccuracyRadius = geopluginLocationAccuracyRadius;
        }

        public String getGeopluginTimezone() {
            return geopluginTimezone;
        }

        public void setGeopluginTimezone(String geopluginTimezone) {
            this.geopluginTimezone = geopluginTimezone;
        }

        public String getGeopluginCurrencyCode() {
            return geopluginCurrencyCode;
        }

        public void setGeopluginCurrencyCode(String geopluginCurrencyCode) {
            this.geopluginCurrencyCode = geopluginCurrencyCode;
        }

        public String getGeopluginCurrencySymbol() {
            return geopluginCurrencySymbol;
        }

        public void setGeopluginCurrencySymbol(String geopluginCurrencySymbol) {
            this.geopluginCurrencySymbol = geopluginCurrencySymbol;
        }

        public String getGeopluginCurrencySymbolUTF8() {
            return geopluginCurrencySymbolUTF8;
        }

        public void setGeopluginCurrencySymbolUTF8(String geopluginCurrencySymbolUTF8) {
            this.geopluginCurrencySymbolUTF8 = geopluginCurrencySymbolUTF8;
        }

        public Double getGeopluginCurrencyConverter() {
            return geopluginCurrencyConverter;
        }

        public void setGeopluginCurrencyConverter(Double geopluginCurrencyConverter) {
            this.geopluginCurrencyConverter = geopluginCurrencyConverter;
        }

}