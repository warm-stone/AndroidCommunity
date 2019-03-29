package com.example.mycommunity.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.mycommunity.Community.CommunityFragment;
import com.example.mycommunity.Function.FunctionFragment;
import com.example.mycommunity.Login.Login;
import com.example.mycommunity.Login.LoginActivity;
import com.example.mycommunity.Mine.MineFragment;
import com.example.mycommunity.News.NewsFragment;
import com.example.mycommunity.R;

import java.util.ArrayList;
import java.util.List;

public class MainCommunity extends AppCompatActivity {

    private ViewPager main_container;
    private FunctionFragment functionFragment;
    private NewsFragment newsFragment;
    private CommunityFragment communityFragment;
    private List<Fragment> fragments = new ArrayList<>();
    private PagerAdapter pagerAdapter;
    private MineFragment mineFragment;
    private Intent intent;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_news:
                    main_container.setCurrentItem(0);
                    return true;
                case R.id.navigation_community:
                    if(!Login.isLoggedIn(MainCommunity.this)){
                        intent = new Intent(MainCommunity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                    main_container.setCurrentItem(1);
                    return true;
                case R.id.navigation_function:
                    main_container.setCurrentItem(2);
                    return true;
                case R.id.navigation_mine:
                    main_container.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_community);
        main_container = findViewById(R.id.main_container);
        newsFragment = new NewsFragment();
        functionFragment = new FunctionFragment();
        communityFragment = new CommunityFragment();
        mineFragment = new MineFragment();
        fragments.add(0, newsFragment);
        fragments.add(1, communityFragment);
        fragments.add(2, functionFragment);
        fragments.add(3, mineFragment);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        main_container.setAdapter(pagerAdapter);
        main_container.setOffscreenPageLimit(4);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
