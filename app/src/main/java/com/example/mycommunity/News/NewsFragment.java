package com.example.mycommunity.News;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycommunity.R;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private ViewPager hotNewsViewPager;
    private  ViewPager newsViewPager;
    private TabLayout newsTabLayout;
    private  NewsPagerAdapter newsPagerAdapter;
    private  NewsRecycleViewFragment newsRecycleViewFragment;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        init();

        View view = inflater.inflate(R.layout.news_layout, container, false);
        newsRecycleViewFragment = new NewsRecycleViewFragment();
        hotNewsViewPager = view.findViewById(R.id.hot_show_view_pager);
        //newsTabLayout = view.findViewById(R.id.news_tab_layout);
        newsViewPager = view.findViewById(R.id.news_view_pager);
        fragments.add(newsRecycleViewFragment);
        newsPagerAdapter = new NewsPagerAdapter(getFragmentManager(), fragments);
        newsViewPager.setAdapter(newsPagerAdapter);
        return view;
    }

    @Override
    public void onStart() {
        newsViewPager.setCurrentItem(0);
        super.onStart();
    }

    private void init() {
    }
}
