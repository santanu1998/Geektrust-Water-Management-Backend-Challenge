package com.geektrust.backend.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.geektrust.backend.exceptions.NoSuchCommandException;

public class WaterManagementCommandRegistry {

    // private static final Map<String, ICommand> commands = new HashMap<>();

    // public void registerCommand(String commandKeyword, ICommand command) {
    //     commands.putIfAbsent(commandKeyword, command);
    // }

    // public void unRegisterCommand(String commandKeyword) {
    //     commands.remove(commandKeyword);
    // }

    // private ICommand get(String commandName){
    //     return commands.get(commandName);
    // }

    // private List<String> parse(String input){
    //     return Arrays.stream(input.split(" ")).collect(Collectors.toList());
    // }


    // public void invokeCommand(String input, List<String> tokens) {
    //     tokens = parse(input);
    //     ICommand command = get(tokens.get(0));
    //     if(command == null){
    //         // Handle Exception
    //         throw new NoSuchCommandException("INVALID COMMAND 🛑");
    //     } 
    //     command.invoke(tokens);
    //     return;
    // }

    private static final Map<String, ICommand> commandMap = new HashMap<>();

    // Register the command into the HashMap
    public void registerCommand(String commandName, ICommand command){
        commandMap.putIfAbsent(commandName, command);
    }

    public void unRegisterCommand(String commandKeyword) {
        commandMap.remove(commandKeyword);
    }

    // Get the registered Command
    private ICommand get(String commandName){
        return commandMap.get(commandName);
    }

    // Execute the registered Command
    public void invokeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        ICommand command = get(commandName);
        if (command == null) {
            // Handle Exception
            throw new NoSuchCommandException("INVALID COMMAND 🛑");
        }
        command.invoke(tokens);
    }

    // private static final Map<String, ICommand> commands = new HashMap<>();

    // public void registerCommand(String commandKeyword, ICommand command) {
    //     commands.putIfAbsent(commandKeyword, command);
    // }

    // public void unRegisterCommand(String commandKeyword) {
    //     commands.remove(commandKeyword);
    // }

    // private ICommand get(String commandName){
    //     return commands.get(commandName);
    // }

    // private List<String> parse(String input){
    //     return Arrays.stream(input.split(" ")).collect(Collectors.toList());
    // }


    // public void invokeCommand(String input) {
    //     List<String> tokens = parse(input);
    //     ICommand command = get(tokens.get(0));
    //     if(command == null){
    //         // Handle Exception
    //         throw new NoSuchCommandException("INVALID COMMAND 🛑");
    //     } 
    //     command.invoke(tokens);
    //     return;
    // }
}
