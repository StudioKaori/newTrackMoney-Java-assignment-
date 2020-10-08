package com.studiokaori.trackmoney.model;

import com.studiokaori.trackmoney.item.Item;

import java.util.List;

public class CalcBalance {
    

    public int getTotalBalance(List<Item> items) {

        return items.stream()
                .map(item -> item.getAmountToCalc())
                .reduce(0, (total, amount) -> total + amount);

    }
}
