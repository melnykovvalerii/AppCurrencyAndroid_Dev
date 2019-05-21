package com.allerates.appforyou.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;

import com.allerates.appforyou.R;
import com.allerates.appforyou.adapters.ImageAdapter;
import com.allerates.appforyou.adapters.MoviesAdapter;
import com.allerates.appforyou.helpers.IOHelper;
import com.allerates.appforyou.model.City;
import com.allerates.appforyou.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DetailedActivity extends AppCompatActivity {

    private static final String REGEX_INPUT_BOUNDARY_BEGINNING = "\\A";
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private String stUniqueIDGet;
    private String latitude = null;
    private String longitude = null;
    private String stSite = null;
    private String stNumber = null;
    private  String stAddress = null;
    private  String stCurrency = null;
    private  String stAbout = null;
    //private  String stAdditionalInformation = null;
    private  String stMinSum = null;
    private  String stDaysOfTheWeek = null;
    private  String stSpinnerCurrency = null;
    private  String stPaymentMethods = null;
    private  String stUniqueID = null;
    private  String stTime = null;
    private Unbinder unbinder;
    @BindView(R.id.tv_site) TextView tvSite;
    @BindView(R.id.tv_number) TextView tvNumber;
    @BindView(R.id.tv_days_of_work) TextView tvDaysOfWork;
    @BindView(R.id.tv_address) TextView tvAddress;
    @BindView(R.id.tv_work_time) TextView tvWorkTime;
    @BindView(R.id.tv_currency) TextView tvSpinnerCurrency;
    @BindView(R.id.tv_payment_methods2) TextView tvAbout;


    List<City> items = new ArrayList<City>();
    private TextView mSelectText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        unbinder = ButterKnife.bind(this);

        mAdapter = new MoviesAdapter(movieList);
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.setAdapter(mAdapter);

        mSelectText = (TextView) findViewById(R.id.info);


        init();
        try {

            getCity();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void init(){
        if(getIntent().getExtras().getString("stUniqueID") != null){
            stUniqueIDGet = getIntent().getExtras().getString("stUniqueID");
        }else {
            stUniqueIDGet = null;
        }
    }

    public void checkIcons(String stCurrency) {
        if(stCurrency != null) {
            if(!stCurrency.equals("null")) {
                String[] parts = stCurrency.split(",");
                Log.d("fd", parts.toString());
                GridView gridview = (GridView) findViewById(R.id.grid_view);
                gridview.setAdapter(new ImageAdapter(this, parts));
            }
        }
    }

    public void getCity() throws JSONException {
        try {
        AddLabelActivity addLabelActivity = new AddLabelActivity();
        String json = "";
        //We have to request the permission
        if (addLabelActivity.isExternalStorageReadable()) {
            File dirPics = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            File f = new File(dirPics, "map.txt");
            try {
                json = IOHelper.stringFromFile(f);
                // Toast.makeText(this, "str = " + str, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            if (!object.isNull("stUniqueID")) {
                stUniqueID = object.getString("stUniqueID");
                if(stUniqueIDGet.equals(stUniqueID)){
                    if (!object.isNull("latitude")) {
                        latitude = object.getString("latitude");
                    }
                    if (!object.isNull("longitude")) {
                        longitude = object.getString("longitude");
                    }
                    if (!object.isNull("stSite")) {
                        stSite = object.getString("stSite");
                    }
                    if (!object.isNull("stNumber")) {
                        stNumber = object.getString("stNumber");
                    }
                    if (!object.isNull("stAddress")) {
                        stAddress = object.getString("stAddress");
                    }
                    if (!object.isNull("stAbout")) {
                        stAbout = object.getString("stAbout");
                    }
//                    if (!object.isNull("stAdditionalInformation")) {
//                        stAdditionalInformation = object.getString("stAdditionalInformation");
//                    }
                    if (!object.isNull("stMinSum")) {
                        stMinSum = object.getString("stMinSum");
                    }
                    if (!object.isNull("stDaysOfTheWeek")) {
                        if(!object.isNull("stDaysOfTheWeek2")){
                        stDaysOfTheWeek = object.getString("stDaysOfTheWeek") + " - " + object.getString("stDaysOfTheWeek2");
                        }
                    }

                    if (!object.isNull("stSpinnerCurrency")) {
                        stSpinnerCurrency = object.getString("stSpinnerCurrency");
                    }
                    if (!object.isNull("stTime")) {
                        stTime = object.getString("stTime");
                    }
                    if (!object.isNull("stPaymentMethods")) {
                        stPaymentMethods = object.getString("stPaymentMethods");
                    }
                    if (!object.isNull("stCurrency")) {
                        stCurrency = object.getString("stCurrency");
                    }
                    checkIcons(stPaymentMethods);
//                    items.add(new City(stSite, stNumber, stAddress, stAbout, stAdditionalInformation, stMinSum, stDaysOfTheWeek, stSpinnerCurrency, stPaymentMethods, latitude, longitude, stUniqueID));
//                    break;
                    setData();
                }
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
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
        } catch(Exception e) {
            e.printStackTrace();
        }
    }//onBackPressed
    public void setData(){
        try {
        tvSite.setText(stSite);
        tvWorkTime.setText(stTime);
        tvNumber.setText(stNumber);
        tvDaysOfWork.setText(stDaysOfTheWeek);
//        minOrder.setText(stMinSum);
        tvAddress.setText(stAddress);
        tvSpinnerCurrency.setText(stSpinnerCurrency);
        tvAbout.setText(stAbout);
            checkIcons(stPaymentMethods);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        try {
        super.onDestroy();
        unbinder.unbind();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
