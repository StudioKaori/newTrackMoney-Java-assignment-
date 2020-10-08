package com.studiokaori.trackmoney.controller;

import com.studiokaori.trackmoney.item.*;
import com.studiokaori.trackmoney.model.CommandValidation;

import java.util.List;

/**
 * This class is the main class of the "Track Money" application.
 * "rack Money" is a very simple, text based money tracker.
 *
 * @author Kaori Persson
 * @version 2020.09
 */

public abstract class EditItemController extends Controller {
    protected List<String> categories;

    /**
     *
     */
    public EditItemController(List<Item> items) {

        super(items);

    }


    protected void chooseCategory(Item item) {

        System.out.println("Please choose category from bellow.");

        if (item instanceof ExpenseItem) {
            commandMenu = ExpenseCategories.expenseCategories;
        } else if (item instanceof IncomeItem) {
            commandMenu = IncomeCategories.incomeCategories;
        }

        // create and show item categories
        showCommandList();
        commandValidation = new CommandValidation();

        int chosenCategory = getInput();
        item.setCategory(chosenCategory);

    }

    protected void setNameToItem(Item item) {

        System.out.println("Please input item name.");
        System.out.print("> ");

        String inputName = scanner.nextLine();

        try {

            item.setName(inputName);

        } catch (IllegalArgumentException e) {

            System.out.println("Item name is empty.");
            setNameToItem(item);

        }
    }


    protected void setAmountToItem(Item item) {

        System.out.println("Please input amount of money (SEK).");

        try {

            String amount = scanner.nextLine();
            item.setAmount(amount);

        } catch (IllegalArgumentException e) {

            System.out.println("You input an invalid number.");
            setAmountToItem(item);

        }
    }


}
