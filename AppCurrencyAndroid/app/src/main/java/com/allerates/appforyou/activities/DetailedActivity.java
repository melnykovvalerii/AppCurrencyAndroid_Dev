package com.allerates.appforyou.activities;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.adapters.ImageAdapter;
import com.allerates.appforyou.model.Point;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.api.GetPoint;
import com.allerates.appforyou.request.api.ListComment;
import com.allerates.appforyou.sql.DatabaseHelper;
import org.json.JSONException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class DetailedActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private String stUniqueIDGet;
    private String latitude = null;
    private String longitude = null;
    private com.allerates.appforyou.request.Point itemPoints;
    private String stSite = null;
    private String stNumber = null;
    private String stRating = null;
    private String stAddress = null;
    private String stAbout = null;
    private String stMinSum = null;
    private String stDaysOfTheWeek = null;
    private String stPayMeth = null;
    private String stPaymentMethods = null;
    private String stTime = null;
    private String stCountComment = null;
    private SwipeRefreshLayout refreshLayout;
    private Unbinder unbinder;
    @BindView(R.id.tv_site)
    TextView tvSite;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.comments_count)
    TextView commentsCount;
    @BindView(R.id.tv_days_of_work)
    TextView tvDaysOfWork;
    @BindView(R.id.tv_currency2)
    TextView minOrder;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_work_time)
    TextView tvWorkTime;
    @BindView(R.id.tv_currency)
    TextView tvPayMeth;
    @BindView(R.id.tv_about)
    TextView tvAbout;
    @BindView(R.id.add_commend)
    ImageView imgAdd;
    @BindString(R.string.txt_error_colon)
    String txtErrorColon;
    @BindView(R.id.lnr_comment)
    LinearLayout lnrComment;
    @BindString(R.string.txt_def_id_user)
    String defIdUser;
    private boolean isShowCommentList;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_detailed);
            unbinder = ButterKnife.bind(this);
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.add_commend)
    public void onButClick(View view) {
        try {
            Intent intent = new Intent(DetailedActivity.this, AddCommendActivity.class);
            intent.putExtra("stUniqueID", stUniqueIDGet);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.open_map)
    public void onButMapClick(View view) {
        try {
            String geoUri = String.format("http://maps.google.com/maps?daddr=%s,%s", longitude, latitude);
            Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
            startActivity(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init() {
        refreshLayout = findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorScheme(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.red);
        imgAdd.setVisibility(View.VISIBLE);
        if (getIntent().getExtras().getString("stUniqueID") != null) {
            stUniqueIDGet = getIntent().getExtras().getString("stUniqueID");
        } else {
            stUniqueIDGet = null;
        }
        setDataUser();
        lnrComment.setOnClickListener(v -> {
            if (isShowCommentList) {
                Intent intent = new Intent(DetailedActivity.this, ShowListCommendActivity.class);
                intent.putExtra("stUniqueID", stUniqueIDGet);
                startActivity(intent);
                finish();
            } else {
                showToast();
            }
        });

        onRefresh();
    }

    public void showToast() {
        Toast.makeText(this, "No comment.", Toast.LENGTH_LONG).show();
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
            int comCount;
            comCount = listComments.getCountComment();
            stCountComment = String.valueOf(comCount);
            isShowCommentList = comCount >= 2;
            setDataCountComment(stCountComment);
        } else {
            //  Toast.makeText(this, "No comment.", Toast.LENGTH_LONG).show();
        }
    }

    public void setDataCountComment(String comCount) {
        if (comCount != null) {
            commentsCount.setText(comCount);
        }
    }

    public User getSt() {
        DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(getApplicationContext());
        return databaseHelper.getUser();

    }

    public void setDataUser() {
        User user = getSt();
        id = user.getId();
        if (id == null)
            id = defIdUser;
    }

    public void getAllCount() {
        GetPoint mGetPoint = Common.getPoint();
        mGetPoint.mValue(id)
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
        for (com.allerates.appforyou.request.Point point : pointList) {
            if (point.getAuthKey() != null && !point.getAuthKey().isEmpty()) {
                if (stUniqueIDGet.equals(point.getPlaceID())) {
                    itemPoints = point;
                    try {
                        setPoint(itemPoints);
                        String stTemp;
                        stTemp = itemPoints.getAuthKey();
                        getListComment(stTemp);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void clearVariables() {
        stPaymentMethods = null;
        stPayMeth = null;
    }

    public void checkIcons(String stCurrency) {
        if (stCurrency != null) {
            if (!stCurrency.equals("null")) {
                String[] parts = stCurrency.split(",");
                Log.d("fd", parts.toString());
                GridView gridview = findViewById(R.id.grid_view);
                gridview.setAdapter(new ImageAdapter(this, parts));
            }
        }
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state))
            return true;

        return false;
    }

    public void setPoint(com.allerates.appforyou.request.Point itemPoints) throws JSONException {
        if (isExternalStorageReadable()) {
            File dirPics = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File f = new File(dirPics, "map.txt");
        }
        if (itemPoints != null) {
            if (isCheckSt(itemPoints.getNewPointDl())) {
                latitude = itemPoints.getNewPointDl();
            }
            if (isCheckSt(itemPoints.getNewPointSh())) {
                longitude = itemPoints.getNewPointSh();
            }
            if (isCheckSt(itemPoints.getSiteCurency())) {
                stSite = itemPoints.getSiteCurency();
            }
            if (isCheckSt(itemPoints.getRating())) {
                stRating = itemPoints.getRating();
            }
            if (isCheckSt(itemPoints.getPhoneCurrencyPlace())) {
                stNumber = itemPoints.getPhoneCurrencyPlace();
            }
            if (isCheckSt(itemPoints.getPointAdress())) {
                stAddress = itemPoints.getPointAdress();
            } else {
                stAddress = "Address is not specified";
            }
            if (isCheckSt(itemPoints.getAbout())) {
                stAbout = itemPoints.getAbout();
            } else {
                stAbout = "Information not specified";
            }
//                    if (!object.isNull("stAdditionalInformation")) {
//                        stAdditionalInformation = object.getString("stAdditionalInformation");
//                    }
            if (isCheckSt(itemPoints.getMinimalAmount())) {
                stMinSum = itemPoints.getMinimalAmount();
            } else {
                stMinSum = "The minimum amount is not specified";
            }
            if (isCheckSt(itemPoints.getDayWork()) && isCheckSt(itemPoints.getDayWorkEnd())) {
                stDaysOfTheWeek = itemPoints.getDayWork() + " - " + itemPoints.getDayWorkEnd();
            }
            if (isCheckSt(itemPoints.getCard())) {
                stPayMeth = setStPaymentMethods(itemPoints.getCard(), "card", stPayMeth);
            }
            if (isCheckSt(itemPoints.getMailCash())) {
                stPayMeth = setStPaymentMethods(itemPoints.getMailCash(), "mail cash", stPayMeth);
            }
            if (isCheckSt(itemPoints.getCash())) {
                stPayMeth = setStPaymentMethods(itemPoints.getCash(), "cash", stPayMeth);
            }
            if (isCheckSt(itemPoints.getTimeWork()) && isCheckSt(itemPoints.getTimeWorkEnd())) {
                stTime = itemPoints.getTimeWork() + " - " + itemPoints.getTimeWorkEnd();
            } else {
                stTime = "The time is not specified";
            }
            if (isCheckSt(itemPoints.getCard())) {
                // stTime = itemPoints.getCard();
            }// временно getCard потому что нет поля для способов оплаты

            if (isCheckSt(itemPoints.getBTC())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getBTC(), getResources().getString(R.string.btc_string), stPaymentMethods);
            }
            if (isCheckSt(itemPoints.getAUR())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getAUR(), getResources().getString(R.string.aur_string), stPaymentMethods);
            }
            if (isCheckSt(itemPoints.getDASH())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getDASH(), getResources().getString(R.string.dash_string), stPaymentMethods);
            }
            if (isCheckSt(itemPoints.getETC())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getETC(), getResources().getString(R.string.etc_string), stPaymentMethods);
            }
            if (isCheckSt(itemPoints.getETH())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getETH(), getResources().getString(R.string.eth_string), stPaymentMethods);
            }
            if (isCheckSt(itemPoints.getXEM())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getXEM(), getResources().getString(R.string.xem_string), stPaymentMethods);
            }
            if (isCheckSt(itemPoints.getLTC())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getLTC(), getResources().getString(R.string.ltc_string), stPaymentMethods);
            }
            if (isCheckSt(itemPoints.getXRP())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getXRP(), getResources().getString(R.string.xrp_string), stPaymentMethods);
            }
            if (isCheckSt(itemPoints.getXMR())) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getXMR(), getResources().getString(R.string.xmr_string), stPaymentMethods);
            }
            String sTemp = itemPoints.getMAID();
            if (isCheckSt(sTemp)) {
                stPaymentMethods = setStPaymentMethods(itemPoints.getMAID(), getResources().getString(R.string.maid_string), stPaymentMethods);
            } else {

            }

            setData(stPaymentMethods);
