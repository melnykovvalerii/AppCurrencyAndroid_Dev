// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.allerates.appforyou.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConverterFragment_ViewBinding implements Unbinder {
  private ConverterFragment target;

  private View view2131296322;

  private View view2131296329;

  private View view2131296335;

  private View view2131296448;

  private View view2131296388;

  private View view2131296550;

  private View view2131296389;

  @UiThread
  public ConverterFragment_ViewBinding(final ConverterFragment target, View source) {
    this.target = target;

    View view;
    target.toTextView = Utils.findRequiredViewAsType(source, R.id.toTextView, "field 'toTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btnConvert, "field 'btnConvert' and method 'onBtnConvert'");
    target.btnConvert = Utils.castView(view, R.id.btnConvert, "field 'btnConvert'", Button.class);
    view2131296322 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBtnConvert(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_first, "field 'btnFirst' and method 'onButtonClick'");
    target.btnFirst = Utils.castView(view, R.id.btn_first, "field 'btnFirst'", Button.class);
    view2131296329 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButtonClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_second, "field 'btnSecond' and method 'onButtonCl'");
    target.btnSecond = Utils.castView(view, R.id.btn_second, "field 'btnSecond'", Button.class);
    view2131296335 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButtonCl(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ed_value, "field 'edValue' and method 'onEdCl'");
    target.edValue = Utils.castView(view, R.id.ed_value, "field 'edValue'", EditText.class);
    view2131296448 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onEdCl(p0);
      }
    });
    target.coinImage = Utils.findRequiredViewAsType(source, R.id.coinImage, "field 'coinImage'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.coin_to_coin, "field 'coinToCoin' and method 'onB'");
    target.coinToCoin = Utils.castView(view, R.id.coin_to_coin, "field 'coinToCoin'", ImageView.class);
    view2131296388 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onB(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.money_to_money, "field 'moneyToMoney' and method 'onBu'");
    target.moneyToMoney = Utils.castView(view, R.id.money_to_money, "field 'moneyToMoney'", ImageView.class);
    view2131296550 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBu(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.coin_to_money, "field 'coinToMoney' and method 'onBut'");
    target.coinToMoney = Utils.castView(view, R.id.coin_to_money, "field 'coinToMoney'", ImageView.class);
    view2131296389 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onBut(p0);
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.downArrow = res.getString(R.string.txt_down_arrow);
    target.txtError = res.getString(R.string.txt_error);
    target.btcString = res.getString(R.string.btc_string);
    target.etcString = res.getString(R.string.etc_string);
    target.xrpString = res.getString(R.string.xrp_string);
    target.aurString = res.getString(R.string.aur_string);
    target.dashString = res.getString(R.string.dash_string);
    target.maidString = res.getString(R.string.maid_string);
    target.xmrString = res.getString(R.string.xmr_string);
    target.xemString = res.getString(R.string.xem_string);
    target.ethString = res.getString(R.string.eth_string);
    target.ltcString = res.getString(R.string.ltc_string);
    target.usdString = res.getString(R.string.usd_string);
    target.gbpString = res.getString(R.string.gbp_string);
    target.eurString = res.getString(R.string.eur_string);
    target.usdTextIcon = res.getString(R.string.usd_text_icon);
    target.gbpTextIcon = res.getString(R.string.gbp_text_icon);
    target.eurTextIcon = res.getString(R.string.eur_text_icon);
    target.txtYouSelected = res.getString(R.string.txt_you_selected);
    target.txtErrorColon = res.getString(R.string.txt_error_colon);
    target.txtNumberCheck = res.getString(R.string.txt_number_check);
    target.txtIsFirstButton = res.getString(R.string.txt_is_first_button);
    target.cryptoCurrencyNames = res.getString(R.string.txt_crypto_currency_names);
    target.defString = res.getString(R.string.def_string);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConverterFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toTextView = null;
    target.btnConvert = null;
    target.btnFirst = null;
    target.btnSecond = null;
    target.edValue = null;
    target.coinImage = null;
    target.coinToCoin = null;
    target.moneyToMoney = null;
    target.coinToMoney = null;

    view2131296322.setOnClickListener(null);
    view2131296322 = null;
    view2131296329.setOnClickListener(null);
    view2131296329 = null;
    view2131296335.setOnClickListener(null);
    view2131296335 = null;
    view2131296448.setOnClickListener(null);
    view2131296448 = null;
    view2131296388.setOnClickListener(null);
    view2131296388 = null;
    view2131296550.setOnClickListener(null);
    view2131296550 = null;
    view2131296389.setOnClickListener(null);
    view2131296389 = null;
  }
}
