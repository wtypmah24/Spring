package com.taras.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"com.taras.props", "com.taras.connect"})
@PropertySource("classpath:application.properties")
public class AppConfig {
}
