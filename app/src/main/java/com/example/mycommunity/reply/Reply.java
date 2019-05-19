package com.example.mycommunity.reply;

public class Reply {

    /**
     * content : 评论回复小编，什么时候来点Netty相关的可以吗？我现在对Netty的认识还很浅，我个人认为可能就是在一些游戏行业或者即时聊天又或者TCP工具中会用，不知道其他那些场景可以使用Netty
     * postId : 34
     * imageUrl : http://47.95.244.237:8888/group1/M00/00/00/rBElLFyS5V6APMzyAAiQx3COPNA489.jpg
     * parentId : 0
     */

    private String content;
    private int postId;
    private String imageUrl;
    private int parentId;
    /**
     * id : 17
     * replyTime : 1553142280594
     */

    private int id;
    private long replyTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(long replyTime) {
        this.replyTime = replyTime;
    }
}
