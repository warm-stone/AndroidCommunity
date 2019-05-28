package com.example.mycommunity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.mycommunity.login.Login;
import com.example.mycommunity.login.LoginActivity;
import com.example.mycommunity.main.MainCommunity;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView() {
        TextView textView = findViewById(R.id.welcome_text);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = null;
                if (Login.isLoggedIn(WelcomeActivity.this)){
                    intent = new Intent(WelcomeActivity.this, MainCommunity.class);
                } else {
                    intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        };

        timer.schedule(task, 2000);
    }
}
