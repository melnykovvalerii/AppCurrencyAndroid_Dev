package com.allerates.appforyou.request.api;

import com.allerates.appforyou.request.AuthKey;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by rikmen00@gmail.com on 02.11.2018.
 */

public interface SetPoint {
    @POST("/wp-json/NewMapPoint/v2")
    Call <List<AuthKey>> mSetPoint(
                                  @Query("site_curency") String siteCurrency,
                                  @Query("phone_currency") String phoneCurrency,
                                  @Query("new_point_Sh") String newPointSh,
                                  @Query("new_point_Dl") String newPointDl,
                                  @Query("day_work") String dayWork,
                                  @Query("time_work") String timeWork,
                                  @Query("minimal_amount") String minimalAmount,
                                  @Query("card") String card,
                                  @Query("BTC") String bts,
                                  @Query("ETH") String eth,
                                  @Query("MAID") String maid,
                                  @Query("XMR") String xmr,
                                  @Query("XRP") String xrp,
                                  @Query("XEM") String xem,
                                  @Query("DASH") String dash,
                                  @Query("LTC") String ltc,
                                  @Query("AUR") String aur,
                                  @Query("ETC") String etc,
                                  @Query("day_work_end") String dayWorkEnd,
                                  @Query("time_work_end") String timeWorkEnd,
                                  @Query("about") String about,
                                  @Query("cash") String cash,
                                  @Query("mail_cash") String mail_cash,
                                  @Query("point_adres") String point_adres
    );}

//                                          site_curency=ауауа.fe&
//                                          phone_currency=12311111111&
//                                          new_point_Sh=44.23456&
//                                          new_point_Dl=4.123123&
//                                          day_work=12&
//                                          time_work=12&
//                                          minimal_amount=234&
//                                          card=1&
//                                          BTC=1&
//                                          ETH=1&
//                                          MAID=1&
//                                          XMR=1&
//                                          XRP=1&
//                                          XEM=1&
//                                          DASH=1&
//                                          LTC=1&
//                                          AUR=1&
//                                          ETC=1&
//                                          day_work_end=DDDDAASSDAD&
//                                          time_work_end=asdasdasd&
//                                          about=sss&
//                                          cash=1&
//                                          mail_cash=1&
//                                          point_adres=dwdaw


                                  //Observable<AuthKey> mSetPoint(@Query("site_curency") String siteCurency,

 //http://www.look-studio.com/wp-json/NewMapPoint/v2?site_curency=Ggfghh.ru&phone_currency=12345678912&new_point_Sh=60.87493286582681&new_point_Dl=37.915315702557564&day_work=пятница&time_work=12:00&minimal_amount=500&card=1&BTC=1&ETH=1&MAID=1&XMR=1&XRP=1&XEM=1&DASH=1&LTC=1&AUR=1&ETC=1&day_work_end=12:30&time_work_end=13:00&about=dfb&cash=1&mail_cash=1&point_adres=dadawda
