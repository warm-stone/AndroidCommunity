package com.example.mycommunity.community;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycommunity.CacheManager;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.example.mycommunity.community.newPost.NewPostActivity;
import com.google.gson.Gson;

import java.util.List;

public class CommunityFragment extends Fragment {

    private static final int NEW_POST_REQUEST = 1;
    private RecyclerView recyclerView;
    private List<CommunityPost> posts;
    private SwipeRefreshLayout refreshLayout;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            CacheManager<CommunityPost> manager = new CacheManager<>(CommunityPost.class);
            if (msg.what == 0) {
                try {
                    ReturnPosts returnPosts = new Gson().fromJson((String) msg.obj, ReturnPosts.class);
                    posts = returnPosts.getData();
                    setListData(posts);
                    manager.saveData(posts);
                    refreshLayout.setRefreshing(false);
                } catch (Exception e) {
                    UserNotice.showToast(getContext(), UserNotice.UNFORMATTED_DATA);
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
                        netRequest(1, 8);
                        break;
                    case 5:
                        UserNotice.showToast(getContext(), UserNotice.UNEXPECTED_STATE);
                        break;
                    default:
                        UserNotice.showToast(getContext(), UserNotice.UNEXPECTED_STATE);
                }
                setListData(manager.getData(0, 8));
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
        refreshLayout = view.findViewById(R.id.community_refresh_layout);
        FloatingActionButton actionButton = view.findViewById(R.id.community_floating_action_button);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                netRequest(1, 8);
                refreshLayout.setRefreshing(false);
            }
        });
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(getContext(), NewPostActivity.class),
                        NEW_POST_REQUEST
                );
            }
        });
        recyclerView = view.findViewById(R.id.community_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_POST_REQUEST) {
            switch (resultCode) {
                case Activity.RESULT_OK:
                    refreshLayout.setRefreshing(true);
                    netRequest(0, 8);
//                    posts.add(0, (CommunityPost) data.getSerializableExtra("post"));
//                    setListData(posts);
            }
        }
    }

    public void netRequest(int page, int size) {
        new NetworkModule().get("/news/all", handler, getContext());
    }

    private void setListData(List<CommunityPost> listData) {
        CommunityPostAdapter newsItemAdapter = new CommunityPostAdapter(listData);
        recyclerView.setAdapter(newsItemAdapter);
    }
}
