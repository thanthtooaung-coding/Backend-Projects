package com.vinn.service;

import com.vinn.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskManager {
    void addTask(String description);
    void updateTask(int id, String description);
    void deleteTask(int id);
    void markInProgress(int id);
    void markDone(int id);
    Optional<Task> getTaskById(int id);
    void listTasks(String status);
    void saveTasks();
    List<Task> loadTasks();
}
