package com.studiokaori.trackmoney.controller;

import com.studiokaori.trackmoney.item.Item;
import com.studiokaori.trackmoney.model.CommandValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Controller {
    protected CommandValidation commandValidation;
    protected List<String> commandMenu;
    protected List<Item> items;
    protected Scanner scanner;


    public Controller() {

        items = new ArrayList<>();

    }

    public Controller(List<Item> items) {

        this.items = items;
        scanner = new Scanner(System.in);

    }

    public void printFirstInstruction() {

        System.out.println("Please input the menu number.");

    }

    protected int getInput() {

        // Reading commands and execute them until the tracker is over.
        boolean finished = false;
        int commandNumber = 0;

        while (!finished) {

            try {

                commandNumber = commandValidation.getCommand();
                finished = true;

            } catch (IllegalArgumentException e) {

                System.out.println("Invalid menu number.");
                System.out.println("Please input menu number.");

            }

        }
        return commandNumber;
    }


    protected void showCommandList() {

        for (int i = 0; i < commandMenu.size(); i++) {
            System.out.println("(" + i + ") " + commandMenu.get(i));
        }

    }

    protected void backToMainMenu() {

        new MainController(items);

    }


    abstract void run();

}
