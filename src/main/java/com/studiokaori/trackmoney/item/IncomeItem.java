package com.studiokaori.trackmoney.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * This class represents income item.
 *
 * @author Kaori Persson
 * @version 2020.09
 */

// Jackson Polymorphic Deserialization annotation
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonTypeName("IncomeItem")
@JsonIgnoreProperties(ignoreUnknown = true)

public class IncomeItem extends Item {

    public IncomeItem() {

        super();

    }

    @Override
    public String getFormattedStringToShowAllIncomeExpense() {

        String format = " %tY-%tm-%td | %-14s | %-30s |             | %,11d |";
        return getFormattedString(format);

    }

    @Override
    public String getFormattedString(String format) {

        return String.format(format,
                getDate(),
                getDate(),
                getDate(),
                IncomeCategories.incomeCategories.get(getCategory()),
                getName(),
                getAmount());

    }

    @Override
    public String getFormattedString() {

        String format = " %tY-%tm-%td | %-14s | %-30s | %,11d |";
        return getFormattedString(format);

    }


    @Override
    public int getAmountToCalcBalance() {
        return getAmount();
    }

    @Override
    public String toString() {

//        return "INCOME  name: " + this.name
//                + " Amount: " + this.amount
//                + " Category Number: " + this.category
//                + " Date: " + this.date;

        String format = "[INCOME ] %nDate    : %tY-%tm-%td %nCategory: %s %nName    : %s %nAmount  : %,d ";
        return getFormattedString(format);

    }
}
