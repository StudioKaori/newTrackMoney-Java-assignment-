package com.studiokaori.trackmoney.controller;

import com.studiokaori.trackmoney.item.ExpenseCategories;
import com.studiokaori.trackmoney.item.ExpenseItem;
import com.studiokaori.trackmoney.item.Item;
import com.studiokaori.trackmoney.item.SortItems;

import java.util.ArrayList;
import java.util.List;

public class ExpenseControlController extends Controller {

    SortItems sortItems;

    public ExpenseControlController(List<Item> items) {

        super(items);

        sortItems = new SortItems();

    }

    public void run() {

        printFirstInstruction();
        showExpenseControl();

    }

    @Override
    public void printFirstInstruction() {
        System.out.println("Welcome to Expense control");
    }

    private void showExpenseControl() {

        // calculate sums for each category, and put the sums to array
        List<Integer> sums = new ArrayList<>();


        // Initialize sums with number of categories
        for (int categoryIndex = 0; categoryIndex < ExpenseCategories.expenseCategories.size(); categoryIndex++) {
            sums.add(0);
        }

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i) instanceof ExpenseItem) {

                //add item amount to each sum by category

                Item item = items.get(i);
                int categoryNum = item.getCategory();
                int amount = sums.get(categoryNum) + item.getAmount();
                sums.set(categoryNum, amount);

            }

        }


        // find out the biggest sum
        int maxAmount = sums.stream().max(Integer::compare).get();


        // one row has letters limit(numOfLettersInOneRow). The biggest sum will be LIMIT. one letter represents (limit / the biggest sum)
        int numOfLettersInOneRow = 70;
        int amountPerOneLetter = (int) maxAmount / numOfLettersInOneRow;
        String fillLetter = "█";

        for (int categoryIndex = 0; categoryIndex < sums.size(); categoryIndex++) {

            int amount = sums.get(categoryIndex);
            int numOfLetter = (int) amount / amountPerOneLetter;

            System.out.printf("█ %-16s", ExpenseCategories.expenseCategories.get(categoryIndex));
            System.out.print("[ ");

            String percentage = "";
            for (int j = 0; j < numOfLetter; j++) {
                percentage += fillLetter;
            }


            // when the amount is greater than zero, but to small to print letter, print one letter at least.
            if (amount != 0 && numOfLetter == 0) {
                percentage += fillLetter;
            }

            String format = "%-" + numOfLettersInOneRow + "s";
            System.out.print(String.format(format, percentage));

            System.out.print(" ]");
            System.out.printf(" %,8d Kr", sums.get(categoryIndex));

            System.out.println("");
        }


        //todo show options to back to main menu
    }

}
