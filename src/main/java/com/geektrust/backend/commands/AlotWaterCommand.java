package com.geektrust.backend.commands;

import java.util.List;
import com.geektrust.backend.constants.ConstantsHere;
import com.geektrust.backend.exceptions.NoSuchCommandException;
import com.geektrust.backend.services.IApartmentBillServices;

public class AlotWaterCommand implements ICommand {

    private final IApartmentBillServices apartmentBillServices;

    public AlotWaterCommand(IApartmentBillServices apartmentBillServices) {
        this.apartmentBillServices = apartmentBillServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        try {
            apartmentBillServices.allotWaterForApartmentHere(Integer.valueOf(tokens.get(ConstantsHere.ONE_HERE)),tokens.get(ConstantsHere.TWO_HERE));
        } 
        catch (NoSuchCommandException e) {
            System.out.println("Invalid Command");
        } 
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
