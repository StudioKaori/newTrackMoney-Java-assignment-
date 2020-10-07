package com.studiokaori.trackmoney.model;

import com.studiokaori.trackmoney.item.Item;

import java.util.List;

public class CalcBalance {

//    public int getMonthlyTotalBalance(List<Item> items) {
//        // calc balance of this month
//        return getMonthlyTotalBalance(items, new Date());
//    }
//
//    public int getMonthlyTotalBalance(List<Item> items, Date date) {
//
//        // todo not completed!! calc balance of the month
//        String strMonth = String.format("%tm", date);
//        int month = Integer.parseInt(strMonth);
//
//        int total = getMonthlyTotalBalance(items);
//        return total;
//
//    }

    public int getTotalBalance(List<Item> items) {

        return items.stream()
                .map(item -> item.getAmountToCalc())
                .reduce(0, (total, amount) -> total + amount);

    }
}
