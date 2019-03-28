package com.example.mycommunity;

import android.support.annotation.Nullable;

import com.example.mycommunity.JsonEntity.UserInformation;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class NetworkModule {

    public static void get(String url, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    public static void post(String url, String json, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        client.newCall(request).enqueue(callback);
    }

    public static void postForm(String url, UserInformation userInformation, @Nullable Callback callback) {
        OkHttpClient client = new OkHttpClient();
        FormBody formBody = new FormBody.Builder()
                .add("nickname", userInformation.getNickname())
                .add("password", userInformation.getPassword())
                .build();
        Request request = new Request.Builder().url("http://192.168.123.50:8585/chengfeng/user/login").post(formBody).build();
        client.newCall(request).enqueue(callback);
    }


}
