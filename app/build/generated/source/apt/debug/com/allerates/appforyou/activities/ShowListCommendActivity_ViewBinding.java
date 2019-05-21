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

public class ShowListCommendActivity_ViewBinding implements Unbinder {
  @UiThread
  public ShowListCommendActivity_ViewBinding(ShowListCommendActivity target) {
    this(target, target);
  }

  /**
   * @deprecated Use {@link #ShowListCommendActivity_ViewBinding(ShowListCommendActivity, Context)} for direct creation.
   *     Only present for runtime invocation through {@code ButterKnife.bind()}.
   */
  @Deprecated
  @UiThread
  public ShowListCommendActivity_ViewBinding(ShowListCommendActivity target, View source) {
    this(target, source.getContext());
  }

  @UiThread
  public ShowListCommendActivity_ViewBinding(ShowListCommendActivity target, Context context) {
    Resources res = context.getResources();
    target.txtErrorColon = res.getString(R.string.txt_error_colon);
  }

  @Override
  @CallSuper
  public void unbind() {
  }
}
