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

public class MainActivity_ViewBinding implements Unbinder {
  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target);
  }

  /**
   * @deprecated Use {@link #MainActivity_ViewBinding(MainActivity, Context)} for direct creation.
   *     Only present for runtime invocation through {@code ButterKnife.bind()}.
   */
  @Deprecated
  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this(target, source.getContext());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, Context context) {
    Resources res = context.getResources();
    target.txtErrorColon = res.getString(R.string.txt_error_colon);
    target.defIdUser = res.getString(R.string.txt_def_id_user);
  }

  @Override
  @CallSuper
  public void unbind() {
  }
}
