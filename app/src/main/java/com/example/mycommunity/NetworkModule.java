package com.example.mycommunity;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.Login.Login;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkModule {

    private final static String baseUrl = "http://192.168.123.50:8585/chengfeng";
    private static Handler handler;
    private static Context context;
    private static Callback stateCheck = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Gson gson = new Gson();
            BaseReturnMsg baseReturnMsg = gson.fromJson(response.body().string(), BaseReturnMsg.class);
            if (baseReturnMsg.getStatus() == 401) {
                Login.login(loginCallback, context);
            }
            else {
                Message message = handler.obtainMessage(0, baseReturnMsg);
                handler.sendMessage(message);
            }
        }
    };

    private static Callback loginCallback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            Gson gson = new Gson();
            BaseReturnMsg baseReturnMsg = gson.fromJson(response.body().string(), BaseReturnMsg.class);
            if (baseReturnMsg.getStatus() == 401) {
                ((Activity)context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "用户认证失败", Toast.LENGTH_SHORT).show();
                    }
                });
                Login.setLoggedIn(context, false);
            }
            else {
                Message message = handler.obtainMessage(0, baseReturnMsg);
                handler.sendMessage(message);
            }
        }
    };


    public static void get(String url, Callback callback) {
        url = baseUrl + url;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(callback);
    }

    public static void post(String url, String json, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        url = baseUrl + url;
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        client.newCall(request).enqueue(callback);
    }

    public static void postWithAuthor(String url, String json,Handler mhandler , String authorization, Context mcontext) {
        context = mcontext;
        handler = mhandler;
        OkHttpClient client = new OkHttpClient();
        url = baseUrl + url;
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder().url(url).header("Authorization", authorization).post(requestBody).build();
        client.newCall(request).enqueue(stateCheck);
    }

    public static void postForm(String url, UserInformation userInformation, @Nullable Callback callback) {
        OkHttpClient client = new OkHttpClient();
        url = baseUrl + url;
        FormBody formBody = new FormBody.Builder()
                .add("nickname", userInformation.getNickname())
                .add("password", userInformation.getPassword())
                .build();
        Request request = new Request.Builder().url("http://192.168.123.50:8585/chengfeng/user/login").post(formBody).build();
        client.newCall(request).enqueue(callback);
    }


}
