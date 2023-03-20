package com.geektrust.backend.services;

import com.geektrust.backend.constants.ConstantsHere;
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
        return apartments.getAllocatedWaterForCorporationWaterForNecessary() * ConstantsHere.CORPORATION_WATER_RATE_HERE;
    }

    private double calculateBillForBoreWellWaterNeededHere() {
        return apartments.getAllocatedWaterForBoreWellWaterForNecessary() * ConstantsHere.BOREWELL_WATER_RATE_HERE;
    }

    private double calculateBillForTankerWater() {
        int totalWaterForAdditionalGuestsNeeded = apartments.getTotalWaterConsumedHere() - apartments.getMonthlyWaterAllocatedForTenantsAndNecessary();
        double billForTankerWaterNeededHere = 0.0;
        if (totalWaterForAdditionalGuestsNeeded <= ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE_HERE) {
            billForTankerWaterNeededHere += totalWaterForAdditionalGuestsNeeded * ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_RATE_HERE;
        }
        else if (totalWaterForAdditionalGuestsNeeded > ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE_HERE
                && totalWaterForAdditionalGuestsNeeded <= ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE_HERE) {
            billForTankerWaterNeededHere += ((ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE_HERE * ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_RATE_HERE) + 
                    (totalWaterForAdditionalGuestsNeeded - ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE_HERE) * ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_RATE_HERE);
        } 
        else if (totalWaterForAdditionalGuestsNeeded > ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE_HERE && totalWaterForAdditionalGuestsNeeded <= ConstantsHere.TANKER_WATER_SLAB_1501_TO_3000L_MAX_VALUE_HERE) {
            billForTankerWaterNeededHere += ((ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE_HERE * ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_RATE_HERE) + (ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_Difference_HERE * ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_RATE_HERE) +
                     (totalWaterForAdditionalGuestsNeeded - ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE_HERE) * ConstantsHere.TANKER_WATER_SLAB_1501_TO_3000L_RATE_HERE);
        }
        else {
            billForTankerWaterNeededHere += ((ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_MAX_VALUE_HERE * ConstantsHere.TANKER_WATER_SLAB_0_TO_500L_RATE_HERE) + 
                    (ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_Difference_HERE * ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_RATE_HERE) + 
                    (ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE_HERE * ConstantsHere.TANKER_WATER_SLAB_1501_TO_3000L_RATE_HERE) + 
                    (totalWaterForAdditionalGuestsNeeded - ConstantsHere.TANKER_WATER_SLAB_1501_TO_3000L_MAX_VALUE_HERE) * ConstantsHere.TANKER_WATER_SLAB_3001_PLUS_RATE_HERE);
        }
        return billForTankerWaterNeededHere;
    }
    
}
