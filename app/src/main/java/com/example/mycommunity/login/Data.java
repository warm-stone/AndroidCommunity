package com.example.mycommunity.login;

import java.io.Serializable;

public class Data implements Serializable {
    /**
     * id : 1
     * name : 中北路社区
     * address : 北京市朝阳区中北路社区
     * admin : 松哥
     */

    private int id;
    private String name;
    private String address;
    private String admin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
