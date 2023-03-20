package com.geektrust.backend.entities;

import com.geektrust.backend.constants.Constants;

public class Apartments {
    private Integer typesOfApartments;
    private Integer numberOfAdditionalGuests;
    private Integer totalNumberOfTenants;
    private double allocatedWaterForCorporationWaterForNecessary;
    private double allocatedWaterForBoreWellWaterForNecessary;
    private Integer totalWaterConsumedHere;

    private Integer monthlyWaterAllocatedForTenantsAndNecessary;

    public  Apartments(){}
    public Apartments(Integer typesOfApartments, String corporationIsToBoreWellRatioGivenHere) {
        this.typesOfApartments = typesOfApartments;
        totalNumberOfTenants = 0;
        numberOfAdditionalGuests = 0;
        totalWaterConsumedHere = 0;
        allocatedWaterForCorporationWaterForNecessary = 0.0;
        allocatedWaterForBoreWellWaterForNecessary = 0.0;
        monthlyWaterAllocatedForTenantsAndNecessary = 0;
        setTotalNumberOfTenantsInApartments();
        setMonthlyWaterAllocatedForTenantsAndTotalWaterConsumedHere();
        allotWaterToCorporateAndBoreWellHere(corporationIsToBoreWellRatioGivenHere);
    }

    private void setTotalNumberOfTenantsInApartments() {
        if (typesOfApartments.equals(Constants.TWO_BHK)) {
            totalNumberOfTenants = Constants.TENANTS_IN_TWO_BHK;
        }
        else if (typesOfApartments.equals(Constants.THREE_BHK)) {
            totalNumberOfTenants = Constants.TENANTS_IN_THERE_BHK;
        }
    }

    private void allotWaterToCorporateAndBoreWellHere(String corporationIsToBoreWellRatioGivenHere) {
        String [] ratioSplitHere = corporationIsToBoreWellRatioGivenHere.split(":");
        int corporateMultiplierHere = Integer.parseInt(ratioSplitHere[Constants.ZERO]);
        int boreWellMultiplierHere = Integer.parseInt(ratioSplitHere[Constants.ONE]);
        int totalSumOfMultiplierHere = corporateMultiplierHere + boreWellMultiplierHere;
        allocatedWaterForCorporationWaterForNecessary = (double) (totalWaterConsumedHere * corporateMultiplierHere) / totalSumOfMultiplierHere;
        allocatedWaterForBoreWellWaterForNecessary = (double) (totalWaterConsumedHere * boreWellMultiplierHere) / totalSumOfMultiplierHere;
    }

    private void setMonthlyWaterAllocatedForTenantsAndTotalWaterConsumedHere() {
        monthlyWaterAllocatedForTenantsAndNecessary = totalNumberOfTenants * Constants.CONSUMPTION_OF_A_PERSON_PER_DAY*Constants.NO_OF_DAYS_IN_A_MONTH;
        totalWaterConsumedHere = monthlyWaterAllocatedForTenantsAndNecessary;
    }

    public void addGuestToApartmentHere(int numberOfGuest) {
        numberOfAdditionalGuests += numberOfGuest;
        totalWaterConsumedHere += numberOfGuest * Constants.NO_OF_DAYS_IN_A_MONTH*Constants.CONSUMPTION_OF_A_PERSON_PER_DAY;
    }

    public Integer getNoOfAdditionalGuestHere() {
        return numberOfAdditionalGuests;
    }

    public double getAllocatedWaterForCorporationWaterForNecessary() {
        return allocatedWaterForCorporationWaterForNecessary;
    }

    public double getAllocatedWaterForBoreWellWaterForNecessary() {
        return allocatedWaterForBoreWellWaterForNecessary;
    }

    public Integer getTotalWaterConsumedHere() {
        return totalWaterConsumedHere;
    }

    public Integer getMonthlyWaterAllocatedForTenantsAndNecessary() {
        return monthlyWaterAllocatedForTenantsAndNecessary;
    }

}