//                    items.add(new Point(stSite, stNumber, stAddress, stAbout, stAdditionalInformation, stMinSum, stDaysOfTheWeek, stPayMeth, stPaymentMethods, latitude, longitude, stUniqueID));
//                    break;
        }
    }

    /**
     * Tracked depression back
     */
    @Override
    public void onBackPressed() {
        try {
            super.onBackPressed();
            Intent intent = new Intent(DetailedActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//onBackPressed

    public boolean isCheckSt(String str) {
        return str != null && !str.isEmpty();
    }

    public boolean isCheckStBool(String str) {
        boolean isEq = false;
        if (str.equals("1")) {
            isEq = true;
        } else {
            isEq = false;
        }
        return isEq;
    }

    public String setStPaymentMethods(String valueCur, String cur, String stPayment) {
        String temp = null;
        if (isCheckStBool(valueCur)) {
            if (!isCheckSt(stPayment)) {
                temp = cur;
            } else {
                temp = stPayment += getResources().getString(R.string.txt_comma) + cur;
            }
        } else {
            temp = stPayment;
        }
        return temp;
    }

    public void setData(String stPayMethod) {
        try {
            tvSite.setText(stSite);
            tvWorkTime.setText(stTime);
            tvNumber.setText(stNumber);
            tvDaysOfWork.setText(stDaysOfTheWeek);
            minOrder.setText(stMinSum);
            float flTemp = Float.parseFloat(stRating);
            if (flTemp < 1) {
                ratingBar.setRating(1);
            }
            tvAddress.setText(stAddress);
            tvPayMeth.setText(stPayMeth);
            tvAbout.setText(stAbout);
            checkIcons(stPayMethod);
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

    /**
     * updates UI to reflect model
     */
    @Override
    public void onRefresh() {
        try {
            if (!refreshLayout.isRefreshing()) {
                refreshLayout.setRefreshing(true);
            }
            refreshLayout.postDelayed(() -> {
                clearVariables();
                getAllCount();
            }, 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
