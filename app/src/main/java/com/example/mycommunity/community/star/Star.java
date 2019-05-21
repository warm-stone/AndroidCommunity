package com.example.mycommunity.community.star;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.example.mycommunity.community.CommunityPost;
import com.example.mycommunity.community.collect.ReturnCollectionMsg;
import com.example.mycommunity.community.postDetail.commonPost.ReturnFollowMsg;
import com.example.mycommunity.userInf.UserActivityInf;
import com.example.mycommunity.userInf.UserInformation;
import com.google.gson.Gson;

import java.util.List;

public class Star {

    private Context context;
    private ImageView imageView;
    private TextView textView;
    private CommunityPost postHolder = null;
    private UserInformation userHolder = null;
    private Handler defaultHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            String s = null;
            return false;
        }
    });
    private Handler followHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            ReturnFollowMsg returnFollowMsg = null;
            try {
                returnFollowMsg = new Gson().fromJson((String) msg.obj, ReturnFollowMsg.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean isFollowed = true;
            switch (msg.what) {
                case 0:
                    if (returnFollowMsg != null) {
                        UserActivityInf activityInf = returnFollowMsg.getData();
                        List<String> followings = activityInf.getFollowings();
                        for (String following : followings) {
                            if (userHolder.getNickname().equals(following)) {
                                isFollowed = true;
                                break;
                            } else {
                                isFollowed = false;
                            }
                        }
                        if (!isFollowed) {
                            new NetworkModule().post("/news/follow/poster/" + userHolder.getNickname(), "", new Handler(this), context);
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    UserNotice.showToast(context, "已关注");
                                }
                            });
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
                    new NetworkModule().post("/news/collect/" + postHolder.getIdx(), "", new Handler(this), context);
                    break;
                case 4:
                    if (returnFollowMsg != null)
                        UserNotice.showToast(context, returnFollowMsg.getMessage());
                    break;
                default:
                    UserNotice.showToast(context, UserNotice.UNEXPECTED_STATE);
            }
            return false;
        }
    });
    private Handler starHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            ReturnCollectionMsg collectionMsg = null;
            try {
                collectionMsg = new Gson().fromJson((String) msg.obj, ReturnCollectionMsg.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean isCollected = true;
            switch (msg.what) {
                case 0:
                    if (collectionMsg != null) {
                        if (imageView.getDrawable().getCurrent().getConstantState() == context.getResources().getDrawable(R.drawable.ic_heart).getConstantState()) {
                            if (collectionMsg.getData() != null && collectionMsg.getData().getCollectNews() != null)
                                for (CommunityPost post : collectionMsg.getData().getCollectNews())
                                    if (post.getIdx() == postHolder.getIdx()) {
                                        ((Activity) context).runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (textView != null && imageView != null) {
                                                    textView.setText(String.valueOf(Integer.valueOf(textView.getText().toString()) + 1));
                                                    imageView.setImageResource(R.drawable.ic_red_heart);
                                                }
                                            }
                                        });
                                        isCollected = true;
                                        break;
                                    } else {
                                        isCollected = false;
                                    }
                            else isCollected = false;
                            if (!isCollected) {
                                new NetworkModule().post("/news/collect/" + postHolder.getIdx(), "", defaultHandler, context);
                                ((Activity) context).runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        UserNotice.showToast(context, "您已收藏");
                                        imageView.setImageResource(R.drawable.ic_red_heart);
                                    }
                                });
                            }
                        } else {
                            ((Activity) context).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(String.valueOf(Integer.valueOf(textView.getText().toString()) - 1));
                                    imageView.setImageResource(R.drawable.ic_heart);
                                }
                            });
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
                    new NetworkModule().post("/news/collect/" + postHolder.getIdx(), "", new Handler(this), context);
                    break;
                case 4:
                    if (collectionMsg != null)
                        UserNotice.showToast(context, collectionMsg.getMessage());
                    break;
                default:
                    UserNotice.showToast(context, UserNotice.UNEXPECTED_STATE);
            }
            return false;
        }
    });


    public Star(Context context, UserInformation userInformation) {
        this.context = context;
        userHolder = userInformation;
    }

    public Star(Context context, ImageView imageView, TextView textView, CommunityPost postHolder) {
        this.context = context;
        this.imageView = imageView;
        this.textView = textView;
        this.postHolder = postHolder;
    }


    public Handler getFollowHandler() {
        return followHandler;
    }

    public Handler getStarHandler() {
        return starHandler;
    }
}
