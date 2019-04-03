package com.example.mycommunity.news;

public class CommunityNotice {
    /**
     * id : 36
     * notice : 3月份补缴水费通知
     * showtime : 1551451767000
     * communityId : 1
     * description : 万事起于忽微，量变引起质变
     */

    private int id;
    private String notice;
    private long showtime;
    private int communityId;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
