package com.vinn.service.implement;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vinn.model.Task;
import com.vinn.service.TaskManager;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TaskManagerImplement implements TaskManager {
    private final List<Task> tasks;
    private final String FILE_PATH = "tasks.json";
    private final ObjectMapper objectMapper;

    public TaskManagerImplement() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        tasks = loadTasks();
    }

    @Override
    public void addTask(String description) {
        int id = tasks.size() + 1;
        Task task = new Task(id, description, "todo");
        tasks.add(task);
        saveTasks();
        System.out.println("Task added successfully (ID: " + id + ")");
    }

    @Override
    public void updateTask(int id, String description) {
        Optional<Task> taskOptional = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setDescription(description);
            task.setUpdatedAt(LocalDateTime.now());
            saveTasks();
            System.out.println("Task " + id + " updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    @Override
    public void deleteTask(int id) {
        Optional<Task> taskOptional = getTaskById(id);
        if (taskOptional.isPresent()) {
            tasks.remove(taskOptional.get());
            saveTasks();
            System.out.println("Task " + id + " deleted successfully.");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    @Override
    public void markInProgress(int id) {
        Optional<Task> taskOptional = getTaskById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus("in-progress");
            task.setUpdatedAt(LocalDateTime.now());
            saveTasks();
            System.out.println("Task " + id + " marked as in-progress.");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    @Override
    public void markDone(int id) {
        Optional<Task> taskOptional = getTaskById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus("done");
            task.setUpdatedAt(LocalDateTime.now());
            saveTasks();
            System.out.println("Task " + id + " marked as done.");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return tasks.stream().filter(t -> t.getId() == id).findFirst();
    }

    @Override
    public void listTasks(String status) {
        tasks.stream()
                .filter(task -> status == null || task.getStatus().equalsIgnoreCase(status))
                .forEach(task -> System.out.println(
                        "ID: " + task.getId() +
                                ", Description: " + task.getDescription() +
                                ", Status: " + task.getStatus() +
                                ", CreatedAt: " + task.getCreatedAt() +
                                ", UpdatedAt: " + task.getUpdatedAt()
                ));
    }

    @Override
    public void saveTasks() {
        try {
            objectMapper.writeValue(new File(FILE_PATH), tasks);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    @Override
    public List<Task> loadTasks() {
        try {
            return objectMapper.readValue(new File(FILE_PATH), new TypeReference<>() {});
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
