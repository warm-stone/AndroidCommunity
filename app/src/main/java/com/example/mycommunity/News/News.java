package com.example.mycommunity.News;


import org.litepal.crud.LitePalSupport;

public class News  extends LitePalSupport {
    private String title;
    private String news_had_seen;
    private String news_had_heart;
    private int imgId;
    private String news_content;

    public News(){

    }
    public News(String title,String news_had_seen, String news_had_heart,int imgId) {
        this.title = title;
        this.news_had_seen = news_had_seen;
        this.news_had_heart = news_had_heart;
        this.imgId = imgId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNews_had_seen(String news_had_seen) {
        this.news_had_seen = news_had_seen;
    }

    public void setNews_had_heart(String news_had_heart) {
        this.news_had_heart = news_had_heart;
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

    public String getNews_had_seen() {
        return news_had_seen;
    }

    public String getNews_had_heart() {
        return news_had_heart;
    }

    public int getImgId() {
        return imgId;
    }

    public String getNews_content() {
        return news_content;
    }
}
