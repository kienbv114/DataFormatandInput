package controller;

import common.Algorithm;
import view.Menu;

public class ExpenseController {

    private final String[] MAIN_MENU_ITEMS = {
        " Add an expense",
        " Display all expenses",
        " Delete an expense",
        " Quit",};

    Algorithm algorithm = new Algorithm();
    int id = 0;

    Menu mainMenu = new Menu("=======Handy Expense program======", MAIN_MENU_ITEMS) {
        @Override
        public void execute(int choice) {
            switch (choice) {
                case 1:
                    algorithm.addExpense(++id);
                    break;
                case 2:
                    algorithm.displayExpense();
                    break;
                case 3:
                    algorithm.deleteExpense();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }
        }
    };

    public void run() {
        mainMenu.run();
    }
}
