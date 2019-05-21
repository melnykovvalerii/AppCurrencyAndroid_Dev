package com.allerates.appforyou.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.helpers.InputValidation;
import com.allerates.appforyou.model.Ip;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.LocationREST;
import com.allerates.appforyou.request.UserDataList;
import com.allerates.appforyou.request.api.GetDataUser;
import com.allerates.appforyou.request.api.IpServiceGet;
import com.allerates.appforyou.request.api.IpServiceREST;
import com.allerates.appforyou.request.api.LogWithMail;
import com.allerates.appforyou.sql.DatabaseHelper;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.support.constraint.Constraints.TAG;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;

    private FirebaseAuth mAuth;
    private CallbackManager callbackManager;
    private Button loginButtonFacebook;

    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;
    private TextView textLostPassword;

    private Button appCompatButtonLogin;

    private CheckConnection checkConnection;

    private AppCompatTextView textViewLinkRegister;
    private TextView textView2;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    private GoogleSignInClient mGoogleSignInClient;
    private SignInButton mGoogleBtn;
    private Button mCustomGoogleBtn;

    private String name, email;
    private static final int RC_SIGN_IN = 1;
    private User user;
    private String id;
    private static final String SP_NAME = "userDetails";
    private SharedPreferences userLocalDatabase;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

//            try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "com.allerates.appforyou",
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Login.d("KeyHash", "KeyHash:" + Base64.encodeToString(md.digest(),
//                        Base64.DEFAULT));
//                Toast.makeText(getApplicationContext(), Base64.encodeToString(md.digest(),
//                        Base64.DEFAULT), Toast.LENGTH_LONG).show();
//            }
//            } catch (PackageManager.NameNotFoundException e) {
//
//            } catch (NoSuchAlgorithmException e) {
//
//            }
//        getSupportActionBar().hide();
        initViews();

        initObjects();
        RegWithFacebook();
        initGoogleSignin();
    }//onCreate

    /**
     * This trimLastCharacter is set facebook data
     */
    private void setFacebookData(final LoginResult loginResult) {
        try {
        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {
                            Profile profile = Profile.getCurrentProfile();
                            if (Profile.getCurrentProfile() != null) {
                                Log.i(getResources().getString(R.string.txt_login), "ProfilePic" + Profile.getCurrentProfile().getProfilePictureUri(200, 200));
                            }
                            email = response.getJSONObject().getString(getResources().getString(R.string.txt_email));
                            name = response.getJSONObject().getString(getResources().getString(R.string.txt_first_name));

                            postDataToSQLite(email, email, name, email);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString(getResources().getString(R.string.txt_fields), getResources().getString(R.string.txt_some_fields));
        request.setParameters(parameters);
        request.executeAsync();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * This trimLastCharacter is to initialize views facebook sign
     */
    public void RegWithFacebook(){
        try {
        FacebookSdk.sdkInitialize(getApplicationContext());
        // вход устанавливаем с кастомной кнопки
        callbackManager = CallbackManager.Factory.create();
            loginButtonFacebook.setClickable(true);
            loginButtonFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            if (checkConnection.isOnline(getApplicationContext())) {
                LoginManager.getInstance().logInWithReadPermissions
                        (LoginActivity.this, Arrays.asList("email", "public_profile"));
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        setFacebookData(loginResult);
//                    Toast.makeText(ActivityAuth.this, "Вошел FB", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(LoginActivity.this, getResources().getString(R.string.txt_cancer_fb), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onError(FacebookException error) {
                        Toast.makeText(LoginActivity.this, getResources().getString(R.string.txt_error) + error, Toast.LENGTH_SHORT).show();
                        Log.d(getResources().getString(R.string.txt_login_activity), getResources().getString(R.string.txt_face_exception) + error);
                    }
                });
            } else {
                checkConnection.makeToastConnection(LoginActivity.this);
            }
        }
        });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }




    /**
     * This trimLastCharacter is to initialize views google sign
     */
    public void initGoogleSignin(){
        try {
    mGoogleBtn = (SignInButton) findViewById(R.id.googleBtn);
    mCustomGoogleBtn = (Button) findViewById(R.id.login_btn_google);

            // Configure Google Sign In
    GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.def_web_client_id))
            .requestServerAuthCode(getString(R.string.def_web_client_id))
            .requestEmail()
            .build();

