package com.example.mycommunity.mine;

import com.example.mycommunity.BaseReturnMsg;

public class ReturnImgUrl extends BaseReturnMsg {

    /**
     * data : http://47.95.244.237:8888/group1/M00/00/00/rBElLFyPFl-AaNFDAAAZFoy4-OY554.jpg,http://47.95.244.237:8888/group1/M00/00/00/rBElLFyPFmCAMFTMAAiQx3COPNA417.jpg
     */

    private String urls;

    public String getData() {
        return urls;
    }

    public void setData(String urls) {
        this.urls = urls;
    }
}
