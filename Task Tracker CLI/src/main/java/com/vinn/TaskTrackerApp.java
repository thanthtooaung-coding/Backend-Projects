package com.vinn;

import com.vinn.config.AppConfig;
import com.vinn.model.Task;
import com.vinn.service.TaskManager;
import com.vinn.service.implement.TaskManagerImplement;

import java.util.Optional;
import java.util.Scanner;

public class TaskTrackerApp {
    public static void main(String[] args) {

        AppConfig.configureObjectMapper();
        TaskManager taskManager = new TaskManagerImplement();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            TaskIO.displayMenu();
            int choice = TaskIO.getUserChoice();

            switch (choice) {
                case 1:
                    String description = TaskIO.getInput("Enter description: ");
                    taskManager.addTask(description);
                    break;
                case 2:
                    int updateId = TaskIO.getTaskId("Enter task ID to update: ");
                    Optional<Task> taskOptional = taskManager.getTaskById(updateId);
                    if (taskOptional.isPresent()) {
                        String newDescription = TaskIO.getInput("Enter new description: ");
                        taskManager.updateTask(updateId, newDescription);
                    } else {
                        System.out.println("Task with ID " + updateId + " not found.");
                    }
                    break;
                case 3:
                    int deleteId = TaskIO.getTaskId("Enter task ID to delete: ");
                    taskManager.deleteTask(deleteId);
                    break;
                case 4:
                    String status = TaskIO.getInput("Enter status to list (or leave empty to list all tasks): ");
                    taskManager.listTasks(status.isEmpty() ? null : status);
                    break;
                case 5:
                    System.out.print("Enter task ID to mark as in progress: ");
                    int inProgressId = TaskIO.getUserChoice();
                    taskManager.markInProgress(inProgressId);
                    break;
                case 6:
                    System.out.print("Enter task ID to mark as done: ");
                    int markDoneId = TaskIO.getUserChoice();
                    taskManager.markDone(markDoneId);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }

        TaskIO.closeScanner();
    }
}