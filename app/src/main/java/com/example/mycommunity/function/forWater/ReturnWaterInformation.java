package com.example.mycommunity.function.forWater;

import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnWaterInformation extends BaseReturnMsg {
    private List<Water> data;

    public List<Water> getData() {
        return data;
    }

    public void setData(List<Water> data) {
        this.data = data;
    }
}
