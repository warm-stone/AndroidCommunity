package com.example.mycommunity.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.mycommunity.JsonEntity.UserInformation;

public class Login {
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static void storagePassword(UserInformation userInformation, Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("username", userInformation.getUsername());
        editor.putString("password", userInformation.getPassword());
        editor.apply();
    }

    public static UserInformation loadPassword(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(preferences.getString("username",""));
        userInformation.setPassword(preferences.getString("password",""));
        return userInformation;
    }
}
