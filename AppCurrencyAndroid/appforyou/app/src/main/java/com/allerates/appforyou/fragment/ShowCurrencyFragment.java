package com.allerates.appforyou.fragment;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.activities.DialogActivity;
import com.allerates.appforyou.adapters.CurrencyAdapterForCalcValue;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.model.ArticleForValue;
import com.allerates.appforyou.model.Coin;
import com.allerates.appforyou.request.api.CoinHistoryDay;
import com.allerates.appforyou.request.api.CoinService;
import com.allerates.appforyou.sql.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class ShowCurrencyFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    private static final int LAYOUT = R.layout.activity_main2;
    private List<ArticleForValue> articleList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CurrencyAdapterForCalcValue mAdapter;
    private CoinService mService;
    private Context context;
    private ImageView currencyImg;
    private CoinHistoryDay mService2;
    private CoinService mServiceCoin;
    private DatabaseHelper databaseHelper;
    private SwipeRefreshLayout refreshLayout;
    private SharedPreferences userLocalDatabase;
    private View view;
    private static Context cont;
    @BindString(R.string.txt_number_check) String txtNumberCheck;
    @BindString(R.string.txt_down_arrow) String downArrow;
    @BindView(R.id.btn_currency) Button btnCurrency;
    @BindString(R.string.txt_you_selected) String txtYouSelected;
    @BindString(R.string.txt_crypto_currency_names) String cryptoCurrencyNames;
    private String[] coin = {"BTC", "ETH", "ETC", "XRP", "LTC", "XMR", "DASH", "MAID", "AUR", "XEM"};
    public  ArrayList<ArticleForValue> arrayList = new ArrayList<ArticleForValue>();
    private CheckConnection checkConnection;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
        view = inflater.inflate(LAYOUT, container, false);
        ButterKnife.bind(this, view);
        init();
        showData();

        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return view;
    }//onCreateView

    private void setCoin2MoneySource(String coinName) {
        try {
            userLocalDatabase = getActivity().getApplicationContext().getSharedPreferences(DatabaseHelper.getSpName(), 0);
            SharedPreferences.Editor spEditor = userLocalDatabase.edit();
            spEditor.putString("money", coinName);
            spEditor.commit();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void showData(){
        if (checkConnection.isOnline(view.getContext())) {
            showValue();
        }else {
            checkConnection.makeToastConnection(getActivity());
        }
    }
    private void init(){
        try {
        btnCurrency.setText(String.format("%s%s", coin[0], downArrow));
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorScheme(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.red);
        checkConnection = new CheckConnection();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mServiceCoin = Common.getCoinService();
        mAdapter = new CurrencyAdapterForCalcValue(articleList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        currencyImg = (ImageView) view.findViewById(R.id.currency_img);
        mService2 = Common.Histoday();
        context = getActivity().getApplicationContext();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.btn_currency)
    public void onB(View view) {
        startDialog();
    }
    public void startDialog() {
        final Intent intent = new Intent(getActivity(), DialogActivity.class);
        intent.putExtra("numberCheck", 3);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String currencyCode = data.getStringExtra(cryptoCurrencyNames);
            setSource(btnCurrency, currencyCode);
            setCoin2MoneySource(currencyCode);
            refreshData();
            Toast.makeText(getActivity(), txtYouSelected + currencyCode, Toast.LENGTH_LONG).show();
        }
    }

    private void setSource(Button btnConvert, String selString) {
        try {
            btnConvert.setText(selString + downArrow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setContext(Context context) {
        this.cont = context;
    }
    private void showValue() {
        try {
        final ProgressDialog mDialog = new ProgressDialog(getActivity());
        mDialog.setMessage(getString(R.string.wait_string));
        mDialog.setCancelable(false);
        mDialog.show();

        // final String coinName = toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString();
        String fromCoin;
        String limit = "10";
//        final String fsym = "BTC";
//        String tsym = "USD";

        userLocalDatabase = getActivity().getSharedPreferences(DatabaseHelper.getSpName(), 0);
        final String coinName = userLocalDatabase.getString(getString(R.string.money_string), null);
        btnCurrency.setText(String.format("%s%s", coinName, downArrow));
        for (int i = 0; i < coin.length; i++) {
            final String finalFromCoin1 = coin[i];
            String time;
            CoinService mService;
            mService = (CoinService) Common.getCoinService();
            mService.calculateValue(coinName, finalFromCoin1).enqueue(new Callback<Coin>() {
                @Override
                public void onResponse(Call<Coin> call, Response<Coin> response) {
                    // https://min-api.cryptocompare.com/data/histoday?fsym=BTC&tsym=USD&limit=10 example
                    mDialog.dismiss();

                    for (int i = 0; i < 1 ; i++) {
                        ArticleForValue article = new ArticleForValue();
                        if(finalFromCoin1.equals(context.getString(R.string.btc_string))) {
                            article.setCourseValue(response.body().getBTC());}
                        else if(finalFromCoin1.equals(context.getString(R.string.etc_string)))
                            article.setCourseValue(response.body().getETC());
                        else if(finalFromCoin1.equals(context.getString(R.string.xrp_string)))
                            article.setCourseValue(response.body().getXRP());
                        else if(finalFromCoin1.equals(context.getString(R.string.eth_string)))
                            article.setCourseValue(response.body().getETH());
                        else if(finalFromCoin1.equals(context.getString(R.string.aur_string)))
                            article.setCourseValue(response.body().getAUR());
                        else if(finalFromCoin1.equals(context.getString(R.string.dash_string)))
                            article.setCourseValue(response.body().getDASH());
                        else if(finalFromCoin1.equals(context.getString(R.string.maid_string)))
                            article.setCourseValue(response.body().getMAID());
                        else if(finalFromCoin1.equals(context.getString(R.string.ltc_string)))
                            article.setCourseValue(response.body().getLTC());
                        else if(finalFromCoin1.equals(context.getString(R.string.xmr_string)))
                            article.setCourseValue(response.body().getXMR());
                        else if(finalFromCoin1.equals(context.getString(R.string.xem_string)))
                            article.setCourseValue(response.body().getXEM());
                        else if(finalFromCoin1.equals(context.getString(R.string.usd_string) ))
                            article.setCourseValue(response.body().getUSD());
                        else if(finalFromCoin1.equals(context.getString(R.string.eur_string)))
                            article.setCourseValue(response.body().getEUR());
                        else if(finalFromCoin1.equals(context.getString(R.string.gbp_string)))
                            article.setCourseValue(response.body().getGBP());

                        article.setContext(context);
                        article.setFrom(finalFromCoin1);
                        article.setTo(coinName);
                        arrayList.add(i, article);
                    }
                    showData(arrayList);
                }

                @Override
                public void onFailure(Call<Coin> call, Throwable t) {
                    Log.e("ERROR", t.getMessage());
                    mDialog.dismiss();
                }
            });
        }

        String s = new SimpleDateFormat(getResources().getString(R.string.txt_format_data)).format(new Date(1529280000 * 1000L));
        String da = s + "@";

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void showData(ArrayList<ArticleForValue> arrayList) {
        try {
        articleList.clear();
        articleList.addAll(arrayList); // add collection
        mAdapter.notifyDataSetChanged();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


//    /**
//     *  Call a dialog to confirm exit
//     */
//    private void openQuitDialog() {
//        AlertDialog.Builder quitDialog = new AlertDialog.Builder(com.allerates.appforyou.activities.MainActivity2.this);
//        quitDialog.setTitle(getString(R.string.exit_string));
//        quitDialog.setPositiveButton(getString(R.string.yes_string), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });
//
//        quitDialog.setNegativeButton(getString(R.string.no_string), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        quitDialog.show();
//    }

    /**
     *   updates UI to reflect model
     */
    @Override
    public void onRefresh() {
        try {
        refreshLayout.setRefreshing(true);
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
                refreshData();

            }
        }, 1000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshData() {
        if (checkConnection.isOnline(getActivity())) {
            arrayList = new ArrayList<ArticleForValue>();
            showValue();
        }else {
            checkConnection.makeToastConnection(getActivity());
        }
    }

}
