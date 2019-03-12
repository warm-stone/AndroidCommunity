package com.example.mycommunity.Community;

public class CommunityPost {
    private int userImg;
    private String useName;
    private String postTime;
    private String postTitle;
    private int postImg;
    private String postHeartCount;
    private String postCommentsCount;

    public CommunityPost(){}

    public CommunityPost(int userImg, String useName, String postTime, String postTitle, int postImg, String postHeartCount, String postCommentsCount) {
        this.userImg = userImg;
        this.useName = useName;
        this.postTime = postTime;
        this.postTitle = postTitle;
        this.postImg = postImg;
        this.postHeartCount = postHeartCount;
        this.postCommentsCount = postCommentsCount;
    }

    public int getUserImg() {
        return userImg;
    }

    public void setUserImg(int userImg) {
        this.userImg = userImg;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public int getPostImg() {
        return postImg;
    }

    public void setPostImg(int postImg) {
        this.postImg = postImg;
    }

    public String getPostHeartCount() {
        return postHeartCount;
    }

    public void setPostHeartCount(String postHeartCount) {
        this.postHeartCount = postHeartCount;
    }

    public String getPostCommentsCount() {
        return postCommentsCount;
    }

    public void setPostCommentsCount(String postCommentsCount) {
        this.postCommentsCount = postCommentsCount;
    }
}
