package com.example.mycommunity.function.forWater;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.example.mycommunity.BaseReturnMsg;
import com.example.mycommunity.MyPopWheel;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.login.Login;
import com.google.gson.Gson;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ForWaterActivity extends AppCompatActivity {
    private EditText phone;
    private EditText address;
    private EditText description;
    private EditText hopeTime;
    private EditText selectBrand;
    private EditText count;
    private WheelView wheelView;
    private TimePickerView timePicker;
    private Date hopeTimeDate;
    private Water selectedWater;
    private Gson gson = new Gson();
    private Handler postInfHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    BaseReturnMsg returnMsg = gson.fromJson((String) msg.obj, BaseReturnMsg.class);
                    Toast.makeText(ForWaterActivity.this, returnMsg.getMessage(), Toast.LENGTH_SHORT).show();
                    finish();
                    break;
                default:
                    Toast.makeText(ForWaterActivity.this, "出现其他错误", Toast.LENGTH_SHORT).show();
            }
            return false;
        }
    });
    private Handler getBrandsHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    ReturnWaterInformation waterInformation = gson.fromJson((String) msg.obj, ReturnWaterInformation.class);
                    final List<Water> waterClasses = waterInformation.getData();
                    if (waterClasses != null) {
                        List<String> brands = new ArrayList<>();
                        for (Water water : waterClasses) {
                            brands.add(water.getBrand());
                        }
                        selectedWater = waterClasses.get(0);

                        wheelView.setAdapter(new ArrayWheelAdapter<>(brands));
                        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(int index) {
                                selectedWater = waterClasses.get(index);
                            }
                        });
                    } else {
                        Toast.makeText(ForWaterActivity.this, "未获取到品牌数据", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 3:
                    requestWaterBrands();
                    break;
                default:
                    Toast.makeText(ForWaterActivity.this, "出现其他错误", Toast.LENGTH_SHORT).show();

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
            List<WaterOrderContent> contents = new ArrayList<>();
            contents.add(new WaterOrderContent(selectedWater.getId(), Integer.valueOf(count.getText().toString())));
            PostWaterOrderInf orderInf = new PostWaterOrderInf();
            orderInf.setPhone(phone.getText().toString());
            orderInf.setAddress(address.getText().toString());
            orderInf.setDescription(description.getText().toString());
            orderInf.setHopeTime(hopeTimeDate.getTime());
            orderInf.setDetailsList(contents);
            requestForWater(orderInf);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_water);
        requestWaterBrands();
        initView();

    }

    private void requestForWater(PostWaterOrderInf orderInf) {
        new NetworkModule().postWithAuthor("/portal/book/water", new Gson().toJson(orderInf), postInfHandler, ForWaterActivity.this);
    }

    private void requestWaterBrands() {
        new NetworkModule().getWithAuthor("/portal/water/brands", getBrandsHandler, ForWaterActivity.this);
    }

    private void initView() {
        phone = findViewById(R.id.for_water_phone);
        address = findViewById(R.id.for_water_address);
        description = findViewById(R.id.for_water_description);
        hopeTime = findViewById(R.id.for_water_hopeTime);
        selectBrand = findViewById(R.id.for_water_select_brand);
        count = findViewById(R.id.for_water_count);
        final MyPopWheel myPopWheel = new MyPopWheel();
        View view = myPopWheel.getSelector();
        wheelView = view.findViewById(R.id.wheel_item_wheel);
        wheelView.setCyclic(false);
        TextView selectCancel = view.findViewById(R.id.wheel_item_select_cancel);
        TextView selectConfirm = view.findViewById(R.id.wheel_item_select_confirm);
        Button confirm = findViewById(R.id.for_water_confirm);
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
        selectBrand.setCursorVisible(false);
        selectBrand.setFocusableInTouchMode(false);
        selectBrand.setFocusable(false);
        selectBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                View view = getWindow().peekDecorView();
                if (null != view) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                myPopWheel.popIn(LayoutInflater.from(ForWaterActivity.this).inflate(R.layout.activity_for_water, null, false));
            }
        });

        timePicker = new TimePickerBuilder(this, timeSelectListener).setDecorView((ViewGroup) getWindow().getDecorView()).build();
        timePicker.setDate(Calendar.getInstance());
        selectCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPopWheel.popOut();
            }
        });
        selectConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPopWheel.popOut();
                selectBrand.setText(selectedWater.getBrand());
            }
        });

    }


    private void test() {
        final List<String> brands = new ArrayList<>();
        brands.add("打发");
        brands.add("打山东发");
        brands.add("打发sdf");
        brands.add("打发");
        brands.add("打发是");
        brands.add("打撒发");
        if (brands.size() != 0) {
            wheelView.setAdapter(new ArrayWheelAdapter<>(brands));
            wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(int index) {
                    Water water = new Water();
                    water.setBrand(brands.get(index));
                    selectedWater = water;
                }
            });
        }
    }


}
