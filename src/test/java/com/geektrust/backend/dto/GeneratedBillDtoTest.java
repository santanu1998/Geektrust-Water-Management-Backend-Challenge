package com.geektrust.backend.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("GeneratedBillDtoTest")
public class GeneratedBillDtoTest {
    @Test
    @DisplayName("should create a GeneratedBillDto Object")
    public void shouldCreateAGeneratedBillDtoObject() {
        GeneratedBillDtoForNeed generatedBillDtoForNeed = new GeneratedBillDtoForNeed(900,1200);
        String expectedString = "900 1200";
        String acutalString = generatedBillDtoForNeed.toString();
        assertEquals(expectedString, acutalString);
    }
}