//    mGoogleSignInClient = new GoogleApiClient.Builder(getApplicationContext())
//            .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
//                @Override
//                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//
//                    Toast.makeText(LoginActivity.this, "You Got an Error", Toast.LENGTH_LONG).show();
//                }
//            })
//            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//            .build();

    // Build GoogleAPIClient with the Google Sign-In API and the above options.
    mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    mCustomGoogleBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == mCustomGoogleBtn) {
                onClickGoogle();
            }
        }
    });
    } catch(Exception e) {
        e.printStackTrace();
    }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        String s = account.getServerAuthCode();
        s += "sakura";
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                        } else {
                            Log.d(TAG, "signInWithCredential:NOT_success");
                        }
                    }
                });
    }

    public void onClickGoogle() {
        if (checkConnection.isOnline(getApplicationContext())) {
            signIn();
            mCustomGoogleBtn.setEnabled(false);
        }else {
            checkConnection.makeToastConnection(LoginActivity.this);
        }
    }
    private void refreshIdToken() {
        // Attempt to silently refresh the GoogleSignInAccount. If the GoogleSignInAccount
        // already has a valid token this method may complete immediately.
        //
        // If the user has not previously signed in on this device or the sign-in has expired,
        // this asynchronous branch will attempt to sign in the user silently and get a valid
        // ID token. Cross-device single sign on will occur in this branch.
        mGoogleSignInClient.silentSignIn()
                .addOnCompleteListener(this, new OnCompleteListener<GoogleSignInAccount>() {
                    @Override
                    public void onComplete(@NonNull Task<GoogleSignInAccount> task) {
                        handleSignInResult(task);
                    }
                });
    }

    // [START handle_sign_in_result]
    private void handleSignInResult(@NonNull Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            String idToken = account.getIdToken();
            //sendTokenId(mCustomGoogleBtn, getApplicationContext(), idToken);
            // TODO(developer): send ID Token to server and validate
            Toast.makeText(this, idToken, Toast.LENGTH_SHORT)
                    .show();
            //updateUI(account);
        } catch (ApiException e) {
            Log.w(TAG, "handleSignInResult:error", e);
            //updateUI(null);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            // [START get_id_token]
            // This task is always completed immediately, there is no need to attach an
            // asynchronous listener.

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
            refreshIdToken();
            ///////////////////////////

            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            String sToken = FirebaseInstanceId.getInstance().getToken();
            /////////////////////////

            if(result.isSuccess()) {
                //GoogleSignInAccount account = result.getSignInAccount();
               // firebaseAuthWithGoogle(account);

     //           GoogleSignInAccount account = result.getSignInAccount();
//                if(account != null){
//                    String st = null;
//                    String idToken = account.getIdToken();
//                    st += idToken;
//                    name = account.getDisplayName();
//                    email = account.getEmail();
//                    ////////////////////////////////////////
//                    ////////////////////////////////////////
//                    ////////////////////////////////////////
//                    ////////////////////////////////////////
//                    ////////////////////////////////////////
//                    ////////////////////////////////////////
//                    postDataToSQLite(email, email, name, email);
//                    databaseHelper.setUserLogedIn(true, getApplicationContext());
//                    getIpAddress(email, getApplicationContext());
//                }
            }else {
                // Google Sign In failed, update UI appropriately
                Toast.makeText(this, getResources().getString(R.string.txt_authentication_error), Toast.LENGTH_SHORT)
                        .show();
            }
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This trimLastCharacter is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite(String auth, String email, String name, String password) {
        try {
        if (!databaseHelper.checkUser(email)) {
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setId(auth);
            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Toast.makeText(this, getString(R.string.success_message), Toast.LENGTH_LONG).show();
            //databaseHelper.getIpAddress(email, getApplicationContext());
            emptyInputEditText();

        } else {
            databaseHelper.setUserLogedIn(true, getApplicationContext());
           // databaseHelper.getIpAddress(email, getApplicationContext());
           // Intent accountsIntent = new Intent(activity, ShowCurrencyFragment.class);
            emptyInputEditText();
            //startActivity(accountsIntent);
            // Snack Bar to show error message that record already exists
            Toast.makeText(this, getString(R.string.error_email_exists), Toast.LENGTH_LONG).show();

        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This trimLastCharacter is to initialize views
     */
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
    ////////////////////////////////////////////////
//    public void sendTokenId(final Button btnSend, final Context context, final String tokenId){
//        final ProgressDialog mDialog = new ProgressDialog(context);
//        mDialog.setMessage(context.getString(R.string.wait_string));
//        mDialog.setCancelable(false);
//        mDialog.show();
//
//        GetNearPoints mGetNearPoints;
//        mGetNearPoints = Common.getNearPoints();
//        mGetNearPoints.sendKey(tokenId)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Example>() {
//                               @Override
//                               public void accept(@io.reactivex.annotations.NonNull Example example) throws Exception {
//                                   if (example.getStatus().equals("success")) {
//                                       tvTitle.setText(example.getMessage().toString());
//
//                                       mDialog.dismiss();
//                                       btnSend.setEnabled(true);
//                                   }else {
//                                       Toast.makeText(context, example.getMessage(), Toast.LENGTH_LONG).show();
//                                       btnSend.setEnabled(true);
//                                       mDialog.dismiss();
//                                   }
//                               }
//                           },
//                        throwable -> {
//                            Log.e(TAG, "Error: " + throwable);
//                            mDialog.dismiss();
//                        });
//    }
    private void initViews() {

        textLostPassword = (TextView) findViewById(R.id.textLostPassword);
        loginButtonFacebook = (Button) findViewById(R.id.login_btn_facebook);

        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        appCompatButtonLogin = (Button) findViewById(R.id.appCompatButtonLogin);

        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
        textView2 = (TextView) findViewById(R.id.textView2);

        initListeners();

        textLostPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent accountsIntent = new Intent(getApplicationContext(), PasswordRecognitionActivity.class);
                startActivity(accountsIntent);
            }
        });
    }

    private void signIn() {
        try {
        // Show an account picker to let the user choose a Google account from the device.
        // If the GoogleSignInOptions only asks for IDToken and/or profile and/or email then no
        // consent screen will be shown here.
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        //Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleSignInClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This trimLastCharacter is to initialize listeners
     */
    private void initListeners() {

        appCompatButtonLogin.setOnClickListener(this);
        textViewLinkRegister.setOnClickListener(this);
        textView2.setOnClickListener(this);

    }

    /**
     * This trimLastCharacter is to initialize objects to be used
     */
    private void initObjects() {
      //  try {

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(LoginActivity.this, AccountActivity.class));

                }
            }
        };
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
        checkConnection = new CheckConnection();
        user = new User();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * This implemented trimLastCharacter is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                if (checkConnection.isOnline(getApplicationContext())) {
                    verifyFromSQLite(name, email, 1);
                }else {
                    checkConnection.makeToastConnection(LoginActivity.this);
                }
                break;
            case R.id.textViewLinkRegister:
                // Navigate to RegisterIp
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;

            case R.id.textView2:
                // Navigate to RegisterIp
                Intent intentRegister2 = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister2);
                break;
        }

    }

    /**
     * This trimLastCharacter is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite(String eMail, String password, int number) {
        try {
        switch (number){
            case 1 :
                if (!inputValidation.isInputEditTextFilled(getApplicationContext(), textInputEditTextEmail, getString(R.string.error_message_email))) {
                    return;
                }
                if (!inputValidation.isInputEditTextEmail(getApplicationContext(), textInputEditTextEmail, getString(R.string.error_message_email))) {
                    return;
                }
                if (!inputValidation.isInputEditTextFilled(getApplicationContext(), textInputEditTextPassword, getString(R.string.error_message_email))) {
                    return;
                }

                eMail = textInputEditTextEmail.getText().toString().trim();
                password = textInputEditTextPassword.getText().toString().trim();
                break;
            case 2 :
                break;
            default :
                System.out.println(getResources().getString(R.string.txt_inv_number));
        }
            getLog(appCompatButtonLogin, getApplicationContext(), eMail, password);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void getLog(final Button appCompatButtonRegister,
                       final Context context, final String exMail, final String exPassword){
        user = new User();

        final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
        mDialog.setMessage(getString(R.string.wait_string));
        mDialog.setCancelable(false);
        mDialog.show();

        DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(context);
        LogWithMail mLogWithMail;
        mLogWithMail = Common.LogWithMail();
        mLogWithMail.mValue(exMail, exPassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(login -> {

                    id = login.getQueryContent().get(0).getAuthKey();
                    if (id != null) {



                        user.setName(login.getQueryContent().get(0).getExName());
                        user.setEmail(exMail);
                        user.setPassword(exPassword);
                        user.setId(id);

                        isConfirmed(user);
//                        getIpAddress(exMail, context);
//                        databaseHelper.addUser(user);
//                        databaseHelper.setUserLogedIn(true, context);

                        appCompatButtonRegister.setEnabled(true);
                        mDialog.dismiss();
                    } else {
                        appCompatButtonRegister.setEnabled(true);
                        Toast.makeText(context,
                                "The user is not registered or details are not right",
                                Toast.LENGTH_LONG).show();
                        mDialog.dismiss();
                    }
                },
                        throwable -> {
                            Log.e(TAG, "Error: " + throwable);
                            mDialog.dismiss();
                        });
    }
    private void isConfirmed(User mUser) {

        final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
        mDialog.setMessage(getResources().getString(R.string.txt_plz_wait));
        mDialog.setCancelable(false);
        mDialog.show();

        GetDataUser getDataUser;
        getDataUser = Common.getUserDate();
        getDataUser.sendKey(mUser.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserDataList>() {
                               @Override
                               public void accept(com.allerates.appforyou.request.UserDataList userDataList) throws Exception {
                                   Intent accountsIntent;
                                   if(userDataList.getQueryContent().get(0).getActivateUser() != null){
                                       String sConf = userDataList.getQueryContent().get(0).getActivateUser();
                                       if(sConf.equals("1")){
                                           DatabaseHelper databaseHelper;
                                           databaseHelper = new DatabaseHelper(getApplicationContext());
                                           databaseHelper.addUser(mUser);
                                           databaseHelper.setUserLogedIn(true, getApplicationContext());
                                           accountsIntent = new Intent(getApplicationContext(), MainActivity.class);

                                           initUserLocalDatabase(getApplicationContext());
                                           SharedPreferences.Editor spEditor = userLocalDatabase.edit();
                                           spEditor.putString("money", getApplicationContext().getString(R.string.def_currency)); // for def currency
                                           spEditor.commit();


                                           startActivity(accountsIntent);
                                       }else {
                                           accountsIntent = new Intent(getApplicationContext(), ActivityCheckPassword.class);
                                           accountsIntent.putExtra("active_key", mUser.getId());
                                           accountsIntent.putExtra("email", mUser.getEmail());
                                           accountsIntent.putExtra("name", mUser.getName());
                                           accountsIntent.putExtra("password", mUser.getPassword());

                                           initUserLocalDatabase(getApplicationContext());
                                           SharedPreferences.Editor spEditor = userLocalDatabase.edit();
                                           spEditor.putString("money", getApplicationContext().getString(R.string.def_currency)); // for def currency
                                           spEditor.commit();

                                           startActivity(accountsIntent);
                                           Toast.makeText(getApplicationContext(), "Mail not confirmed. Go to the e-mail and click on the link.", Toast.LENGTH_LONG).show();
                                       }
                                   }
                                   mDialog.dismiss();
                               }
                           },
                        throwable -> {
                            Toast.makeText(this, "Error " + throwable, Toast.LENGTH_LONG).show();
                            Log.e("TAG", "Mail not confirmed. Go to the e-mail and click on the link." + throwable);
                            mDialog.dismiss();
                        });
    }

    public void getIpAddress(final String email, final Context context){
        IpServiceGet mServiceIp;
        mServiceIp = Common.getIpService();
        mServiceIp.getIP().enqueue(new Callback<Ip>() {
            @Override
            public void onResponse(Call<Ip> call, Response<Ip> response) {
                try {
                    if(response.body().getIp() != null){
                        String ip = response.body().getIp(); // getIpAddress
                        getCountry(ip, context);
                    }else {
                        getCountry("109.254.254.81", context);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                    getCountry("109.254.254.81", context);
                }
            }

            @Override
            public void onFailure(Call<Ip> call, Throwable t) {
                String ip = context.getString(R.string.def_ip); // defIp
                getCountry(ip,  context);
            }
        });
    }
    public void getCountry(String ip, final Context context){
        // s = "109.254.254.81";
        IpServiceREST mService;
        try {
            mService = Common.getCurrentSer();
            mService.defineCurrency(ip).enqueue(new Callback<LocationREST>() {
                @Override
                public void onResponse(Call<LocationREST> call, Response<LocationREST> response) {
                    String code = response.body().getGeopluginCurrencyCode();
                    initUserLocalDatabase(context);
                    SharedPreferences.Editor spEditor = userLocalDatabase.edit();
                    spEditor.putString("money", code); // for def currency
                    spEditor.commit();
//                    RegisterActivity registerActivity = new RegisterActivity();
//                    registerActivity.openActivity(context);
                    Intent accountsIntent = new Intent(context, MainActivity.class);
                    startActivity(accountsIntent);

                }

                @Override
                public void onFailure(Call<LocationREST> call, Throwable t) {
                    Log.e("ERROR", t.getMessage());
                    initUserLocalDatabase(context);
                    SharedPreferences.Editor spEditor = userLocalDatabase.edit();
                    spEditor.putString("money", context.getString(R.string.def_currency)); // for def currency
                    spEditor.commit();
                    openActivity(context);
                }
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void openActivity(Context context) {
        //try {
        Intent accountsIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(accountsIntent);
        //finish();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }

    public void initUserLocalDatabase(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }
    /**
     * This trimLastCharacter is to empty all input edit text
     */
    private void emptyInputEditText() {
        try {
        textInputEditTextEmail.setText(null);
        textInputEditTextPassword.setText(null);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        try {
        if(authenticate()){
            Intent accountsIntent = new Intent(activity, MainActivity.class);// open first Activity
            emptyInputEditText();
            startActivity(accountsIntent);
            finish();
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private boolean authenticate(){
        return databaseHelper.getUserLoggedIn(getApplicationContext());
    }
}
