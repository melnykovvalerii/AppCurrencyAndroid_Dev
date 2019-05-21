package com.allerates.appforyou.helpers;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.allerates.appforyou.Common;


public class InputValidation {
    private Context context;

    /**
     * constructor
     *
     * @param context
     */
    public InputValidation(Context context) {
        this.context = context;
    }

    /**
     * method to check InputEditText filled .
     *
     * @param textInputEditText
     * @param message
     * @return
     */
    public boolean isInputEditTextFilled(Context context, TextInputEditText textInputEditText, String message) {
        String value = textInputEditText.getText().toString().trim();
        if (value.isEmpty() || value.length() < 4) {
            hideKeyboardFrom(textInputEditText);
            Toast.makeText(context , message, Toast.LENGTH_LONG).show();
            Common.isGetReq = false;
            return false;
        } else {
            Common.isGetReq = true;
        }

        return true;
    }


    /**
     * method to check InputEditText has valid email .
     *
     * @param textInputEditText
     * @param message
     * @return
     */
    public boolean isInputEditTextEmail(Context context, TextInputEditText textInputEditText, String message) {
        String value = textInputEditText.getText().toString().trim();
        String mainChapterNumber = value.split("@", 2)[0];

        if (value.isEmpty()
            || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches() || mainChapterNumber.length() < 4) {

            hideKeyboardFrom(textInputEditText);
            Toast.makeText(context , message, Toast.LENGTH_SHORT).show();
            Common.isGetReq = false;
            return false;
        } else {
            Common.isGetReq = true;
        }
        return true;
    }

    public boolean isInputEditTextMatches(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2, String message) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if(value1.length() < 5 || value1.length() > 15){
            Toast.makeText(context , message + "The password field must consist of Latin characters allowed length of the parameter is not less than 5 and not more than 15 characters.\"", Toast.LENGTH_SHORT).show();
            Common.isGetReq = false;
            return false;
        }else {
            if (!value1.contentEquals(value2)) {
                hideKeyboardFrom(textInputEditText2);
                Toast.makeText(context , message, Toast.LENGTH_SHORT).show();
                Common.isGetReq = false;
                return false;
            } else {
                Common.isGetReq = true;
            }
            return true;
        }
    }

    /**
     * method to Hide keyboard
     *
     * @param view
     */
    private void hideKeyboardFrom(View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
