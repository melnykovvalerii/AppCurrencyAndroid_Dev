package com.allerates.appforyou.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.helpers.InputValidation;
import com.allerates.appforyou.model.User;
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
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;

    private CallbackManager callbackManager;
    private Button loginButtonFacebook;

    private TextInputEditText textInputEditTextEmail;
    private TextInputEditText textInputEditTextPassword;

    private Button appCompatButtonLogin;

    private CheckConnection checkConnection;

    private AppCompatTextView textViewLinkRegister;
    private TextView textView2;

    private InputValidation inputValidation;
    private DatabaseHelper databaseHelper;

    private GoogleApiClient mGoogleSignInClient;
    private SignInButton mGoogleBtn;
    private Button mCustomGoogleBtn;

    private String name, email;
    private static final int RC_SIGN_IN = 1;
    private User user;

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
//                Log.d("KeyHash", "KeyHash:" + Base64.encodeToString(md.digest(),
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
        initGoogleSignin();
        RegWithFacebook();

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

                            postDataToSQLite(email, name, email);

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
            .requestEmail()
            .build();

    mGoogleSignInClient = new GoogleApiClient.Builder(getApplicationContext())
            .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
        @Override
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

            Toast.makeText(LoginActivity.this, getResources().getString(R.string.txt_got_error), Toast.LENGTH_LONG).show();
        }
    })
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

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

    public void onClickGoogle() {
        if (checkConnection.isOnline(getApplicationContext())) {
            signIn();
        }else {
            checkConnection.makeToastConnection(LoginActivity.this);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if(result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                if(account != null){
                    name = account.getDisplayName();
                    email = account.getEmail();
                    postDataToSQLite(email, name, email);
                    databaseHelper.setUserLogedIn(true, getApplicationContext());
                    databaseHelper.getIpAddress(email, getApplicationContext());

                }
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
    private void postDataToSQLite(String email, String name, String password) {
        try {
        if (!databaseHelper.checkUser(email)) {
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            databaseHelper.addUser(user);

            // Snack Bar to show success message that record saved successfully
            Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            databaseHelper.getIpAddress(email, getApplicationContext());
            emptyInputEditText();

        } else {
            databaseHelper.setUserLogedIn(true, getApplicationContext());
            databaseHelper.getIpAddress(email, getApplicationContext());
           // Intent accountsIntent = new Intent(activity, ShowCurrencyFragment.class);
            emptyInputEditText();
            //startActivity(accountsIntent);
            // Snack Bar to show error message that record already exists
            Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * This trimLastCharacter is to initialize views
     */
    private void initViews() {


        loginButtonFacebook = (Button) findViewById(R.id.login_btn_facebook);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputEditTextEmail = (TextInputEditText) findViewById(R.id.textInputEditTextEmail);
        textInputEditTextPassword = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        appCompatButtonLogin = (Button) findViewById(R.id.appCompatButtonLogin);

        textViewLinkRegister = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
        textView2 = (TextView) findViewById(R.id.textView2);

        initListeners();
    }

    private void signIn() {
        try {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleSignInClient);
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
        try {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
        checkConnection = new CheckConnection();
        user = new User();
        } catch(Exception e) {
            e.printStackTrace();
        }
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
        if (databaseHelper.checkUser(eMail , password)) {

                Intent accountsIntent = new Intent(activity, UsersListActivity.class);
                accountsIntent.putExtra(getResources().getString(R.string.txt_caps_email), textInputEditTextEmail.getText().toString().trim());
                emptyInputEditText();
                startActivity(accountsIntent);
        } else {
            // Snack Bar to show success message that record is wrong
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
        } catch(Exception e) {
            e.printStackTrace();
        }
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
