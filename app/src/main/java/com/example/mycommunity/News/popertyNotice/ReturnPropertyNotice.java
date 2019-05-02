package com.example.mycommunity.news.popertyNotice;

import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnPropertyNotice extends BaseReturnMsg {
    private List<PropertyNotice> data;

    public List<PropertyNotice> getData() {
        return data;
    }

    public void setData(List<PropertyNotice> data) {
        this.data = data;
    }
}
