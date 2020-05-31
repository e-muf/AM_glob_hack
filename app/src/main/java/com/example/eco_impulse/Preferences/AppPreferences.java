package com.example.eco_impulse.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {

    private SharedPreferences appData;
    private SharedPreferences.Editor appEditor;

    public AppPreferences(Context context){
        appData = context.getSharedPreferences("dataApp", Context.MODE_PRIVATE);
    }

    public void setLoginStatusg(boolean status){
        appEditor = appData.edit();
        appEditor.putBoolean("loginStatus", status);
        appEditor.apply();
    }

    public boolean isLogued(){
        return appData.getBoolean("loginStatus", false);
    }

}
