package com.example.mycommunity.news;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.google.gson.Gson;

import java.util.List;
import java.util.Random;

public class NewsRecycleViewFragment extends Fragment {

    private RecyclerView newsRecycleView;
    private NewsItemAdapter newsItemAdapter;
    private List<News> newsList;
    private LinearLayoutManager layoutManager;
    private Handler newsHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Gson gson = new Gson();
            switch (msg.what){
                case 0:
                    ReturnHeadline headline = gson.fromJson((String)msg.obj, ReturnHeadline.class);
                    newsList = headline.getData();
                    newsItemAdapter = new NewsItemAdapter(newsList);
                    newsRecycleView.setAdapter(newsItemAdapter);
            }
            return false;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_recycle_view,container,false);
        initView(view);
        netRequest();
        return view;
    }

    private void initView(View view){
        newsRecycleView = (RecyclerView)view;
        layoutManager = new LinearLayoutManager(getContext());
        newsRecycleView.setLayoutManager(layoutManager);
    }

    private void netRequest(){
        NetworkModule.getWithAuthor("/headline/top5", newsHandler, getContext());
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
            news =new News(temp.toString(), 134, 43, R.drawable.ic_big_news);
            newsList.add(i,news);
        }
    }
}
