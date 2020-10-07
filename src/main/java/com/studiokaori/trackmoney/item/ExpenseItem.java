package com.studiokaori.trackmoney.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

// Jackson Polymorphic Deserialization annotation
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonTypeName("ExpenseItem")
@JsonIgnoreProperties(ignoreUnknown = true)

public class ExpenseItem extends Item {


    public ExpenseItem() {

        super();

    }

    @Override
    public String getFormattedStringForAll() {

        String format = " %tY-%tm-%td | %-14s | %-30s | %,11d |             |";
        return getFormattedString(format);

    }

    @Override
    public String getFormattedString(String format) {

        return String.format(format,
                getDate(),
                getDate(),
                getDate(),
                ExpenseCategories.expenseCategories.get(getCategory()),
                getName(),
                getAmount());

    }

    @Override
    public String getFormattedString() {

        String format = " %tY-%tm-%td | %-14s | %-30s | %,11d |";
        return getFormattedString(format);

    }

    // return negative amount to calculate
    @Override
    public int getAmountToCalc() {
        return -(getAmount());
    }

    @Override
    public String toString() {

        String format = "[EXPENSE] %nDate    : %tY-%tm-%td %nCategory: %s %nName    : %s %nAmount  : %,d ";
        return getFormattedString(format);

    }
}
