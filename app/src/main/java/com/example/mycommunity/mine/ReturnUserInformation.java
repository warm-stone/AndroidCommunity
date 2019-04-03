package com.example.mycommunity.mine;

import com.example.mycommunity.jsonEntity.UserInformation;

import java.util.List;

public class ReturnUserInformation {

    /**
     * status : 10001
     * message : 请求成功
     * data : {"posts":1,"replys":1,"collections":1,"collectNews":[{"id":36,"title":"兄弟，用大白话告诉你小白都能看懂的Hadoop架构原理","description":"Hadoop是目前大数据领域最主流的一套技术体系，包含了多种技术。包括HDFS（分布式文件系统），YARN（分布式资源调度系统），MapReduce（分布式计算系统），等等。","imgUrl":"","star":0,"comments":0,"type":0,"userId":27,"newsDetail":"你说，我可以搞多台MySQL数据库服务器，分库分表啊！每台服务器放一部分数据不就得了。如上图所示！好，没问题，那咱们搞3台数据库服务器，3个MySQL实例，然后每台服务器都可以2T的数据。现在我问你一个问题，所谓的大数据是在干什么？我们来说一下大数据最初级的一个使用场景。假设你有一个电商网站，现在要把这个电商网站里所有的用户在页面和APP上的点击、购买、浏览的行为日志都存放起来分析。你现在把这些数据全都放在了3台MySQL服务器，数据量很大，但还是勉强可以放的下。"}],"postNewsList":[{"id":35,"title":"老司机生产实践经验：线上系统的JVM内存是越大越好吗？","description":"先说明白一个前提，本文主要讨论的是Kafka和Elasticsearch两种分布式系统的线上部署情况，不是普通的Java应用系统。","imgUrl":"","star":0,"comments":0,"type":0,"userId":27,"newsDetail":"先说明一点，不管是我们自己开发的Java应用系统，还是一些中间件系统，在实现的时候都需要选择是否基于自己Java进程的内存来处理数据。大家应该都知道，Java、Scala等编程语言底层依赖的都是JVM，那么只要是使用JVM，就可以考虑在JVM进程的内存中来放置大量的数据。还是给大家举个例子，大家应该还记得之前聊过消息中间件系统。"}],"postReplyList":[{"id":15,"content":"评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty","replyTime":1553141827582,"parentId":0,"postId":35},{"id":16,"content":"评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty","replyTime":1553142058788,"parentId":0,"postId":35}],"followerNums":1,"followingNums":1,"followers":["shuwang00"],"followings":["shuwang00"],"base_info":{"id":27,"nickname":"shuwang","communityId":1,"signUp":1553138289655}}
     */

    private int status;
    private String message;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

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
         * collections : 1
         * collectNews : [{"id":36,"title":"兄弟，用大白话告诉你小白都能看懂的Hadoop架构原理","description":"Hadoop是目前大数据领域最主流的一套技术体系，包含了多种技术。包括HDFS（分布式文件系统），YARN（分布式资源调度系统），MapReduce（分布式计算系统），等等。","imgUrl":"","star":0,"comments":0,"type":0,"userId":27,"newsDetail":"你说，我可以搞多台MySQL数据库服务器，分库分表啊！每台服务器放一部分数据不就得了。如上图所示！好，没问题，那咱们搞3台数据库服务器，3个MySQL实例，然后每台服务器都可以2T的数据。现在我问你一个问题，所谓的大数据是在干什么？我们来说一下大数据最初级的一个使用场景。假设你有一个电商网站，现在要把这个电商网站里所有的用户在页面和APP上的点击、购买、浏览的行为日志都存放起来分析。你现在把这些数据全都放在了3台MySQL服务器，数据量很大，但还是勉强可以放的下。"}]
         * postNewsList : [{"id":35,"title":"老司机生产实践经验：线上系统的JVM内存是越大越好吗？","description":"先说明白一个前提，本文主要讨论的是Kafka和Elasticsearch两种分布式系统的线上部署情况，不是普通的Java应用系统。","imgUrl":"","star":0,"comments":0,"type":0,"userId":27,"newsDetail":"先说明一点，不管是我们自己开发的Java应用系统，还是一些中间件系统，在实现的时候都需要选择是否基于自己Java进程的内存来处理数据。大家应该都知道，Java、Scala等编程语言底层依赖的都是JVM，那么只要是使用JVM，就可以考虑在JVM进程的内存中来放置大量的数据。还是给大家举个例子，大家应该还记得之前聊过消息中间件系统。"}]
         * postReplyList : [{"id":15,"content":"评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty","replyTime":1553141827582,"parentId":0,"postId":35},{"id":16,"content":"评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty","replyTime":1553142058788,"parentId":0,"postId":35}]
         * followerNums : 1
         * followingNums : 1
         * followers : ["shuwang00"]
         * followings : ["shuwang00"]
         * base_info : {"id":27,"nickname":"shuwang","communityId":1,"signUp":1553138289655}
         */

