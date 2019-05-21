// Generated code from Butter Knife. Do not modify!
package com.allerates.appforyou.activities;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.allerates.appforyou.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailedActivity_ViewBinding implements Unbinder {
  private DetailedActivity target;

  private View view2131296289;

  private View view2131296598;

  @UiThread
  public DetailedActivity_ViewBinding(DetailedActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailedActivity_ViewBinding(final DetailedActivity target, View source) {
    this.target = target;

    View view;
    target.tvSite = Utils.findRequiredViewAsType(source, R.id.tv_site, "field 'tvSite'", TextView.class);
    target.ratingBar = Utils.findRequiredViewAsType(source, R.id.ratingBar, "field 'ratingBar'", RatingBar.class);
    target.tvNumber = Utils.findRequiredViewAsType(source, R.id.tv_number, "field 'tvNumber'", TextView.class);
    target.commentsCount = Utils.findRequiredViewAsType(source, R.id.comments_count, "field 'commentsCount'", TextView.class);
    target.tvDaysOfWork = Utils.findRequiredViewAsType(source, R.id.tv_days_of_work, "field 'tvDaysOfWork'", TextView.class);
    target.minOrder = Utils.findRequiredViewAsType(source, R.id.tv_currency2, "field 'minOrder'", TextView.class);
    target.tvAddress = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'tvAddress'", TextView.class);
    target.tvWorkTime = Utils.findRequiredViewAsType(source, R.id.tv_work_time, "field 'tvWorkTime'", TextView.class);
    target.tvPayMeth = Utils.findRequiredViewAsType(source, R.id.tv_currency, "field 'tvPayMeth'", TextView.class);
    target.tvAbout = Utils.findRequiredViewAsType(source, R.id.tv_about, "field 'tvAbout'", TextView.class);
    view = Utils.findRequiredView(source, R.id.add_commend, "field 'imgAdd' and method 'onButClick'");
    target.imgAdd = Utils.castView(view, R.id.add_commend, "field 'imgAdd'", ImageView.class);
    view2131296289 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButClick(p0);
      }
    });
    target.lnrComment = Utils.findRequiredViewAsType(source, R.id.lnr_comment, "field 'lnrComment'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.open_map, "method 'onButMapClick'");
    view2131296598 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onButMapClick(p0);
      }
    });

    Context context = source.getContext();
    Resources res = context.getResources();
    target.txtErrorColon = res.getString(R.string.txt_error_colon);
    target.defIdUser = res.getString(R.string.txt_def_id_user);
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailedActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvSite = null;
    target.ratingBar = null;
    target.tvNumber = null;
    target.commentsCount = null;
    target.tvDaysOfWork = null;
    target.minOrder = null;
    target.tvAddress = null;
    target.tvWorkTime = null;
    target.tvPayMeth = null;
    target.tvAbout = null;
    target.imgAdd = null;
    target.lnrComment = null;

    view2131296289.setOnClickListener(null);
    view2131296289 = null;
    view2131296598.setOnClickListener(null);
    view2131296598 = null;
  }
}
