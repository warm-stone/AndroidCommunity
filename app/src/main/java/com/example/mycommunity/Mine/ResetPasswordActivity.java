package com.example.mycommunity.Mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mycommunity.JsonEntity.UserInformation;
import com.example.mycommunity.R;

public class ResetPasswordActivity extends AppCompatActivity {

    private UserInformation information = new UserInformation();
    private View.OnClickListener resetPasswordButton = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        EditText rawPassword = findViewById(R.id.reset_password_raw);
        EditText newPassword = findViewById(R.id.reset_password_new);
        EditText confirmPassword = findViewById(R.id.reset_password_confirm);
        Button resetButton = findViewById(R.id.reset_password_button);
        resetButton.setOnClickListener(resetPasswordButton);
    }
}
