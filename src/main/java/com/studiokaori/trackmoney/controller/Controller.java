package com.studiokaori.trackmoney.controller;

import com.studiokaori.trackmoney.item.Item;
import com.studiokaori.trackmoney.model.CommandValidation;
import com.studiokaori.trackmoney.model.MyScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class provides basic functions and a skeletal implementation of controller class.
 *
 * @author Kaori Persson
 * @version 2020.09
 */

public abstract class Controller {
    protected CommandValidation commandValidation;
    protected List<String> commandMenu;
    protected List<Item> items;
    protected Scanner scanner;


    /**
     * Constructs controller with an empty items list to hold expenses and incomes.
     * Initially this constructor is called.
     */
    public Controller() {

        items = new ArrayList<>();

    }

    /**
     * Constructs controller with already exist items list to hold expenses and incomes.
     * This constructor is used when other controller calls.
     */
    public Controller(List<Item> items) {

        this.items = items;
        scanner = MyScanner.getInstance();

    }

    /**
     * When the controller is called, this method is initially called.
     */
    abstract void run();


    /**
     * Prints first instruction.
     */
    protected void printFirstInstruction() {

        System.out.println("Please input the menu number.");

    }

    /**
     * Reads user input from the console, and evaluate if the input is valid command or not.
     * If it's not valid command, prompts back to user.
     */
    protected int getInput() {

        // Reading commands and execute them until the tracker is over.
        int commandNumber = 0;

        try {

            commandNumber = commandValidation.getCommand(commandMenu.size());

        } catch (IllegalArgumentException e) {

            System.out.println("Invalid menu number.");
            System.out.println("Please input menu number.");
            getInput();

        }

        return commandNumber;
    }


    /**
     * Shows current command list in the commandMenu.
     */
    protected void showCommandList() {

        for (int i = 0; i < commandMenu.size(); i++) {
            System.out.println("(" + i + ") " + commandMenu.get(i));
        }

    }

    /**
     * Brings back you to the main menu.
     */
    protected void backToMainMenu() {

        new MainController(items).run();

    }


}
