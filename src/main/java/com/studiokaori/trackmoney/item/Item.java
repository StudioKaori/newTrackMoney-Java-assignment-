package com.studiokaori.trackmoney.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Jackson Polymorphic Deserialization annotation
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonIgnoreProperties(ignoreUnknown = true)


/**
 * This class provides basic functions and a skeletal implementation of item class.
 *
 * @author Kaori Persson
 * @version 2020.09
 */

public abstract class Item {
    protected String name;
    protected int amount;
    protected Date date;
    protected int category;


    /**
     * Constructs item.
     * Called for to load saved items.
     */
    public Item(int category, String name, int amount, Date date) {

        setName(name);
        setCategory(category);
        setAmount(amount);
        setDate(date);

    }

    /**
     * Constructs item.
     * Called for newly registered item.
     */
    public Item() {

        setDate(new Date());

    }

    public String getName() {
        return name;
    }

    /**
     * Sets the name to the item.
     *
     * @param name name of the item
     * @throws IllegalArgumentException is thrown if the name is empty.
     */
    public void setName(String name) throws IllegalArgumentException {

        if (!name.equals("")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Item name is empty.");
        }

    }

    public int getAmount() {
        return amount;
    }

    /**
     * Sets the price to the item.
     * Called for Json mapping.(loading saved item)
     *
     * @param amount price of the item
     * @throws IllegalArgumentException is thrown if the price is negative or zero.
     */
    public void setAmount(int amount) throws IllegalArgumentException {

        // exception will be thrown when amount is negative.
        if (amount >= 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("The amount of money must be grater than 0.");
        }

    }

    /**
     * Sets the price to the item.
     * Called for user input.
     *
     * @param strAmount price of the item (String)
     * @throws NumberFormatException is thrown if the price is not valid number.
     */
    public void setAmount(String strAmount) throws NumberFormatException {

        // exception will be thrown when boxing is failed.
        int amount = Integer.parseInt(strAmount);
        setAmount(amount);

    }

    public Date getDate() {
        return date;
    }

    @JsonProperty
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Sets the date to the item.
     * Called for user input.
     *
     * @param stringDate date of the item (String)
     * @throws ParseException is thrown if the date is not valid.
     */
    @JsonIgnore
    public void setDate(String stringDate) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(stringDate);
        setDate(date);

    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * Returns formatted text of the item
     *
     * @param format
     * @return formatted text of the item
     */
    @JsonIgnore
    public abstract String getFormattedString(String format);

    /**
     * Returns formatted text of the item using default format.
     *
     * @return formatted text of the item
     */
    @JsonIgnore
    public abstract String getFormattedString();

    /**
     * Returns formatted text of the item for the occasion to show all incomes and expenses.
     *
     * @return formatted text of the item
     */
    @JsonIgnore
    public abstract String getFormattedStringToShowAllIncomeExpense();


    /**
     * Returns amount of money to calculate total balance.
     * If the item belongs to expense, return negative number.
     * if the item belongs to income, positive number.
     *
     * @return amount of money
     */
    @JsonIgnore
    public abstract int getAmountToCalcBalance();

}
