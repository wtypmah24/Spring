import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.DataProcessor;
import pojo.config.AppConfiguration;

public class Main {
    /*Создайте бин DataProcessor, который зависит от бина DatabaseConnection.
    В свою очередь DatabaseConnection не может существовать, пока база данных
    не будет проинициализирована бином DatabaseInitializer.
    Обеспечьте корректный порядок инициализации бинов.*/
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        DataProcessor dataProcessor = context.getBean("dataProcessor", DataProcessor.class);
        System.out.println(dataProcessor);
    }
}