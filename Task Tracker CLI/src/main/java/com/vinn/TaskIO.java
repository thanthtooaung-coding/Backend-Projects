package com.vinn;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskIO {
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("1. Add Task");
        System.out.println("2. Update Task");
        System.out.println("3. Delete Task");
        System.out.println("4. List Tasks");
        System.out.println("5. Mark in Progress");
        System.out.println("6. Mark as Done");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    public static int getUserChoice() {
        int choice = -1;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
        return choice;
    }

    public static int getTaskId(String prompt) {
        int id = -1;
        while (id < 0) {
            System.out.print(prompt);
            try {
                id = scanner.nextInt();
                scanner.nextLine();
                if (id < 0) {
                    System.out.println("Task ID must be a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid task ID.");
                scanner.nextLine();
            }
        }
        return id;
    }

    public static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
