package com.app.task;

import com.app.interfaces.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Getter
@ToString
public class ScheduledTask implements Task {

    @Value("${task.default-id}")
    private int id;

    @Value("${task.default-date}")
    private String taskDateTime;

    @Value("${task.default-title}")
    private String title;

    @Value("${task.default-description}")
    private String description;

    @Value("${task.default-priority}")
    private int taskPriority;

    @Value("${task.default-isPerformed}")
    private boolean isPerformed;

}
