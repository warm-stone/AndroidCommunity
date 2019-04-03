package com.example.mycommunity.news;

import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnHeadline extends BaseReturnMsg {
    private List<News> data;

    public List<News> getData() {
        return data;
    }

    public void setData(List<News> data) {
        this.data = data;
    }
}
