package common;

import java.util.ArrayList;
import model.ExpenseModel;

public class Algorithm {

    Validation validation = new Validation();
    ArrayList<ExpenseModel> le=new ArrayList<>();

    public void addExpense(int id) {
        do{
            System.out.println("-------- Add an expense--------");
            System.out.print("Enter Date: ");
            String date = validation.checkInputDate();
            System.out.print("Enter Amount: ");
            double amount = validation.checkInputDouble();
            System.out.print("Enter Content: ");
            String content = validation.checkInputString();
            le.add(new ExpenseModel(id, date, amount, content));
        }while (validation.checkInputYN());
    }

    public void displayExpense() {
        System.out.println("---------Display all expenses------------");
        if (le.isEmpty()) {
            System.err.println("List Expenses empty");
            return;
        }
        double total = 0;
        System.out.printf("%-7s%-20s%-20s%-20s\n", "ID", "Date", "Amount", "Content");
        for (int i = 0; i < le.size(); i++) {
            System.out.printf("%-7d%-20s%-20.0f%-20s\n", le.get(i).getId(), le.get(i).getDate(),
                    le.get(i).getAmount(), le.get(i).getContent());
            total += le.get(i).getAmount();
        }
        System.out.printf("Total: %-20.0f\n", total);
    }

    public int checkIdExist(int id) {
        for (int i = 0; i < le.size(); i++) {
            if (le.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void deleteExpense() {
        System.out.println("--------Delete an expense------");
        System.out.print("Enter ID: ");
        int id = validation.checkInputInt();
        int checkIdExist = checkIdExist(id);
        if (checkIdExist != -1) {
            le.remove(checkIdExist);
            System.out.println("Delete an expense successful");
            for (int i = id - 1; i < le.size(); i++) {
                le.get(i).setId(le.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }
}
