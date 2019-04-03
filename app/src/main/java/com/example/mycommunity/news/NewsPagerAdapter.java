package com.example.mycommunity.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class NewsPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    public NewsPagerAdapter(FragmentManager manager,List<Fragment> fragments){
        super(manager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i){
        return fragments.get(i);
    }

    @Override
    public int getCount(){
        return fragments.size();
    }

}
