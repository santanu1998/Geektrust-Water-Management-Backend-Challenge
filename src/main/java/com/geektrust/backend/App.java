package com.geektrust.backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.geektrust.backend.appConfig.ApplicationConfiguration;
import com.geektrust.backend.commands.WaterManagementCommandRegistry;
import com.geektrust.backend.constants.ConstantsHere;
import com.geektrust.backend.exceptions.NoSuchCommandException;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException();
        }
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        run(commandLineArgs);
    }

    public static void run(List<String> commandLineArgs) {

        // Configuration conf = Configuration.getInstance();

        // // CommandRegistry commandRegistry = conf.getCommandRegistry();

        // WaterManagementCommandRegistry waterManagementCommandRegistry = conf.getWaterManagementCommandRegistry();
        
        // String inputFile = commandLineArgs.get(0).split("=")[1];

        // try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

        //     while (true) {
        //         String line = reader.readLine();
        //         if (line == null){
        //             break;
        //         }
        //         // commandRegistry.invokeCommand(line);
        //         waterManagementCommandRegistry.invokeCommand(line);
        //     }
        // } 
        // catch (Exception e) {
        //     e.printStackTrace();
        // }

        // Configuration conf = Configuration.getInstance();

        // // CommandRegistry commandRegistry = conf.getCommandRegistry();

        // WaterManagementCommandRegistry waterManagementCommandRegistry = conf.getWaterManagementCommandRegistry();
        
        // String inputFile = commandLineArgs.get(0).split("=")[1];

        // try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

        //     while (true) {
        //         String line = reader.readLine();
        //         if (line == null){
        //             break;
        //         }
        //         List<String> tokens = Arrays.asList(line.split(" "));
        //         waterManagementCommandRegistry.invokeCommand(tokens.get(0),tokens);
        //     }
        // } 
        // catch (Exception e) {
        //     e.printStackTrace();
        // }

        // Configuration configuration = Configuration.getInstance();
		// WaterManagementCommandRegistry waterManagementCommandRegistry = configuration.getWaterManagementCommandRegistry();
		// BufferedReader reader;
		// String inputFile = commandLineArgs.get(ConstantsHere.ZERO_HERE);
		// try {
		// 	reader = new BufferedReader(new FileReader(inputFile));
		// 	String line = reader.readLine();
		// 	while (line != null) {
		// 		List<String> tokens = Arrays.asList(line.split(" "));
		// 		waterManagementCommandRegistry.invokeCommand(tokens.get(ConstantsHere.ZERO_HERE),tokens);
		// 		// read next line
		// 		line = reader.readLine();
		// 	}
		// 	reader.close();
		// } catch (IOException | NoSuchCommandException e) {
		// 	e.printStackTrace();
		// }

        ApplicationConfiguration applicationConfiguration = new ApplicationConfiguration();
		WaterManagementCommandRegistry waterManagementCommandRegistry = applicationConfiguration.getWaterManagementCommandRegistry();
		BufferedReader reader;
		String inputFile = commandLineArgs.get(ConstantsHere.ZERO_HERE);
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while (line != null) {
				List<String> tokens = Arrays.asList(line.split(" "));
				waterManagementCommandRegistry.invokeCommand(tokens.get(ConstantsHere.ZERO_HERE), tokens);
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} 
        catch (IOException | NoSuchCommandException e) {
			e.printStackTrace();
		}
    }
}
