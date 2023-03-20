package com.geektrust.backend.commands;

public enum WaterManagementCommandKeyword {
    
    ALLOT_WATER_COMMAND("ALLOT_WATER"),
    ADD_GUESTS_COMMAND("ADD_GUESTS"),
    BILL_COMMAND("BILL");

    private final String name;
    private WaterManagementCommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
