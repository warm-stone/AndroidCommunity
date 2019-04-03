package com.example.mycommunity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.mycommunity.jsonEntity.UserInformation;
import com.example.mycommunity.login.Login;

public class test extends AppCompatActivity {

    UserInformation userInformation = new UserInformation("1234","1234567");
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button  = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button_2);

        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener2);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Login.storagePassword(userInformation,test.this);

        }
    };
    View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

}
