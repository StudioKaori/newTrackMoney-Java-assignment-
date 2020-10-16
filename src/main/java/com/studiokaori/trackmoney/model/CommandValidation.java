package com.studiokaori.trackmoney.model;

import java.util.Scanner;

/**
 * This class checks if the input from users is valid command number or not.
 */
public class CommandValidation {
    private Scanner scanner;

    public CommandValidation() {
        scanner = new Scanner(System.in);
    }

    /**
     * If command is not valid, throw exception
     *
     * @return int command number
     * @throws IllegalArgumentException is thrown when the command is not valid.
     */
    public int getCommand(int numberOfCommands) throws IllegalArgumentException, NumberFormatException {

        System.out.print("> ");

        String inputLine = scanner.nextLine();
        int commandNumber = Integer.parseInt(inputLine);

        if (commandNumber > numberOfCommands) {
            throw new IllegalArgumentException("Invalid command");
        }

        return commandNumber;
    }

}
