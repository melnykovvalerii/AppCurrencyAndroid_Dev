// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.allerates.appforyou.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActivitySetPassword_ViewBinding implements Unbinder {
  private ActivitySetPassword target;

  private View view2131296669;

  @UiThread
  public ActivitySetPassword_ViewBinding(ActivitySetPassword target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ActivitySetPassword_ViewBinding(final ActivitySetPassword target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.send, "field 'btnSend' and method 'onButClick'");
    target.btnSend = Utils.castView(view, R.id.send, "field 'btnSend'", Button.class);
    view2131296669 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButClick(p0);
      }
    });
    target.edPassword = Utils.findRequiredViewAsType(source, R.id.ed_password, "field 'edPassword'", TextInputEditText.class);
    target.edPassword2 = Utils.findRequiredViewAsType(source, R.id.ed_password2, "field 'edPassword2'", TextInputEditText.class);
    target.edCode = Utils.findRequiredViewAsType(source, R.id.ed_code, "field 'edCode'", TextInputEditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ActivitySetPassword target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnSend = null;
    target.edPassword = null;
    target.edPassword2 = null;
    target.edCode = null;

    view2131296669.setOnClickListener(null);
    view2131296669 = null;
  }
}
