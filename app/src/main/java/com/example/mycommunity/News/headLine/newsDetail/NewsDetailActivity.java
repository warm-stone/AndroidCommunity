package com.example.mycommunity.news.headLine.newsDetail;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.google.gson.Gson;

import java.util.List;

public class NewsDetailActivity extends AppCompatActivity {

    private RecyclerView detailContainer;
    private RecyclerView comments;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    ReturnNewsDetail newsDetail = new Gson().fromJson((String) msg.obj, ReturnNewsDetail.class);
                    if (newsDetail.getData() != null) {
                        List<NewsDetail> details = newsDetail.getData().getContents();
                        if (details != null) {
                            detailContainer.setLayoutManager(new LinearLayoutManager(NewsDetailActivity.this));
                            detailContainer.setAdapter(new NewsDetailAdapter(details));
                            comments.setLayoutManager(new LinearLayoutManager(NewsDetailActivity.this));
                            comments.setAdapter(new NewsDetailAdapter(details));

                        }
                    } else {
                        Toast.makeText(NewsDetailActivity.this, "获取内容失败", Toast.LENGTH_SHORT).show();
                    }
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
        new NetworkModule().getWithAuthor("/headline/get/1", handler, NewsDetailActivity.this);
       // netRequest();
    }

    private void initView() {
        detailContainer = findViewById(R.id.news_detail_container);
        comments = findViewById(R.id.news_detail_user_comments_container);
        FloatingActionButton addComment = findViewById(R.id.news_detail_add_comment);

    }

    private void netRequest() {
        String journalismId = getIntent().getStringExtra("journalismId");
        if (journalismId != null) {
            new NetworkModule().getWithAuthor("/headline/get/1", handler, NewsDetailActivity.this);
        } else {
            Toast.makeText(NewsDetailActivity.this, "获取摘要ID失败", Toast.LENGTH_SHORT).show();
        }
    }
}
