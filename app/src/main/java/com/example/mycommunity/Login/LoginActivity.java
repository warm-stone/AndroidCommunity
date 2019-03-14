package com.example.mycommunity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
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


public class LoginActivity extends AppCompatActivity {

    private static String url = "http://47.95.244.237:9990/chengfeng/per/login";
    private EditText userIdEditText;
    private EditText passWordEditText;
    private ProgressBar progressBar;
    private Gson gson = new Gson();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message message) {
            super.handleMessage(message);
            ReturnMsg returnMsg = (ReturnMsg) message.obj;
            switch (returnMsg.getStatus()) {
                case 10003:
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                default:
                    progressBar.setVisibility(View.INVISIBLE);
                    Toast.makeText(LoginActivity.this, returnMsg.getData().getExceptionMsg(), Toast.LENGTH_SHORT).show();
            }

        }
    };
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            UserInformation userInformation = new UserInformation();
            userInformation = new UserInformation();
            userInformation.setUsername(userIdEditText.getText().toString());
            userInformation.setPassword(passWordEditText.getText().toString());
            login(userInformation);
        }
    };

    public void login(UserInformation userInformation) {
        progressBar.setVisibility(View.VISIBLE);
        NetworkModule.postForm(url, userInformation, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.w("test", e.toString());
                Toast.makeText(LoginActivity.this, "shibai", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ReturnMsg returnMsg = gson.fromJson(response.body().string(), ReturnMsg.class);
                Message message = handler.obtainMessage(0, returnMsg);
                handler.sendMessage(message);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.hide();
        }
        userIdEditText = findViewById(R.id.user_id);
        passWordEditText = findViewById(R.id.password);
        progressBar = findViewById(R.id.check_information);
        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(onClickListener);

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
