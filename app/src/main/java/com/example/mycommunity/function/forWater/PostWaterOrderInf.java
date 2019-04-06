package com.example.mycommunity.function.forWater;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostWaterOrderInf {

    /**
     * phone : 17864195273
     * address : 山东师范大学信工楼
     * description : 送水的快点
     * hopeTime : 1552890061740
     * detailsList : [{"brandId":5,"waterNums":3},{"brandId":2,"waterNums":4}]
     */

    private String phone;
    private String address;
    private String description;
    private long hopeTime;
    private List<WaterOrderContent> detailsList;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<WaterOrderContent> getDetailsList() {
        return detailsList;
    }

    public void setDetailsList(List<WaterOrderContent> detailsList) {
        this.detailsList = detailsList;
    }
}
