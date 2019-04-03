package com.example.mycommunity.News;


import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ImgViewpagerAdapter extends PagerAdapter {
    private List<ImageView> imageViews;
    private ViewPager viewPager;
    public ImgViewpagerAdapter(List<ImageView> imageViews, ViewPager viewPager){
        this.imageViews = imageViews;
        this.viewPager = viewPager;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public int getCount(){
        return 9;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // 把position对应位置的ImageView添加到ViewPager中
        ImageView iv = imageViews.get(position % imageViews.size());
        viewPager.addView(iv);
        // 把当前添加ImageView返回回去.
        return iv;
    }

    @NonNull
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position,@NonNull Object object) {
        // 把ImageView从ViewPager中移除掉
        viewPager.removeView(imageViews.get(position % imageViews.size()));
    }
}
