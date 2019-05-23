package com.example.mycommunity.imgService;

import com.example.mycommunity.BaseReturnMsg;

public class ReturnImgMsg extends BaseReturnMsg {

    /**
     * data : http://47.95.244.237:8888/group1/M00/00/00/rBElLFyPFl-AaNFDAAAZFoy4-OY554.jpg,http://47.95.244.237:8888/group1/M00/00/00/rBElLFyPFmCAMFTMAAiQx3COPNA417.jpg
     */

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
