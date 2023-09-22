package com.example.gaia.Authentication;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class SPHelper {
    private static final String NAME = "MySharedPref";
    private static final String AUTH_KEY = "authData";

    private final SharedPreferences sharedPreferences;

    private final Gson gson;

    public SPHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void saveData(AuthD authD){
        String json = gson.toJson(authD);
        sharedPreferences.edit().putString(AUTH_KEY,json).apply();
    }

    public String getAccessToken(){
        String json = sharedPreferences.getString(AUTH_KEY,null);
        if(json!=null){
            AuthD authD = gson.fromJson(json,AuthD.class);
            return authD.getAccessToken();
        }
        return null;
    }
}
