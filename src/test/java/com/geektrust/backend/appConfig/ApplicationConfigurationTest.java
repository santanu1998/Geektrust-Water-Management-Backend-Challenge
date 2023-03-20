package com.geektrust.backend.appConfig;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.geektrust.backend.commands.WaterManagementCommandRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("ApplicationConfigurationTest")
public class ApplicationConfigurationTest {
    private ApplicationConfiguration applicationConfiguration;

    @BeforeEach
    void setup(){
        applicationConfiguration = new ApplicationConfiguration();
    }

    @Test
    @DisplayName("should Return CommandInvoker Via GetCommandInvoker()")
    public void shouldReturnCommandInvokerViaGetCommandInvoker() {
        WaterManagementCommandRegistry waterManagementCommandRegistry = applicationConfiguration.getWaterManagementCommandRegistry();
        assertNotNull(waterManagementCommandRegistry);
    }
}
