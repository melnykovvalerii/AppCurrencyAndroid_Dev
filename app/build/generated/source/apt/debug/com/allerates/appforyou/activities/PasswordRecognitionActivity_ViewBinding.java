// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.activities;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.allerates.appforyou.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PasswordRecognitionActivity_ViewBinding implements Unbinder {
  private PasswordRecognitionActivity target;

  private View view2131296669;

  @UiThread
  public PasswordRecognitionActivity_ViewBinding(PasswordRecognitionActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PasswordRecognitionActivity_ViewBinding(final PasswordRecognitionActivity target,
      View source) {
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
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.title, "field 'tvTitle'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PasswordRecognitionActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnSend = null;
    target.tvTitle = null;

    view2131296669.setOnClickListener(null);
    view2131296669 = null;
  }
}
