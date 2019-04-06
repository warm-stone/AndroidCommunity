package com.example.mycommunity.function.forWater;

public class WaterOrderContent {
    /**
     * brandId : 5
     * waterNums : 3
     */

    private int brandId;
    private int waterNums;

    public WaterOrderContent(int brandId, int waterNums) {
        this.brandId = brandId;
        this.waterNums = waterNums;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getWaterNums() {
        return waterNums;
    }

    public void setWaterNums(int waterNums) {
        this.waterNums = waterNums;
    }
}
