package com.example.mycommunity.community;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycommunity.R;
import com.example.mycommunity.community.newPost.NewPostActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommunityFragment extends Fragment {

    private static final int NEW_POST_REQUEST = 1;
    private List<CommunityPost> posts = new ArrayList<>();
    private CommunityPostAdapter communityPostAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.community_layout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        FloatingActionButton actionButton = view.findViewById(R.id.community_floating_action_button);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getContext(), NewPostActivity.class), NEW_POST_REQUEST);
            }
        });
        RecyclerView recyclerView = view.findViewById(R.id.community_recycler_view);
        init();
        communityPostAdapter = new CommunityPostAdapter(posts);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(communityPostAdapter);
    }

    private void init(){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        int tem;
        for (int i = 0; i < 40; i++){
            CommunityPost communityPost = new CommunityPost();
            communityPost.setUserImg(R.drawable.ic_user);
            builder.append("一个大新闻");
            communityPost.setUseName("小虾米");
            communityPost.setPostTime("4分钟前");
            communityPost.setPostTitle(builder.toString());
            communityPost.setPostImg(R.drawable.ic_big_news);
            tem = random.nextInt(3000);
            communityPost.setPostHeartCount(String.valueOf(tem));
            tem = random.nextInt(3000);
            communityPost.setPostCommentsCount(String.valueOf(tem));
            posts.add(communityPost);
        }
    }
}
