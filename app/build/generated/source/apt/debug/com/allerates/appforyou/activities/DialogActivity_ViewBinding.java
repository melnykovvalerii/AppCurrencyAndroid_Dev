// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.activities;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import com.allerates.appforyou.R;
import java.lang.Deprecated;
import java.lang.Override;

public class DialogActivity_ViewBinding implements Unbinder {
  @UiThread
  public DialogActivity_ViewBinding(DialogActivity target) {
    this(target, target);
  }

  /**
   * @deprecated Use {@link #DialogActivity_ViewBinding(DialogActivity, Context)} for direct creation.
   *     Only present for runtime invocation through {@code ButterKnife.bind()}.
   */
  @Deprecated
  @UiThread
  public DialogActivity_ViewBinding(DialogActivity target, View source) {
    this(target, source.getContext());
  }

  @UiThread
  public DialogActivity_ViewBinding(DialogActivity target, Context context) {
    Resources res = context.getResources();
    target.txtGotError = res.getString(R.string.txt_got_error);
    target.txtNumberCheck = res.getString(R.string.txt_number_check);
    target.txtIsFirstButton = res.getString(R.string.txt_is_first_button);
    target.txtInvalidValue = res.getString(R.string.txt_invalid_value);
    target.txtError = res.getString(R.string.txt_error);
  }

  @Override
  @CallSuper
  public void unbind() {
  }
}
