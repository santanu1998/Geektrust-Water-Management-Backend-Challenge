package com.geektrust.backend.services;

import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.dto.GeneratedBillDtoForNeed;
import com.geektrust.backend.entities.Apartments;
import com.geektrust.backend.entities.Bills;

public class ApartmentBillServices implements IApartmentBillServices {

    private Apartments apartments;

    public ApartmentBillServices() {
        this.apartments = new Apartments();
    }

    @Override
    public void allotWaterForApartmentHere(Integer typesOfApartments, String corporationIsToBoreWellRatioNeededHere) {
        apartments = new Apartments(typesOfApartments, corporationIsToBoreWellRatioNeededHere);
    }

    @Override
    public void addGuestToApartmentHere(Integer numberOfGuestsNeeded) {
        apartments.addGuestToApartmentHere(numberOfGuestsNeeded);
    }

    @Override
    public GeneratedBillDtoForNeed calculateBillForApartmentHere() {
        double totalAmountNeededHere = calculateBillForCorporateWaterHere() + calculateBillForBoreWellWaterNeededHere() + calculateBillForTankerWater();
        Bills bills = new Bills(apartments, totalAmountNeededHere);
        return new GeneratedBillDtoForNeed(apartments.getTotalWaterConsumedHere(), (int) Math.ceil(totalAmountNeededHere));
    }

    private double calculateBillForCorporateWaterHere() {
        return apartments.getAllocatedWaterForCorporationWaterForNecessary() * Constants.CORPORATION_WATER_RATE;
    }

    private double calculateBillForBoreWellWaterNeededHere() {
        return apartments.getAllocatedWaterForBoreWellWaterForNecessary() * Constants.BOREWELL_WATER_RATE;
    }

    private double calculateBillForTankerWater() {
        int totalWaterForAdditionalGuestsNeeded = apartments.getTotalWaterConsumedHere() - apartments.getMonthlyWaterAllocatedForTenantsAndNecessary();
        double billForTankerWaterNeededHere = 0.0;
        if (totalWaterForAdditionalGuestsNeeded <= Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE) {
            billForTankerWaterNeededHere += totalWaterForAdditionalGuestsNeeded * Constants.TANKER_WATER_SLAB_0_TO_500L_RATE;
        }
        else if (totalWaterForAdditionalGuestsNeeded > Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE
                && totalWaterForAdditionalGuestsNeeded <= Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE) {
            billForTankerWaterNeededHere += ((Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE * Constants.TANKER_WATER_SLAB_0_TO_500L_RATE) + 
                    (totalWaterForAdditionalGuestsNeeded - Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE) * Constants.TANKER_WATER_SLAB_501_TO_1500L_RATE);
        } 
        else if (totalWaterForAdditionalGuestsNeeded > Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE && totalWaterForAdditionalGuestsNeeded <= Constants.TANKER_WATER_SLAB_1501_TO_3000L_MAX_VALUE) {
            billForTankerWaterNeededHere += ((Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE * Constants.TANKER_WATER_SLAB_0_TO_500L_RATE) + (Constants.TANKER_WATER_SLAB_501_TO_1500L_Difference * Constants.TANKER_WATER_SLAB_501_TO_1500L_RATE) +
                     (totalWaterForAdditionalGuestsNeeded - Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE) * Constants.TANKER_WATER_SLAB_1501_TO_3000L_RATE);
        }
        else {
            billForTankerWaterNeededHere += ((Constants.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE * Constants.TANKER_WATER_SLAB_0_TO_500L_RATE) + 
                    (Constants.TANKER_WATER_SLAB_501_TO_1500L_Difference * Constants.TANKER_WATER_SLAB_501_TO_1500L_RATE) + 
                    (Constants.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE * Constants.TANKER_WATER_SLAB_1501_TO_3000L_RATE) + 
                    (totalWaterForAdditionalGuestsNeeded - Constants.TANKER_WATER_SLAB_1501_TO_3000L_MAX_VALUE) * Constants.TANKER_WATER_SLAB_3001_PLUS_RATE);
        }
        return billForTankerWaterNeededHere;
    }
    
}
