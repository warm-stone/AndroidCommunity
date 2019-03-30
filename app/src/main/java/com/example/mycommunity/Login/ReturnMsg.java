package com.example.mycommunity.Login;


import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnMsg extends BaseReturnMsg {

    private List<Data> data;
    /**
     * status : 10001
     * message : 请求成功
     */



    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
