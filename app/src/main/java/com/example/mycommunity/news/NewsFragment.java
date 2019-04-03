package com.example.mycommunity.news;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mycommunity.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private ViewPager hotNewsViewPager;
    private ViewPager newsViewPager;
    private TabLayout newsTabLayout;
    private NewsPagerAdapter newsPagerAdapter;
    private List<Fragment> fragments = new ArrayList<>();
    private ImageView imageView;
    private String[] tabString = new String[]{"社区头条", "社区公告", "物业公告"};
    private Handler hotNewsHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Gson gson = new Gson();
                    ReturnRotationchar returnRotationchar = gson.fromJson((String) msg.obj, ReturnRotationchar.class);
                    List<RotationCharData> rotationCharData = returnRotationchar.getData();
                    List<ImageView> imageViews = new ArrayList<ImageView>();
                    for (RotationCharData data : rotationCharData) {
                        data = rotationCharData.get(0);
                        int i = 0;
                        imageView = new ImageView(getContext());
                        Glide.with(getContext()).load(data.getImageUrl()).into(imageView);
                        imageViews.add(i, imageView);
                    }
                    ImageViewpagerAdapter adapter = new ImageViewpagerAdapter(imageViews, hotNewsViewPager);
                    hotNewsViewPager.setAdapter(adapter);
                    break;
                case 1:
            }
            return false;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_layout, container, false);
        initView(view);
        netRequest();
        return view;
    }

    private void netRequest() {
        //请求轮播图
        // NetworkModule.getWithAuthor("/portal/carousal", hotNewsHandler, getContext());
    }

    private void initView(View view) {
        hotNewsViewPager = view.findViewById(R.id.hot_show_view_pager);
        newsTabLayout = view.findViewById(R.id.news_tab_layout);
        newsViewPager = view.findViewById(R.id.news_view_pager);
        fragments.add(0, new NewsRecycleViewFragment());
        fragments.add(1, new NewsRecycleViewFragment());
        fragments.add(2, new NewsRecycleViewFragment());
        newsPagerAdapter = new NewsPagerAdapter(getFragmentManager(), fragments);
        newsViewPager.setAdapter(newsPagerAdapter);
        for (int i = 0; i < 3; i ++){

            newsTabLayout.addTab(newsTabLayout.newTab());
        }
        newsTabLayout.setupWithViewPager(newsViewPager, false);
        for (int i = 0; i < 3; i ++) {
            newsTabLayout.getTabAt(i).setText(tabString[i]);
        };

    }
}