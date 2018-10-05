package com.software.tempe.uitheme;

import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationState {
    private SharedPreferences sharedPreferences;

    public ApplicationState(Context context) {
        sharedPreferences = context.getSharedPreferences("theme_settings", Context.MODE_PRIVATE);
    }

    // save app theme state
    public void setThemeState(Boolean state) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("DarkMode", state);
        editor.apply();
    }

    // load app theme state
    public Boolean getThemeState() {
        return sharedPreferences.getBoolean("DarkMode", false);
    }



}
