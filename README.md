![Track-money-manual-jpg-960_540-](/uploads/63bcf08b38d2cbec80294d4e3bfbddf8/Track-money-manual-jpg-960_540-.png)

# Track Money

Track Money is a simple money tracker. You can follow all expenses and incomes.

## Installation

Build tool is Maven.

## SDK version

11.0.8

## JUnit test

JUnit 5.

```bash
mvn test
```
ExpenseItemTest and IncomeItemTest are included.

These inherite Item class. These two are kept in the "items" array and their static type is Item class. However, they behave differently in run-time. (i.e. having different item categories, returning the different amount of values.)

The tests were created to make sure their behavior in the run-time.

CalcBalanceTest, SaveLoadItemsTest, MyScanner tests are done.


## Class diagram
Please take a look 'Track_money_class_diagram.pdf' in the repo.

## Javadoc
Please take a look 'javadoc' in the repo.

## Manual
Please take a look 'Track_money_manual.pdf' in the repo.


## License
[MIT](https://choosealicense.com/licenses/mit/)