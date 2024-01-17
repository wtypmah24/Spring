package com.taras;

import com.taras.pojo.Customer;
import com.taras.pojo.NotificationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Customer firstCustomer = context.getBean("customer", Customer.class);
        firstCustomer.setId(1L);
        firstCustomer.setName("Bob");
        firstCustomer.setDateOfLastNotification(LocalDate.now());
        firstCustomer.setPhone("+19138445656");
        firstCustomer.setEmail(null);

        Customer secondCustomer = context.getBean("customer", Customer.class);
        secondCustomer.setId(2L);
        secondCustomer.setName("Sarah");
        secondCustomer.setDateOfLastNotification(LocalDate.of(2023, 01, 16));
        secondCustomer.setPhone("+19158455617");
        secondCustomer.setEmail("sarah-sweet@candy.com");

        System.out.println(firstCustomer.getName());
        System.out.println(secondCustomer.getName());

        NotificationService notificationService = context.getBean("notificationService", NotificationService.class);
        notificationService.sendSpam(firstCustomer);
        notificationService.sendSpam(secondCustomer);
    }
}