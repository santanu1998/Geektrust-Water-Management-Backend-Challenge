package com.geektrust.backend.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.entities.Apartments;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ApartmentTest")
public class ApartmentTest {

    @Test
    @DisplayName("checkIfApartment is assigning correct water allocation for Two Bhk")
    public void testCheckingAllotWaterToCorporateAndBoreWellForTwoBhk(){
        int apartmentType=Constants.TWO_BHK;
        String corporationIsToBoreWellRatio="3:7";
        Apartments apartments = new Apartments(apartmentType,corporationIsToBoreWellRatio);
        assertEquals(900,apartments.getMonthlyWaterAllocatedForTenantsAndNecessary());
        assertEquals(270,apartments.getAllocatedWaterForCorporationWaterForNecessary());
        assertEquals(630,apartments.getAllocatedWaterForBoreWellWaterForNecessary());
    }
    @Test
    @DisplayName("should create a default Apartment")
    public void shouldCreateADefaultApartment() {
        Apartments apartments = new Apartments();
        assertNotNull(apartments);
    }

    @Test
    @DisplayName("checkIfApartment is assigning correct water allocation for Three Bhk")
    public void testCheckingAllotWaterToCorporateAndBoreWellForThreeBhk(){
        int apartmentType=Constants.THREE_BHK;
        String corporationIsToBoreWellRatio="3:7";
        Apartments apartments = new Apartments(apartmentType, corporationIsToBoreWellRatio);
        assertEquals(1500, apartments.getMonthlyWaterAllocatedForTenantsAndNecessary());
        assertEquals(450, apartments.getAllocatedWaterForCorporationWaterForNecessary());
        assertEquals(1050, apartments.getAllocatedWaterForBoreWellWaterForNecessary());
    }

    @Test
    @DisplayName("addGuestToApartment is assigning correct no of guest and total water consumed")
    public void testCheckingAddGuestToApartment() {
        int apartmentType = 2;
        String corporationIsToBoreWellRatio = "3:7";
        Apartments apartments = new Apartments(Constants.TWO_BHK, corporationIsToBoreWellRatio);
        apartments.addGuestToApartmentHere(2);
        assertEquals(2, apartments.getNoOfAdditionalGuestHere());
        assertEquals(1500, apartments.getTotalWaterConsumedHere());
    }


}