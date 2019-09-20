package com.allerates.appforyou;


import com.allerates.appforyou.request.api.AddCommentPoint;
import com.allerates.appforyou.request.api.CoinHistoryDay;
import com.allerates.appforyou.request.api.CoinService;
import com.allerates.appforyou.request.api.GetDataUser;
import com.allerates.appforyou.request.api.GetNearPoints;
import com.allerates.appforyou.request.api.GetPoint;
import com.allerates.appforyou.request.api.ListComment;
import com.allerates.appforyou.request.api.LogWithMail;
import com.allerates.appforyou.request.api.SendVerMail;
import com.allerates.appforyou.request.api.SetPoint;


public class Common {
    private static final String API_URL = "https://min-api.cryptocompare.com";
    private static final String BASE_URL = "https://cryptocompare.com";
    private static final String BASE_URL_API = "http://www.look-studio.com";
    public static boolean isGetReq = false;
    public static final String ID_COUNT = "ft9tkda487d8r3t66e80";

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

    public static ListComment getListComment(){
        return RetrofitClient.getApiClient(BASE_URL_API).create(ListComment.class);
    }
    public static LogWithMail LogWithMail(){
        return RetrofitClient.getApiClient(BASE_URL_API).create(LogWithMail.class);
    }
    public static AddCommentPoint addCommentPoint(){
        return RetrofitClient.getApiClient(BASE_URL_API).create(AddCommentPoint.class);
    }
    public static SetPoint setPoint(){
        return RetrofitClient.getApiClient(BASE_URL_API).create(SetPoint.class);
    }
    public static SendVerMail sendVerMail(){
        return RetrofitClient.getApiClient(BASE_URL_API).create(SendVerMail.class);
    }
    public static CoinService getCoinService(){
        return RetrofitClient.getApiClient(API_URL).create(CoinService.class);
    }
    public static GetDataUser getUserDate(){
        return RetrofitClient.getApiClient(BASE_URL_API).create(GetDataUser.class);
    }
    public static GetNearPoints getNearPoints(){
        return RetrofitClient.getApiClient(BASE_URL_API).create(GetNearPoints.class);
    }
    public static CoinHistoryDay Histoday(){
        return RetrofitClient.getApiClient(API_URL).create(CoinHistoryDay.class);
    }
    public static GetPoint getPoint(){
        return RetrofitClient.getApiClient(BASE_URL_API).create(GetPoint.class);
    }
}
