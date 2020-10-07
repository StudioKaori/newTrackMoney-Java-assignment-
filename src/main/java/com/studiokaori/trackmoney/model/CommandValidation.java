package com.studiokaori.trackmoney.model;

import java.util.Scanner;

/**
 *
 */
public class CommandValidation {
    private Scanner scanner;
    private int numberOfCommands;

    /**
     * Create a parser to read from the terminal window.
     */
    public CommandValidation(int numberOfCommands) {
        scanner = new Scanner(System.in);
        this.numberOfCommands = numberOfCommands;
    }

    /**
     * @return int
     */
    public int getCommand() throws IllegalArgumentException, NumberFormatException {

        System.out.print("> ");

        String inputLine = scanner.nextLine();
        int commandNumber = Integer.parseInt(inputLine);

        if (commandNumber > numberOfCommands) {
            throw new IllegalArgumentException("Invalid command");
        }

        return commandNumber;
    }

}
