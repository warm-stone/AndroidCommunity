package com.example.mycommunity.function.repair;

public class RepairInformation {
    /**
     * telephone : 17864195273
     * address : 北京市中关村
     * description : 需要整修
     * hopeTime : 1552890061740
     */

    private String telephone;
    private String address;
    private String description;
    private long hopeTime;

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getHopeTime() {
        return hopeTime;
    }

    public void setHopeTime(long hopeTime) {
        this.hopeTime = hopeTime;
    }
}
