package com.example.mycommunity.Community.Mine;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.Login.Login;
import com.example.mycommunity.R;

public class UserAccountActivity extends AppCompatActivity {

    private UserInformation userInformation;
    private View.OnClickListener passwordListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserAccountActivity.this, ResetPasswordActivity.class);
            startActivity(intent);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        userInformation = Login.loadInformation(UserAccountActivity.this);
        RelativeLayout avatar = findViewById(R.id.user_account_avatar);
        RelativeLayout nickname = findViewById(R.id.user_account_nickname);
        RelativeLayout motto = findViewById(R.id.user_account_motto);
        RelativeLayout gender = findViewById(R.id.user_account_gender);
        RelativeLayout phone = findViewById(R.id.user_account_phone);
        RelativeLayout community = findViewById(R.id.user_account_community_id);
        RelativeLayout username = findViewById(R.id.user_account_username);
        RelativeLayout password = findViewById(R.id.user_account_password);
        TextView avatarText = avatar.findViewById(R.id.common_text);
        avatarText.setText("头像");
        EditText nicknameEditText = nickname.findViewById(R.id.common_edit);
        TextView nicknameText = nickname.findViewById(R.id.common_text);
        nicknameText.setText("昵称");
        nicknameEditText.setText(userInformation.getNickname());
        TextView mottoText = motto.findViewById(R.id.common_text);
        mottoText.setText("个性签名");
        TextView genderText = gender.findViewById(R.id.common_text);
        genderText.setText("性别");
        TextView phoneText = phone.findViewById(R.id.common_text);
        phoneText.setText("电话");
        TextView communityText = community.findViewById(R.id.common_text);
        communityText.setText("社区");
        TextView usernameText = username.findViewById(R.id.common_text);
        usernameText.setText("真实姓名");
        TextView passwordText = password.findViewById(R.id.common_text);
        passwordText.setText("修改密码");
        password.setOnClickListener(passwordListener);

    }

}
