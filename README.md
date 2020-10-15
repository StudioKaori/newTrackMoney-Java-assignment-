# Track Money

Track Money is a simple money tracker. You can follow all expenses and incomes.

## Installation
Move to the installed directory.

Simply type following command in the terminal / command line,
and press Enter key.

```bash
java Main
```

## SDK version

11.0.8

## Build tool

Maven

(That’s the only way I knew, learnt from my classmate at that time.)

## JUnit test

JUnit 5.

```bash
mvn test
```
ExpenseItemTest and IncomeItemTest are included.

These inherite Item class. These two are kept in the "items" array and their static type is Item class. However, they behave differently in run-time. (i.e. having different item categories, returning the different amount of values.)

The tests were created to make sure their behavior in the run-time.


## Class diagram
![Track_money_class_diagram-pdf](/uploads/42b626404e9f10784edd211c3dd02ed0/Track_money_class_diagram-pdf.png)

## License
[MIT](https://choosealicense.com/licenses/mit/)