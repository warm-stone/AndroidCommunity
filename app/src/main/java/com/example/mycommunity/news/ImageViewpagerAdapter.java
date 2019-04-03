package com.example.mycommunity.news;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class ImageViewpagerAdapter extends PagerAdapter {
    private List<ImageView> images;
    private ViewPager viewPager;


     ImageViewpagerAdapter(List<ImageView> images, ViewPager viewPager) {
        this.images = images;
        this.viewPager = viewPager;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView iv = images.get(position % images.size());
        viewPager.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position,@NonNull Object object) {
        viewPager.removeView(images.get(position % images.size()));

    }
}