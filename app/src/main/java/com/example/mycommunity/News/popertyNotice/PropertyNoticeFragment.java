package com.example.mycommunity.news.popertyNotice;

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

public class PropertyNoticeFragment extends Fragment {

    private RecyclerView recyclerView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            CacheManager<PropertyNotice> manager = new CacheManager<>(PropertyNotice.class);
            if (msg.what == 0) {
                try {
                    ReturnPropertyNotice headline = new Gson().fromJson((String) msg.obj, ReturnPropertyNotice.class);
                    List<PropertyNotice> propertyList = headline.getData();
                    if (propertyList != null) {
                        setListData(propertyList);
                        propertyList = headline.getData();
                        manager.saveData(propertyList);
                    } else {
                        UserNotice.showToast(getContext(), "物业公告" + UserNotice.NO_DATA_GOTTEN);
                    }
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
                        netRequest();
                        break;
                    case 5:
                        UserNotice.showToast(getContext(), UserNotice.UNEXPECTED_STATE);
                        break;
                }
                if (manager.getData(0, 8) != null) {
                    setListData(manager.getData(0, 8));
                }
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
        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setListData(List<PropertyNotice> notices) {
        PropertyNoticeAdapter adapter = new PropertyNoticeAdapter(notices);
        recyclerView.setAdapter(adapter);
    }

    public void netRequest() {
        new NetworkModule().get("/portal/notice/proper/latest", handler, getContext());
    }
}
