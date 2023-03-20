package com.geektrust.backend.commands;

import com.geektrust.backend.exceptions.NoSuchCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyList;

@DisplayName("WaterManagementCommandRegistryTest")
@ExtendWith(MockitoExtension.class)
public class WaterManagementCommandRegistryTest {

    private WaterManagementCommandRegistry waterManagementCommandRegistry;

    @Mock
    AlotWaterCommand alotWaterCommand;

    @Mock
    AddGuestsCommand addGuestsCommand;

    @Mock
    BillCommand billCommand;

    @BeforeEach
    void setup() {
        waterManagementCommandRegistry = new WaterManagementCommandRegistry();
        waterManagementCommandRegistry.registerCommand("ALLOT_WATER", alotWaterCommand);
        waterManagementCommandRegistry.registerCommand("ADD_GUESTS", addGuestsCommand);
        waterManagementCommandRegistry.registerCommand("BILL", billCommand);
    }

    @Test
    @DisplayName("executeCommand method Should Execute Command Given CommandName and List of tokens")
    public void executeCommand_GivenNameAndTokens_ShouldExecuteCommand() {
        waterManagementCommandRegistry.invokeCommand("ALLOT_WATER", anyList());
        waterManagementCommandRegistry.invokeCommand("ADD_GUESTS", anyList());
        waterManagementCommandRegistry.invokeCommand("BILL", anyList());

    }

    @Test
    @DisplayName("executeCommand method Should Throw Exception Given Incorrect CommandName and List of tokens")
    public void executeCommand_GivenIncorrectNameAndTokens_ShouldThrowException() {
        //Act and Assert
        Assertions.assertThrows(NoSuchCommandException.class,() -> waterManagementCommandRegistry.invokeCommand("RANDOM-COMMAND", new ArrayList<String>()));

    }
    
}
