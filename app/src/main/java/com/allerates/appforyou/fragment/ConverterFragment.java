package com.allerates.appforyou.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.activities.DialogActivity;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.request.api.CoinHistoryDay;
import com.allerates.appforyou.request.api.CoinService;
import com.squareup.picasso.Picasso;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Rikmen00@gmail.com
 */

public class ConverterFragment extends Fragment {
    private static final int LAYOUT = R.layout.fragment_converter;
    private CoinService mService;
    //private MaterialSpinner fromSpinner, toSpinner;
    @BindString(R.string.txt_down_arrow) String downArrow;
    @BindString(R.string.txt_error) String txtError;
    @BindString(R.string.btc_string) String btcString;
    @BindString(R.string.etc_string) String etcString;
    @BindString(R.string.xrp_string) String xrpString;
    @BindString(R.string.aur_string) String aurString;
    @BindString(R.string.dash_string) String dashString;
    @BindString(R.string.maid_string) String maidString;
    @BindString(R.string.xmr_string) String xmrString;
    @BindString(R.string.xem_string) String xemString;
    @BindString(R.string.eth_string) String ethString;
    @BindString(R.string.ltc_string) String ltcString;
    @BindString(R.string.usd_string) String usdString;
    @BindString(R.string.gbp_string) String gbpString;
    @BindString(R.string.eur_string) String eurString;
    @BindString(R.string.usd_text_icon) String usdTextIcon;
    @BindString(R.string.gbp_text_icon) String gbpTextIcon;
    @BindString(R.string.eur_text_icon) String eurTextIcon;
    @BindString(R.string.txt_you_selected) String txtYouSelected;
    @BindString(R.string.txt_error_colon) String txtErrorColon;
    @BindView(R.id.toTextView) TextView toTextView;
    @BindView(R.id.btnConvert) Button btnConvert;
    @BindView(R.id.btn_first) Button btnFirst;
    @BindView(R.id.btn_second) Button btnSecond;
    @BindView(R.id.ed_value) EditText edValue;
    @BindView(R.id.coinImage) ImageView coinImage;
    @BindView(R.id.coin_to_coin) ImageView coinToCoin;
    @BindView(R.id.money_to_money) ImageView moneyToMoney;
    @BindView(R.id.coin_to_money) ImageView coinToMoney;
    @BindString(R.string.txt_number_check) String txtNumberCheck;
    @BindString(R.string.txt_is_first_button) String txtIsFirstButton;
    @BindString(R.string.txt_crypto_currency_names) String cryptoCurrencyNames;
    @BindString(R.string.def_string) String defString;

    private String[] money = {"USD", "EUR", "GBP"};
    private String[] coin = {"BTC", "ETH", "ETC", "XRP", "LTC", "XMR", "DASH", "MAID", "AUR", "XEM"};
    private CoinHistoryDay mService2;
    private View view;
    private int numberCheck = 0;
    private boolean isFirstButton = true;
    private CheckConnection checkConnection;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

            view = inflater.inflate(LAYOUT, container, false);
            ButterKnife.bind(this, view);
            coinToCoin.setSelected(true);
            mService = Common.getCoinService();
            mService2 = Common.Histoday();
            setDataCoinToCoin();
            toTextView = view.findViewById(R.id.toTextView);
            checkConnection = new CheckConnection();

            edValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                        checkCon();
                    }
                    return false;
                }
            });

            return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
                String currencyCode = data.getStringExtra(cryptoCurrencyNames);
            if(isFirstButton){
                setSource(btnFirst, currencyCode);
            }else {
                setSource(btnSecond, currencyCode);
            }
            Toast.makeText(getActivity(), txtYouSelected + currencyCode, Toast.LENGTH_LONG).show();
        }
    }

    @OnClick(R.id.btn_first)
    public void onButtonClick(View view) {
        isFirstButton = true;
        startDialog();
        cleanView();
    }

    @OnClick(R.id.btn_second)
    public void onButtonCl(View view) {
        isFirstButton = false;
        startDialog();
        cleanView();
    }
    @OnClick(R.id.ed_value)
    public void onEdCl(View view) {
        cleanView();
    }

    @OnClick(R.id.coin_to_coin)
    public void onB(View view) {
        setDataCoinToCoin();
        cleanView();
    }

    @OnClick(R.id.money_to_money)
    public void onBu(View view) {
        setMoneyToMoney();
        cleanView();
    }

    @OnClick(R.id.coin_to_money)
    public void onBut(View view) {
        setCoinToMoney();
        cleanView();
    }

    @OnClick(R.id.btnConvert)
    public void onBtnConvert(View view) {
        hideKeyboard(getActivity());
        checkCon();

    }

    public void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void startDialog() {
        final Intent intent = new Intent(getActivity(), DialogActivity.class);
        intent.putExtra(txtNumberCheck, numberCheck);
        intent.putExtra("isFirstButton", isFirstButton);
        startActivityForResult(intent, 1);
    }
    public void cleanView() {
        toTextView.setText(defString);
        coinImage.setImageDrawable(null);
    }
    public void setCoinToMoney() {
        btnFirst.setText(String.format("%s%s", coin[0], downArrow));
        btnSecond.setText(String.format("%s%s", money[0], downArrow));
        numberCheck = 2;
        coinToCoin.setImageResource(R.drawable.selector_coin_to_coin);
        moneyToMoney.setImageResource(R.drawable.selector_money_to_money);
        coinToMoney.setImageResource(R.drawable.coinmoney2);
    }

    public void setMoneyToMoney() {
        btnFirst.setText(String.format("%s%s", money[1], downArrow));
        btnSecond.setText(String.format("%s%s", money[0], downArrow));
        numberCheck = 1;
        coinToCoin.setImageResource(R.drawable.selector_coin_to_coin);
        moneyToMoney.setImageResource(R.drawable.money2);
        coinToMoney.setImageResource(R.drawable.selector_coin_to_money);
    }

    public void setDataCoinToCoin() {
        numberCheck = 0;
        btnFirst.setText(String.format("%s%s", coin[1], downArrow));
        btnSecond.setText(String.format("%s%s", coin[0], downArrow));
        coinToCoin.setImageResource(R.drawable.coin2);
        moneyToMoney.setImageResource(R.drawable.selector_money_to_money);
        coinToMoney.setImageResource(R.drawable.selector_coin_to_money);
    }

    private void setSource(Button btnConvert, String selString) {
        try {
        btnConvert.setText(selString + downArrow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkCon() {
        if (checkConnection.isOnline(getActivity())) {
            calculateValue(formatText(btnFirst.getText().toString()), formatText(btnSecond.getText().toString()));
        }else {
            checkConnection.makeToastConnection(getActivity());
        }
    }

    private void calculateValue(String fromCoin, final String coinName) {
        try {
            final ProgressDialog mDialog = new ProgressDialog(getActivity());
            mDialog.setMessage(getResources().getString(R.string.txt_plz_wait));
            mDialog.show();

//        final String coinName = toSpinner.getItems().get(toSpinner.getSelectedIndex()).toString();
//        String fromCoin = fromSpinner.getItems().get(fromSpinner.getSelectedIndex()).toString();

            mService.calculateValue(fromCoin, coinName)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<com.allerates.appforyou.request.Coin>() {
                                   @Override
                                   public void accept(com.allerates.appforyou.request.Coin coin) throws Exception {
                                       mDialog.dismiss();
                                       if (coinName != null) {
                                           switch (coinName) {
                                               case "XRP":
                                                   calcValue(coin.getXRP());
                                                   break;
                                               case "BTC":
                                                   calcValue(coin.getBTC());
                                                   break;
                                               case "ETC":
                                                   calcValue(coin.getETC());
                                                   break;
                                               case "ETH":
                                                   calcValue(coin.getETH());
                                                   break;
                                               case "AUR":
                                                   calcValue(coin.getAUR());
                                                   break;
                                               case "DASH":
                                                   calcValue(coin.getDASH());
                                                   break;
                                               case "MAID":
                                                   calcValue(coin.getMAID());
                                                   break;
                                               case "LTC":
                                                   calcValue(coin.getLTC());
                                                   break;
                                               case "XMR":
                                                   calcValue(coin.getXMR());
                                                   break;
                                               case "XEM":
                                                   calcValue(coin.getXEM());
                                                   break;
                                               case "USD":
                                                   calcValue(coin.getUSD());
                                                   break;
                                               case "EUR":
                                                   calcValue(coin.getEUR());
                                                   break;
                                               case "GBP":
                                                   calcValue(coin.getGBP());
                                                   break;
                                           }
                                       }
                                   }
                               },
                            throwable -> Log.e("TAG", txtErrorColon + throwable));
//
//            mService.calculateValue(fromCoin, coinName).enqueue(new Callback<Coin>() {
//                @Override
//                public void onResponse(Call<Coin> call, Response<Coin> response) {
//                    mDialog.dismiss();
//                    if (coinName != null) {
//                        switch (coinName) {
//                            case "XRP":
//                                calcValue(response.body().getXRP());
//                                break;
//                            case "BTC":
//                                calcValue(response.body().getBTC());
//                                break;
//                            case "ETC":
//                                calcValue(response.body().getETC());
//                                break;
//                            case "ETH":
//                                calcValue(response.body().getETH());
//                                break;
//                            case "AUR":
//                                calcValue(response.body().getAUR());
//                                break;
//                            case "DASH":
//                                calcValue(response.body().getDASH());
//                                break;
//                            case "MAID":
//                                calcValue(response.body().getMAID());
//                                break;
//                            case "LTC":
//                                calcValue(response.body().getLTC());
//                                break;
//                            case "XMR":
//                                calcValue(response.body().getXMR());
//                                break;
//                            case "XEM":
//                                calcValue(response.body().getXEM());
//                                break;
//                            case "USD":
//                                calcValue(response.body().getUSD());
//                                break;
//                            case "EUR":
//                                calcValue(response.body().getEUR());
//                                break;
//                            case "GBP":
//                                calcValue(response.body().getGBP());
//                                break;
//                        }
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<Coin> call, Throwable t) {
//                    Log.e(txtError, t.getMessage());
//                    mDialog.dismiss();
//                }
//            });
        } catch (Throwable t) {
            Log.e(txtError, t.getMessage());
        }
    }

    private String formatText(String btnText){
       return btnText.substring(0, btnText.length() - 1);
    }

    private void showData(String value){
        try {
        if(formatText(btnSecond.getText().toString()).equals(btcString)){
            Picasso.with(getActivity()).load(Common.BTC_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(etcString)){
            Picasso.with(getActivity()).load(Common.ETC_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(ltcString)){
            Picasso.with(getActivity()).load(Common.LTC_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(ethString)){
            Picasso.with(getActivity()).load(Common.ETH_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(xrpString)){
            Picasso.with(getActivity()).load(Common.XRP_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(aurString)){
            Picasso.with(getActivity()).load(Common.AUR_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(dashString)){
            Picasso.with(getActivity()).load(Common.DASH_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(maidString)){
            Picasso.with(getActivity()).load(Common.MAID_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(xmrString)){
            Picasso.with(getActivity()).load(Common.XMR_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(xemString)){
            Picasso.with(getActivity()).load(Common.XEM_IMAGE)
                    .into(coinImage);
            toTextView.setText(value);
        }else if(formatText(btnSecond.getText().toString()).equals(usdString)){
            toTextView.setText(String.format("%s%s", usdTextIcon, value));
        }else if(formatText(btnSecond.getText().toString()).equals(gbpString)){
            toTextView.setText(String.format("%s%s", gbpTextIcon, value));
        }else if(formatText(btnSecond.getText().toString()).equals(eurString)){
            toTextView.setText(String.format("%s%s", eurTextIcon, value));
        }
        } catch (Throwable t) {
            Log.e(txtError, t.getMessage());
        }
    }

    public void calcValue(String valueGet) {
        try {
            if (valueGet.length() > 9) {
                valueGet = valueGet.substring(0, 9);
            }
            float value;
            String retValue = null;

            if (edValue.getText() != null) {
                if (!edValue.getText().toString().equals(getString(R.string.def_string))) {
                    try {
                        value = Float.parseFloat(edValue.getText().toString());
                        retValue = Float.toString(Float.parseFloat(valueGet) * value);
                        if (retValue.length() > 9) {

                            retValue = (retValue).substring(0, 9);

                        }
                        showData(retValue);
                    } catch (NumberFormatException ex) {
                        retValue = getString(R.string.def_string);
                        Toast.makeText(getContext(), getString(R.string.some_data), Toast.LENGTH_SHORT).show();

                    }
                } else {
                    retValue = getString(R.string.def_string);
                    Toast.makeText(getContext(), getString(R.string.set_data), Toast.LENGTH_SHORT).show();

                }
            }

        } catch (Throwable t) {
            Log.e(txtError, t.getMessage());
        }
    }
}
