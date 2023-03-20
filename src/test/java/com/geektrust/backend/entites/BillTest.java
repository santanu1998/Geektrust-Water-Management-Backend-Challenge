package com.geektrust.backend.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.entities.Apartments;
import com.geektrust.backend.entities.Bills;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BillTest")
public class BillTest {

    @Test
    @DisplayName("should create a bill Object")
    public void shouldCreateABillObject() {
        int apartmentType= Constants.TWO_BHK;
        String corporationIsToBoreWellRatio="1:2";
        Apartments apartments = new Apartments(apartmentType, corporationIsToBoreWellRatio);
        Bills actualBills = new Bills(apartments, 1200.0);
        assertEquals(1200.0, actualBills.getTotalAmountNeeded());
    }
}