package org.example;

import org.example.suit.Suit;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

    /*Создайте POJO-класс Костюм, включающий поля Брюки, Пиджак, Рубашка, Галстук.
    Создайте интерфейсы для каждого элемента костюма, создайте по одной имплементации.
    Укажите автоматическое сканирование пакета и создание бинов. В main получите пару
    костюмов для Ваших друзей – Винсента Веги и Джулса Уиннфилда.
    Временно закомментируйте аннотации на классе, имплементирующем интерфейс Галстук. Какое исключение было получено?
    Раскомментируйте аннотации. Создайте второую имплементацию интерфейса Галстук. Какое исключение было получено?*/

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Suit suit = context.getBean("suit", Suit.class);
        Suit suit2 = context.getBean("suit", Suit.class);

        suit.getJacket().wear();
        suit.getShirt().iron();
        suit.getTie().tie();
        suit.getTrousers().winkle();

        System.out.println(suit == suit2);

        context.close();
    }
}