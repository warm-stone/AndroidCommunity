package com.example.mycommunity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycommunity.JsonEntity.ReturnMsg;
import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passWordEditText;
    private EditText passWordConfirmText;
    private EditText phoneEditText;
    private EditText communityIdText;
    private UserInformation userInformation = new UserInformation();
    private Gson gson = new Gson();

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (passWordEditText.getText().toString().isEmpty() || userNameEditText.getText().toString().isEmpty()) {
                Toast.makeText(RegisterActivity.this, "请输入用户名和密码", Toast.LENGTH_SHORT).show();
            } else if (phoneEditText.getText().toString().isEmpty()) {
                Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
            } else if (!passWordEditText.getText().toString().equals(passWordConfirmText.getText().toString())) {
                Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            } else {
                userInformation.setNickname(userNameEditText.getText().toString());
                userInformation.setPassword(passWordEditText.getText().toString());
                userInformation.setPhone(phoneEditText.getText().toString());
                final String json = gson.toJson(userInformation);
                String url = "/user/registry";
                NetworkModule.post(url, json, new Callback() {
                    @Override
                    public void onFailure(Call call, final IOException e) {
                        Log.w("test", e.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        final ReturnMsg returnMsg = gson.fromJson(response.body().string(), ReturnMsg.class);
                        if (returnMsg.getStatus() == 10001) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Login.storageInformation(userInformation, RegisterActivity.this);
                                    Login.login(loginCallback, RegisterActivity.this);
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this, returnMsg.getData().getError(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }
                });
            }
        }
    };

    private Callback loginCallback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.w("test", e.toString());
            Log.w("test", "登录返回错误");
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            final ReturnMsg returnMsg = gson.fromJson(response.body().string(), ReturnMsg.class);
            if (returnMsg.getStatus() == 10001) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(RegisterActivity.this, "已登录", Toast.LENGTH_SHORT).show();
                    }
                });
                Login.storageAuthorization(returnMsg.getData().getAuthorization(), RegisterActivity.this);
                finish();
            }
        }

    };


    private View.OnClickListener forCommunity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(RegisterActivity.this, CommunityListActivity.class);
            startActivityForResult(intent, 25);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 25:
                    Data data1 = (Data) data.getSerializableExtra("data");
                    communityIdText.setText(data1.getName());
                    userInformation.setCommunityId(data1.getId());
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userNameEditText = findViewById(R.id.register_user_name);
        passWordEditText = findViewById(R.id.register_password);
        passWordConfirmText = findViewById(R.id.register_password_confirm);
        phoneEditText = findViewById(R.id.register_phone_number);
        communityIdText = findViewById(R.id.register_community_id);
        communityIdText.setCursorVisible(false);
        communityIdText.setFocusable(false);
        communityIdText.setFocusableInTouchMode(false);
        communityIdText.setOnClickListener(forCommunity);
        Button registerButton = findViewById(R.id.register_information_button);
        registerButton.setOnClickListener(onClickListener);

    }
}
