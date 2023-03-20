package com.geektrust.backend.entities;

import com.geektrust.backend.constants.ConstantsHere;

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
        if (typesOfApartments.equals(ConstantsHere.TWO_BHK_HERE)) {
            totalNumberOfTenants = ConstantsHere.TENANTS_IN_TWO_BHK_HERE;
        }
        else if (typesOfApartments.equals(ConstantsHere.THREE_BHK_HERE)) {
            totalNumberOfTenants = ConstantsHere.TENANTS_IN_THERE_BHK_HERE;
        }
    }

    private void allotWaterToCorporateAndBoreWellHere(String corporationIsToBoreWellRatioGivenHere) {
        String [] ratioSplitHere = corporationIsToBoreWellRatioGivenHere.split(":");
        int corporateMultiplierHere = Integer.parseInt(ratioSplitHere[ConstantsHere.ZERO_HERE]);
        int boreWellMultiplierHere = Integer.parseInt(ratioSplitHere[ConstantsHere.ONE_HERE]);
        int totalSumOfMultiplierHere = corporateMultiplierHere + boreWellMultiplierHere;
        allocatedWaterForCorporationWaterForNecessary = (double) (totalWaterConsumedHere * corporateMultiplierHere) / totalSumOfMultiplierHere;
        allocatedWaterForBoreWellWaterForNecessary = (double) (totalWaterConsumedHere * boreWellMultiplierHere) / totalSumOfMultiplierHere;
    }

    private void setMonthlyWaterAllocatedForTenantsAndTotalWaterConsumedHere() {
        monthlyWaterAllocatedForTenantsAndNecessary = totalNumberOfTenants * ConstantsHere.CONSUMPTION_OF_A_PERSON_PER_DAY_HERE * ConstantsHere.NO_OF_DAYS_IN_A_MONTH_HERE;
        totalWaterConsumedHere = monthlyWaterAllocatedForTenantsAndNecessary;
    }

    public void addGuestToApartmentHere(int numberOfGuest) {
        numberOfAdditionalGuests += numberOfGuest;
        totalWaterConsumedHere += numberOfGuest * ConstantsHere.NO_OF_DAYS_IN_A_MONTH_HERE * ConstantsHere.CONSUMPTION_OF_A_PERSON_PER_DAY_HERE;
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
