package com.example.mycommunity;

import android.content.Context;
import android.widget.Toast;

public class UserNotice {
    private static boolean noticing = false;
    public static final String NETWORK_CONNECT_FAILURE = "网络连接失败";
    public static final String USER_AUTHENTICATION_FAILURE = "用户认证失败";
    public static final String UNFORMATTED_DATA = "服务器数据格式错误";
    public static final String UNEXPECTED_STATE = "预期之外的错误";
    public static final String NO_DATA_GOTTEN = "未获得数据";

    public static void showToast(Context context, String msg) {
        if (!noticing) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            noticing = true;
            new Thread(){
                @Override
                public void run(){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    noticing = false;
                }
            }.start();
        }
    }
}
