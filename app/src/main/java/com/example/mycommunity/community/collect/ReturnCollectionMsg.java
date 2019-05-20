package com.example.mycommunity.community.collect;

import com.example.mycommunity.BaseReturnMsg;
import com.example.mycommunity.community.CommunityPost;

import java.util.List;

public class ReturnCollectionMsg extends BaseReturnMsg {
    CommunityPost e;

    /**
     * data : {"posts":1,"replys":1,"collections":2,"collectNews":[{"id":36,"title":"兄弟，用大白话告诉你小白都能看懂的Hadoop架构原理","description":"Hadoop是目前大数据领域最主流的一套技术体系，包含了多种技术。包括HDFS（分布式文件系统），YARN（分布式资源调度系统），MapReduce（分布式计算系统），等等。","imgUrl":"","star":0,"comments":0,"type":0,"userId":27,"newsDetail":"你说，我可以搞多台MySQL数据库服务器，分库分表啊！每台服务器放一部分数据不就得了。如上图所示！好，没问题，那咱们搞3台数据库服务器，3个MySQL实例，然后每台服务器都可以2T的数据。现在我问你一个问题，所谓的大数据是在干什么？我们来说一下大数据最初级的一个使用场景。假设你有一个电商网站，现在要把这个电商网站里所有的用户在页面和APP上的点击、购买、浏览的行为日志都存放起来分析。你现在把这些数据全都放在了3台MySQL服务器，数据量很大，但还是勉强可以放的下。"}],"postNewsList":[],"postReplyList":[],"followerNums":1,"followingNums":1,"followers":["shuwang00"],"followings":["shuwang00"],"base_info":{"id":27,"nickname":"shuwang","communityId":1,"signUp":1553138289655}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * posts : 1
         * replys : 1
         * collections : 2
         * collectNews : [{"id":36,"title":"兄弟，用大白话告诉你小白都能看懂的Hadoop架构原理","description":"Hadoop是目前大数据领域最主流的一套技术体系，包含了多种技术。包括HDFS（分布式文件系统），YARN（分布式资源调度系统），MapReduce（分布式计算系统），等等。","imgUrl":"","star":0,"comments":0,"type":0,"userId":27,"newsDetail":"你说，我可以搞多台MySQL数据库服务器，分库分表啊！每台服务器放一部分数据不就得了。如上图所示！好，没问题，那咱们搞3台数据库服务器，3个MySQL实例，然后每台服务器都可以2T的数据。现在我问你一个问题，所谓的大数据是在干什么？我们来说一下大数据最初级的一个使用场景。假设你有一个电商网站，现在要把这个电商网站里所有的用户在页面和APP上的点击、购买、浏览的行为日志都存放起来分析。你现在把这些数据全都放在了3台MySQL服务器，数据量很大，但还是勉强可以放的下。"}]
         * postNewsList : []
         * postReplyList : []
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
        private List<CommunityPost> collectNews;
        private List<?> postNewsList;
        private List<?> postReplyList;
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

        public List<CommunityPost> getCollectNews() {
            return collectNews;
        }

        public void setCollectNews(List<CommunityPost> collectNews) {
            this.collectNews = collectNews;
        }

        public List<?> getPostNewsList() {
            return postNewsList;
        }

        public void setPostNewsList(List<?> postNewsList) {
            this.postNewsList = postNewsList;
        }

        public List<?> getPostReplyList() {
            return postReplyList;
        }

        public void setPostReplyList(List<?> postReplyList) {
            this.postReplyList = postReplyList;
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
}
