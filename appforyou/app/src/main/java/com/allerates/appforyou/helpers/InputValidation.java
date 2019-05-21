package com.allerates.appforyou.helpers;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

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
        if (value.isEmpty()) {
            hideKeyboardFrom(textInputEditText);
            Toast.makeText(context , message, Toast.LENGTH_SHORT).show();
            return false;
        } else {

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
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            hideKeyboardFrom(textInputEditText);
            Toast.makeText(context , message, Toast.LENGTH_SHORT).show();
            return false;
        } else {
        }
        return true;
    }

    public boolean isInputEditTextMatches(TextInputEditText textInputEditText1, TextInputEditText textInputEditText2, String message) {
        String value1 = textInputEditText1.getText().toString().trim();
        String value2 = textInputEditText2.getText().toString().trim();
        if (!value1.contentEquals(value2)) {
            hideKeyboardFrom(textInputEditText2);
            Toast.makeText(context , message, Toast.LENGTH_SHORT).show();
            return false;
        } else {
        }
        return true;
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
