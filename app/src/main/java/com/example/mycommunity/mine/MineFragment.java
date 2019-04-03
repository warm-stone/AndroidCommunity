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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycommunity.login.Login;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MineFragment extends Fragment {

    private Gson gson = new Gson();
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(getContext(), "已退出", Toast.LENGTH_SHORT).show();
            Login.setLoggedIn(getContext(), false);
            return false;
        }
    });
    private View.OnClickListener signOutListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String url = "/logout";
            NetworkModule.postWithAuthor(url, "", handler, getContext());
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
            startActivity(intent);
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
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
        RelativeLayout account = view.findViewById(R.id.mine_account);
        TextView accountText = account.findViewById(R.id.user_information_text);
        accountText.setText("账户");
        account.setOnClickListener(accountListener);
        return view;
    }
}
