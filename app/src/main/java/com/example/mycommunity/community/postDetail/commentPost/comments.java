package com.example.mycommunity.community.postDetail.commentPost;

public class comments {
    /**
     * id : 17
     * content : 评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty
     * replyTime : 1553142281000
     * parentId : 0
     * postId : 34
     */

    private long id;
    private String content;
    private long replyTime;
    private long parentId;
    private long postId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}
