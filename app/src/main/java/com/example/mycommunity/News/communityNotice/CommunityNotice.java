package com.example.mycommunity.news.communityNotice;

import com.google.gson.annotations.SerializedName;

import org.litepal.crud.LitePalSupport;

public class CommunityNotice extends LitePalSupport {
    /**
     * id : 36
     * notice : 3月份补缴水费通知
     * showtime : 1551451767000
     * communityId : 1
     * description : 万事起于忽微，量变引起质变
     */
    @SerializedName("id")
    private int noticeId;
    private String notice;
    private long showtime;
    private int communityId;
    private String description;

    public int getId() {
        return noticeId;
    }

    public void setId(int id) {
        noticeId = id;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public long getShowtime() {
        return showtime;
    }

    public void setShowtime(long showtime) {
        this.showtime = showtime;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
