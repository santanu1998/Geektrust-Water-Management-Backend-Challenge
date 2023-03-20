// package com.geektrust.backend.configuration;

// import com.geektrust.backend.commands.AddGuestsCommand;
// import com.geektrust.backend.commands.AlotWaterCommand;
// import com.geektrust.backend.commands.BillCommand;
// import com.geektrust.backend.commands.WaterManagementCommandKeyword;
// import com.geektrust.backend.commands.WaterManagementCommandRegistry;
// import com.geektrust.backend.services.ApartmentBillServices;
// import com.geektrust.backend.services.IApartmentBillServices;

// public class Configuration {
//     private static Configuration instance = new Configuration();
//     private Configuration(){}
//     public static Configuration getInstance(){
//         return instance;
//     }
//     private final IApartmentBillServices apartmentBillServices = new ApartmentBillServices();
//     private final AddGuestsCommand addGuestsCommand = new AddGuestsCommand(apartmentBillServices);
//     private final AlotWaterCommand alotWaterCommand = new AlotWaterCommand(apartmentBillServices);
//     private final BillCommand billCommand = new BillCommand(apartmentBillServices);
//     private final WaterManagementCommandRegistry waterManagementCommandRegistry = new WaterManagementCommandRegistry();
//     private void registerCommands() {
//         waterManagementCommandRegistry.registerCommand(WaterManagementCommandKeyword.ADD_GUESTS_COMMAND.getName(),addGuestsCommand);
//         waterManagementCommandRegistry.registerCommand(WaterManagementCommandKeyword.ALLOT_WATER_COMMAND.getName(),alotWaterCommand);
//         waterManagementCommandRegistry.registerCommand(WaterManagementCommandKeyword.BILL_COMMAND.getName(),billCommand);
//     }
//     public WaterManagementCommandRegistry getWaterManagementCommandRegistry() {
//         registerCommands();
//         return waterManagementCommandRegistry;
//     }
// }
