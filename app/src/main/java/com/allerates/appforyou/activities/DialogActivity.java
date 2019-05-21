package com.allerates.appforyou.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.allerates.appforyou.R;
import com.allerates.appforyou.adapters.CurrencyListArrayAdapter;
import com.allerates.appforyou.adapters.DataListArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.ButterKnife;

/**
 * Created by rikmen00@gmail.com on 13.09.2018.
 */

public class DialogActivity extends ListActivity {

    public static String RESULT_CURRENCY_CODE = "crypto_currency_names";
    public static String PAYMENT_METHOD_NUMBER = "payment method number";
    private TypedArray imgs;
    private List<Currency> currencyList;
    private List<Data> payMetList;
    private int numberCheck = 12;
    @BindString(R.string.txt_got_error) String txtGotError;
    @BindString(R.string.txt_number_check) String txtNumberCheck;
    @BindString(R.string.txt_is_first_button) String txtIsFirstButton;
    @BindString(R.string.txt_invalid_value) String txtInvalidValue;
    @BindString(R.string.txt_error) String txtError;
    private boolean isFirstButton;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                try {
                    ButterKnife.bind(this);
                    checkArrayString();
                    getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent returnIntent = new Intent();
                switch (numberCheck) {
                    case 3:
                        Currency c = currencyList.get(position);
                        returnIntent.putExtra(RESULT_CURRENCY_CODE, c.getName());
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        Data dCu1r = payMetList.get(position);
                        returnIntent.putExtra(RESULT_CURRENCY_CODE, dCu1r.getName());
                        returnIntent.putExtra(PAYMENT_METHOD_NUMBER, position);
                        break;
                    default:
                        Currency d = currencyList.get(position);
                        returnIntent.putExtra(RESULT_CURRENCY_CODE, d.getName());
                        break;
                }
                setResult(RESULT_OK, returnIntent);
                if(imgs != null)imgs.recycle(); //recycle images
                finish();
            }
        });
        } catch (Throwable t) {
            Log.e(txtError, t.getMessage());
        }
    }

    private void checkArrayString() {
        try{
            numberCheck = getIntent().getExtras().getInt(txtNumberCheck);
            if(numberCheck != 3){
                isFirstButton = getIntent().getExtras().getBoolean(txtIsFirstButton);
            }
        } catch(Exception ex){
            Log.e(txtGotError, txtInvalidValue);
            numberCheck = 0;
            isFirstButton = false;
        }
        switch (numberCheck) {
            case 1:
                populateCountryList(getStArray(numberCheck), R.array.ic_currency_normal);
                ArrayAdapter<Currency> adapterCur = new CurrencyListArrayAdapter(this, currencyList);
                setListAdapter(adapterCur);
                break;
            case 2:
                if(isFirstButton){
                    populateCountryList(getStArray(numberCheck), R.array.ic_currency);
                    ArrayAdapter<Currency> adapterCur2 = new CurrencyListArrayAdapter(this, currencyList);
                    setListAdapter(adapterCur2);
                }else {
                    populateCountryList(getStArray(numberCheck), R.array.ic_currency_normal);
                    ArrayAdapter<Currency> adapterCur2 = new CurrencyListArrayAdapter(this, currencyList);
                    setListAdapter(adapterCur2);
                }
                break;
            case 3:
                populateCountryList(getStArray(numberCheck), R.array.ic_currency_normal);
                ArrayAdapter<Currency> adapterCur1 = new CurrencyListArrayAdapter(this, currencyList);
                setListAdapter(adapterCur1);
                break;
            case 4:
                popPayMethList(getStArray(numberCheck));
                ArrayAdapter<Data> adapter21 = new DataListArrayAdapter(this, payMetList);
                setListAdapter(adapter21);
                break;
            case 5:
                popPayMethList(getStArray(numberCheck));
                ArrayAdapter<Data> adapter2d = new DataListArrayAdapter(this, payMetList);
                setListAdapter(adapter2d);
                break;
            case 6:
                popPayMethList(getStArray(numberCheck));
                ArrayAdapter<Data> adapter2w = new DataListArrayAdapter(this, payMetList);
                setListAdapter(adapter2w);
                break;
            case 7:
                popPayMethList(getStArray(numberCheck));
                ArrayAdapter<Data> adapter2e = new DataListArrayAdapter(this, payMetList);
                setListAdapter(adapter2e);
                break;
            default:
                popCountryList(getStArray(numberCheck), R.array.ic_currency);
                ArrayAdapter<Currency> adapter = new CurrencyListArrayAdapter(this, currencyList);
                setListAdapter(adapter);
                break;
        }
    }

    private String[] getStArray(int numb) {
        String[] stArr = new String[0];
        switch (numb) {
            case 0:
                if(isFirstButton){
                    stArr = getResources().getStringArray(R.array.crypto_currency_names);
                }else {
                    stArr = getResources().getStringArray(R.array.crypto_currency_names);
                }
                break;
            case 1:
                if(isFirstButton){
                    stArr = getResources().getStringArray(R.array.currency_names);
                }else {
                    stArr = getResources().getStringArray(R.array.currency_names);
                }
                break;
            case 2:
                if(isFirstButton){
                    stArr = getResources().getStringArray(R.array.crypto_currency_names);
                }else {
                    stArr = getResources().getStringArray(R.array.currency_names);
                }
                break;
            case 3:
                stArr = getResources().getStringArray(R.array.currency_names);

                break;
            case 4:
                stArr = getResources().getStringArray(R.array.days_of_the_week_names);
                break;

            case 5:
                stArr = getResources().getStringArray(R.array.daytime_names);
                break;

            case 6:
                stArr = getResources().getStringArray(R.array.night_time_names);
                break;
            case 7:
                stArr = getResources().getStringArray(R.array.payment_method_names);
                break;
        }
        return stArr;
    }

    private void popPayMethList(String[] array) {
        payMetList = new ArrayList<Data>();
        payMetList.clear();
        for(int i = 0; i < array.length; i++){
            payMetList.add(new Data(array[i]));
        }
    }

    private void populateCountryList(String[] array, int country_flags) {
        currencyList = new ArrayList<Currency>();
        currencyList.clear();
        imgs = getResources().obtainTypedArray(country_flags);
        for(int i = 0; i < array.length; i++){
            currencyList.add(new Currency(array[i], imgs.getDrawable(i)));
        }
    }

    private void popCountryList(String[] array, int country_flags) {
        try {
        currencyList = new ArrayList<Currency>();
        currencyList.clear();
        imgs = getResources().obtainTypedArray(country_flags);
        for(int i = 0; i < array.length; i++){
            currencyList.add(new Currency(array[i], imgs.getDrawable(i)));
        }
        } catch(Exception ex){
        }
    }

    public class Currency {
        private String name;
        private Drawable flag;

        public Currency(String name, Drawable flag){
            this.name = name;
            this.flag = flag;
        }
        public String getName() {
            return name;
        }
        public Drawable getFlag() {
            return flag;
        }
    }

    public class Data {
        private String name;

    public Data(String name){
            this.name = name;
        }

    public String getName() {
            return name;
        }

     }

}