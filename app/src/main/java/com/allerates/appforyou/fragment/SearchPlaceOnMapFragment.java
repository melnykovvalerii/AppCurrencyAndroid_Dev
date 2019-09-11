package com.allerates.appforyou.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.activities.CustomDialogClass;
import com.allerates.appforyou.activities.DetailedActivity;
import com.allerates.appforyou.activities.MainActivity;
import com.allerates.appforyou.adapters.PlaceAutocompleteAdapter;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.helpers.GPSTracker;
import com.allerates.appforyou.model.MyItem;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.Point;
import com.allerates.appforyou.request.PointNear;
import com.allerates.appforyou.request.UserDataList;
import com.allerates.appforyou.request.api.GetDataUser;
import com.allerates.appforyou.request.api.GetNearPoints;
import com.allerates.appforyou.request.api.GetPoint;
import com.allerates.appforyou.sql.DatabaseHelper;
import com.allerates.appforyou.utils.PermissionUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import org.json.JSONException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static com.allerates.appforyou.activities.MainActivity.currentItem;

/**
 * Created by Rikmen on 31.07.2018.
 */

public class SearchPlaceOnMapFragment  extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnInfoWindowClickListener,
        GoogleMap.OnMarkerDragListener,
        SeekBar.OnSeekBarChangeListener,
        OnMapReadyCallback,
        GoogleMap.OnInfoWindowLongClickListener,
        GoogleMap.OnInfoWindowCloseListener,
        GoogleMap.OnMapClickListener,
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnCameraChangeListener,
        ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener{

    //This is for restriciting search only to india, for other countries you can specify lat lng by changing the below values.
    private static final LatLngBounds BOUNDS_GREATER_INDIA = new LatLngBounds(
            new LatLng(8.062148, 68.212642), new LatLng(37.372499, 96.513423));
    private static final int LAYOUT = R.layout.activity_search_place_on_map;

    private ClusterManager<MyItem> mClusterManager;
    protected GoogleApiClient mGoogleApiClient;
    private PlaceAutocompleteAdapter mAdapter;
    private AutoCompleteTextView mAutocompleteView;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private String mLatitude,mLongitude;
    private double mLatitudeDoub,mLongitudeDoub;
    private GoogleMap mMap;
    static CountDownTimer timer = null;
    private GetPoint mGetPoint;
    private GetNearPoints mGetNearPoints;
    private SwipeRefreshLayout refreshLayout;
    private Menu menu;
    private Toast popupToast;
    private RelativeLayout relativeLayout;
    private CheckConnection checkConnection;
    //GPSTracker class
    private GPSTracker gps;
    private double myLatitude;
    private double myLongitude;
    private int doubleClick;
    private ImageView imBack;
    @BindString(R.string.txt_unique_id) String stUniqueID;
    @BindString(R.string.txt_error_colon) String txtErrorColon;
    @BindString(R.string.txt_def_id_user) String defIdUser;
    private Spinner mSpinner;
    private GetDataUser getDataUser;
    private View view;
    private String id;
    private boolean isIncreasedUser;
    private User user;
    private FloatingActionButton fabAdd;
    private ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback
            = new ResultCallback<PlaceBuffer>() {

        @Override
        public void onResult(PlaceBuffer places) {
            if (!places.getStatus().isSuccess()) {
                places.release();
                return;
            }
            // Get the Place object from the buffer.
            final Place place = places.get(0);
            hideKeyboard();
            mLatitude = String.valueOf(place.getLatLng().latitude);
            mLongitude = String.valueOf(place.getLatLng().longitude);
            LatLng newLatLngTemp = new LatLng(place.getLatLng().latitude, place.getLatLng().longitude);
            // LatLng centerLatLng=new LatLng(mMap.getCameraPosition().target.latitude,mMap.getCameraPosition().target.longitude);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newLatLngTemp, 15f));
        }
    };

    private AdapterView.OnItemClickListener mAutocompleteClickListener
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            final PlaceAutocompleteAdapter.PlaceAutocomplete item = mAdapter.getItem(position);
            final String placeId = String.valueOf(item.getPlaceId());

            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi
                    .getPlaceById(mGoogleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
        }
    };



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
        view = inflater.inflate(LAYOUT, container, false);
        init();
        return view;
     } catch (Exception e) {
             return null;
     }
    }//onCreate

