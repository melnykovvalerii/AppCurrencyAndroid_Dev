// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.fragment;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import com.allerates.appforyou.R;
import java.lang.Deprecated;
import java.lang.Override;

public class SearchPlaceOnMapFragment_ViewBinding implements Unbinder {
  /**
   * @deprecated Use {@link #SearchPlaceOnMapFragment_ViewBinding(SearchPlaceOnMapFragment, Context)} for direct creation.
   *     Only present for runtime invocation through {@code ButterKnife.bind()}.
   */
  @Deprecated
  @UiThread
  public SearchPlaceOnMapFragment_ViewBinding(SearchPlaceOnMapFragment target, View source) {
    this(target, source.getContext());
  }

  @UiThread
  public SearchPlaceOnMapFragment_ViewBinding(SearchPlaceOnMapFragment target, Context context) {
    Resources res = context.getResources();
    target.stUniqueID = res.getString(R.string.txt_unique_id);
    target.txtErrorColon = res.getString(R.string.txt_error_colon);
    target.defIdUser = res.getString(R.string.txt_def_id_user);
  }

  @Override
  @CallSuper
  public void unbind() {
  }
}
