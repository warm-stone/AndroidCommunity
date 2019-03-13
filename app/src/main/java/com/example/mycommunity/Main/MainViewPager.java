package com.example.mycommunity.Main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MainViewPager extends ViewPager {
     boolean scrollAble = false;

    public MainViewPager(@NonNull Context context){
        super(context);
    }
    public MainViewPager(@NonNull Context context, @Nullable AttributeSet attr){
        super(context,attr);
    }

    public void setScrollAble (boolean scrollAble){
        this.scrollAble = scrollAble;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return scrollAble;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev){
        return scrollAble;
    }
}
