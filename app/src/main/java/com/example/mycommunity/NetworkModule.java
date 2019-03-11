package com.example.mycommunity;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public  class NetworkModule {

     public static void get(String url, Callback callback){
         OkHttpClient client = new OkHttpClient();
         Request request = new Request.Builder().url(url).build();
         client.newCall(request).enqueue(callback);
     }

     public static void post(String url, String json,Callback callback){
         OkHttpClient client = new OkHttpClient();
         RequestBody requestBody = FormBody.create(MediaType.parse("application/jason; charset=utf-8"),json);
         Request request = new Request.Builder().url(url).post(requestBody).build();
         client.newCall(request).enqueue(callback);
     }

}
