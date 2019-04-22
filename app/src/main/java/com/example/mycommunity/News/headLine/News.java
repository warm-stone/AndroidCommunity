package com.example.mycommunity.news.headLine;


import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

import java.util.Objects;

public class News  extends LitePalSupport {
    private String title;
    private int news_had_seen;
    private int imgId;
    private String news_content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return imgId == news.imgId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imgId);
    }

    /**
     * id : 8
     * description : 这里是航空航天大学新闻
     * publishTime : 2019-03-22T11:30:38.000+0000
     * publishName : BeautifulSoup
     * communityId : 1
     * commentNums : 0
     * starNums : 65
     */
    @SerializedName("id")
    private String newsId;
    private String description;
    private String publishTime;
    private String publishName;
    private int communityId;
    private int commentNums;
    private int starNums;
    /**
     * author : null
     * images : null
     * videos : null
     */

    private String author;
    private String images;
    private String videos;
    public News(){

    }
    public News(String title,int news_had_seen, int starNums,int imgId) {
        this.title = title;
        this.news_had_seen = news_had_seen;
        this.starNums = starNums;
        this.imgId = imgId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNews_had_seen(int news_had_seen) {
        this.news_had_seen = news_had_seen;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getTitle() {
        return title;
    }

    public int getNews_had_seen() {
        return news_had_seen;
    }

    public int getImgId() {
        return imgId;
    }

    public String getNews_content() {
        return news_content;
    }

    public String getId() {
        return newsId;
    }

    public void setId(String id) {
        newsId = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }
}
