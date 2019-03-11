package com.example.mycommunity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;

public class RegisterActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passWordEditText;
    private EditText passWordConfirmText;
    private EditText phoneEditText;
    private static String url = "http://47.95.244.237:9990/chengfeng/per/registry";
    private Button registerButton;
    private UserInformation userInformation;
    private String json;
    private Gson gson;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(passWordEditText.getText().toString().isEmpty()||userNameEditText.getText().toString().isEmpty()){
                Toast.makeText(RegisterActivity.this,"请输入用户名和密码",Toast.LENGTH_SHORT).show();
            }
            else if(phoneEditText.getText().toString().isEmpty()){
                Toast.makeText(RegisterActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
            }
            else if(passWordEditText.equals(passWordConfirmText)){
                Toast.makeText(RegisterActivity.this,"两次密码输入不一致",Toast.LENGTH_SHORT).show();
            }
            else {
                userInformation = new UserInformation(
                        userNameEditText.toString(),
                        passWordEditText.toString(),
                        passWordConfirmText.toString());
                json = gson.toJson(userInformation);
                NetworkModule.post(url, json, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.w("失败",e.toString());
                        Toast.makeText(RegisterActivity.this,e.toString(),Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.w("成功",response.body().string());
                        Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT);
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
        registerButton = findViewById(R.id.register_information_button);
        registerButton.setOnClickListener(onClickListener);

    }
}
