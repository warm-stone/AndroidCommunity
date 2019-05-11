package com.example.mycommunity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.jsonEntity.ReturnMsg;
import com.example.mycommunity.jsonEntity.UserInformation;
import com.example.mycommunity.mine.ReturnUserInformation;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class LoginActivity extends AppCompatActivity {

    private EditText userIdEditText;
    private EditText passWordEditText;
    private ProgressBar progressBar;
    private Gson gson = new Gson();
    private UserInformation userInformation;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            if (message.what == 0) {
                ReturnMsg returnMsg = (ReturnMsg) message.obj;
                switch (returnMsg.getStatus()) {
                    case 10001:
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Login.storageAuthorization(returnMsg.getData().getAuthorization(), LoginActivity.this);
                        userInformation = new UserInformation(userIdEditText.getText().toString(), passWordEditText.getText().toString());
                        Login.storagePassword(userInformation, LoginActivity.this);
                        new NetworkModule().get("/user/find", findInfHandler, LoginActivity.this);
                        break;
                    default:
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast.makeText(LoginActivity.this, returnMsg.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(LoginActivity.this, "请检查网络后再试", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    private Handler findInfHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    ReturnUserInformation information = gson.fromJson((String) msg.obj, ReturnUserInformation.class);
                    UserInformation base_info = information.getData().getBase_info();
                    userInformation.setId(base_info.getId());
                    userInformation.setCommunityId(base_info.getCommunityId());
                    Login.storageInformation(userInformation, LoginActivity.this);
                    finish();
                    break;
                default:
                    Toast.makeText(LoginActivity.this, "未定义的错误", Toast.LENGTH_SHORT).show();
                    finish();
            }
            return false;
        }
    });
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            UserInformation userInformation;
            userInformation = new UserInformation();
            userInformation.setNickname(userIdEditText.getText().toString());
            userInformation.setPassword(passWordEditText.getText().toString());
            login(userInformation);
        }
    };

    public void login(UserInformation userInformation) {
        String url = "/user/login";
        progressBar.setVisibility(View.VISIBLE);
        NetworkModule.postForm(url, userInformation, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.w("test", e.toString());
                Message message = handler.obtainMessage(1);
                handler.sendMessage(message);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String temp = response.body().string();
                ReturnMsg returnMsg = gson.fromJson(temp, ReturnMsg.class);
                Message message = handler.obtainMessage(0, returnMsg);
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        userIdEditText = findViewById(R.id.user_id);
        passWordEditText = findViewById(R.id.password);
        progressBar = findViewById(R.id.check_information);
        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(onClickListener);
        if (Login.isRemember(LoginActivity.this)) {
            UserInformation userInformation = Login.loadPassword(LoginActivity.this);
            userIdEditText.setText(userInformation.getNickname());
            passWordEditText.setText(userInformation.getPassword());
        }
        //忘记密码
        TextView forget_pass_word = findViewById(R.id.forget_pass_word);
        forget_pass_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetPassWord.class);
                startActivity(intent);
            }
        });

        //注册账户
        TextView register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }
}
