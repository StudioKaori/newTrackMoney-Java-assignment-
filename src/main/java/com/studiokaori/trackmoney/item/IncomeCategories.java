package com.studiokaori.trackmoney.item;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides categories for income item.
 *
 * @author Kaori Persson
 * @version 2020.09
 */
public class IncomeCategories {

    public static final List<String> incomeCategories;

    static {
        incomeCategories = new ArrayList<>();
        incomeCategories.add("Salary");
        incomeCategories.add("Other Income");
    }

}
