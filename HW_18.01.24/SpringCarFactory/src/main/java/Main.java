import com.taras.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

        /*Ваш класс Car зависит от интерфейса Engine.
        Создайте несколько реализаций интерфейса Engine
        (например, GasEngine и ElectricEngine). Аннотируйте их
        с помощью @Component с названием бинов, чтобы явно указать,
        какой двигатель должен быть использован в каждом случае.
        Затем внедрите зависимость двигателя в класс Car с помощью
        @Autowired и @Qualifier, чтобы можно было выбрать тип двигателя во время компиляции.*/

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car flinstownCar = context.getBean("car", Car.class);

        flinstownCar.getEngine().moveCar();

        context.close();
    }
}