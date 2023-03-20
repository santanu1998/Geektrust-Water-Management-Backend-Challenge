package com.geektrust.backend.commands;

import java.util.List;
import com.geektrust.backend.exceptions.NoSuchCommandException;
import com.geektrust.backend.services.IApartmentBillServices;

public class BillCommand implements ICommand {

    private final IApartmentBillServices apartmentBillServices;

    public BillCommand(IApartmentBillServices apartmentBillServices) {
        this.apartmentBillServices = apartmentBillServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        try {
            System.out.println(apartmentBillServices.calculateBillForApartmentHere());
        } 
        catch (NoSuchCommandException e) {
            System.out.println("Invalid Command");
        } 
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
