package com.app.config;

import com.app.connector.Connector;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({"com.app"})
@PropertySource("classpath:application.properties")
public class AppConfiguration {
    @Bean
    public Connector connector() {
        return new Connector();
    }
}