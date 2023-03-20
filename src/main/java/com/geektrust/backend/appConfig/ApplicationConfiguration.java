package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.AddGuestsCommand;
import com.geektrust.backend.commands.AlotWaterCommand;
import com.geektrust.backend.commands.BillCommand;
import com.geektrust.backend.commands.WaterManagementCommandRegistry;
import com.geektrust.backend.services.ApartmentBillServices;
import com.geektrust.backend.services.IApartmentBillServices;

public class ApplicationConfiguration {
    private final IApartmentBillServices apartmentBillService = new ApartmentBillServices();
    private final AlotWaterCommand alotWaterCommand = new AlotWaterCommand(apartmentBillService);
    private final AddGuestsCommand addGuestCommand = new AddGuestsCommand(apartmentBillService);
    private final BillCommand billCommand = new BillCommand(apartmentBillService);
    private final WaterManagementCommandRegistry waterManagementCommandRegistry = new WaterManagementCommandRegistry();

    public WaterManagementCommandRegistry getWaterManagementCommandRegistry() {
        waterManagementCommandRegistry.registerCommand("ALLOT_WATER", alotWaterCommand);
        waterManagementCommandRegistry.registerCommand("ADD_GUESTS", addGuestCommand);
        waterManagementCommandRegistry.registerCommand("BILL", billCommand);
        return waterManagementCommandRegistry;
    }
}
