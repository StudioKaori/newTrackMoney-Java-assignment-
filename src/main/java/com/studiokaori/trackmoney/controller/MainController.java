package com.studiokaori.trackmoney.controller;

import com.studiokaori.trackmoney.item.Item;
import com.studiokaori.trackmoney.model.CalcBalance;
import com.studiokaori.trackmoney.model.CommandValidation;
import com.studiokaori.trackmoney.model.SaveLoadItems;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents main menu of the TrackMoney.
 * It shows main menu.
 *
 * @author Kaori Persson
 * @version 2020.09
 */

public class MainController extends Controller {

    private SaveLoadItems saveLoadItems;
    private String savedItemFileName;

    /**
     *
     */

    // This runs only first time.
    public MainController() {

        super();
        mainInit();
        loadSavedItemsToMain();

    }

    // This runs when other controllers call mainController.
    public MainController(List<Item> items) {

        super(items);
        mainInit();
        run();

    }

    private void mainInit() {

        saveLoadItems = new SaveLoadItems();
        savedItemFileName = "savedItems.dat";

    }

    @Override
    public void run() {

        printFirstInstruction();

        // initialize menu command
        commandMenu = new ArrayList<>();
        commandMenu.add("Show Items (All / Expenses(s) / Income(s)");
        commandMenu.add("Add New Expense / Income");
        commandMenu.add("Edit Item (edit, delete)");
        commandMenu.add("Expense control");
        commandMenu.add("Save and Quit");
        commandValidation = new CommandValidation();
        showCommandList();

        chooseMainMenu();

    }

    @Override
    public void printFirstInstruction() {

        System.out.println("");
        System.out.println("");
        System.out.println("───────────────────────────────────────");
        System.out.println("");
        System.out.println("┌┼┐╔╦╗╦═╗╔═╗╔═╗╦╔═  ╔╦╗╔═╗╔╗╔╔═╗╦ ╦┌┼┐          ");
        System.out.println("└┼┐ ║ ╠╦╝╠═╣║  ╠╩╗  ║║║║ ║║║║║╣ ╚╦╝└┼┐          ");
        System.out.println("└┼┘ ╩ ╩╚═╩ ╩╚═╝╩ ╩  ╩ ╩╚═╝╝╚╝╚═╝ ╩ └┼┘          ");
        System.out.println("");
        System.out.println("───────────────────────────────────────");
        System.out.println("");

        printCurrentBalance();

    }

    /**
     * This method shows current balance based on the all expenses and incomes.
     */

    private void printCurrentBalance() {

        int balance = new CalcBalance().getTotalBalance(items);
        System.out.println("\u001b[00;36m" + "You have currently " + balance + " Kr on your account." + "\u001B[0m");
        System.out.println();

    }

    private void chooseMainMenu() {

        System.out.println("Please input menu number.");

        int menuNumber = getInput();
        switch (menuNumber) {
            case 0:
                goShowItems();
                break;

            case 1:
                goAddItemMenu();
                break;

            case 2:
                //Edit item
                goEditItemMenu();
                break;

            case 3:
                goExpenseControl();
                break;

            case 4:
                saveAndQuit();
                break;

        }
    }


    private void goShowItems() {

        ShowItemController showItemController = new ShowItemController(items);
        showItemController.run();
    }


    private void goAddItemMenu() {

        AddController addController = new AddController(items);
        addController.run();

    }

    private void goEditItemMenu() {

        EditController editController = new EditController(items);
        editController.run();

    }

    private void goExpenseControl() {

        ExpenseControlController expenseControlController = new ExpenseControlController(items);
        expenseControlController.run();

    }


    private void saveAndQuit() {

        try {

            saveLoadItems.saveItems(items, savedItemFileName);

        } catch (IOException e) {

            System.out.println("Cannot save items to the file. Please try again.");
            e.printStackTrace();
        }

        System.out.println("Items successfully saved.");
        System.out.println("Bye!");
        System.exit(0);

    }

    private void loadSavedItemsToMain() {

        try {

            saveLoadItems.loadSavedItems(items, savedItemFileName);

        } catch (NoSuchFileException e) {

            System.out.println("(There is no saved items in this computer.)");

        } catch (IOException e) {

            System.out.println("Can not open saved file. Please close application once, and try again.");
            e.printStackTrace();

        }

    }

}
