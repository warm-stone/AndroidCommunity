package com.example.mycommunity.Mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.Login.Login;
import com.example.mycommunity.R;

public class UserAccountActivity extends AppCompatActivity {

    private UserInformation userInformation;
    private EditText nicknameEditText;
    private EditText mottoEditText;
    private EditText genderEditText;
    private EditText phoneEditText;
    private EditText communityEditText;
    private EditText usernameEditText;
    private View.OnClickListener passwordListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserAccountActivity.this, ResetPasswordActivity.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener modifyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userInformation.setNickname(nicknameEditText.getText().toString());
            userInformation.setMotto(mottoEditText.getText().toString());
            userInformation.setGender(genderEditText.getText().toString());
            userInformation.setPhone(phoneEditText.getText().toString());
            userInformation.setCommunityName(communityEditText.getText().toString());
            userInformation.setUsername(usernameEditText.getText().toString());

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        userInformation = Login.loadInformation(UserAccountActivity.this);
        RelativeLayout avatar = findViewById(R.id.user_account_avatar);
        RelativeLayout nickname = findViewById(R.id.user_account_nickname);
        RelativeLayout email = findViewById(R.id.user_account_email);
        RelativeLayout motto = findViewById(R.id.user_account_motto);
        RelativeLayout gender = findViewById(R.id.user_account_gender);
        RelativeLayout phone = findViewById(R.id.user_account_phone);
        RelativeLayout community = findViewById(R.id.user_account_community_id);
        RelativeLayout username = findViewById(R.id.user_account_username);
        RelativeLayout password = findViewById(R.id.user_account_password);
        TextView avatarText = avatar.findViewById(R.id.common_text);
        avatarText.setText("头像");
        nicknameEditText = nickname.findViewById(R.id.common_edit);
        TextView nicknameText = nickname.findViewById(R.id.common_text);
        nicknameText.setText("昵称");
        nicknameEditText.setText(userInformation.getNickname());
        TextView emailText = email.findViewById(R.id.common_text);
        emailText.setText("邮箱");
        TextView mottoText = motto.findViewById(R.id.common_text);
        mottoEditText = motto.findViewById(R.id.common_edit);
        mottoText.setText("个性签名");
        TextView genderText = gender.findViewById(R.id.common_text);
        genderEditText = gender.findViewById(R.id.common_edit);
        genderText.setText("性别");
        TextView phoneText = phone.findViewById(R.id.common_text);
        phoneEditText = phone.findViewById(R.id.common_edit);
        phoneText.setText("电话");
        TextView communityText = community.findViewById(R.id.common_text);
        communityEditText = community.findViewById(R.id.common_edit);
        communityText.setText("社区");
        TextView usernameText = username.findViewById(R.id.common_text);
        usernameEditText = username.findViewById(R.id.common_edit);
        usernameText.setText("真实姓名");
        TextView passwordText = password.findViewById(R.id.common_text);
        passwordText.setText("修改密码");
        password.setOnClickListener(passwordListener);
        Button modifyButton = findViewById(R.id.user_account_ok);
        modifyButton.setOnClickListener(modifyListener);

    }

}
