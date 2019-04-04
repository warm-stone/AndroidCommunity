package com.example.mycommunity.news.headLine;

import com.example.mycommunity.BaseReturnMsg;
import com.example.mycommunity.news.headLine.News;

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
