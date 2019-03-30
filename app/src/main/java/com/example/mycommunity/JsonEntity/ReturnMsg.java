package com.example.mycommunity.JsonEntity;

import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnMsg extends BaseReturnMsg {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

