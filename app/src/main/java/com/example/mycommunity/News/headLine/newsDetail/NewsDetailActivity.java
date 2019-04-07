package com.example.mycommunity.news.headLine.newsDetail;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.news.headLine.News;
import com.google.gson.Gson;

import java.util.List;

public class NewsDetailActivity extends AppCompatActivity {

    private RecyclerView detailContainer;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    ReturnNewsDetail newsDetail = new Gson().fromJson((String)msg.obj, ReturnNewsDetail.class);
                    List<NewsDetail> details = newsDetail.getData().getContents();
                    detailContainer.setLayoutManager(new LinearLayoutManager(NewsDetailActivity.this));
                    detailContainer.setAdapter(new NewsDetailAdapter(details));
                    break;
                case 3:
                    netRequest();
                    break;

            }
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
        netRequest();
    }

    private void initView(){
        detailContainer = findViewById(R.id.news_detail_container);
        FloatingActionButton addComment = findViewById(R.id.news_detail_add_comment);

    }

    private void netRequest(){
        int journalismId = getIntent().getIntExtra("journalismId", -1);
        if (journalismId != -1){
            new NetworkModule().getWithAuthor("/headline/get/" + String.valueOf(journalismId), handler, NewsDetailActivity.this);
        } else {
            Toast.makeText(NewsDetailActivity.this, "获取摘要ID失败", Toast.LENGTH_SHORT).show();
        }
    }
}
