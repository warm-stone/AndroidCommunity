package com.example.mycommunity.jsonEntity;

import com.example.mycommunity.BaseReturnMsg;

public class ReturnMsg extends BaseReturnMsg {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

