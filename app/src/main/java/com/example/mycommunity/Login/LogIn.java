package com.example.mycommunity.Login;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycommunity.R;
import com.example.mycommunity.JsonEntity.UserInformation;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class LogIn extends AppCompatActivity {

    private EditText userIdEditText;
    private EditText passWordEditText;
    private UserInformation userInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ActionBar actionbar = getSupportActionBar();
        if(actionbar != null){
            actionbar.hide();
        }
        userIdEditText = findViewById(R.id.user_id);
        passWordEditText = findViewById(R.id.password);
        final ProgressBar progressBar = findViewById(R.id.check_information);
        Button login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userId = userIdEditText.getText().toString();
                final String passWord = passWordEditText.getText().toString();
                if (userId == null || passWord == null) {
                    Toast.makeText(LogIn.this, "请输入用户名和密码", Toast.LENGTH_SHORT);
                } else {
                    userInformation = new UserInformation(userId, passWord);
                    progressBar.setVisibility(View.VISIBLE);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            HttpURLConnection connection = null;
                            BufferedReader reader = null;
                            try {
                                URL url = null;
                                String urlHolder = null ;
                                urlHolder = "http://47.95.244.237:9990/chengfeng/per/login?" + "password=" +passWord + "&" +
                                "username=" + userId;

                                url = new URL(urlHolder);
                                connection = (HttpURLConnection) url.openConnection();
                                connection.setRequestMethod("POST");
                                connection.setConnectTimeout(8000);
                                connection.setReadTimeout(8000);
                                InputStream in = connection.getInputStream();
                                reader = new BufferedReader(new InputStreamReader(in));
                                StringBuilder builder = new StringBuilder();
                                String response;
                                while ((response = reader.readLine()) != null) {
                                    builder.append(response);
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            } finally {
                                if (reader != null) {
                                    try {
                                        reader.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (connection != null)
                                    connection.disconnect();
                            }
                        }
                    }).start();



                }
            }
        });

        //忘记密码
        TextView forget_pass_word = findViewById(R.id.forget_pass_word);
        forget_pass_word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, ForgetPassWord.class);
                startActivity(intent);
            }
        });

        //注册账户
        TextView register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, RegisterActivity.class);
                finish();
                startActivity(intent);
            }
        });

    }
}
