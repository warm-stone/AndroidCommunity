package com.example.mycommunity.userInf;

import com.example.mycommunity.BaseReturnMsg;

public class ReturnMsg extends BaseReturnMsg {
    UserInformation e;

    /**
     * data : {"id":45,"username":"黄翔","nickname":"Hans20","idcard":"372330199706111111","integral":0,"gender":"","avatar":"http://www.baidu.com","motto":"解决一个计算机问题的方法就是恰好的不解决","email":"beautifulsoup@163.com","phone":"17864195000","communityId":1,"signUp":1553928538000}
     */

    private UserInformation data;

    public UserInformation getData() {
        return data;
    }

    public void setData(UserInformation data) {
        this.data = data;
    }

}
