package com.app.service;

import com.app.interfaces.Task;
import com.app.interfaces.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class TaskServiceImpl implements TaskService {
    private final Map<Integer, Task> tasks = new HashMap<>();

    @Override
    public List<Task> getAllTasks() {
        return tasks.values().stream().toList();
    }

    @Override
    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    @Override

    public void addTask(int id, @Autowired Task task) {
        tasks.put(id, task);
    }

    @Override
    public void updateTask(int id, Task task) {
        tasks.put(id, task);
    }

    @Override
    public void deleteTask(int id) {
        tasks.remove(id);
    }
}
