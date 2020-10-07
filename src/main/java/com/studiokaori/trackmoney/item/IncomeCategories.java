package com.studiokaori.trackmoney.item;

import java.util.ArrayList;
import java.util.List;

public class IncomeCategories {

    public static final List<String> incomeCategories;

    static {
        incomeCategories = new ArrayList<>();
        incomeCategories.add("Salary");
        incomeCategories.add("Other Income");
    }

}
