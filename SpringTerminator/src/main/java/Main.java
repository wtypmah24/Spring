import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.JohnConnor;
import pojo.Terminator;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;


public class Main {
   /*Создайте бины классов Terminator и JohnConnor.
   JohnConnor обладает запасом здоровья, равным 100%.
   Каждый терминатор обладает случайным запасом здоровья
   от 1 до 10. Новый терминатор нападает на Джона раз в
   3 секунды, каждый терминатор отнимает у Джона столько
   здоровья, сколько есть у этого терминатора. Битва
   продолжается до тех пор, пока Джон ещё жив или пока не вышла 1 минута времени.*/

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JohnConnor johnConnor = context.getBean("john", JohnConnor.class);


        for (LocalTime i = LocalTime.now();
             LocalTime.now().isBefore(i.plusMinutes(1));){

            Terminator terminator = context.getBean("terminator", Terminator.class);
            System.out.println(terminator);
            boolean isConnorAlive = johnConnor.destroyTerminator(terminator) > 0;
            System.out.println(johnConnor);

            if (!isConnorAlive) {
                System.out.println(johnConnor + " terminator won!");
                return;
            }
        }
        System.out.println("Won " + johnConnor);

        context.close();
    }
}