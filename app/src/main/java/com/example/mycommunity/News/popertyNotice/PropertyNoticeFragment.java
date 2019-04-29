package com.example.mycommunity.news.popertyNotice;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;

public class PropertyNoticeFragment extends Fragment {

    private RecyclerView recyclerView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

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
        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view;
        recyclerView = refreshLayout.findViewById(R.id.news_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                netRequest();
                refreshLayout.setRefreshing(false);
            }
        });
    }

    private void netRequest(){
        new NetworkModule().get("/portal/notice/proper/latest", handler, getContext());
    }
}
