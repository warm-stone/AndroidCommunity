package com.example.mycommunity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.Login.Login;

public class UserAccountActivity extends AppCompatActivity {

    UserInformation userInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        userInformation = Login.loadInformation(UserAccountActivity.this);
        RelativeLayout nickname = findViewById(R.id.user_account_nickname);
        TextView nicknameText = nickname.findViewById(R.id.common_text);
        EditText nicknameEditText = nickname.findViewById(R.id.common_edit);
        nicknameText.setText("昵称");
        nicknameEditText.setText(userInformation.getNickname());

    }
}
