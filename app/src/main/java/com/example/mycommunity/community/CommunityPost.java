package com.example.mycommunity.community;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

import java.io.Serializable;

public class CommunityPost extends LitePalSupport implements Serializable {
    /**
     * id : 32
     * title : Java 基础与提高干货系列—Java 反射机制
     * description : Java反射机制是指在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。用一句话总结就是反射可以实现在运行时可以知道任意一个类的属性和方法。
     * imgUrl :
     * star : 0
     * comments : 0
     * type : 1
     * userId : 19
     * newsDetail : 前面我们知道了怎么获取Class，那么我们可以通过这个Class干什么呢？总结如下：获取成员方法Method获取成员变量Field获取构造函数Constructor下面来具体介绍获取成员方法信息单独获取某一个方法是通过Class类的以下方法获得的：public Method getDeclaredMethod(String name, Class<?>... parameterTypes) // 得到该类所有的方法，不包括父类的public Method getMethod(String name, Class<?>... parameterTypes) // 得到该类所有的public方法，包括
     */

    @SerializedName("id")
    private int idx;
    private String title;
    private String description;
    private String imgUrl;
    private int star;
    private int comments;
    private int type;
    private long userId;
    private String newsDetail;

    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    /**
     * posted : 1554558536000
     */

    private long posted;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNewsDetail() {
        return newsDetail;
    }

    public void setNewsDetail(String newsDetail) {
        this.newsDetail = newsDetail;
    }

    public long getPosted() {
        return posted;
    }

    public void setPosted(long posted) {
        this.posted = posted;
    }
}
