package com.vinn.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
    private static final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

    // Method to get a valid numeric amount from user input
    public static double getValidAmount() throws IOException {
        double amount = 0;
        while (true) {
            System.out.print("Enter amount: ");
            String input = inputReader.readLine().trim();
            try {
                amount = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric amount.");
            }
        }
        return amount;
    }

    // Method to get a valid integer ID from user input
    public static int getValidId(String prompt) throws IOException {
        int id = 0;
        while (true) {
            System.out.print(prompt);
            String input = inputReader.readLine().trim();
            try {
                id = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid numeric ID.");
            }
        }
        return id;
    }
}
