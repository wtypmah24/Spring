import config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.CertificateReceiver;

public class Main {
    /*Допустим, у Вас есть сервис, который выполняет долгую (30 сек)
     операцию получения сертификатов доступа к внутренней сети предприятия
     при старте приложения из корпоративного сервера. Вам необходимо
     избежать замедления старта приложения и отложить инициализацию
     этого сервиса до момента его первого вызова. Сравните скорость
     запуска приложения с использованием @Lazy и без неё.*/
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        System.out.println("Начало работы приложения.");

        CertificateReceiver certificateReceiver = context.getBean("certificateReceiver", CertificateReceiver.class);

        System.out.println(certificateReceiver);

        context.close();

    }
}