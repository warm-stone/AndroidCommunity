package com.example.mycommunity.news.headLine.newsDetail;

public class NewsDetail {
    /**
     * id : 1
     * imageUrl : http://123.207.157.129/banner3.webp
     * videoUrl : http://47.95.244.237:8888/group1/M00/00/00/rBElLFyGHOSAFkf3AGvX0JaiVbs497.mp3
     * journalismId : null
     * content : 最后一步，.我们点击“开始-运行”接着输入'gpedit.msc“打开组策略，并依次打开：'本地计算机 策略计算机配置Windows设置脚本(启动/关机)”，然后在右边的框中选择项，我们把刚才建立的批处理文件添加到启动脚本列表当中，然后保存确定就可以了。
     */

    private int id;
    private String imageUrl;
    private String videoUrl;
    private Object journalismId;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Object getJournalismId() {
        return journalismId;
    }

    public void setJournalismId(Object journalismId) {
        this.journalismId = journalismId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