        private int posts;
        private int replys;
        private int collections;
        private int followerNums;
        private int followingNums;
        private UserInformation base_info;
        private List<CollectNewsBean> collectNews;
        private List<PostNewsListBean> postNewsList;
        private List<PostReplyListBean> postReplyList;
        private List<String> followers;
        private List<String> followings;

        public int getPosts() {
            return posts;
        }

        public void setPosts(int posts) {
            this.posts = posts;
        }

        public int getReplys() {
            return replys;
        }

        public void setReplys(int replys) {
            this.replys = replys;
        }

        public int getCollections() {
            return collections;
        }

        public void setCollections(int collections) {
            this.collections = collections;
        }

        public int getFollowerNums() {
            return followerNums;
        }

        public void setFollowerNums(int followerNums) {
            this.followerNums = followerNums;
        }

        public int getFollowingNums() {
            return followingNums;
        }

        public void setFollowingNums(int followingNums) {
            this.followingNums = followingNums;
        }

        public UserInformation getBase_info() {
            return base_info;
        }

        public void setBase_info(UserInformation base_info) {
            this.base_info = base_info;
        }

        public List<CollectNewsBean> getCollectNews() {
            return collectNews;
        }

        public void setCollectNews(List<CollectNewsBean> collectNews) {
            this.collectNews = collectNews;
        }

        public List<PostNewsListBean> getPostNewsList() {
            return postNewsList;
        }

        public void setPostNewsList(List<PostNewsListBean> postNewsList) {
            this.postNewsList = postNewsList;
        }

        public List<PostReplyListBean> getPostReplyList() {
            return postReplyList;
        }

        public void setPostReplyList(List<PostReplyListBean> postReplyList) {
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

        public static class CollectNewsBean {
            /**
             * id : 36
             * title : 兄弟，用大白话告诉你小白都能看懂的Hadoop架构原理
             * description : Hadoop是目前大数据领域最主流的一套技术体系，包含了多种技术。包括HDFS（分布式文件系统），YARN（分布式资源调度系统），MapReduce（分布式计算系统），等等。
             * imgUrl :
             * star : 0
             * comments : 0
             * type : 0
             * userId : 27
             * newsDetail : 你说，我可以搞多台MySQL数据库服务器，分库分表啊！每台服务器放一部分数据不就得了。如上图所示！好，没问题，那咱们搞3台数据库服务器，3个MySQL实例，然后每台服务器都可以2T的数据。现在我问你一个问题，所谓的大数据是在干什么？我们来说一下大数据最初级的一个使用场景。假设你有一个电商网站，现在要把这个电商网站里所有的用户在页面和APP上的点击、购买、浏览的行为日志都存放起来分析。你现在把这些数据全都放在了3台MySQL服务器，数据量很大，但还是勉强可以放的下。
             */

            private int id;
            private String title;
            private String description;
            private String imgUrl;
            private int star;
            private int comments;
            private int type;
            private int userId;
            private String newsDetail;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getNewsDetail() {
                return newsDetail;
            }

            public void setNewsDetail(String newsDetail) {
                this.newsDetail = newsDetail;
            }
        }

        public static class PostNewsListBean {
            /**
             * id : 35
             * title : 老司机生产实践经验：线上系统的JVM内存是越大越好吗？
             * description : 先说明白一个前提，本文主要讨论的是Kafka和Elasticsearch两种分布式系统的线上部署情况，不是普通的Java应用系统。
             * imgUrl :
             * star : 0
             * comments : 0
             * type : 0
             * userId : 27
             * newsDetail : 先说明一点，不管是我们自己开发的Java应用系统，还是一些中间件系统，在实现的时候都需要选择是否基于自己Java进程的内存来处理数据。大家应该都知道，Java、Scala等编程语言底层依赖的都是JVM，那么只要是使用JVM，就可以考虑在JVM进程的内存中来放置大量的数据。还是给大家举个例子，大家应该还记得之前聊过消息中间件系统。
             */

            private int id;
            private String title;
            private String description;
            private String imgUrl;
            private int star;
            private int comments;
            private int type;
            private int userId;
            private String newsDetail;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getNewsDetail() {
                return newsDetail;
            }

            public void setNewsDetail(String newsDetail) {
                this.newsDetail = newsDetail;
            }
        }

        public static class PostReplyListBean {
            /**
             * id : 15
             * content : 评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty
             * replyTime : 1553141827582
             * parentId : 0
             * postId : 35
             */

            private int id;
            private String content;
            private long replyTime;
            private int parentId;
            private int postId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getReplyTime() {
                return replyTime;
            }

            public void setReplyTime(long replyTime) {
                this.replyTime = replyTime;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public int getPostId() {
                return postId;
            }

            public void setPostId(int postId) {
                this.postId = postId;
            }
        }
    }
}
