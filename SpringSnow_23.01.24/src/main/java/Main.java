import com.taras.config.AppConfig;
import com.taras.season.Season;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /*Создайте бин Снег в классе конфигурации. Внедрите бин Снег в бин класса Зима, имплементирующий интерфейс Сезон.
     *
     * Дополните предыдущее задание. Создайте также бины классов Лето, Весна, Осень,
     * имплементирующие интерфейс Сезон. Создайте бин Текущий сезон, который хранит
     * текущий сезон года (когда бы ни запускалась программа, сезон должен быть правильный).
     * Создайте бин Туристический сезон – каждый новый туристический сезон должен начинаться с
     * Зимы (используйте @Primary). Создайте бин класса Год и внедрите в него все 4 сезона года.*/

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Season winter = context.getBean(Season.class);
        System.out.println(winter);

        Season currentSeason = context.getBean("currentSeason", Season.class);
        System.out.println(currentSeason);

        context.close();
    }
}