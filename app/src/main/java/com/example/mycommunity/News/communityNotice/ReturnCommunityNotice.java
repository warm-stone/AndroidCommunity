package com.example.mycommunity.news.communityNotice;

import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnCommunityNotice extends BaseReturnMsg {
    private List<CommunityNotice> data;

    public List<CommunityNotice> getData() {
        return data;
    }

    public void setData(List<CommunityNotice> data) {
        this.data = data;
    }
}
