package com.studiokaori.trackmoney.model;

import com.studiokaori.trackmoney.item.Item;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalcBalanceTest {

    @Test
    void getTotalBalance() throws IOException {
        String savedItemFileName = "savedItems.dat";
        List<Item> items = new ArrayList<>();
        items = new SaveLoadItems().loadSavedItems(items, savedItemFileName);

        CalcBalance calcBalance = new CalcBalance();
        int expected = 21240;
        int result = calcBalance.getTotalBalance(items);

        assertEquals(expected, result);

    }

}