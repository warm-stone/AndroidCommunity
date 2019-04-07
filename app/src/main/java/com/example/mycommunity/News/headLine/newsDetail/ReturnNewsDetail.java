package com.example.mycommunity.news.headLine.newsDetail;

import com.example.mycommunity.BaseReturnMsg;

import java.util.List;

public class ReturnNewsDetail extends BaseReturnMsg {
    private NewsDetail detail;
    /**
     * data : {"id":"1","title":"AAA师范大学新闻","author":null,"description":"这里是师范大学新闻介绍","images":null,"videos":null,"publishTime":"2011-01-15T11:30:38.000+0000","publishName":"BeautifulSoup","communityId":2,"commentNums":0,"starNums":101,"contents":[{"id":1,"imageUrl":"http://123.207.157.129/banner3.webp","videoUrl":"http://47.95.244.237:8888/group1/M00/00/00/rBElLFyGHOSAFkf3AGvX0JaiVbs497.mp3","journalismId":null,"content":"最后一步，.我们点击\u201c开始-运行\u201d接着输入'gpedit.msc\u201c打开组策略，并依次打开：'本地计算机 策略计算机配置Windows设置脚本(启动/关机)\u201d，然后在右边的框中选择项，我们把刚才建立的批处理文件添加到启动脚本列表当中，然后保存确定就可以了。"},{"id":2,"imageUrl":null,"videoUrl":null,"journalismId":null,"content":"现在电脑加密已经有很多的方法了，简单的就是在电脑上设置密码，可以总觉得不安全，买个指纹开机吧，又有点小贵。那么有没有其它方法可以保护我们的电脑，今天韩博士小编介绍一种使用u盘作为钥匙的启动方法，让电脑在插入自己的u盘才能够正常启动，让你的电脑更加的安全。但这个方法对于大神们来说是形同虚设的，没办法，家里的锁还有专门开锁的呢。防君子不防小人吧。"},{"id":3,"imageUrl":"http://123.207.157.129/banner3.webp","videoUrl":"http://47.95.244.237:8888/group1/M00/00/00/rBElLFyGHOSAFkf3AGvX0JaiVbs497.mp3","journalismId":null,"content":"新华社北京3月15日电 题：新时代的春天充满希望\u2014\u2014读懂习近平总书记的\u201c两会时间\u201d"},{"id":4,"imageUrl":null,"videoUrl":null,"journalismId":null,"content":"\u201c脱贫攻坚越到紧要关头，越要坚定必胜的信心\u201d。在甘肃代表团参加审议时，习近平总书记的一番话鼓舞人心。此时此刻，中国的反贫困斗争正是最吃劲的时候。"}],"comments":null}
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
         * id : 1
         * title : AAA师范大学新闻
         * author : null
         * description : 这里是师范大学新闻介绍
         * images : null
         * videos : null
         * publishTime : 2011-01-15T11:30:38.000+0000
         * publishName : BeautifulSoup
         * communityId : 2
         * commentNums : 0
         * starNums : 101
         * contents : [{"id":1,"imageUrl":"http://123.207.157.129/banner3.webp","videoUrl":"http://47.95.244.237:8888/group1/M00/00/00/rBElLFyGHOSAFkf3AGvX0JaiVbs497.mp3","journalismId":null,"content":"最后一步，.我们点击\u201c开始-运行\u201d接着输入'gpedit.msc\u201c打开组策略，并依次打开：'本地计算机 策略计算机配置Windows设置脚本(启动/关机)\u201d，然后在右边的框中选择项，我们把刚才建立的批处理文件添加到启动脚本列表当中，然后保存确定就可以了。"},{"id":2,"imageUrl":null,"videoUrl":null,"journalismId":null,"content":"现在电脑加密已经有很多的方法了，简单的就是在电脑上设置密码，可以总觉得不安全，买个指纹开机吧，又有点小贵。那么有没有其它方法可以保护我们的电脑，今天韩博士小编介绍一种使用u盘作为钥匙的启动方法，让电脑在插入自己的u盘才能够正常启动，让你的电脑更加的安全。但这个方法对于大神们来说是形同虚设的，没办法，家里的锁还有专门开锁的呢。防君子不防小人吧。"},{"id":3,"imageUrl":"http://123.207.157.129/banner3.webp","videoUrl":"http://47.95.244.237:8888/group1/M00/00/00/rBElLFyGHOSAFkf3AGvX0JaiVbs497.mp3","journalismId":null,"content":"新华社北京3月15日电 题：新时代的春天充满希望\u2014\u2014读懂习近平总书记的\u201c两会时间\u201d"},{"id":4,"imageUrl":null,"videoUrl":null,"journalismId":null,"content":"\u201c脱贫攻坚越到紧要关头，越要坚定必胜的信心\u201d。在甘肃代表团参加审议时，习近平总书记的一番话鼓舞人心。此时此刻，中国的反贫困斗争正是最吃劲的时候。"}]
         * comments : null
         */

        private String id;
        private String title;
        private Object author;
        private String description;
        private Object images;
        private Object videos;
        private String publishTime;
        private String publishName;
        private int communityId;
        private int commentNums;
        private int starNums;
        private Object comments;
        private List<NewsDetail> contents;

        public List<NewsDetail> getContents() {
            return contents;
        }

        public void setContents(List<NewsDetail> contents) {
            this.contents = contents;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getAuthor() {
            return author;
        }

        public void setAuthor(Object author) {
            this.author = author;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public Object getVideos() {
            return videos;
        }

        public void setVideos(Object videos) {
            this.videos = videos;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(String publishTime) {
            this.publishTime = publishTime;
        }

        public String getPublishName() {
            return publishName;
        }

        public void setPublishName(String publishName) {
            this.publishName = publishName;
        }

        public int getCommunityId() {
            return communityId;
        }

        public void setCommunityId(int communityId) {
            this.communityId = communityId;
        }

        public int getCommentNums() {
            return commentNums;
        }

        public void setCommentNums(int commentNums) {
            this.commentNums = commentNums;
        }

        public int getStarNums() {
            return starNums;
        }

        public void setStarNums(int starNums) {
            this.starNums = starNums;
        }

        public Object getComments() {
            return comments;
        }

        public void setComments(Object comments) {
            this.comments = comments;
        }

    }
}
