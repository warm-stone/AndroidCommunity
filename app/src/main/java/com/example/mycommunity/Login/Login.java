package com.example.mycommunity.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.NetworkModule;

import okhttp3.Callback;


public class Login {
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static void storagePassword(UserInformation userInformation, Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("username", userInformation.getUsername());
        editor.putString("password", userInformation.getPassword());
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    public static void clearPassword(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.remove("username");
        editor.remove("password");
        editor.remove("isLoggedIn");
        editor.apply();
    }

    public static boolean isLoggedIn(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean("isLoggedIn", false);
    }

    public static UserInformation loadPassword(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        UserInformation userInformation = new UserInformation();
        userInformation.setUsername(preferences.getString("username",""));
        userInformation.setPassword(preferences.getString("password",""));
        return userInformation;
    }

    public static void login(@Nullable Callback callback , Context context){
        String url = "http://47.95.244.237:9990/chengfeng/per/login";
        NetworkModule.postForm(url, loadPassword(context), callback);
    }
}
