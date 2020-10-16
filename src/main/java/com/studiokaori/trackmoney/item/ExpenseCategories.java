package com.studiokaori.trackmoney.item;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides categories for expense item.
 *
 * @author Kaori Persson
 * @version 2020.09
 */
public class ExpenseCategories {

    public static final List<String> expenseCategories;

    static {

        expenseCategories = new ArrayList<>();
        expenseCategories.add("Food");
        expenseCategories.add("Shopping");
        expenseCategories.add("Health");
        expenseCategories.add("Leisure");
        expenseCategories.add("Transportation");
        expenseCategories.add("Loans and tax");
        expenseCategories.add("Others");

    }

}
