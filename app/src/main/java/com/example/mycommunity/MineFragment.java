package com.example.mycommunity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.Login.Login;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MineFragment extends Fragment {

    private Gson gson = new Gson();
    private View.OnClickListener signOutListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            UserInformation userInformation = new UserInformation();
            userInformation.setAuthorization(Login.getAuthorization(getContext()));
            String url = "http://192.168.123.50:8585/chengfeng/logout";
            NetworkModule.post(url, gson.toJson(userInformation), callback);
        }
    };

    private Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            ((Activity)getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), "预期之外的错误", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            ((Activity)getContext()).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getContext(), "已退出", Toast.LENGTH_SHORT).show();
                }
            });
        }
    };

    private View.OnClickListener informationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savadInstanceState){
        View view = inflater.inflate(R.layout.mine_layout, container, false);
        RelativeLayout signOut = view.findViewById(R.id.mine_sign_out);
        TextView signOutText = signOut.findViewById(R.id.user_information_text);
        RelativeLayout message = view.findViewById(R.id.mine_message);
        TextView messageText = message.findViewById(R.id.user_information_text);
        RelativeLayout information = view.findViewById(R.id.mine_information);
        TextView informationText = information.findViewById(R.id.user_information_text);
        signOutText.setText("退出");
        signOutText.setTextColor(getResources().getColor(R.color.red));
        informationText.setText("个人信息");
        messageText.setText("消息");
        signOut.setOnClickListener(signOutListener);
        return view;
    }
}
