package com.geektrust.backend.entities;

public class Bills {
    private final Apartments apartments;
    private Double totalAmountNeeded;

    public Bills(Apartments apartments, Double totalAmountNeeded) {
        this.apartments = apartments;
        this.totalAmountNeeded = totalAmountNeeded;
    }
    public Double getTotalAmountNeeded() {
        return totalAmountNeeded;
    }
}
