package com.studiokaori.trackmoney.controller;

import com.studiokaori.trackmoney.item.ExpenseItem;
import com.studiokaori.trackmoney.item.IncomeItem;
import com.studiokaori.trackmoney.item.Item;
import com.studiokaori.trackmoney.model.CommandValidation;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the main class of the "Track Money" application.
 * "rack Money" is a very simple, text based money tracker.
 *
 * @author Kaori Persson
 * @version 2020.09
 */

public class AddController extends EditItemController {

    public AddController(List<Item> items) {

        super(items);

    }

    public void run() {

        // initialize menu command
        commandMenu = new ArrayList<>();
        commandMenu.add("Expenses");
        commandMenu.add("Income");
        commandMenu.add("Cancel");
        commandValidation = new CommandValidation();

        printFirstInstruction();
        showCommandList();
        chooseMode();

    }

    private void chooseMode() {

        //choose Expenses or Income mode
        int numOfMode = getInput();
        switch (numOfMode) {
            case 0:
                // Expenses
                createExpensesItem();
                break;

            case 1:
                // Income
                createIncomeItem();
                break;

            case 2:
                // Cancel, back to the main menu
                backToMainMenu();
                break;

        }
    }


    private void createExpensesItem() {

        Item item = new ExpenseItem();
        items.add(item);
        chooseCategory(item);

    }

    private void createIncomeItem() {

        Item item = new IncomeItem();
        items.add(item);
        chooseCategory(item);

    }

    @Override
    protected void chooseCategory(Item item) {

        super.chooseCategory(item);
        setNameToItem(item);

    }

    @Override
    protected void setNameToItem(Item item) {

        super.setNameToItem(item);
        setAmountToItem(item);
    }

    @Override
    protected void setAmountToItem(Item item) {

        super.setAmountToItem(item);
        System.out.println("Item was successfully registered.");
        System.out.println(item);
        backToMainMenu();
    }


}
