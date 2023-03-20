package com.geektrust.backend.constants;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("ConstantsHereTest")
public class ConstantsHereTest {

    @Test
    @DisplayName("Testing Constants Value")
    public void testCheckingConstantsValue(){
        assertEquals(10, ConstantsHere.CONSUMPTION_OF_A_PERSON_PER_DAY_HERE);
        assertNotEquals(25, ConstantsHere.NO_OF_DAYS_IN_A_MONTH_HERE);
        assertEquals(1500, ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_MAX_VALUE_HERE);
        assertEquals(1000, ConstantsHere.TANKER_WATER_SLAB_501_TO_1500L_Difference_HERE);
        assertNotEquals(2, ConstantsHere.TENANTS_IN_TWO_BHK_HERE);
    }
}
