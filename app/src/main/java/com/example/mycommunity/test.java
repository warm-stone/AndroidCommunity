package com.example.mycommunity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;

import java.util.ArrayList;
import java.util.List;

public class test extends AppCompatActivity {

    WheelView wheelView;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button_2);

        button.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener2);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            popWindow();
        }
    };
    View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    private void popWindow() {
        View v = LayoutInflater.from(this).inflate(R.layout.wheel_item_layout, null, false);
        wheelView = v.findViewById(R.id.wheel_item_wheel);
        PopupWindow popupWindow = new PopupWindow(v, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        test();
        popupWindow.setAnimationStyle(R.style.animTranslate);
        popupWindow.showAtLocation( LayoutInflater.from(this).inflate(R.layout.activity_test, null, false), Gravity.BOTTOM, 0, 0);
        this.popupWindow = popupWindow;
        addBackground();
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
            wheelView.setAdapter(new ArrayWheelAdapter(brands));
            wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
                @Override
                public void onItemSelected(int index) {
                }
            });
        }
    }
    private void addBackground() {
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        lp.alpha = 0.7f;//调节透明度
        getWindow().setAttributes(lp);
        //dismiss时恢复原样
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }
}
