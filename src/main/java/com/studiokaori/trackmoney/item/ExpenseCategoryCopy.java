package com.studiokaori.trackmoney.item;

public enum ExpenseCategoryCopy {
    FOOD("Food"),
    SHOPPING("Shopping"),
    HEALTH("Health"),
    LEISURE("Leisure"),
    TRANSPORTATION("Transportation"),
    LOAN("Loans and tax"),
    OTHERS("Others");

    private String expenseCategory;

    ExpenseCategoryCopy(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String toString() {
        return expenseCategory;
    }
}
