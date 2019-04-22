package com.example.mycommunity.news.headLine;

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

import com.example.mycommunity.CacheManager;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.google.gson.Gson;

import java.util.List;
import java.util.Random;

public class NewsRecycleViewFragment extends Fragment {

    private RecyclerView newsRecycleView;
    private List<News> newsList;
    private Handler newsHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            CacheManager<News> manager = new CacheManager<>(News.class);
            newsList = manager.getData(0, 8);
            if (msg.what == 0){
                try {
                    ReturnHeadline headline = new Gson().fromJson((String) msg.obj, ReturnHeadline.class);
                    newsList = headline.getData();
                    setListData(newsList);
                    newsList = headline.getData();
                    manager.saveData(newsList);
                } catch (Exception e) {
                    UserNotice.showToast(getContext(),UserNotice.UNFORMATTED_DATA);
                }
            } else {
                switch (msg.what) {
                    case 1:
                        UserNotice.showToast(getContext(), UserNotice.NETWORK_CONNECT_FAILURE);
                        break;
                    case 2:
                        UserNotice.showToast(getContext(), UserNotice.USER_AUTHENTICATION_FAILURE);
                        break;
                    case 3:
                        netRequest();
                        break;
                    case 5:
                        UserNotice.showToast(getContext(), UserNotice.UNEXPECTED_STATE);
                        break;
                }
                setListData(newsList);
            }

            return false;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_recycle_view, container, false);
        initView(view);
        netRequest();
        return view;
    }

    private void initView(View view) {
        newsRecycleView = (RecyclerView) view;
        newsRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void netRequest() {
        new NetworkModule().get("/headline/all", newsHandler, getContext());
    }

    private void setListData(List<News> listData) {
        NewsItemAdapter newsItemAdapter = new NewsItemAdapter(listData);
        newsRecycleView.setAdapter(newsItemAdapter);
    }

    //本地界面测试
    private void init() {
        News news;
        StringBuilder temp = new StringBuilder();
        Random random = new Random();
        int length;
        for (int i = 0; i < 30; i++) {
            length = random.nextInt(20) + 1;
            for (int j = 0; j < length; j++) {
                temp.append("大新闻");
            }
            news = new News(temp.toString(), 134, 43, R.drawable.ic_big_news);
            newsList.add(i, news);
        }
    }
}
