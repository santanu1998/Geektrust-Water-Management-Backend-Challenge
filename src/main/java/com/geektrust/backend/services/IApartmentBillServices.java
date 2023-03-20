package com.geektrust.backend.services;

import com.geektrust.backend.dto.GeneratedBillDtoForNeed;

public interface IApartmentBillServices {
    public void allotWaterForApartmentHere(Integer typesOfApartments, String corporationIsToBoreWellRatioNeededHere);
    public void addGuestToApartmentHere(Integer numberOfGuestsNeeded);
    public GeneratedBillDtoForNeed calculateBillForApartmentHere();
}
