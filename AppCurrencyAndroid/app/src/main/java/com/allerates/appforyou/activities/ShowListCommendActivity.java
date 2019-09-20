package com.allerates.appforyou.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.adapters.ListCommentAdapter;
import com.allerates.appforyou.request.AllPointComment;
import com.allerates.appforyou.request.api.GetPoint;
import com.allerates.appforyou.request.api.ListComment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.allerates.appforyou.Common.ID_COUNT;


public class ShowListCommendActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private String stUniqueIDGet;
    private SwipeRefreshLayout refreshLayout;
    private Unbinder unbinder;
    @BindString(R.string.txt_error_colon)
    String txtErrorColon;
    private GetPoint mGetPoint;
    private List<AllPointComment> commentList = new ArrayList<>();
    private ListCommentAdapter mAdapter;
    private RecyclerView recyclerView;
    private com.allerates.appforyou.request.Point itemPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_main_list_comment);
            unbinder = ButterKnife.bind(this);
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        recyclerView = findViewById(R.id.recycler_view_comment);
        mAdapter = new ListCommentAdapter(commentList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        refreshLayout = findViewById(R.id.refresh_list);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorScheme(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.red);
        if (getIntent().getExtras().getString("stUniqueID") != null)
            stUniqueIDGet = getIntent().getExtras().getString("stUniqueID");
        else
            stUniqueIDGet = null;
        onRefresh();
    }

    public void getAllCount() {
        mGetPoint = Common.getPoint();
        mGetPoint.mValue(ID_COUNT)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(points -> {
                    getAccurInfo(points);
                    refreshLayout.setRefreshing(false);
                },
                        throwable -> {
                            Log.e("TAG", txtErrorColon + throwable);
                            refreshLayout.setRefreshing(false);
                        });
    }

    private void getAccurInfo(List<com.allerates.appforyou.request.Point> pointList) {
        itemPoints = new com.allerates.appforyou.request.Point();
        String idTemp;
        for (com.allerates.appforyou.request.Point point : pointList) {
            if (point.getAuthKey() != null && !point.getAuthKey().isEmpty()) {
                idTemp = point.getPlaceID();
                if (idTemp.equals(stUniqueIDGet))
                    itemPoints = point;
            }
        }
        String stAuth = itemPoints.getAuthKey();
        if (stAuth != null) {
            getListComment(itemPoints.getAuthKey());
            Log.e("TAG", txtErrorColon + stAuth);
        }
    }

    public void getListComment(String auth) {
        ListComment mListComment;
        mListComment = Common.getListComment();
        mListComment.getListComment(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listComments -> {
                            getInfo(listComments);
                            refreshLayout.setRefreshing(false);
                        },
                        throwable -> {
                            Log.e("TAG", txtErrorColon + throwable);
                            txtErrorColon = throwable.getMessage();
                            Log.e("TAG", throwable.getMessage());
                            refreshLayout.setRefreshing(false);
                        });
    }

    private void getInfo(com.allerates.appforyou.request.ListComment listComments) {
        if (listComments.getAllPointComment().size() > 0) {
            commentList.clear();
            commentList.addAll(listComments.getAllPointComment());
            mAdapter.notifyDataSetChanged();
        } else
            Toast.makeText(this, "No comment.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        try {
            super.onBackPressed();
            Intent intent = new Intent(ShowListCommendActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        try {
            super.onDestroy();
            unbinder.unbind();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRefresh() {
        try {
            if (!refreshLayout.isRefreshing())
                refreshLayout.setRefreshing(true);
            refreshLayout.postDelayed(() -> getAllCount(), 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
