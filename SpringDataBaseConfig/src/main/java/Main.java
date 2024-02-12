import com.taras.config.DataBaseConfig;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    /*В ресурсах создайте файл настроек приложения application.properties.
    Укажите в файле настройки подключения к базе данных: url, логин и пароль.
    Для хранения настроек создайте класс DatabaseConfig и определите его бин.
    При определении бина укажите, что данные для бина должны быть получены
    из application.properties. Выведите бин DatabaseConfig в консоль.*/
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataBaseConfig dataBaseConfig = context.getBean("dataBaseConfig", DataBaseConfig.class);
        System.out.println(dataBaseConfig);
        context.close();
    }
}