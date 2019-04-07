package com.example.mycommunity.community;

import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnPosts extends BaseReturnMsg {
    private List<CommunityPost> data;

    public List<CommunityPost> getData() {
        return data;
    }

    public void setData(List<CommunityPost> data) {
        this.data = data;
    }
}
