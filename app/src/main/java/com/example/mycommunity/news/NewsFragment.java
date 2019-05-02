package com.example.mycommunity.news;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.example.mycommunity.news.communityNotice.CommunityNoticeRecyclerViewFragment;
import com.example.mycommunity.news.headLine.NewsRecycleViewFragment;
import com.example.mycommunity.news.popertyNotice.PropertyNoticeFragment;
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
            String s = (String) msg.obj;
            try {

                ReturnRotationchar returnRotationchar = new Gson().fromJson((String) msg.obj, ReturnRotationchar.class);
                switch (msg.what) {
                    case 0:
                        List<RotationCharData> rotationCharData = returnRotationchar.getData();
                        List<ImageView> imageViews = new ArrayList<>();
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
                        UserNotice.showToast(getContext(), UserNotice.NETWORK_CONNECT_FAILURE);
                        break;
                    case 2:
                        UserNotice.showToast(getContext(), UserNotice.USER_AUTHENTICATION_FAILURE);
                        break;
                    case 3:
                        netRequest();
                        break;
                    case 4:
                        UserNotice.showToast(getContext(), returnRotationchar.getMessage());
                        break;
                    case 5:
                        UserNotice.showToast(getContext(), UserNotice.UNEXPECTED_STATE);
                        break;
                }
            } catch (Exception e) {
                UserNotice.showToast(getContext(), UserNotice.UNFORMATTED_DATA);
                e.printStackTrace();
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
        new NetworkModule().get("/portal/carousal", hotNewsHandler, getContext());
    }

    private void initView(View view) {
        hotNewsViewPager = view.findViewById(R.id.hot_show_view_pager);
        newsTabLayout = view.findViewById(R.id.news_tab_layout);
        newsViewPager = view.findViewById(R.id.news_view_pager);
        final SwipeRefreshLayout refreshLayout = view.findViewById(R.id.news_refresh_layout);
        final NewsRecycleViewFragment newsFragment = new NewsRecycleViewFragment();
        final CommunityNoticeRecyclerViewFragment communityFragment = new CommunityNoticeRecyclerViewFragment();
        final PropertyNoticeFragment propertyNoticeFragment = new PropertyNoticeFragment();
        fragments.add(0, newsFragment);
        fragments.add(1, communityFragment);
        fragments.add(2, propertyNoticeFragment);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                netRequest();
                try {
                    newsFragment.netRequest();
                    communityFragment.netRequest();
                    propertyNoticeFragment.netRequest();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                refreshLayout.setRefreshing(false);
            }
        });
        newsPagerAdapter = new NewsPagerAdapter(getFragmentManager(), fragments);
        newsViewPager.setAdapter(newsPagerAdapter);
        for (int i = 0; i < 3; i++) {

            newsTabLayout.addTab(newsTabLayout.newTab());
        }
        newsTabLayout.setupWithViewPager(newsViewPager, false);
        for (int i = 0; i < 3; i++) {
            newsTabLayout.getTabAt(i).setText(tabString[i]);
        }

    }
}
