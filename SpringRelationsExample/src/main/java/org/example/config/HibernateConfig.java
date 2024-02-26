package org.example.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

// Данный файл приведён как пример настройки SessionFactory с помощью hibernate.cfg.xml
//@Configuration
public class HibernateConfig {
    // Метод создания SessionFactory, использующего настройки из hibernate.cfg.xml
    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        // Указываем расположение hibernate.cfg.xml
        sessionFactory.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        // Указываем пакеты, содержащие сущности
        sessionFactory.setPackagesToScan("org.example.entity");
        return sessionFactory;
    }

    // Bean для управления транзакциями Hibernate
    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }
}

