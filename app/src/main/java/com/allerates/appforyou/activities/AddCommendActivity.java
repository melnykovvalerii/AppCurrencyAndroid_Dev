package com.allerates.appforyou.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.allerates.appforyou.Common;
import com.allerates.appforyou.R;
import com.allerates.appforyou.helpers.CheckConnection;
import com.allerates.appforyou.model.User;
import com.allerates.appforyou.request.Comments;
import com.allerates.appforyou.request.api.AddCommentPoint;
import com.allerates.appforyou.sql.DatabaseHelper;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AddCommendActivity extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener {
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.create_btn)
    Button createBtn;
    @BindView(R.id.ed_about)
    EditText edAbout;
    @BindString(R.string.txt_def_id_user)
    String defIdUser;
    private Toolbar toolbar;
    private CheckConnection checkConnection;
    private String stUniqueID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_commend);
        toolbar = findViewById(R.id.toolbar);
        checkConnection = new CheckConnection();
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        if(getIntent().getExtras().getString("stUniqueID") != null){
            stUniqueID = getIntent().getExtras().getString("stUniqueID");
        }else {
            stUniqueID = null;
        }

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        ratingBar.setRating(rating);
        Toast.makeText(AddCommendActivity.this, "rating: " + String.valueOf(rating),
                Toast.LENGTH_LONG).show();

    }

    @OnClick(R.id.create_btn)
    public void onB(View view) {
        getDataUser();
    }

    public void getDataUser() {
        User user = new User();
        user = getSt();
        String id = user.getId();
        if (id == null) {
            id = defIdUser;
        }
        if (isInternet()) {
            isValid(edAbout.getText().toString(), ratingBar.getNumStars(), stUniqueID);
        }
    }

    private boolean isInternet() {
        if (checkConnection.isOnline(getApplicationContext())) {
            return true;
        } else {
            checkConnection.makeToastConnection(this);
            return false;
        }
    }

    public User getSt() {
        DatabaseHelper databaseHelper;
        databaseHelper = new DatabaseHelper(getApplicationContext());
        return databaseHelper.getUser();

    }

    private void isValid(String stringCom, int numStars, String idPoint) {
        if (stringCom.length() < 500) {
            if (numStars > 5) {
                numStars = 5;

            } else if (numStars < 1) {
                numStars = 1;
            }
            setCommend(getApplicationContext(), Integer.toString(numStars), stringCom, idPoint);
        } else {
            Toast.makeText(AddCommendActivity.this, "comment length should not exceed 500",
                    Toast.LENGTH_LONG).show();
        }

    }
    public void showToast(Context context, String text){
        Toast.makeText(context,
                text,
                Toast.LENGTH_LONG).show();
    }
    public void setCommend(final Context context, final String rating, final String comment, final String auth_key) {
        final ProgressDialog mDialog = new ProgressDialog(AddCommendActivity.this);
        mDialog.setMessage(getString(R.string.wait_string));
        mDialog.setCancelable(false);
        mDialog.show();

        AddCommentPoint mAddCommentPoint;
        mAddCommentPoint = Common.addCommentPoint();
        mAddCommentPoint.mValue(rating, comment, auth_key)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer <Comments>() {
                               @Override
                               public void accept(com.allerates.appforyou.request.Comments response) throws Exception {
                                String txtRes;
                                int numb = response.hashCode();
                                   switch (numb) {
                                       case 401:  txtRes = "The user is not registered or details are not right";
                                           break;
                                       case 406:  txtRes = "The user is not registered or details are not right";
                                           break;
                                       case 403:  txtRes = "Rating cannot content characters";
                                           break;
                                       case 402:  txtRes = "Rating cannot be less then < 1 or biggest then > 5";
                                           break;
                                       case 404:  txtRes = "Empty comment";
                                           break;
                                       case 405:  txtRes = "Comments must not exceed 500 characters";
                                           break;
                                       case 200:  txtRes = "Comment successfully added";
                                           break;
                                       default: txtRes = "No options. Successful response";
                                           break;
                                   }
                                   if(!(numb == 200)){
                                           showToast(getApplicationContext(), txtRes);
                                   }
                                   mDialog.dismiss();
                                   onOpenAct();
                               }
                           },
                        new Consumer <Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.e("TAG", "error: " + throwable);
                                mDialog.dismiss();
                            }
                        });
    }
    /**
     * Tracked depression back
     */
    @Override
    public void onBackPressed() {
        onOpenAct();
    }//onBackPressed

    public void onOpenAct() {
        try {
            super.onBackPressed();
            Intent intent = new Intent(AddCommendActivity.this, DetailedActivity.class);
            intent.putExtra("stUniqueID", stUniqueID);
            startActivity(intent);
            finish();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}