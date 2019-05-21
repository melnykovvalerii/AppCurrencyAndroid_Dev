// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.activities;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.allerates.appforyou.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SettingActivity_ViewBinding implements Unbinder {
  private SettingActivity target;

  private View view2131296291;

  private View view2131296325;

  private View view2131296413;

  @UiThread
  public SettingActivity_ViewBinding(SettingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SettingActivity_ViewBinding(final SettingActivity target, View source) {
    this.target = target;

    View view;
    target.edName = Utils.findRequiredViewAsType(source, R.id.ed_name, "field 'edName'", EditText.class);
    target.edPassword = Utils.findRequiredViewAsType(source, R.id.ed_password, "field 'edPassword'", EditText.class);
    target.edPhone = Utils.findRequiredViewAsType(source, R.id.ed_phone, "field 'edPhone'", EditText.class);
    target.checkAct = Utils.findRequiredViewAsType(source, R.id.check_act, "field 'checkAct'", CheckBox.class);
    target.edEmail = Utils.findRequiredViewAsType(source, R.id.ed_email, "field 'edEmail'", EditText.class);
    view = Utils.findRequiredView(source, R.id.add_photo, "field 'imgUser' and method 'onImg'");
    target.imgUser = Utils.castView(view, R.id.add_photo, "field 'imgUser'", ImageView.class);
    view2131296291 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onImg(p0);
      }
    });
    target.def_img = Utils.findRequiredView(source, R.id.def_img, "field 'def_img'");
    view = Utils.findRequiredView(source, R.id.btn_currency, "field 'btnCurrency' and method 'onB'");
    target.btnCurrency = Utils.castView(view, R.id.btn_currency, "field 'btnCurrency'", Button.class);
    view2131296325 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onB(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.create_btn, "field 'BtnCreate' and method 'sendData'");
    target.BtnCreate = Utils.castView(view, R.id.create_btn, "field 'BtnCreate'", Button.class);
    view2131296413 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.sendData(p0);
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.cryptoCurrencyNames = res.getString(R.string.txt_crypto_currency_names);
    target.txtYouSelected = res.getString(R.string.txt_you_selected);
    target.downArrow = res.getString(R.string.txt_down_arrow);
    target.wentWrong = res.getString(R.string.wrong);
    target.defIdUser = res.getString(R.string.txt_def_id_user);
    target.haventPicked = res.getString(R.string.havent_picked);
    target.stMoney = res.getString(R.string.money);
    target.numberCheckSimpl = res.getString(R.string.number_check_simpl);
    target.txtSucUpdated = res.getString(R.string.txt_suc_updated);
    target.txtNotCorrect = res.getString(R.string.txt_not_correct);
    target.txtFailedToUp = res.getString(R.string.txt_failed_to_up);
    target.txtErrorColon = res.getString(R.string.txt_error_colon);
  }

  @Override
  @CallSuper
  public void unbind() {
    SettingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edName = null;
    target.edPassword = null;
    target.edPhone = null;
    target.checkAct = null;
    target.edEmail = null;
    target.imgUser = null;
    target.def_img = null;
    target.btnCurrency = null;
    target.BtnCreate = null;

    view2131296291.setOnClickListener(null);
    view2131296291 = null;
    view2131296325.setOnClickListener(null);
    view2131296325 = null;
    view2131296413.setOnClickListener(null);
    view2131296413 = null;
  }
}
