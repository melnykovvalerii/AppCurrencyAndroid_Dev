package com.allerates.appforyou;

import com.allerates.appforyou.request.api.CoinHistoryDay;
import com.allerates.appforyou.request.api.CoinService;
import com.allerates.appforyou.request.api.IpService;
import com.allerates.appforyou.request.api.IpServiceGet;

/**
 * Created by Rikmen on 01.06.2018.
 */

public class Common {
    private static final String API_URL = "https://min-api.cryptocompare.com";
    private static final String BASE_URL = "https://cryptocompare.com";
    private static final String BASE_URL_IPSTACK = "https://api.ipstack.com";
    private static final String BASE_URL_IP_JSON = "http://ip.jsontest.com";

    public static final String ETH_IMAGE = new StringBuilder(BASE_URL).append("/media/20646/eth_logo.png").toString();
    public static final String BTC_IMAGE = new StringBuilder(BASE_URL).append("/media/19633/btc.png").toString();
    public static final String ETC_IMAGE = new StringBuilder(BASE_URL).append("/media/20275/etc2.png").toString();
    public static final String LTC_IMAGE = new StringBuilder(BASE_URL).append("/media/19782/litecoin-logo.png").toString();
    public static final String XRP_IMAGE = new StringBuilder(BASE_URL).append("/media/19972/ripple.png").toString();
    public static final String XMR_IMAGE = new StringBuilder(BASE_URL).append("/media/19969/xmr.png").toString();
    public static final String DASH_IMAGE = new StringBuilder(BASE_URL).append("/media/20026/dash.png").toString();
    public static final String MAID_IMAGE = new StringBuilder(BASE_URL).append("/media/352247/maid.png").toString();
    public static final String AUR_IMAGE = new StringBuilder(BASE_URL).append("/media/19608/aur.png").toString();
    public static final String XEM_IMAGE = new StringBuilder(BASE_URL).append("/media/20490/xem.png").toString();




    private static final String ACCESS_KEY = new StringBuilder(BASE_URL).append("5ec357e82d495fe23b1aa37160ed3fa0").toString();


    public static IpServiceGet getIpService(){
        return RetrofitClient.getApiClient(BASE_URL_IP_JSON).create(IpServiceGet.class);
    }

    public static CoinService getCoinService(){

        return RetrofitClient.getApiClient(API_URL).create(CoinService.class);
    }
    public static IpService getCurrentService(){
        return RetrofitClient.getApiClient(BASE_URL_IPSTACK).create(IpService.class);
    }

    public static CoinHistoryDay CoinHistoryDay(){
        return RetrofitClient.getApiClient(API_URL).create(CoinHistoryDay.class);
    }

    public static CoinHistoryDay Histoday(){
        return RetrofitClient.getApiClient(API_URL).create(CoinHistoryDay.class);
    }
}
