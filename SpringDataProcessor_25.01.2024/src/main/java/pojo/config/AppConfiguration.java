package pojo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import pojo.DataBaseConnection;
import pojo.DataBaseInitializer;
import pojo.DataProcessor;

@Configuration
public class AppConfiguration {
    @Bean
    public DataBaseInitializer dataBaseInitializer() {
        return new DataBaseInitializer();
    }

    @Bean
    @DependsOn("dataBaseInitializer")
    public DataBaseConnection dataBaseConnection() {
        return new DataBaseConnection();
    }

    @Bean
    public DataProcessor dataProcessor() {
        return new DataProcessor(dataBaseConnection());
    }
}