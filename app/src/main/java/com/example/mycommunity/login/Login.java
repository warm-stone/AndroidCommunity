package com.example.mycommunity.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.mycommunity.jsonEntity.UserInformation;
import com.example.mycommunity.NetworkModule;

import okhttp3.Callback;


public class Login {
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    public static void storagePassword(UserInformation userInformation, Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("nickname", userInformation.getNickname());
        editor.putString("password", userInformation.getPassword());
        editor.putBoolean("isRemember", true);
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    public static UserInformation loadInformation(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        UserInformation userInformation = new UserInformation();
        userInformation.setNickname(preferences.getString("nickname", ""));
        userInformation.setPassword(preferences.getString("password", ""));
        userInformation.setPhone(preferences.getString("phone", ""));
        userInformation.setAvatar(preferences.getString("avatar", ""));
        userInformation.setUsername(preferences.getString("username", ""));
        userInformation.setEmail(preferences.getString("email", ""));
        userInformation.setGender(preferences.getString("gender", ""));
        userInformation.setBirthday(preferences.getLong("birthday", 0L));
        userInformation.setMotto(preferences.getString("motto", ""));
        userInformation.setCommunityId(preferences.getInt("communityId", 0));
        return userInformation;
    }

    public static void storageInformation(UserInformation information, Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putLong("id", information.getId());
        editor.putString("idcard", information.getIdCard());
        editor.putLong("signUp", information.getSignUp());
        editor.putString("password", information.getPassword());
        editor.putString("nickname", information.getNickname());
        editor.putString("phone", information.getPhone());
        editor.putString("avatar", information.getAvatar());
        editor.putString("username", information.getUsername());
        editor.putString("email", information.getEmail());
        editor.putLong("birthday", information.getBirthday());
        editor.putString("motto", information.getMotto());
        editor.putInt("communityId", information.getCommunityId());
        editor.putString("communityName", information.getCommunityName());
        editor.putBoolean("isRemember", true);
        editor.putBoolean("isLoggedIn", true);
        editor.apply();
    }

    public static void storageAuthorization(String authorization, Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putString("Authorization", authorization);
        editor.apply();
    }

    public static void clearPassword(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.remove("nickname");
        editor.remove("password");
        editor.remove("phone");
        editor.remove("avatar");
        editor.remove("username");
        editor.remove("email");
        editor.remove("birthday");
        editor.remove("motto");
        editor.remove("community");
        editor.remove("isLoggedIn");
        editor.remove("Authorization");
        editor.remove("isRemember");
        editor.apply();
    }

    public static String getAuthorization(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("Authorization", "");
    }

    public static boolean isRemember(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean("isRemember", false);
    }

    public static boolean isLoggedIn(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean("isLoggedIn", false);
    }

    public static void setLoggedIn(Context context, boolean state) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = preferences.edit();
        editor.putBoolean("isLoggedIn", state);
        editor.apply();
    }

    public static String getPhone(Context context){
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString("phone", "");
    }
    public static UserInformation loadPassword(Context context) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        UserInformation userInformation = new UserInformation();
        userInformation.setNickname(preferences.getString("nickname", ""));
        userInformation.setPassword(preferences.getString("password", ""));
        return userInformation;
    }

    public static void login(Callback callback, Context context) {
        String url = "/user/login";
        NetworkModule.postForm(url, loadPassword(context), callback);
    }
}
