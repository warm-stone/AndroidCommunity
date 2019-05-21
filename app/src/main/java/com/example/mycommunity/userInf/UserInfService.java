package com.example.mycommunity.userInf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycommunity.CacheManager;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.google.gson.Gson;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserInfService {

    private UserInformation userInformation = null;
    private long userId = -1;
    private String nickname = null;
    private Context context;
    private CircleImageView imageView;
    private TextView textView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            boolean isOnline = false;
            ReturnMsg returnUserInformation = null;
            try {
                returnUserInformation = new Gson().fromJson((String) msg.obj, ReturnMsg.class);
                userInformation = returnUserInformation.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (msg.what) {
                case 0:
                    isOnline = true;
                    if (userInformation != null) {
                        Glide.with(context).load(userInformation.getAvatar()).error(R.drawable.ic_error_ic).into(imageView);
                        textView.setText(userInformation.getNickname());
                        List<UserInformation> informations = new CacheManager<>(UserInformation.class).getData(0, 100);
                        boolean isSaved = false;
                        for (UserInformation saved : informations) {
                            if (userInformation.equals(saved)) {
                                saved.updateTo(userInformation);
                                saved.save();
                                isSaved = true;
                                break;
                            }
                        }
                        if (!isSaved) {
                            userInformation.save();
                        }
                    }
                    break;
                case 1:
                    UserNotice.showToast(context, UserNotice.NETWORK_CONNECT_FAILURE);
                    break;
                case 2:
                    UserNotice.showToast(context, UserNotice.USER_AUTHENTICATION_FAILURE);
                    break;
                case 3:
                    netRequest();
                    break;
                case 4:
                    if (returnUserInformation != null)
                        UserNotice.showToast(context, returnUserInformation.getMessage());
                    break;
                default:
                    UserNotice.showToast(context, UserNotice.UNEXPECTED_STATE);
                    break;

            }
            if (!isOnline) {
                if (userId != -1){
                    userInformation = cacheRequest(userId);
                    Glide.with(context).load(userInformation.getAvatar()).error(R.drawable.ic_error_ic).into(imageView);
                    textView.setText(userInformation.getNickname());
                }
            }
            return false;
        }
    });

    public UserInfService(Context context) {
        this.context = context;
    }

    public UserInformation getUserInformation () {
        return userInformation;
    }

    public void getUserInfById(long userId, CircleImageView imageView, TextView textView) {
        new NetworkModule().get("/user/findbyid?id=" + userId, handler, context);
        this.userId = userId;
        this.imageView = imageView;
        this.textView = textView;
    }

    public void getUserInfById(long userId, CircleImageView imageView, TextView textView, UserInformation userInformation) {
        new NetworkModule().get("/user/findbyid?id=" + userId, handler, context);
        this.userId = userId;
        this.imageView = imageView;
        this.textView = textView;
        this.userInformation = userInformation;
    }
    public void getUserInfByNickname(String nickname) {
        new NetworkModule().get("", handler, context);
        this.nickname = nickname;
    }

    private void netRequest() {
        if (userId != -1) {
            new NetworkModule().get("/user/findbyid?id=", handler, context);
        } else if (nickname != null) {
            new NetworkModule().get("", handler, context);
        }
    }

    private UserInformation cacheRequest(long userId) {
        return new CacheManager<>(UserInformation.class).findById(userId);
    }
}
