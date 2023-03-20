package com.geektrust.backend.dto;

public class GeneratedBillDtoForNeed {
    private Integer totalWaterConsumedToManage;
    private Integer OverallCost;

    public GeneratedBillDtoForNeed(Integer totalWaterConsumedToManage, Integer OverallCost) {
        this.totalWaterConsumedToManage = totalWaterConsumedToManage;
        this.OverallCost = OverallCost;
    }

    @Override
    public String toString() {
        return totalWaterConsumedToManage + " " + OverallCost;
    }

}
