import com.taras.spam.senders.EmailSender;
import com.taras.spam.senders.SmsSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    /*Создайте класс MessageGenerator, который генерирует
    уникальные сообщения с временной меткой. Каждый раз,
    когда бин запрашивается из контекста, создаётся новый
    экземпляр MessageGenerator. Внедрите этот бин в классы
    EmailSender и SmsSender.*/
    public static void main(String[] args) {

        ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");

        SmsSender smsSender = context.getBean("smsSender", SmsSender.class);
        EmailSender emailSender = context.getBean("emailSender", EmailSender.class);

        smsSender.getMessageGenerator().generateUniqueMsg();
        emailSender.getMessageGenerator().generateUniqueMsg();
    }
}