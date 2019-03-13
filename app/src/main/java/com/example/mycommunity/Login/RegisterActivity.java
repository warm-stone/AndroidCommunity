package com.example.mycommunity.Login;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mycommunity.Main.MainCommunity;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.JsonEntity.ReturnMsg;
import com.example.mycommunity.JsonEntity.UserInformation;
import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passWordEditText;
    private EditText passWordConfirmText;
    private EditText phoneEditText;
    private Gson gson = new Gson();
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(passWordEditText.getText().toString().isEmpty()||userNameEditText.getText().toString().isEmpty()){
                Toast.makeText(RegisterActivity.this,"请输入用户名和密码",Toast.LENGTH_SHORT).show();
            }
            else if(phoneEditText.getText().toString().isEmpty()){
                Toast.makeText(RegisterActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
            }
            else if(!passWordEditText.getText().toString().equals(passWordConfirmText.getText().toString())){
                Toast.makeText(RegisterActivity.this,"两次密码输入不一致",Toast.LENGTH_SHORT).show();
            }
            else {
                UserInformation userInformation = new UserInformation(
                        userNameEditText.getText().toString(),
                        passWordEditText.getText().toString(),
                        phoneEditText.getText().toString());

                final String json = gson.toJson(userInformation);
                NetworkModule.post("http://47.95.244.237:9990/chengfeng/per/registry", json, new Callback() {
                    @Override
                    public void onFailure(Call call,final IOException e) {
                        Log.w("失败",e.toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this,e.toString(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        final ReturnMsg returnMsg = gson.fromJson(response.body().string(),ReturnMsg.class);
                        if(returnMsg.getStatus() == 10001){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,returnMsg.getMessage(),Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            });
                        }
                        else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterActivity.this,returnMsg.getData().getExceptionMsg(),Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }
                });
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userNameEditText = findViewById(R.id.register_user_name);
        passWordEditText = findViewById(R.id.register_password);
        passWordConfirmText = findViewById(R.id.register_password_confirm);
        phoneEditText = findViewById(R.id.register_phone_number);
        Button registerButton = findViewById(R.id.register_information_button);
        registerButton.setOnClickListener(onClickListener);

    }
}
