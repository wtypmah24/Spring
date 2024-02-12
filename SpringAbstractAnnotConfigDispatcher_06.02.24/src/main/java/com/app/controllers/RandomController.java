package com.app.controllers;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/random")
public class RandomController {
    private final Random random;
    private final Faker faker;

    @Autowired
    public RandomController(Random random, Faker faker) {
        this.random = random;
        this.faker = faker;
    }

    @GetMapping("/date")
    public LocalDate getDate() {
        return LocalDate.of(random.nextInt(0, 3000), random.nextInt(1, 13), random.nextInt(1, 30));
    }

    @GetMapping("/time")
    public LocalTime getTime() {
        return LocalTime.of(random.nextInt(0, 13), random.nextInt(0, 60));
    }

    @GetMapping("/date-time")
    public LocalDateTime getDateTime() {
        return LocalDateTime.of(random.nextInt(0, 3000),
                random.nextInt(1, 13),
                random.nextInt(1, 30),
                random.nextInt(0, 13),
                random.nextInt(0, 60));
    }

    @GetMapping("/UUID")
    public String detUUID() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/email")
    public String getEmail() {
        return faker.internet().emailAddress();
    }

    @GetMapping("/name")
    public String getName() {
        return faker.name().fullName();
    }

    @GetMapping("/phone")
    public String getPhone() {
        return faker.phoneNumber().cellPhone();
    }
    @GetMapping("/all-fake")
    public List<Object> getAll(){
        return List.of(getDate(), getTime(), getDateTime(), getEmail(), detUUID(), getName(), getPhone());
    }
}

    /*Создайте Spring MVC приложение с конфигурацией в Java-коде. Приложение генерирует случайные данные по запросу:
    дату
    время
    дату и время
    UUID
    email
    имя
    номер телефона
    Для упрощения воспользуйтесь библиотекой https://mvnrepository.com/artifact/com.github.javafaker/javafaker*/
