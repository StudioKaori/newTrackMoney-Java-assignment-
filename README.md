![Track-money-manual-jpg-960_540-](/uploads/63bcf08b38d2cbec80294d4e3bfbddf8/Track-money-manual-jpg-960_540-.png)

# Track Money

Track Money is a simple money tracker. You can follow all expenses and incomes.

## Installation

Build tool is Maven.

## SDK version

11.0.8

## JUnit test

JUnit 5.(Build tool, Maven)

ExpenseItemTest and IncomeItemTest are included.

These inherite Item class. These two are kept in the "items" array and their static type is Item class. However, they behave differently in run-time. (i.e. having different item categories, returning the different amount of values.)

The tests were created to make sure their behavior in the run-time.

CalcBalanceTest, SaveLoadItemsTest, MyScanner tests are done.


## Class diagram
Please take a look '[Track_money_class_diagram.pdf](https://git.2020.school/kaori_persson/newtrackmoney/-/blob/master/Track_money_class_diagram.pdf)' in the repo.

## Javadoc
Please take a look '[javadoc](https://git.2020.school/kaori_persson/newtrackmoney/-/tree/master/Javadoc)' in the repo.

## Manual
Please take a look '[Track_money_manual.pdf](https://git.2020.school/kaori_persson/newtrackmoney/-/blob/master/Track_money_manual.pdf)' in the repo.

## Updates
2020.10.23 class diagram update for new MyScanner class
2020.10.22 Merge singletonScanner branch to master branch
2020.10.22 Update Javadoc for new MyScanner class
2020.10.17 Add static MyScanner class to avoid having too many scanner instances

## Bug/issues
No bug/issues reported.

## Milestones
[Done] 1.Use of milestones for planning
[Done] 2.Use of issues for features and bug tracking
For futher information, please take a look at milestone in the repo.

## License
[MIT](https://choosealicense.com/licenses/mit/)