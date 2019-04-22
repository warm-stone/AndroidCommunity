package com.example.mycommunity.community;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.community.newPost.NewPostActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CommunityFragment extends Fragment {

    private static final int NEW_POST_REQUEST = 1;
    private List<CommunityPost> posts = new ArrayList<>();
    private CommunityPostAdapter communityPostAdapter;
    private RecyclerView recyclerView;
    NetworkModule networkModule;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    ReturnPosts returnPosts = new Gson().fromJson((String) msg.obj, ReturnPosts.class);
                    posts = returnPosts.getData();
                    if (posts != null) {
                        communityPostAdapter = new CommunityPostAdapter(posts);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(communityPostAdapter);
                    }
            }
            return false;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.community_layout, container, false);
        initView(view);
        netRequest(1, 8);
        return view;
    }

    private void initView(View view) {
        FloatingActionButton actionButton = view.findViewById(R.id.community_floating_action_button);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getContext(), NewPostActivity.class), NEW_POST_REQUEST);
            }
        });
        recyclerView = view.findViewById(R.id.community_recycler_view);


    }

    private void netRequest(int page, int size) {
       networkModule = new NetworkModule();
       // networkModule.get("/portal/notice/community/latest", handler, getContext());
        networkModule.get("/news/all", handler, getContext());
    }

//    private void init() {
//        Random random = new Random();
//        StringBuilder builder = new StringBuilder();
//        int tem;
//        for (int i = 0; i < 40; i++) {
//            CommunityPost communityPost = new CommunityPost();
//            communityPost.setUserImg(R.drawable.ic_user);
//            builder.append("一个大新闻");
//            communityPost.setUseName("小虾米");
//            communityPost.setPostTime("4分钟前");
//            communityPost.setPostTitle(builder.toString());
//            communityPost.setPostImg(R.drawable.ic_big_news);
//            tem = random.nextInt(3000);
//            communityPost.setPostHeartCount(String.valueOf(tem));
//            tem = random.nextInt(3000);
//            communityPost.setPostCommentsCount(String.valueOf(tem));
//            posts.add(communityPost);
//        }
//    }
}
