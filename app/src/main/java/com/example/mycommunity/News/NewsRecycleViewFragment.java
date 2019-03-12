package com.example.mycommunity.News;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycommunity.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsRecycleViewFragment extends Fragment {

    private RecyclerView newsRecycleView;
    private NewsItemAdapter newsItemAdapter;
    private List<News> newsList = new ArrayList<>();
    private LinearLayoutManager layoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_recycle_view,container,false);
        init();
        newsItemAdapter = new NewsItemAdapter(newsList);
        newsRecycleView = (RecyclerView)view;
        layoutManager = new LinearLayoutManager(getContext());
        newsRecycleView.setLayoutManager(layoutManager);
        newsRecycleView.setAdapter(newsItemAdapter);
        return view;
    }

    private void init(){
        News news;
        StringBuilder temp = new StringBuilder();
        Random random = new Random();
        int length;
        for (int i = 0; i < 30; i++) {
            length = random.nextInt(20) + 1;
            for (int j = 0;j < length; j++){
                temp.append("大新闻");
            }
            news =new News(temp.toString(), "134", "34", R.drawable.ic_big_news);
            newsList.add(i,news);
        }
    }
}
