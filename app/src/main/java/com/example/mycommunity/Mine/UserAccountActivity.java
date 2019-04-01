package com.example.mycommunity.Mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycommunity.JsonEntity.Data;
import com.example.mycommunity.JsonEntity.ReturnMsg;
import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.Login.Login;
import com.example.mycommunity.Mine.UserImg.SelectUserImgActivity;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserAccountActivity extends AppCompatActivity {

    private UserInformation userInformation;
    private EditText nicknameEditText;
    private TextView emailValueText;
    private EditText mottoEditText;
    private EditText genderEditText;
    private EditText phoneEditText;
    private TextView communityValueText;
    private EditText usernameEditText;
    private String json; //用户信息
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Gson gson = new Gson();
            ReturnMsg returnMsg = gson.fromJson(((String) msg.obj), ReturnMsg.class);
            switch (msg.what) {
                case 0:
                    Toast.makeText(UserAccountActivity.this, returnMsg.getMessage(), Toast.LENGTH_SHORT).show();
                    Data data = returnMsg.getData();
                    userInformation.setNickname(data.getNickname());
                    userInformation.setUsername(data.getUsername());
                    userInformation.setIdCard(data.getIdcard());
                    userInformation.setGender(data.getGender());
                    userInformation.setMotto(data.getMotto());
                    userInformation.setEmail(data.getEmail());
                    Login.storageInformation(userInformation, UserAccountActivity.this);
                    break;
                case 1:
                    Toast.makeText(UserAccountActivity.this, "网络连接出现问题", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(UserAccountActivity.this, "身份验证时出现问题", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    NetworkModule.putWithAuthor(
                            "/user/update",
                            json,
                            handler,
                            UserAccountActivity.this
                    );
                    break;
                case 4:
                    Toast.makeText(UserAccountActivity.this, returnMsg.getData().getError(), Toast.LENGTH_SHORT).show();
                    break;

            }
            return false;
        }
    });
    private View.OnClickListener avatarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserAccountActivity.this, SelectUserImgActivity.class);
            startActivity(intent);
        }
    };
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
            if (!nicknameEditText.getText().toString().equals(userInformation.getNickname())){
                userInformation.setNickname(nicknameEditText.getText().toString());
            }
            else {
                userInformation.setNickname(null);
            }
            userInformation.setMotto(mottoEditText.getText().toString());
            userInformation.setGender(genderEditText.getText().toString());
            userInformation.setPhone(phoneEditText.getText().toString());
            //userInformation.setCommunityName(communityEditText.getText().toString());
            userInformation.setUsername(usernameEditText.getText().toString());
            userInformation.setGender(null);
            Gson gson = new GsonBuilder().serializeNulls().create();
            json = gson.toJson(userInformation, UserInformation.class);
            NetworkModule.putWithAuthor(
                    "/user/update",
                    json,
                    handler,
                    UserAccountActivity.this
            );
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
        avatar.setOnClickListener(avatarListener);
        TextView avatarText = avatar.findViewById(R.id.common_text);
        avatarText.setText("头像");
        nicknameEditText = nickname.findViewById(R.id.common_edit);
        nicknameEditText.setText(userInformation.getNickname());
        TextView nicknameText = nickname.findViewById(R.id.common_text);
        nicknameText.setText("昵称");
        emailValueText = email.findViewById(R.id.common_edit);
        emailValueText.setText(userInformation.getEmail());
        emailValueText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        TextView emailText = email.findViewById(R.id.common_text);
        emailText.setText("邮箱");
        TextView mottoText = motto.findViewById(R.id.common_text);
        mottoEditText = motto.findViewById(R.id.common_edit);
        mottoEditText.setText(userInformation.getMotto());
        mottoText.setText("个性签名");
        TextView genderText = gender.findViewById(R.id.common_text);
        genderEditText = gender.findViewById(R.id.common_edit);
        genderEditText.setText(userInformation.getGender());
        genderText.setText("性别");
        TextView phoneText = phone.findViewById(R.id.common_text);
        phoneEditText = phone.findViewById(R.id.common_edit);
        phoneEditText.setText(userInformation.getPhone());
        phoneEditText.setInputType(InputType.TYPE_CLASS_PHONE);
        phoneText.setText("电话");
        TextView communityText = community.findViewById(R.id.common_text);
        communityValueText = community.findViewById(R.id.common_edit);
        communityValueText.setText(userInformation.getCommunityName());
        communityText.setText("社区");
        TextView usernameText = username.findViewById(R.id.common_text);
        usernameEditText = username.findViewById(R.id.common_edit);
        usernameEditText.setText(userInformation.getUsername());
        usernameText.setText("真实姓名");
        TextView passwordText = password.findViewById(R.id.common_text);
        passwordText.setText("修改密码");
        password.setOnClickListener(passwordListener);
        Button modifyButton = findViewById(R.id.user_account_ok);
        modifyButton.setOnClickListener(modifyListener);

    }

}
