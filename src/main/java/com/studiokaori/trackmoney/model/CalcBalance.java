package com.studiokaori.trackmoney.model;

import com.studiokaori.trackmoney.item.Item;

import java.util.List;

/**
 * This class provide calculate balance function for list of items.
 *
 * @author Kaori Persson
 * @version 2020.09
 */
public class CalcBalance {


    public int getTotalBalance(List<Item> items) {

        return items.stream()
                .map(item -> item.getAmountToCalcBalance())
                .reduce(0, (total, amount) -> total + amount);

    }
}
