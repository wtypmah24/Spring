package com.taras.config;

import com.taras.season.*;
import org.springframework.context.annotation.*;

import java.time.LocalDate;

@Configuration
@ComponentScan({"com.taras.season"})
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Snow snow() {
        return new Snow();
    }
    @Bean
    public Season winter() {
        return new Winter(snow());
    }
    @Bean
    public Season spring() {
        return new Spring();
    }
    @Bean
    public Season autumn() {
        return new Autumn();
    }
    @Bean
    @Primary
    public Season summer() {
        return new Summer();
    }

    @Bean(name = "currentSeason")
    public Season currentSeason() {
        return switch (LocalDate.now().getMonth()){
            case JANUARY, DECEMBER, FEBRUARY -> winter();
            case MARCH, APRIL, MAY -> spring();
            case JUNE, JULY, AUGUST -> summer();
            case SEPTEMBER, OCTOBER, NOVEMBER -> autumn();
        };
    }
}