package com.example.mycommunity.function.repair;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.mycommunity.BaseReturnMsg;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.example.mycommunity.login.Login;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class RepairActivity extends AppCompatActivity {

    private EditText phone;
    private EditText address;
    private EditText description;
    private EditText hopeTime;
    private TimePickerView timePicker;
    private Date hopeTimeDate;
    private RepairInformation information;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            BaseReturnMsg returnMsg = new Gson().fromJson((String) msg.obj, BaseReturnMsg.class);
            switch (msg.what) {
                case 0:
                    UserNotice.showToast(RepairActivity.this, returnMsg.getMessage());
                    finish();
                    break;
                case 3:
                    netRequest();
                    break;
                default:
                    UserNotice.showToast(RepairActivity.this, UserNotice.UNEXPECTED_STATE);
            }
            return false;
        }
    });
    private OnTimeSelectListener timeSelectListener = new OnTimeSelectListener() {
        @Override
        public void onTimeSelect(Date date, View v) {
            hopeTimeDate = date;
            hopeTime.setText(
                    DateFormat.getDateInstance(2).format(date));
        }
    };
    private View.OnClickListener confirmListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            information = new RepairInformation();
            information.setTelephone(phone.getText().toString());
            information.setAddress(address.getText().toString());
            information.setDescription(description.getText().toString());
            information.setHopeTime(hopeTimeDate.getTime());
            netRequest();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair);
        initView();
    }

    private void netRequest() {
        new NetworkModule().post("/portal/book/repair", new Gson().toJson(information), handler, RepairActivity.this);
    }

    private void initView() {
        phone = findViewById(R.id.repair_phone);
        address = findViewById(R.id.repair_address);
        description = findViewById(R.id.repair_description);
        hopeTime = findViewById(R.id.repair_hopeTime);
        Button confirm = findViewById(R.id.repair_confirm);
        confirm.setOnClickListener(confirmListener);
        phone.setText(Login.getPhone(this));
        hopeTime.setCursorVisible(false);
        hopeTime.setFocusable(false);
        hopeTime.setFocusableInTouchMode(false);
        hopeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                View view = getWindow().peekDecorView();
                if (null != view) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                timePicker.show();
            }
        });
        timePicker = new TimePickerBuilder(this, timeSelectListener).build();
        timePicker.setDate(Calendar.getInstance());
    }
}
