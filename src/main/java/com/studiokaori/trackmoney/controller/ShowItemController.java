package com.studiokaori.trackmoney.controller;

import com.studiokaori.trackmoney.item.ExpenseItem;
import com.studiokaori.trackmoney.item.IncomeItem;
import com.studiokaori.trackmoney.item.Item;
import com.studiokaori.trackmoney.item.SortItems;
import com.studiokaori.trackmoney.model.CommandValidation;

import java.util.ArrayList;
import java.util.List;

public class ShowItemController extends Controller {

    private SortItems sortItems;

    public ShowItemController(List<Item> items) {

        super(items);

        sortItems = new SortItems();

    }

    @Override
    public void run() {

        // initialize menu command
        commandMenu = new ArrayList<>();
        commandMenu.add("Sort by date");
        commandMenu.add("Sort by date DEC");
        commandMenu.add("Sort by item name");
        commandMenu.add("Sort by item name DEC");
        commandMenu.add("Sort by amount");
        commandMenu.add("Sort by amount Dec");
        commandMenu.add("Back to main menu");
        commandValidation = new CommandValidation();

        printFirstInstruction();
        showCommandList();
        showListingOrderOptions();

    }

    private void showListingOrderOptions() {

        int numOfMode = getInput();
        switch (numOfMode) {
            case 0:
                items = sortItems.sortByDate(items);
                break;

            case 1:
                items = sortItems.sortByDateDes(items);
                break;

            case 2:
                items = sortItems.sortByName(items);
                break;

            case 3:
                items = sortItems.sortByNameDes(items);
                break;

            case 4:
                items = sortItems.sortByAmount(items);
                break;

            case 5:
                items = sortItems.sortByAmountDes(items);
                break;

            case 6:
                backToMainMenu();
                break;

        }

        giveListingOption();

    }


    private void giveListingOption() {

        // initialize menu command
        commandMenu = new ArrayList<>();
        commandMenu.add("Show All Expenses/Incomes");
        commandMenu.add("Show Only Expenses");
        commandMenu.add("Show Only Income");
        commandMenu.add("Back to main menu");
        commandValidation = new CommandValidation();

        showCommandList();
        chooseMode();

    }

    private void chooseMode() {

        long printCount = 0;

        int numOfMode = getInput();
        switch (numOfMode) {
            case 0:
                // All
                printCount = printAll();
                break;

            case 1:
                // Only expenses
                printCount = printOnlyExpenses();
                break;

            case 2:
                // Only income
                printCount = printOnlyIncomes();
                break;

            case 3:
                // Cancel, back to the main menu
                backToMainMenu();
                break;

        }

        if (printCount == 0) {

            System.out.println("No item registered.");
            System.out.println("");

        }

        System.out.println("");

        //back to the show item menu
        run();
    }


    private long printAll() {

        long printCount = 0;

        //String format = " %tY-%tm-%td | %-14s | %-30s |             | %,11d |";
        System.out.printf(" %-10s | %-14s | %-30s | %-11s | %-11s |%n",
                "DATE",
                "CATEGORY",
                "ITEM NAME",
                "EXPENSE",
                "INCOME");
        System.out.println("-------------------------------------------------------------------------------------------");

//        //todo ask TA. somehow didn't work... didn't print any.
//        printCount = items.stream()
//                .peek(item -> System.out.println(item.getFormattedStringForAll()))
//                .count();

        for (Item item : items) {

            System.out.println(item.getFormattedStringForAll());
            printCount++;

        }

        return printCount;
    }

    private long printOnlyExpenses() {

        long printCount = 0;

        System.out.printf(" %-10s | %-14s | %-30s | %-11s |%n",
                "DATE",
                "CATEGORY",
                "ITEM NAME",
                "EXPENSE AMOUNT");
        System.out.println("--------------------------------------------------------------------------------------");

        printCount = items.stream()
                .filter(item -> item instanceof ExpenseItem)
                .peek(item -> System.out.println(item.getFormattedString()))
                .count();

        return printCount;
    }

    private long printOnlyIncomes() {

        long printCount = 0;

        System.out.printf(" %-10s | %-14s | %-30s | %-11s |%n",
                "DATE",
                "CATEGORY",
                "ITEM NAME",
                "INCOME AMOUNT");
        System.out.println("--------------------------------------------------------------------------------------");

        printCount = items.stream()
                .filter(item -> item instanceof IncomeItem)
                .peek(item -> System.out.println(item.getFormattedString()))
                .count();

        return printCount;
    }

}
