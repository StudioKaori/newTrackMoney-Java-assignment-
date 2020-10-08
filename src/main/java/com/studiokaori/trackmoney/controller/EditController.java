package com.studiokaori.trackmoney.controller;

import com.studiokaori.trackmoney.item.Item;
import com.studiokaori.trackmoney.model.CommandValidation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main class of the "Track Money" application.
 * "rack Money" is a very simple, text based money tracker.
 *
 * @author Kaori Persson
 * @version 2020.09
 */

public class EditController extends EditItemController {

    public EditController(List<Item> items) {

        super(items);

    }

    @Override
    public void printFirstInstruction() {
        System.out.println("Please input an item number you want to edit or delete.");
    }

    @Override
    public void run() {

        // initialize menu command
        commandMenu = new ArrayList<>();
        items.stream().forEach(item1 -> commandMenu.add(item1.getFormattedString()));
        commandValidation = new CommandValidation();

        printFirstInstruction();
        showCommandList();
        chooseItem();

    }

    private void chooseItem() {

        int itemIndex = getInput();
        Item item = items.get(itemIndex);

        chooseMode(item);

    }

    private void chooseMode(Item item) {

        // initialize menu command
        commandMenu = new ArrayList<>();
        commandMenu.add("Edit");
        commandMenu.add("Delete");
        commandMenu.add("Back to main menu");
        commandValidation = new CommandValidation();
        showCommandList();

        //get command, edit, remove or back to menu
        int numOfMode = getInput();
        switch (numOfMode) {
            case 0:
                editItem(item);
                break;

            case 1:
                removeItem(item);
                break;

            case 2:
                // Cancel, back to the main menu
                backToMainMenu();
                break;

        }

    }


    private void editItem(Item item) {

        System.out.println("Selected item: " + item.toString());

        // initialize menu command
        commandMenu = new ArrayList<>();
        commandMenu.add("Edit date");
        commandMenu.add("Edit category");
        commandMenu.add("Edit item name");
        commandMenu.add("Edit amount");
        commandMenu.add("Back to edit menu");
        commandMenu.add("Back to main menu");
        commandValidation = new CommandValidation();
        showCommandList();


        int numOfMode = getInput();
        switch (numOfMode) {
            case 0:
                setDateToItem(item);
                break;

            case 1:
                chooseCategory(item);
                break;

            case 2:
                setNameToItem(item);
                break;

            case 3:
                setAmountToItem(item);
                break;

            case 4:
                run();
                break;

            case 5:
                backToMainMenu();
                break;

        }


    }

    private void setDateToItem(Item item) {

        System.out.println("Please input new date in the following format, YYYY-MM-DD");
        System.out.print("> ");

        String inputLine = scanner.nextLine();

        try {

            item.setDate(inputLine);

        } catch (ParseException e) {

            System.out.println("Invalid date.");
            setDateToItem(item);

        }

        editItem(item);

    }

    @Override
    protected void chooseCategory(Item item) {

        super.chooseCategory(item);
        editItem(item);

    }

    @Override
    protected void setNameToItem(Item item) {

        super.setNameToItem(item);
        editItem(item);
    }

    @Override
    protected void setAmountToItem(Item item) {

        super.setAmountToItem(item);
        editItem(item);
    }

    private void removeItem(Item item) {

        boolean result = items.remove(item);

        if (result) {
            System.out.println("Item was successfully deleted.");
        } else {
            System.out.println("Unexpected error happened. Please try again.");
        }

        backToMainMenu();

    }


}
