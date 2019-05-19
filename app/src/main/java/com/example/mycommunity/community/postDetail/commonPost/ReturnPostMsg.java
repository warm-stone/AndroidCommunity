package com.example.mycommunity.community.postDetail.commonPost;

import com.example.mycommunity.BaseReturnMsg;
import com.example.mycommunity.community.CommunityPost;
import com.example.mycommunity.community.postDetail.Comment;

import java.util.List;

public class ReturnPostMsg extends BaseReturnMsg {
    /**
     * data : {"post_news":{"id":35,"title":"老司机生产实践经验：线上系统的JVM内存是越大越好吗？","description":"先说明白一个前提，本文主要讨论的是Kafka和Elasticsearch两种分布式系统的线上部署情况，不是普通的Java应用系统。","imgUrl":"","star":0,"comments":0,"type":0,"userId":27,"newsDetail":"先说明一点，不管是我们自己开发的Java应用系统，还是一些中间件系统，在实现的时候都需要选择是否基于自己Java进程的内存来处理数据。大家应该都知道，Java、Scala等编程语言底层依赖的都是JVM，那么只要是使用JVM，就可以考虑在JVM进程的内存中来放置大量的数据。还是给大家举个例子，大家应该还记得之前聊过消息中间件系统。"},"post_replys":[{"id":16,"content":"评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty","replyTime":1553142059000,"parentId":0,"postId":35},{"id":15,"content":"评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty","replyTime":1553141828000,"parentId":0,"postId":35}]}
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
         * post_news : {"id":35,"title":"老司机生产实践经验：线上系统的JVM内存是越大越好吗？","description":"先说明白一个前提，本文主要讨论的是Kafka和Elasticsearch两种分布式系统的线上部署情况，不是普通的Java应用系统。","imgUrl":"","star":0,"comments":0,"type":0,"userId":27,"newsDetail":"先说明一点，不管是我们自己开发的Java应用系统，还是一些中间件系统，在实现的时候都需要选择是否基于自己Java进程的内存来处理数据。大家应该都知道，Java、Scala等编程语言底层依赖的都是JVM，那么只要是使用JVM，就可以考虑在JVM进程的内存中来放置大量的数据。还是给大家举个例子，大家应该还记得之前聊过消息中间件系统。"}
         * post_replys : [{"id":16,"content":"评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty","replyTime":1553142059000,"parentId":0,"postId":35},{"id":15,"content":"评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty","replyTime":1553141828000,"parentId":0,"postId":35}]
         */

        private CommunityPost post_news;
        private List<Comment> post_replys;

        public CommunityPost getPost_news() {
            return post_news;
        }

        public void setPost_news(CommunityPost post_news) {
            this.post_news = post_news;
        }

        public List<Comment> getPost_replys() {
            return post_replys;
        }

        public void setPost_replys(List<Comment> post_replys) {
            this.post_replys = post_replys;
        }
    }
}
