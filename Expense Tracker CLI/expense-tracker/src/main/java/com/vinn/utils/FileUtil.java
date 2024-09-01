package com.vinn.utils;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FileUtil {
    private static final String DIRECTORY_NAME = "Expense Tracker CLI/expense-tracker/data";
    private static final String FILE_NAME = DIRECTORY_NAME + "/expenses.csv";

    // Creates the file if it does not exist
    public static void createFileIfNotExists() throws IOException {
        Path dirPath = Paths.get(DIRECTORY_NAME);
        Path filePath = Paths.get(FILE_NAME);
        if (!Files.exists(dirPath)) {
            Files.createDirectory(dirPath);
        }
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
    }

    // Reads all expense entries from the CSV file
    public static List<String> readAllExpenses() throws IOException {
        return Files.readAllLines(Paths.get(FILE_NAME));
    }

    // Writes the provided list of expenses to the CSV file, replacing the existing content
    public static void writeExpenses(List<String> expenses) throws IOException {
        Files.write(Paths.get(FILE_NAME), expenses);
    }

    // Appends a new expense entry to the CSV file
    public static void appendExpense(String expense) throws IOException {
        Files.write(Paths.get(FILE_NAME), (expense + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
    }

    // Generates a new unique ID for an expense, one greater than the highest existing ID
    public static int generateNewId() throws IOException {
        List<String> expenses = Files.readAllLines(Paths.get(FILE_NAME));
        int maxId = 0;
        for (String expense : expenses) {
            int id = Integer.parseInt(expense.split(",")[0]);
            if (id > maxId) {
                maxId = id;
            }
        }
        return maxId + 1;
    }

}
