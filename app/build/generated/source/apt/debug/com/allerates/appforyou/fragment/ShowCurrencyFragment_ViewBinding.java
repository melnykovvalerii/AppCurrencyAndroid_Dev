// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.allerates.appforyou.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShowCurrencyFragment_ViewBinding implements Unbinder {
  private ShowCurrencyFragment target;

  private View view2131296325;

  @UiThread
  public ShowCurrencyFragment_ViewBinding(final ShowCurrencyFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_currency, "field 'btnCurrency' and method 'onB'");
    target.btnCurrency = Utils.castView(view, R.id.btn_currency, "field 'btnCurrency'", Button.class);
    view2131296325 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onB(p0);
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.txtNumberCheck = res.getString(R.string.txt_number_check);
    target.downArrow = res.getString(R.string.txt_down_arrow);
    target.txtYouSelected = res.getString(R.string.txt_you_selected);
    target.cryptoCurrencyNames = res.getString(R.string.txt_crypto_currency_names);
    target.txtErrorColon = res.getString(R.string.txt_error_colon);
    target.numberCheckSimpl = res.getString(R.string.number_check_simpl);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShowCurrencyFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnCurrency = null;

    view2131296325.setOnClickListener(null);
    view2131296325 = null;
  }
}
