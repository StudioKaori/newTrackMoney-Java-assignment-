package com.studiokaori.trackmoney.model;

import java.util.Scanner;

/**
 *
 */
public class CommandValidation {
    private Scanner scanner;

    /**
     * Create a parser to read from the terminal window.
     */
    public CommandValidation() {
        scanner = new Scanner(System.in);
    }

    /**
     * @return int
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
