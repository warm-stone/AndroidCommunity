package com.example.mycommunity.news.communityNotice;

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
import android.widget.Toast;

import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.google.gson.Gson;

import java.util.List;

public class CommunityNoticeRecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            ReturnCommunityNotice returnCommunityNotice = new Gson().fromJson((String)msg.obj, ReturnCommunityNotice.class);
            switch (msg.what){
                case 0:
                    try {
                        List<CommunityNotice> notices = returnCommunityNotice.getData();
                        CommunityNoticeAdapter adapter = new CommunityNoticeAdapter(notices);
                        recyclerView.setAdapter(adapter);
                    }catch (Exception e){
                        Toast.makeText(getContext(), "获取社区通知失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 1:
                    Toast.makeText(getContext(), "请检查网络后再试", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getContext(), "登录异常", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    netRequest();
                    break;
                case 4:
                    Toast.makeText(getContext(), returnCommunityNotice.getMessage(), Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    Toast.makeText(getContext(), "预期之外的错误", Toast.LENGTH_SHORT).show();
                    break;
            }
            return false;
        }
    });
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView)inflater.inflate(R.layout.news_recycle_view, container, false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        netRequest();
        return recyclerView;
    }

    private void netRequest(){
        new NetworkModule().getWithAuthor("/portal/notice/community/latest", handler, getContext());
    }
}
