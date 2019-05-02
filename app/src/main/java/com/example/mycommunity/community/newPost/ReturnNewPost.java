package com.example.mycommunity.community.newPost;

import com.example.mycommunity.BaseReturnMsg;
import com.example.mycommunity.community.CommunityPost;

public class ReturnNewPost extends BaseReturnMsg {
    /**
     * data : {"id":30,"title":"Java 基础与提高干货系列\u2014Java 反射机制","description":"Java反射机制是指在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。用一句话总结就是反射可以实现在运行时可以知道任意一个类的属性和方法。","imgUrl":"","posted":1552997033642,"star":0,"comments":0,"type":1,"userId":16,"newsDetail":"前面我们知道了怎么获取Class，那么我们可以通过这个Class干什么呢？总结如下：获取成员方法Method获取成员变量Field获取构造函数Constructor下面来具体介绍获取成员方法信息单独获取某一个方法是通过Class类的以下方法获得的：public Method getDeclaredMethod(String name, Class<?>... parameterTypes) // 得到该类所有的方法，不包括父类的public Method getMethod(String name, Class<?>... parameterTypes) // 得到该类所有的public方法，包括"}
     */

    private CommunityPost data;

    public CommunityPost getData() {
        return data;
    }

    public void setData(CommunityPost data) {
        this.data = data;
    }
}
