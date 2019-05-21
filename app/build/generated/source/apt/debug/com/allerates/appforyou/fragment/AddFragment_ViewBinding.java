// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.allerates.appforyou.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddFragment_ViewBinding implements Unbinder {
  private AddFragment target;

  private View view2131296330;

  private View view2131296752;

  private View view2131296413;

  private View view2131296325;

  private View view2131296336;

  private View view2131296331;

  private View view2131296291;

  @UiThread
  public AddFragment_ViewBinding(final AddFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_from_day_week, "field 'fromDayWeek' and method 'onBtnFromDayWeek'");
    target.fromDayWeek = Utils.castView(view, R.id.btn_from_day_week, "field 'fromDayWeek'", Button.class);
    view2131296330 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnFromDayWeek(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.to_day_week, "field 'toDayWeek' and method 'onButDayWeek'");
    target.toDayWeek = Utils.castView(view, R.id.to_day_week, "field 'toDayWeek'", Button.class);
    view2131296752 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButDayWeek(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.create_btn, "field 'createBtn' and method 'onButtonClick'");
    target.createBtn = Utils.castView(view, R.id.create_btn, "field 'createBtn'", Button.class);
    view2131296413 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButtonClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_currency, "field 'btnPayMethBtn' and method 'onBtnPayMeth'");
    target.btnPayMethBtn = Utils.castView(view, R.id.btn_currency, "field 'btnPayMethBtn'", Button.class);
    view2131296325 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnPayMeth(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_to_time, "field 'btnToTime' and method 'onBtnTvToTime'");
    target.btnToTime = Utils.castView(view, R.id.btn_to_time, "field 'btnToTime'", Button.class);
    view2131296336 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnTvToTime(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_from_time, "field 'btnFromTime' and method 'onBtnFromTime'");
    target.btnFromTime = Utils.castView(view, R.id.btn_from_time, "field 'btnFromTime'", Button.class);
    view2131296331 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnFromTime(p0);
      }
    });
    target.toTime = Utils.findRequiredViewAsType(source, R.id.txt_to_time, "field 'toTime'", TextView.class);
    target.fromTime = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'fromTime'", TextView.class);
    target.tvToTime = Utils.findRequiredViewAsType(source, R.id.tv_to_time, "field 'tvToTime'", TextView.class);
    target.edSite = Utils.findRequiredViewAsType(source, R.id.ed_site, "field 'edSite'", EditText.class);
    target.edNumber = Utils.findRequiredViewAsType(source, R.id.ed_number, "field 'edNumber'", EditText.class);
    target.edMinSum = Utils.findRequiredViewAsType(source, R.id.ed_min_sum, "field 'edMinSum'", EditText.class);
    target.edAddress = Utils.findRequiredViewAsType(source, R.id.ed_address, "field 'edAddress'", EditText.class);
    target.edAbout = Utils.findRequiredViewAsType(source, R.id.ed_about, "field 'edAbout'", EditText.class);
    view = Utils.findRequiredView(source, R.id.add_photo, "method 'onButClick'");
    view2131296291 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButClick(p0);
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.defString = res.getString(R.string.def_string);
    target.currencyIsNot = res.getString(R.string.txt_currency_is_not);
    target.txtSelectImage = res.getString(R.string.txt_select_image);
    target.txtComma = res.getString(R.string.txt_comma);
    target.txtLeftSquareBrackets = res.getString(R.string.txt_left_square_brackets);
    target.txtRightSquareBrackets = res.getString(R.string.txt_right_square_brackets);
    target.txtLatitude = res.getString(R.string.txt_latitude);
    target.txtLongitude = res.getString(R.string.txt_longitude);
    target.defStringOneSpace = res.getString(R.string.def_string_one_space);
    target.txtMapFile = res.getString(R.string.txt_map_file);
    target.txtDot = res.getString(R.string.txt_dot);
    target.txtColon = res.getString(R.string.colon);
    target.txtAm = res.getString(R.string.txt_am);
    target.txtPm = res.getString(R.string.txt_pm);
    target.txtEmpty = res.getString(R.string.txt_empty);
    target.requiredField = res.getString(R.string.required_field);
    target.theNumber = res.getString(R.string.the_number);
    target.txtField = res.getString(R.string.txt_field);
    target.txtTheMinimumAmount = res.getString(R.string.txt_the_minimum_amount);
    target.txtAdditionalInformation = res.getString(R.string.st_additional_information);
    target.txtAboutCurrencyExchange = res.getString(R.string.txt_about_currency_exchange);
    target.txtAdress = res.getString(R.string.txt_address);
    target.txtThePhoneNumber = res.getString(R.string.txt_the_phone_number);
    target.format = res.getString(R.string.def_string);
    target.txtSite = res.getString(R.string.txt_site);
    target.cryptoCurrencyNames = res.getString(R.string.txt_crypto_currency_names);
    target.paymentMethodNumber = res.getString(R.string.payment_method_number);
    target.txtYouSelected = res.getString(R.string.txt_you_selected);
    target.downArrow = res.getString(R.string.txt_down_arrow);
    target.txtMailCash = res.getString(R.string.txt_mail_cash);
    target.txtCardCheck = res.getString(R.string.txt_card_check);
    target.txtCash = res.getString(R.string.txt_cash);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.fromDayWeek = null;
    target.toDayWeek = null;
    target.createBtn = null;
    target.btnPayMethBtn = null;
    target.btnToTime = null;
    target.btnFromTime = null;
    target.toTime = null;
    target.fromTime = null;
    target.tvToTime = null;
    target.edSite = null;
    target.edNumber = null;
    target.edMinSum = null;
    target.edAddress = null;
    target.edAbout = null;

    view2131296330.setOnClickListener(null);
    view2131296330 = null;
    view2131296752.setOnClickListener(null);
    view2131296752 = null;
    view2131296413.setOnClickListener(null);
    view2131296413 = null;
    view2131296325.setOnClickListener(null);
    view2131296325 = null;
    view2131296336.setOnClickListener(null);
    view2131296336 = null;
    view2131296331.setOnClickListener(null);
    view2131296331 = null;
    view2131296291.setOnClickListener(null);
    view2131296291 = null;
  }
}
