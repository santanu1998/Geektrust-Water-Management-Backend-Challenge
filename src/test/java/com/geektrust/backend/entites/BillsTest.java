package com.geektrust.backend.entites;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.constants.ConstantsHere;
import com.geektrust.backend.entities.Apartments;
import com.geektrust.backend.entities.Bills;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BillsTest")
public class BillsTest {

    @Test
    @DisplayName("should create a bill Object")
    public void shouldCreateABillObject() {
        int apartmentType = ConstantsHere.TWO_BHK_HERE;
        String corporationIsToBoreWellRatio = "1:2";
        Apartments apartments = new Apartments(apartmentType, corporationIsToBoreWellRatio);
        Bills actualBills = new Bills(apartments, 1200.0);
        assertEquals(1200.0, actualBills.getTotalAmountNeeded());
    }
}