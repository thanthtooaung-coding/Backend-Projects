package com.vinn;

import com.vinn.service.ExpenseTrackerManager;
import com.vinn.service.implement.ExpenseTrackerManagerImplement;
import com.vinn.utils.FileUtil;

import java.io.*;
import java.nio.file.*;

public class ExpenseTrackerApp {
    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in))) {
            ExpenseTrackerManager expenseTrackerManager = new ExpenseTrackerManagerImplement();
            FileUtil.createFileIfNotExists();

            while (true) {
                System.out.println("\n--- Expense Tracker Menu ---");
                System.out.println("Please choose an option by entering the number or the command:");
                System.out.println("1. Add Expense (type 'add')");
                System.out.println("2. Update Expense (type 'update')");
                System.out.println("3. Delete Expense (type 'delete')");
                System.out.println("4. List All Expenses (type 'list')");
                System.out.println("5. View Expense Summary (type 'summary')");
                System.out.println("6. Exit the Program (type 'exit')");
                System.out.print("Enter your choice: ");

                String command = inputReader.readLine().trim().toLowerCase();

                switch (command) {
                    case "1":
                    case "add":
                        expenseTrackerManager.addExpense();
                        break;
                    case "2":
                    case "update":
                        expenseTrackerManager.updateExpense();
                        break;
                    case "3":
                    case "delete":
                        expenseTrackerManager.deleteExpense();
                        break;
                    case "4":
                    case "list":
                        expenseTrackerManager.listExpenses();
                        break;
                    case "5":
                    case "summary":
                        expenseTrackerManager.viewSummary();
                        break;
                    case "6":
                    case "exit":
                        System.out.println("Exiting... Thank you for using Expense Tracker!");
                        inputReader.close();
                        return;
                    default:
                        System.out.println("Invalid input. Please enter a valid number or command.");
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading input: " + e.getMessage());
        }
    }
}
