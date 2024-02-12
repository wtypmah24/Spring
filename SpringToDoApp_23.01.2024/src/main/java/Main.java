import com.app.config.AppConfiguration;
import com.app.interfaces.TaskService;
import com.app.notification.NotificationService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        NotificationService notificationService = context.getBean(NotificationService.class);
        notificationService.sendNotification("Hello!");

        TaskService taskService =  context.getBean(TaskService.class);
        System.out.println(taskService.getAllTasks());
    }
}