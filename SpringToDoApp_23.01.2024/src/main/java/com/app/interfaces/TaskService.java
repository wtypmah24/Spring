package com.app.interfaces;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task getTaskById(int id);

    void addTask(int id, Task task);

    void updateTask(int id, Task task);

    void deleteTask(int id);
}
