package com.allerates.appforyou.fragment

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.allerates.appforyou.Common
import com.allerates.appforyou.R
import com.allerates.appforyou.activities.CustomDialogClass
import com.allerates.appforyou.activities.DetailedActivity
import com.allerates.appforyou.activities.MainActivity
import com.allerates.appforyou.adapters.PlaceAutocompleteAdapter
import com.allerates.appforyou.helpers.GPSTracker
import com.allerates.appforyou.model.MyItem
import com.allerates.appforyou.model.User
import com.allerates.appforyou.request.Point
import com.allerates.appforyou.request.api.GetDataUser
import com.allerates.appforyou.request.api.GetNearPoints
import com.allerates.appforyou.request.api.GetPoint
import com.allerates.appforyou.sql.DatabaseHelper
import com.allerates.appforyou.utils.PermissionUtils
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.ResultCallback
import com.google.android.gms.location.places.PlaceBuffer
import com.google.android.gms.location.places.Places
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.clustering.ClusterManager
import org.json.JSONException
import java.util.ArrayList
import butterknife.BindString
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.allerates.appforyou.activities.MainActivity.currentItem
import com.allerates.appforyou.helpers.TAG
import com.allerates.appforyou.helpers.showToast


class SearchPlaceOnMapFragment:
        Fragment(),
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
        View.OnClickListener {

    private var mClusterManager: ClusterManager<MyItem>? = null
    private var mGoogleApiClient: GoogleApiClient? = null
    private var mAdapter: PlaceAutocompleteAdapter? = null
    private var mAutocompleteView: AutoCompleteTextView? = null
    lateinit var mLatitude: String
    lateinit var mLongitude: String
    private var mLatitudeDoub: Double = 0.toDouble()
    private var mLongitudeDoub: Double = 0.toDouble()
    private var mMap: GoogleMap? = null
    private var mGetPoint: GetPoint? = null
    private var mGetNearPoints: GetNearPoints? = null
    lateinit var refreshLayout: SwipeRefreshLayout
    private var menu: Menu? = null
    private var popupToast: Toast? = null
    private var relativeLayout: RelativeLayout? = null
    //GPSTracker class
    private var gps: GPSTracker? = null
    private var myLatitude = 0.toDouble()
    private var myLongitude = 0.toDouble()
    private var doubleClick = 0
    private var imBack: ImageView? = null
    @BindString(R.string.txt_unique_id) var stUniqueID: String? = null
    @BindString(R.string.txt_error_colon) var txtErrorColon: String? = null
    @BindString(R.string.txt_def_id_user) var defIdUser: String? = null
    lateinit var mSpinner: Spinner
    private var getDataUser: GetDataUser? = null
    lateinit var parent: View
    private var id: String? = null
    private var isIncreasedUser = false
    private var user: User? = null
    lateinit var fabAdd: FloatingActionButton

    private val mUpdatePlaceDetailsCallback = ResultCallback<PlaceBuffer> { places ->
        if (!places.status.isSuccess) {
            places.release()
            return@ResultCallback
        }
        // Get the Place object from the buffer.
        val place = places.get(0)
        hideKeyboard()
        mLatitude = place.latLng.latitude.toString()
        mLongitude = place.latLng.longitude.toString()
        val newLatLngTemp = LatLng(place.latLng.latitude, place.latLng.longitude)
        // LatLng centerLatLng=new LatLng(mMap.getCameraPosition().target.latitude,mMap.getCameraPosition().target.longitude);
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(newLatLngTemp, 15f))
    }

    private val mAutocompleteClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
        val item = mAdapter!!.getItem(position)
        val placeId = item.placeId.toString()

        val placeResult = Places.GeoDataApi
                .getPlaceById(mGoogleApiClient, placeId)
        placeResult.setResultCallback(mUpdatePlaceDetailsCallback)
    }

    private val st: User
        get() = DatabaseHelper(activity).user


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle): View? {
        return try {
            parent = inflater.inflate(R.layout.activity_search_place_on_map, container, false)
            init()
            view
        } catch (e: Exception) {
            null
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun init() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)
        fabAdd = view!!.findViewById(R.id.fab_add)
        mSpinner = view!!.findViewById(R.id.spinner)
        relativeLayout = view!!.findViewById(R.id.rl_fragm)
        fabAdd.setOnClickListener(this)
        imBack = view!!.findViewById(R.id.img_back)
        imBack!!.setOnClickListener(this)
        imBack!!.visibility = View.INVISIBLE
        mAutocompleteView = view!!.findViewById(R.id.googleplacesearch)
        val activity = activity
        val context = context
        refreshLayout = view!!.findViewById(R.id.refresh)
        refreshLayout.setOnRefreshListener(this)
        refreshLayout.setColorScheme(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.red)
        refreshLayout.setProgressViewOffset(true, 0, 300)
        refreshLayout.isRefreshing = false
        refreshLayout.isEnabled = false

        getDataUser = Common.getUserDate()

        if (mGoogleApiClient == null || !mGoogleApiClient!!.isConnected) {
            try {
                if (activity != null && context != null) {
                    mGoogleApiClient = GoogleApiClient.Builder(context)
                            .enableAutoManage(activity as FragmentActivity, 0 /* clientId */, this)
                            .addApi(Places.GEO_DATA_API)
                            .build()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        setDataUser()
        mAdapter = PlaceAutocompleteAdapter(getContext(), R.layout.google_places_search_items,
                mGoogleApiClient!!, null, null!!)

        //TODO:In order to Restrict search to India uncomment this and comment the above line
        /*
        mAdapter = new PlaceAutocompleteAdapter(this, R.layout.google_places_search_items,
                mGoogleApiClient, BOUNDS_GREATER_INDIA, null);
         */
        mAutocompleteView!!.setAdapter<PlaceAutocompleteAdapter>(mAdapter)
        mAutocompleteView!!.onItemClickListener = mAutocompleteClickListener
        mAutocompleteView!!.setOnTouchListener { v, event ->
            val DRAWABLE_LEFT = 0
            val DRAWABLE_TOP = 1
            val DRAWABLE_RIGHT = 2
            val DRAWABLE_BOTTOM = 3

            if (event.action == MotionEvent.ACTION_UP) {
                if (event.rawX >= mAutocompleteView!!.right - mAutocompleteView!!.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
                    if (mAutocompleteView!!.text.toString().isNotEmpty())
                        mAutocompleteView!!.setText("")
                    //return@mAutocompleteView.setOnTouchListener true
                }
            }
            false
        }
        mSpinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                (parent.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                (parent.getChildAt(0) as TextView).gravity = Gravity.END
                if (position == 0) {
                    getAllCount()
                } else {
                    getPointsNear()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }// init


    override fun onCameraChange(cameraPosition: CameraPosition) {}

    override fun onInfoWindowClick(marker: Marker) {}

    override fun onInfoWindowClose(marker: Marker) {}

    override fun onInfoWindowLongClick(marker: Marker) {}

    override fun onMapClick(latLng: LatLng) {}

    override fun onMapReady(googleMap: GoogleMap) {
        try {
            mMap = googleMap
            mMap!!.setOnMarkerClickListener(this)
            mMap!!.setOnMapClickListener(this)
            mMap!!.setOnMyLocationButtonClickListener(this)
            mMap!!.setOnCameraChangeListener(this)
            enableMyLocation()
            // try {
            //readItems();

            getAllCount()

            //        } catch (JSONException e) {
            //            e.printStackTrace();
            //        }
            // click event of the marker text
            mMap!!.setOnMarkerClickListener { marker ->
                //                sedDataFromFragActivity(DetailedActivity.class, );
                // marker.setSnippet("");

                false
            }

            mMap!!.setOnInfoWindowClickListener { marker ->
                // TODO Auto-generated trimLastCharacter stub
                // open DetailedActivity
                val stUniqueID = marker.snippet
                sedDataFromFragActivity(activity, stUniqueID)
            }
        } catch (e: Exception) {
        }
    }

    private fun enableMyLocation() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtils.requestPermission(activity as MainActivity, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true)
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap!!.isMyLocationEnabled = true
        }
    }

    override fun onMarkerClick(marker: Marker) = false

    override fun onMarkerDragStart(marker: Marker) {}

    override fun onMarkerDrag(marker: Marker) {}

    override fun onMarkerDragEnd(marker: Marker) {}

    override fun onMyLocationButtonClick() = false

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}

    override fun onStartTrackingTouch(seekBar: SeekBar) {}

    override fun onStopTrackingTouch(seekBar: SeekBar) {}

    override fun onClick(v: View) {
        try {
            when (v.id) {
                R.id.fab_add -> {
                    mLatitude = String.format("%s", mMap!!.cameraPosition.target.latitude)
                    mLongitude = String.format("%s", mMap!!.cameraPosition.target.longitude)

                    mLatitudeDoub = mMap!!.cameraPosition.target.latitude
                    mLongitudeDoub = mMap!!.cameraPosition.target.longitude
                    doubleClick++

                    mClusterManager = ClusterManager(activity, mMap)
                    mMap!!.setOnCameraIdleListener(mClusterManager)
                    if (isIncreasedUser) {
                        if (doubleClick == 2) {
                            sedDataFromFrag(mLatitudeDoub, mLongitudeDoub)
                            doubleClick = 0
                        } else {
                            showToast(v)
                            imBack!!.visibility = View.VISIBLE
                        }
                    } else {
                        startDialog()
                    }
                }
            }
        } catch (e: Exception) {
        }
    }

    private fun startDialog() {
        val cdd = CustomDialogClass(activity)
        cdd.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        cdd.show()
    }

    private fun showToast(v: View) {
        try {
            val layouttoast = LayoutInflater.from(v.context)
                    .inflate(R.layout.custom_toast, v.findViewById(R.id.toast_layout_root))
            popupToast = Toast(context)
            popupToast!!.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            popupToast!!.duration = Toast.LENGTH_LONG
            popupToast!!.view = layouttoast
            popupToast!!.show()

            timer = object : CountDownTimer(4000, 1000) {
                override fun onTick(millisUntilFinished: Long) =
                        popupToast!!.show()

                override fun onFinish() =
                        popupToast!!.cancel()

            }.start()
        } catch (e: Exception) {
        }
    }

    private fun getPos() {
        try {
            gps = GPSTracker(activity)

            if (gps!!.canGetLocation()) {
                myLatitude = gps!!.latitude
                myLongitude = gps!!.longitude
                // Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + myLatitude + "\nLong: " + myLongitude, Toast.LENGTH_LONG).show();
            } else {
                myLatitude = gps!!.latitude
                myLongitude = gps!!.longitude
                // Can't get location.
                // GPS or network is not enabled.
                // Ask user to enable GPS/network in settings.
                gps!!.showSettingsAlert()
            }
        } catch (e: Exception) {
        }
    }

    @Throws(JSONException::class)
    private fun readItems(pointList: List<Point>) {
        try {
            // def move
            getPos()
            mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(myLatitude, myLongitude), 10f))

            mClusterManager = ClusterManager(context, mMap)
            mMap!!.setOnCameraIdleListener(mClusterManager)

            val items = ArrayList<MyItem>()
            for (point in pointList) {
                val placeIDSt: String
                val stSiteCurrency: String
                val width: Double
                val length: Double

                if (!point.newPointSh.isNullOrEmpty())
                    width = java.lang.Double.parseDouble(point.newPointSh)
                else
                    continue

                if (!point.newPointDl.isNullOrEmpty())
                    length = java.lang.Double.parseDouble(point.newPointDl)
                else
                    continue

                if (!point.siteCurency.isNullOrEmpty())
                    stSiteCurrency = point.siteCurency
                else
                    continue

                if (!point.placeID.isNullOrEmpty())
                    placeIDSt = point.placeID
                else
                    continue

                items.add(MyItem(width, length, stSiteCurrency, placeIDSt, placeIDSt))
            }

            if (items.isNotEmpty()) {
                mMap!!.clear()
                mClusterManager!!.clearItems()
                mClusterManager!!.addItems(items)
            }
        } catch (e: Exception) {
            Log.e(TAG, "error: $e")
        }
    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {}

    override fun onRefresh() {
        try {
            refreshLayout!!.isRefreshing = true
            refreshLayout!!.postDelayed({
                refreshLayout!!.isRefreshing = false
                getAllCount()
            }, 1000)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @SuppressLint("CheckResult")
    fun getAllCount() {
        relativeLayout!!.visibility = View.INVISIBLE
        refreshLayout!!.isRefreshing = true
        mGetPoint = Common.getPoint()
        mGetPoint!!.mValue(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ points ->
                    readItems(points)
                    refreshLayout!!.isRefreshing = false
                    relativeLayout!!.visibility = View.VISIBLE
                },
                        { throwable ->
                            Log.e("TAG", txtErrorColon!! + throwable)
                            run { refreshLayout!!.isRefreshing = false }
                        })
    }

    @SuppressLint("CheckResult")
    fun getPointsNear() {
        relativeLayout!!.visibility = View.INVISIBLE
        refreshLayout!!.isRefreshing = true
        mGetNearPoints = Common.getNearPoints()
        mGetNearPoints!!.sendKey("EUR")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ pointNear ->
                    readItems(pointNear.nearPoint)
                    refreshLayout!!.isRefreshing = false
                    relativeLayout!!.visibility = View.VISIBLE
                },
                        { throwable ->
                            Log.e("TAG", txtErrorColon!! + throwable)
                            run { refreshLayout!!.isRefreshing = false }
                        })
    }

    private fun sedDataFromFrag(mLatitude: Double, mLongitude: Double) {
        try {
            val navigationView = activity.findViewById<NavigationView>(R.id.nav_view)
            menu = navigationView.menu

            val bundle = Bundle()
            bundle.putDouble("mLatitude", mLatitude)
            bundle.putDouble("mLongitude", mLongitude)

            val fragment = AddFragment()
            fragment.arguments = bundle

            //showFloatingButton();
            val ft = activity.fragmentManager.beginTransaction()
            //ft.replace(R.id.app_bar_main2, fragment);
            ft.commit()
            val item = menu!!.findItem(R.id.drawer_item_courses)
            val id = 2131296509
            // Выделяем выбранный пункт меню в шторке
            item.isChecked = true
            // Выводим выбранный пункт в заголовке
            // setTitle(item.getTitle());
            val drawer = activity.findViewById<DrawerLayout>(R.id.drawer_layout)
            drawer.closeDrawer(GravityCompat.START)

            currentItem = id
            // changeFragment(fragment, item); поправить
        } catch (e: Exception) {
        }

    }

    private fun sedDataFromFragActivity(activity: Activity, stUniqueID: String?) {
        try {
            val intent = Intent(activity, DetailedActivity::class.java)
            intent.putExtra("stUniqueID", stUniqueID)
            startActivity(intent)
            activity.finish()
        } catch (e: Exception) {
        }
    }

    private fun setDataUser() {
        user = User()
        user = st
        id = user!!.id
        if (id == null)
            id = defIdUser
        getDataOfUser(id)
    }

    @SuppressLint("CheckResult")
    private fun getDataOfUser(auth: String?) {
        val mDialog = ProgressDialog(activity)
        mDialog.setMessage(resources.getString(R.string.txt_plz_wait))
        mDialog.setCancelable(false)
        mDialog.show()

        getDataUser!!.sendKey(auth)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userDataList ->
                    if (userDataList.queryContent[0].activateUser != null) {
                        isActivate(userDataList.queryContent[0].activateUser)
                    }
                    mDialog.dismiss()
                },
                        { throwable ->
                            showToast(activity, "Error $throwable")
                            mDialog.dismiss()
                        })
    }

    private fun isActivate(activateUser: String) {
        isIncreasedUser = activateUser == "1"
    }

    private fun hideKeyboard() {
        if (activity.currentFocus == null) return
        val inputManager =
                activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
        internal var timer: CountDownTimer? = null
    }
}