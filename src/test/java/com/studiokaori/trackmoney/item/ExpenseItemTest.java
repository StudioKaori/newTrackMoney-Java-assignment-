package com.studiokaori.trackmoney.item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseItemTest {
    static ExpenseItem expenseItem;

    @BeforeAll
    static void expenseItemTest() {

        expenseItem = new ExpenseItem();

        try {
            expenseItem.setDate("2020-10-05");
        } catch (ParseException e) {
            System.out.println("Parse error.");
        }

        expenseItem.setName("test name");
        expenseItem.setAmount(300);
        expenseItem.setCategory(0);

    }

    @Test
    void getFormattedStringForAll() {
        String result = expenseItem.getFormattedStringToShowAllIncomeExpense();
        assertEquals(" 2020-10-05 | Food           | test name                      |         300 |             |", result);
    }

    @Test
    void getFormattedString() {
        String result = expenseItem.getFormattedStringToShowAllIncomeExpense();
        assertEquals(" 2020-10-05 | Food           | test name                      |         300 |             |", result);
    }

    @Test
    void getAmountToCalc() {
        int result = expenseItem.getAmountToCalcBalance();
        assertEquals(-300, result);
    }

    @Test
    void getAmount() {
        int result = expenseItem.getAmount();
        assertEquals(300, result);
    }

    @Test
    void setName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            expenseItem.setName("");
        });
    }
}