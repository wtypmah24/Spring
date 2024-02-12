import com.taras.config.AppConfig;
import com.taras.connect.Connector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /*1. Создайте Spring-приложение, которое получает настройки
    host, port и token из файла application.properties, используя @Value.

    2. В ранее созданном приложении залогируйте настройки после их получения из файла.
    Во время работы программы токен должен поменяться (сгенерируйте с помощью UUID).
    Перед уничтожением бина замените токен в файле конфигурации на значение, хранящееся в бине.

    3. Переведите ранее созданное приложение на конфигурацию без использования xml.
    Создайте класс Connector, который использует бин настроек приложения (host, port и token).
    В классе создайте метод, эмулирующий подключение к удалённому серверу.
    Получите бин Connector из контекста и запустите метод подключения.*/

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Connector connector = context.getBean("connector", Connector.class);
        connector.connect();
        context.close();
    }
}