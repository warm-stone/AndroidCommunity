package com.example.mycommunity.news.popertyNotice;

import org.litepal.crud.LitePalSupport;

public class PropertyNotice extends LitePalSupport {
    /**
     * id : 36
     * notice : 3月份补缴水费通知
     * showtime : 1551451767000
     * userId : 1
     */

    private int id;
    private String notice;
    private long showtime;
    private int userId;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
