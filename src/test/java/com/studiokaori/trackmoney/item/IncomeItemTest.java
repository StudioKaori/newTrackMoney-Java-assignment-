package com.studiokaori.trackmoney.item;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IncomeItemTest {

    static IncomeItem incomeItem;

    @BeforeAll
    static void expenseItemTest() {

        incomeItem = new IncomeItem();

        try {
            incomeItem.setDate("2020-10-05");
        } catch (ParseException e) {
            System.out.println("Parse error.");
        }

        incomeItem.setName("test name");
        incomeItem.setAmount(300);
        incomeItem.setCategory(0);

    }

    @Test
    void setAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            incomeItem.setName("");
        });
    }

    @Test
    void getAmountToCalc() {
        int result = incomeItem.getAmountToCalc();
        assertEquals(300, result);
    }

    @Test
    void getAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            incomeItem.setAmount("aaaa");
        });
    }


    @Test
    void setDate() {
    }
}