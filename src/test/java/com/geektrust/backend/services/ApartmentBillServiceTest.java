package com.geektrust.backend.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.dto.GeneratedBillDtoForNeed;
import com.geektrust.backend.entities.Apartments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("ApartmentBillServiceTest")
@ExtendWith(MockitoExtension.class)
public class ApartmentBillServiceTest {

    @Mock
    private ApartmentBillServices apartmentBillServiceMock;

    @Test
    @DisplayName("should Generate Bill For Apartment")
    public void shouldGenerateBillForApartments(){
        //Arrange
        String corporationIsToBoreWellRatio = "1:2";
        Apartments expectedApartment = new Apartments(Constants.TWO_BHK, corporationIsToBoreWellRatio);
        GeneratedBillDtoForNeed generatedBillDtoExpected=new GeneratedBillDtoForNeed(900, 1200);
        when(apartmentBillServiceMock.calculateBillForApartmentHere()).thenReturn(generatedBillDtoExpected);

        //Act
        GeneratedBillDtoForNeed generatedBillDtoActual = apartmentBillServiceMock.calculateBillForApartmentHere();

        //Assert
        Assertions.assertEquals(generatedBillDtoExpected,generatedBillDtoActual);
        verify(apartmentBillServiceMock,times(1)).calculateBillForApartmentHere();
    }



}