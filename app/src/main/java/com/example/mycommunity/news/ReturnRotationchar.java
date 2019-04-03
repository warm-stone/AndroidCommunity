package com.example.mycommunity.news;

import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnRotationchar extends BaseReturnMsg {
    private List<RotationCharData> data;

    public List<RotationCharData> getData() {
        return data;
    }

    public void setData(List<RotationCharData> data) {
        this.data = data;
    }
}
