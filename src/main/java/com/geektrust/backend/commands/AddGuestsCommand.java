package com.geektrust.backend.commands;

import java.util.List;
import com.geektrust.backend.constants.Constants;
import com.geektrust.backend.exceptions.NoSuchCommandException;
import com.geektrust.backend.services.IApartmentBillServices;

public class AddGuestsCommand implements ICommand {

    private final IApartmentBillServices apartmentBillServices;

    public AddGuestsCommand(IApartmentBillServices apartmentBillServices) {
        this.apartmentBillServices = apartmentBillServices;
    }

    @Override
    public void invoke(List<String> tokens) {
        try {
            apartmentBillServices.addGuestToApartmentHere(Integer.valueOf(tokens.get(Constants.ONE)));
        } 
        catch (NoSuchCommandException e) {
            System.out.println("Invalid Command");
        } 
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
