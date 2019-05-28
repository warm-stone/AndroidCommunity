package com.example.mycommunity.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.example.mycommunity.jsonEntity.UserInformation;
import com.example.mycommunity.login.Login;
import com.google.gson.Gson;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;

public class MineFragment extends Fragment {

    private static final int ACCOUNT = 234;
    private Gson gson = new Gson();
    private CircleImageView userImg;
    private ImageView background;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            UserNotice.showToast(getContext(), "退出成功");
            Login.setLoggedIn(getContext(), false);
            return false;
        }
    });

    private Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            ((Activity) getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    UserNotice.showToast(getContext(), UserNotice.UNEXPECTED_STATE);
                }
            });
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            ((Activity) getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    UserNotice.showToast(getContext(), "已退出");
                }
            });
            Login.setLoggedIn(getContext(), false);
        }
    };

    private View.OnClickListener informationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private View.OnClickListener accountListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getContext(), UserAccountActivity.class);
            startActivityForResult(intent, ACCOUNT);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_layout, container, false);
        userImg = view.findViewById(R.id.user_img_user_ic);
        background = view.findViewById(R.id.user_img_background);
        if (getContext() != null) {
            UserInformation userInformation = Login.loadInformation(getContext());
            if (userInformation.getAvatar() != null && !userInformation.getAvatar().equals(""))
                Glide.with(this).load(userInformation.getAvatar()).into(userImg);
            if (Login.getBackground(getContext()) != null && !Login.getBackground(getContext()).equals(""))
                Glide.with(this).load(Login.getBackground(getContext())).into(background);
        }
        RelativeLayout signOut = view.findViewById(R.id.mine_sign_out);
        TextView signOutText = signOut.findViewById(R.id.user_information_text);
        RelativeLayout message = view.findViewById(R.id.mine_message);
        TextView messageText = message.findViewById(R.id.user_information_text);
        RelativeLayout information = view.findViewById(R.id.mine_information);
        TextView informationText = information.findViewById(R.id.user_information_text);
        signOutText.setText("退出");
        signOutText.setTextColor(getResources().getColor(R.color.red));
        //informationText.setText("个人信息");
        //messageText.setText("消息");
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "/logout";
                new NetworkModule().post(url, "", handler, getContext());
            }
        });
        RelativeLayout account = view.findViewById(R.id.mine_account);
        TextView accountText = account.findViewById(R.id.user_information_text);
        accountText.setText("账户");
        account.setOnClickListener(accountListener);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case ACCOUNT:
                if (resultCode == RESULT_OK) {
                    UserInformation userInformation = Login.loadInformation(getContext());
                    if (getContext() != null) {
                        if (userInformation.getAvatar() != null && !userInformation.getAvatar().equals(""))
                            Glide.with(getContext()).load(userInformation.getAvatar()).into(userImg);
                        if (Login.getBackground(getContext()) != null && !Login.getBackground(getContext()).equals(""))
                            Glide.with(getContext()).load(Login.getBackground(getContext())).into(background);
                    }
                }
                break;
        }

    }
}
