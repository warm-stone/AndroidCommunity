package com.example.mycommunity;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class MyPopWheel {
    private View v;
    private PopupWindow popupWindow;
    private Context context;
    private Activity activity;

    public PopupWindow popWindow(Context context) {
        activity = (Activity) context;
        this.context = context;
        v = LayoutInflater.from(context).inflate(R.layout.wheel_item_layout, null, false);
        popupWindow = new PopupWindow(v, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setAnimationStyle(R.style.animTranslate);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
                lp.alpha = 1f;
                activity.getWindow().setAttributes(lp);
            }
        });
        return popupWindow;
    }

    public View getSelector() {
        return v;
    }

    private void addBackground() {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        lp.alpha = 0.7f;
        activity.getWindow().setAttributes(lp);
    }

    public void popIn(View contentView) {
        popupWindow.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);
        addBackground();
    }
    public void popOut(){
        popupWindow.dismiss();
    }
}
