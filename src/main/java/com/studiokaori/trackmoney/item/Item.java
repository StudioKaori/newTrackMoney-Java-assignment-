package com.studiokaori.trackmoney.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Jackson Polymorphic Deserialization annotation
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonIgnoreProperties(ignoreUnknown = true)

public abstract class Item {
    protected String name;
    protected int amount;
    protected Date date;
    protected int category;


    public Item(int category, String name, int amount, Date date) {

        setName(name);
        setCategory(category);
        setAmount(amount);
        setDate(date);

    }

    public Item() {

        setDate(new Date());

    }

    public String getName() {
        return name;
    }

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

    public void setAmount(int amount) throws IllegalArgumentException {

        // exception will be thrown when amount is negative.
        if (amount >= 0) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("The amount of money must be grater than 0.");
        }

    }

    public void setAmount(String strAmount) throws NumberFormatException {

        // exception will be thrown when boxing is failed.
        int amount = Integer.parseInt(strAmount);
        setAmount(amount);

    }

    public Date getDate() {
        return date;
    }

//    public String getFormattedDate() {
//
//        return new SimpleDateFormat("yyyy-MM-dd").format(date);
//
//    }

    public void setDate(Date date) {
        this.date = date;
    }

    @JsonIgnore
    public void setDate(String stringDate) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(stringDate);
        this.date = date;

    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @JsonIgnore
    public abstract String getFormattedString(String format);

    @JsonIgnore
    public abstract String getFormattedString();

    @JsonIgnore
    public abstract String getFormattedStringForAll();


    //return amount of money to calculate
    @JsonIgnore
    public abstract int getAmountToCalc();

}
