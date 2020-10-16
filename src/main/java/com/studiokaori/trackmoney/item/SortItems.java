package com.studiokaori.trackmoney.item;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class provide sort function for list of items.
 *
 * @author Kaori Persson
 * @version 2020.09
 */
public class SortItems {


    public List<Item> sortByDate(List<Item> items) {

        Comparator<Item> comparator = Comparator.comparing(Item::getDate);
        return createSortedItems(items, comparator);

    }

    public List<Item> sortByDateDes(List<Item> items) {

        Comparator<Item> comparator = Comparator.comparing(Item::getDate).reversed();
        return createSortedItems(items, comparator);

    }

    //ask TA, both amount and date don't work
    public List<Item> sortByAmount(List<Item> items) {

        Comparator<Item> comparator = Comparator.comparing(Item::getAmount);
        return createSortedItems(items, comparator);

    }

    public List<Item> sortByAmountDes(List<Item> items) {

        Comparator<Item> comparator = Comparator.comparing(Item::getAmount).reversed();
        return createSortedItems(items, comparator);

    }

    public List<Item> sortByName(List<Item> items) {

        Comparator<Item> comparator = Comparator.comparing(Item::getName, String.CASE_INSENSITIVE_ORDER);
        return createSortedItems(items, comparator);

    }

    public List<Item> sortByNameDes(List<Item> items) {

        Comparator<Item> comparator = Comparator.comparing(Item::getName, String.CASE_INSENSITIVE_ORDER).reversed();
        return createSortedItems(items, comparator);

    }

    public List<Item> createSortedItems(List<Item> items, Comparator<Item> comparator) {

        List<Item> sortedItems = items.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        return sortedItems;

    }

}
