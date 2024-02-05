package com.app.task;

import com.app.interfaces.Task;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@ToString

public class SimpleTask implements Task {

    @Value("${task.default-id}")
    private int id;

    @Value("${task.default-title}")
    private String title;

    @Value("${task.default-description}")
    private String description;

    @Value("${task.default-priority}")
    private int taskPriority;

    @Value("${task.default-isPerformed}")
    private boolean isPerformed;

    public SimpleTask(@Value("${task.default-id}") int id,
                      @Value("${task.default-title}") String title,
                      @Value("${task.default-description}") String description,
                      @Value("${task.default-priority}") int taskPriority,
                      @Value("${task.default-isPerformed}") boolean isPerformed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskPriority = taskPriority;
        this.isPerformed = isPerformed;
    }
}