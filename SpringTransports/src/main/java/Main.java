import com.taras.transport.Bicycle;
import com.taras.transport.Car;
import com.taras.transport.Motorcycle;
import com.taras.transport.Transport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    /*Реализуйте простую систему создания различных
    видов транспортных средств. Создайте бин фабрики
    (TransportFactory), которая будет иметь метод createTransport,
    возвращающий различные виды транспортных средств (например,
    "Car", "Bicycle", "Motorcycle"). Используйте factory-method
    для создания объектов. В описании бинов каждого из видов
    транспорта укажите factory-bean="transportFactory" factory-method="createTransport"*/

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = context.getBean("car", Car.class);
        Bicycle bicycle = context.getBean("bicycle", Bicycle.class);
        Motorcycle motorcycle = context.getBean("motorcycle", Motorcycle.class);

        List<Transport> transports = List.of(car, bicycle, motorcycle);
        transports.forEach(Transport::drive);
    }
}
