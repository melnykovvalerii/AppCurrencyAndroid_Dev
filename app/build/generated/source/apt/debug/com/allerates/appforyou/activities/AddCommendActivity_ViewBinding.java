// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.activities;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.allerates.appforyou.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddCommendActivity_ViewBinding implements Unbinder {
  private AddCommendActivity target;

  private View view2131296413;

  @UiThread
  public AddCommendActivity_ViewBinding(AddCommendActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddCommendActivity_ViewBinding(final AddCommendActivity target, View source) {
    this.target = target;

    View view;
    target.ratingBar = Utils.findRequiredViewAsType(source, R.id.ratingBar, "field 'ratingBar'", RatingBar.class);
    view = Utils.findRequiredView(source, R.id.create_btn, "field 'createBtn' and method 'onB'");
    target.createBtn = Utils.castView(view, R.id.create_btn, "field 'createBtn'", Button.class);
    view2131296413 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onB(p0);
      }
    });
    target.edAbout = Utils.findRequiredViewAsType(source, R.id.ed_about, "field 'edAbout'", EditText.class);

    Context context = source.getContext();
    Resources res = context.getResources();
    target.defIdUser = res.getString(R.string.txt_def_id_user);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddCommendActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ratingBar = null;
    target.createBtn = null;
    target.edAbout = null;

    view2131296413.setOnClickListener(null);
    view2131296413 = null;
  }
}
