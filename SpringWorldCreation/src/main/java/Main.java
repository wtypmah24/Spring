import org.springframework.context.support.ClassPathXmlApplicationContext;
import world.World;

public class Main {
    /*Создайте бин класса World. В классе
    определите конструктор, который принимает
    название создаваемого мира и выводит фразу
    «Сотворение мира X». Добавьте метод, выводящий
    в консоль сообщение «Восход цивилизаций».
    Получите бин из контекста и вызовите метод.*/
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        World earth = context.getBean("world", World.class);
        System.out.println(earth);

        context.close();
    }
}