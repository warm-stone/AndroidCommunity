package com.example.mycommunity.community.postDetail.commonPost;

import com.example.mycommunity.BaseReturnMsg;
import com.example.mycommunity.userInf.UserActivityInf;

public class ReturnFollowMsg extends BaseReturnMsg {
    private UserActivityInf data;

    public UserActivityInf getData() {
        return data;
    }

    public void setData(UserActivityInf data) {
        this.data = data;
    }
}
