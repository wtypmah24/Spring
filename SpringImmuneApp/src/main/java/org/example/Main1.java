package org.example;


import org.example.immun.sys.Immunity;
import org.example.immun.sys.Organism;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

   /*1 Создайте класс Иммунитет, содержащий поле типа Прививка.
   Прививка – интерфейс. Сделайте разные имплементации прививки
   (от кори, от бешенства, от гриппа, от короновируса).
   Создайте несколько бинов иммунитета, каждый иммунитет должен
   быть инжектирован своей прививкой: иммунитет против кори,
   иммунитет против бешенства и т.д. Внедрите все иммунитеты в бин Организм.*/

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Immunity immunity = context.getBean("immunity", Immunity.class);
//
//        immunity.getVaccination().printName();

        Immunity coronaImm = context.getBean("immunityCorona", Immunity.class);
        System.out.println(coronaImm.vaccination());

        Organism organism = context.getBean("organism", Organism.class);
        System.out.println(organism);


        context.close();
    }
}