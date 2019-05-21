package com.example.mycommunity.userInf;

import java.util.List;

public class UserActivityInf {

    /**
     * posts : 0
     * replys : 0
     * collections : 0
     * followerNums : 1
     * followingNums : 1
     * followers : ["shuwang00"]
     * followings : ["shuwang00"]
     * base_info : {"id":27,"nickname":"shuwang","communityId":1,"signUp":1553138289655}
     */

    private long posts;
    private long replys;
    private long collections;
    private long followerNums;
    private long followingNums;
    private List<String> followers;
    private List<String> followings;

    public long getPosts() {
        return posts;
    }

    public void setPosts(long posts) {
        this.posts = posts;
    }

    public long getReplys() {
        return replys;
    }

    public void setReplys(long replys) {
        this.replys = replys;
    }

    public long getCollections() {
        return collections;
    }

    public void setCollections(long collections) {
        this.collections = collections;
    }

    public long getFollowerNums() {
        return followerNums;
    }

    public void setFollowerNums(long followerNums) {
        this.followerNums = followerNums;
    }

    public long getFollowingNums() {
        return followingNums;
    }

    public void setFollowingNums(long followingNums) {
        this.followingNums = followingNums;
    }

    public List<String> getFollowers() {
        return followers;
    }

    public void setFollowers(List<String> followers) {
        this.followers = followers;
    }

    public List<String> getFollowings() {
        return followings;
    }

    public void setFollowings(List<String> followings) {
        this.followings = followings;
    }

}
