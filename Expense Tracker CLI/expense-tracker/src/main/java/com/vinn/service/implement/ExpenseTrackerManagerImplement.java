package com.vinn.service.implement;

import com.vinn.model.Expense;
import com.vinn.service.ExpenseTrackerManager;
import com.vinn.utils.FileUtil;
import com.vinn.utils.InputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class ExpenseTrackerManagerImplement implements ExpenseTrackerManager {
    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    // Adds a new expense to the file
    @Override
    public void addExpense() throws IOException {
        System.out.print("Enter description: ");
        String description = inputReader.readLine().trim();
        double amount = InputUtil.getValidAmount();
        String date = LocalDate.now().toString();
        String expense = String.format("%d,%s,%s,%.2f", FileUtil.generateNewId(), date, description, amount);

        FileUtil.appendExpense(expense);
        System.out.println("Expense added successfully.");
    }

    // Updates an existing expense based on the ID
    @Override
    public void updateExpense() throws IOException {
        int id = InputUtil.getValidId("Enter expense ID to update: ");
        List<String> expenses = FileUtil.readAllExpenses();
        boolean found = false;

        for (int i = 0; i < expenses.size(); i++) {
            String[] parts = expenses.get(i).split(",");
            if (Integer.parseInt(parts[0]) == id) {
                System.out.print("Enter new description: ");
                String description = inputReader.readLine().trim();
                double amount = InputUtil.getValidAmount();
                String updatedExpense = String.format("%d,%s,%s,%.2f", id, parts[1], description, amount);
                expenses.set(i, updatedExpense);
                FileUtil.writeExpenses(expenses);
                System.out.println("Expense updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Expense not found.");
        }
    }

    // Deletes an expense by ID
    @Override
    public void deleteExpense() throws IOException {
        int id = InputUtil.getValidId("Enter expense ID to delete: ");
        List<String> expenses = FileUtil.readAllExpenses();
        boolean found = false;

        for (int i = 0; i < expenses.size(); i++) {
            String[] parts = expenses.get(i).split(",");
            if (Integer.parseInt(parts[0]) == id) {
                expenses.remove(i);
                FileUtil.writeExpenses(expenses);
                System.out.println("Expense deleted successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Expense not found.");
        }
    }

    // Lists all expenses in the file
    @Override
    public void listExpenses() throws IOException {
        List<String> expenses = FileUtil.readAllExpenses();
        System.out.println("ID  Date        Description  Amount");
        for (String expense : expenses) {
            String[] parts = expense.split(",");
            System.out.printf("%s  %s  %s  $%s%n", parts[0], parts[1], parts[2], parts[3]);
        }
    }

    @Override
    public void viewSummary() throws IOException {
        List<String> expenses = FileUtil.readAllExpenses();
        double total = expenses.stream()
                .map(Expense::fromString)
                .mapToDouble(Expense::getAmount)
                .sum();

        System.out.printf("Total expenses: $%.2f%n", total);
    }
}
