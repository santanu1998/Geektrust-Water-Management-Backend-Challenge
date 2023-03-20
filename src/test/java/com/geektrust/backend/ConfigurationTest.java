package com.geektrust.backend;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.geektrust.backend.commands.WaterManagementCommandRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("ConfigurationTest")
public class ConfigurationTest {
    private Configuration configuration;
    @BeforeEach
    void setup() {
        configuration = Configuration.getInstance();
    }
    @Test
    @DisplayName("should Return CommandInvoker Via GetCommandInvokerHere()")
    public void shouldReturnCommandInvokerViaGetCommandInvokerHere() {
        WaterManagementCommandRegistry waterManagementCommandRegistry = configuration.getWaterManagementCommandRegistry();
        assertNotNull(waterManagementCommandRegistry);
    }
}