//    @Override
//    protected void onNewIntent(Intent intent) {
//        setIntent(intent);
//        handleIntent(intent);
//    }


    private void init() {

        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        fabAdd = (FloatingActionButton) view.findViewById(R.id.fab_add);
        mSpinner = (Spinner) view.findViewById(R.id.spinner);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_fragm);
        fabAdd.setOnClickListener(this);
        checkConnection = new CheckConnection();
        imBack = (ImageView) view.findViewById(R.id.img_back);
        imBack.setOnClickListener(this);
        imBack.setVisibility(View.INVISIBLE);
        mAutocompleteView = (AutoCompleteTextView) view.findViewById(R.id.googleplacesearch);
        Activity activity = getActivity();
        Context context = getContext();
        refreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setColorScheme(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.red);
        refreshLayout.setProgressViewOffset(true, 0 , 300);
        refreshLayout.setRefreshing(false);
        refreshLayout.setEnabled(false);

        getDataUser = Common.getUserDate();

        if(mGoogleApiClient == null || !mGoogleApiClient.isConnected()){
            try {
                if(activity != null && context != null){
                    mGoogleApiClient = new GoogleApiClient.Builder(context)
                            .enableAutoManage((FragmentActivity) activity, 0 /* clientId */, this)
                            .addApi(Places.GEO_DATA_API)
                            .build();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        setDataUser();
        mAdapter = new PlaceAutocompleteAdapter(getContext(), R.layout.google_places_search_items,
                mGoogleApiClient, null, null);

        //TODO:In order to Restrict search to India uncomment this and comment the above line
        /*
        mAdapter = new PlaceAutocompleteAdapter(this, R.layout.google_places_search_items,
                mGoogleApiClient, BOUNDS_GREATER_INDIA, null);
         */
        mAutocompleteView.setAdapter(mAdapter);
        mAutocompleteView.setOnItemClickListener(mAutocompleteClickListener);
        mAutocompleteView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (mAutocompleteView.getRight() - mAutocompleteView.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                    if(!(mAutocompleteView.getText().toString().length() < 1)){
                        mAutocompleteView.setText("");
                    }
                        return true;
                    }
                }
                // press back button
//                if (event.getRawX() <= (mAutocompleteView.getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width())) {
//
//                    Intent i = new Intent(getActivity(), MainActivity.class);
//                    startActivity(i);
//
//                    getActivity().finish();
//                    return true;
//                }
                return false;
            }
        });
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) parent.getChildAt(0)).setGravity(Gravity.END);
                if(position == 0){
                    getAllCount();
                }else {
                    getPointsNear();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }// init
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

        }
    }


    @Override
    public void onCameraChange(CameraPosition cameraPosition) {

    }

    @Override
    public void onInfoWindowClick(Marker marker) {

    }

    @Override
    public void onInfoWindowClose(Marker marker) {

    }

    @Override
    public void onInfoWindowLongClick(Marker marker) {

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        try {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);
        mMap.setOnMapClickListener(this);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnCameraChangeListener(this);
        enableMyLocation();
       // try {
            //readItems();

        if(refreshData()){
            getAllCount();
        }

//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        // click event of the marker text
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
//                sedDataFromFragActivity(DetailedActivity.class, );
               // marker.setSnippet("");
                
                return false;
            }
        });

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                // TODO Auto-generated trimLastCharacter stub
                // open DetailedActivity
                if(refreshData()){
                    String stUniqueID = marker.getSnippet();
                    sedDataFromFragActivity(getActivity() ,stUniqueID);
                }
            }
        });
        } catch (Exception e) {
        }
    }

    private void enableMyLocation() {
        try {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission((MainActivity) getActivity(),LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
        } catch (Exception e) {
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {

    }

    @Override
    public boolean onMyLocationButtonClick() {
        return false;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View v) {
        try {
        switch (v.getId()){
            case R.id.fab_add:
                mLatitude = String.format("%s", mMap.getCameraPosition().target.latitude);
                mLongitude = String.format("%s", mMap.getCameraPosition().target.longitude);

                mLatitudeDoub = mMap.getCameraPosition().target.latitude;
                mLongitudeDoub = mMap.getCameraPosition().target.longitude;
                doubleClick++;

                mClusterManager = new ClusterManager<MyItem>(getActivity(), mMap);
                mMap.setOnCameraIdleListener(mClusterManager);
                if(isIncreasedUser) {
                    if (doubleClick == 2) {
                        sedDataFromFrag(mLatitudeDoub, mLongitudeDoub);
                        doubleClick = 0;
                    } else {
                        showToast(v);
                        imBack.setVisibility(View.VISIBLE);
                    }
                }else {
                    startDialog();
                }
                break;
        }
        } catch (Exception e) {
        }
    }
    public void startDialog() {
        CustomDialogClass cdd = new CustomDialogClass(getActivity());
        cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cdd.show();
    }

    private void showToast(View v) {
        try {
        View layouttoast = LayoutInflater.from(v.getContext())
                .inflate(R.layout.custom_toast,(ViewGroup)v.findViewById(R.id.toast_layout_root));
        TextView popupText;
        popupText = (TextView) layouttoast.findViewById(R.id.textToast);
        popupToast = new Toast(getContext());
        popupToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        popupToast.setDuration(Toast.LENGTH_LONG);
        popupToast.setView(layouttoast);
        popupToast.show();

        timer = new CountDownTimer(4000, 1000){
            public void onTick(long millisUntilFinished)
            {
                popupToast.show();
            }
            public void onFinish()
            {
                popupToast.cancel();
            }

        }.start();
        } catch (Exception e) {
        }
    }// showToast
    private boolean refreshData() {
        if (checkConnection.isOnline(getActivity())) {
            return true;
        }else {
            checkConnection.makeToastConnection(getActivity());
            return false;
        }
    }

    // add some marker in the map
    private void addCluster() {
        mClusterManager = new ClusterManager<MyItem>(getContext(), mMap);
        mMap.setOnCameraIdleListener(mClusterManager);
        LatLng sydney = new LatLng(51.5061590, -0.1300150);
        mMap.addMarker(new MarkerOptions().position(sydney).title("My marker"));
    }

//    public void openActivityWithCoordinates(Context context, String latitude, String longitude ) {
//        Intent accountsIntent = new Intent(context, AddLabelActivity.class);
//        accountsIntent.putExtra("latitude", latitude);
//        accountsIntent.putExtra("longitude", longitude);
//        context.startActivity(accountsIntent);
//    }

    private void getPos() {
        try {
        // Create class object
        gps = new GPSTracker(getActivity());

        // Check if GPS enabled
        if(gps.canGetLocation()) {

            myLatitude = gps.getLatitude();
            myLongitude = gps.getLongitude();
            // \n is for new line
            // Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + myLatitude + "\nLong: " + myLongitude, Toast.LENGTH_LONG).show();
        } else {

            myLatitude = gps.getLatitude();
            myLongitude = gps.getLongitude();
            // Can't get location.
            // GPS or network is not enabled.
            // Ask user to enable GPS/network in settings.
            gps.showSettingsAlert();
        }
        } catch (Exception e) {
        }
    }//getPos()


    private void readItems(List<Point> pointList) throws JSONException {
        try {
        // def move
        getPos();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(myLatitude, myLongitude), 10));

        mClusterManager = new ClusterManager<MyItem>(getContext(), mMap);
        mMap.setOnCameraIdleListener(mClusterManager);

        InputStream inputStream = getResources().openRawResource(R.raw.radar_search);

        List<MyItem> items = new ArrayList<MyItem>();
            for (Point point: pointList) {
                String placeIDSt, stSiteCurrency;
                double width, length;
                if (point.getNewPointSh() != null && !point.getNewPointSh().isEmpty()) {
                    width = Double.parseDouble(point.getNewPointSh());
                } else continue;
                if (point.getNewPointDl() != null && !point.getNewPointDl().isEmpty()) {
                    length = Double.parseDouble(point.getNewPointDl());
                } else continue;
                if (point.getSiteCurency() != null && !point.getSiteCurency().isEmpty()) {
                    stSiteCurrency = point.getSiteCurency();
                } else continue;
                if (point.getPlaceID() != null && !point.getPlaceID().isEmpty()) {
                    placeIDSt = point.getPlaceID();
                } else continue;
                items.add( new MyItem(width, length, stSiteCurrency, placeIDSt, placeIDSt) );
            }

//        AddLabelActivity addLabelActivity = new AddLabelActivity();
//        String json = "";

        // We have to request the permission
//        if (addLabelActivity.isExternalStorageReadable()) {
//            File dirPics = getActivity().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
//            File f = new File(dirPics, "map.txt");
//            try {
//                json = IOHelper.stringFromFile(f);
//                // Toast.makeText(this, "str = " + str, Toast.LENGTH_SHORT).show();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        json = "[{" +
//                "latitude=40.5, longitude=-3.666667, stSite='Hi. Jh', stNumber='Hi. Jh', stAddress='Hi. Jh', stAbout='Hi. Jh', stAdditionalInformation='Hi. Jh', stMinSum='Hi. Jh', stDaysOfTheWeek='Понедельник', stSpinnerCurrency='Картой', stPaymentMethods='BTC'\n" +
//                "}]";
        //JSONObject ddd = new JSONObject(json);

           // *********************************************************************
//        JSONArray array = new JSONArray(json);
//        int count = array.length();
//        for (int i = 0; i < array.length(); i++) {
//            String title = null;
//            String snippet = null;
//            String stUniqueID = "stUniqueID";
//            JSONObject object = array.getJSONObject(i);
//            double lat = object.getDouble("latitude");
//            double lng = object.getDouble("longitude");
//            if (!object.isNull("stSite")) {
//                title = object.getString("stSite");
//            }
//            if (!object.isNull("stNumber")) {
//                snippet = object.getString("stNumber");
//            }
//            if (!object.isNull(stUniqueID)) {
//                stUniqueID = object.getString(stUniqueID);
//            }
//            // items.add(new MyItem(lat, lng, title, snippet, stUniqueID));
//            items.add(new MyItem(lat, lng, title, stUniqueID, stUniqueID));
//        }
    if(!items.isEmpty()) {
        mMap.clear();
        mClusterManager.clearItems();
        mClusterManager.addItems(items);
        }
        } catch (Exception e) {
                Log.e(getActivity().toString(), "error");
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
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
                    if(refreshData()){
                        getAllCount();
                    }
                }
            }, 1000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void getAllCount(){
        relativeLayout.setVisibility(View.INVISIBLE);
        refreshLayout.setRefreshing(true);
        mGetPoint = Common.getPoint();
        mGetPoint.mValue(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer <List<Point>>() {
                    @Override
                    public void accept(List<Point> points) throws Exception {
                        readItems(points);
                        refreshLayout.setRefreshing(false);
                        relativeLayout.setVisibility(View.VISIBLE);
                    }},
                    throwable -> {
                        Log.e("TAG", txtErrorColon + throwable);{
                            refreshLayout.setRefreshing(false);
                        }
                    });
    }
    public void getPointsNear(){
        relativeLayout.setVisibility(View.INVISIBLE);
        refreshLayout.setRefreshing(true);
        mGetNearPoints = Common.getNearPoints();
        mGetNearPoints.sendKey("EUR")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer <PointNear>() {
                               @Override
                               public void accept(PointNear pointNear) throws Exception {
                                   readItems(pointNear.getNearPoint());
                                   refreshLayout.setRefreshing(false);
                                   relativeLayout.setVisibility(View.VISIBLE);
                               }},
                        throwable -> {
                            Log.e("TAG", txtErrorColon + throwable);{
                                refreshLayout.setRefreshing(false);
                            }
                        });
    }

    public void sedDataFromFrag(@Nullable double mLatitude, @Nullable double mLongitude){
        try {
        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        menu = navigationView.getMenu();

        Bundle bundle = new Bundle();
        bundle.putDouble("mLatitude",   mLatitude);
        bundle.putDouble("mLongitude", mLongitude);

        AddFragment fragment = new AddFragment();
        fragment.setArguments(bundle);

        if (fragment != null) {
            //showFloatingButton();
            android.support.v4.app.FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.app_bar_main2, fragment);
            ft.commit();
        }
        MenuItem item = menu.findItem(R.id.nav_gallery);
        int id =  2131296509;
        // Выделяем выбранный пункт меню в шторке
        item.setChecked(true);
        // Выводим выбранный пункт в заголовке
        // setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        currentItem = id;
        // changeFragment(fragment, item); поправить
        } catch (Exception e) {
        }
    }

    public void sedDataFromFragActivity(Activity activity, @Nullable String stUniqueID){
        try {
        Intent intent = new Intent(activity, DetailedActivity.class);
        intent.putExtra("stUniqueID", stUniqueID);
        startActivity(intent);
        activity.finish();
        } catch (Exception e) {
        }
    }

    public void setDataUser() {
        user = new User();
        user = getSt();
        id = user.getId();
        if(id == null){
            id = defIdUser;
        }
        if(isInternet()){
            getDataOfUser(id);
        }
    }
    public User getSt() {
        DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(getActivity());
        return databaseHelper.getUser();

    }
    private boolean isInternet() {
        if (checkConnection.isOnline(getActivity())) {
            return true;
        }else {
            checkConnection.makeToastConnection(getActivity());
            return false;
        }
    }

    private void getDataOfUser(String auth) {
        final ProgressDialog mDialog = new ProgressDialog(getActivity());
        mDialog.setMessage(getResources().getString(R.string.txt_plz_wait));
        mDialog.setCancelable(false);
        mDialog.show();

        getDataUser.sendKey(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserDataList>() {
                               @Override
                               public void accept(com.allerates.appforyou.request.UserDataList userDataList) throws Exception {
                                   if(userDataList.getQueryContent().get(0).getActivateUser() != null){
                                       isActivate(userDataList.getQueryContent().get(0).getActivateUser());
                                   }
                                   mDialog.dismiss();
                               }
                           },
                        throwable -> {
                          //  Toast.makeText(getActivity(), "Error " + throwable, Toast.LENGTH_LONG).show();
                            Log.e("TAG", txtErrorColon + throwable);
                            mDialog.dismiss();
                        });
    }

//    public void hideFloatingButton() {
//        btnCurrency.setVisibility(View.INVISIBLE);
//    }
//    public void showFloatingButton() {
//        btnCurrency.setVisibility(View.INVISIBLE);
//    }

    private void isActivate(String activateUser) {
        if(activateUser.equals("1")){
            isIncreasedUser = true;
        }
    }

    public void hideKeyboard() {
        try {
        // Check if no view has focus:
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        } catch (Exception e) {
        }
    }
}