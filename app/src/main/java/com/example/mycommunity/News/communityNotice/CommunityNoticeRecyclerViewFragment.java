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

import com.example.mycommunity.CacheManager;
import com.example.mycommunity.NetworkModule;
import com.example.mycommunity.R;
import com.example.mycommunity.UserNotice;
import com.google.gson.Gson;

import java.util.List;

public class CommunityNoticeRecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what){
                case 0:
                    try {
                        ReturnCommunityNotice returnCommunityNotice = new Gson().fromJson((String)msg.obj, ReturnCommunityNotice.class);
                        List<CommunityNotice> notices = returnCommunityNotice.getData();
                        CommunityNoticeAdapter adapter = new CommunityNoticeAdapter(notices);
                        recyclerView.setAdapter(adapter);
                        new CacheManager<CommunityNotice>(CommunityNotice.class).saveData(notices);
                    }catch (Exception e){
                        UserNotice.showToast(getContext(), UserNotice.UNFORMATTED_DATA);
                    }
                    break;
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
        new NetworkModule().get("/portal/notice/community/latest", handler, getContext());
    }
}
