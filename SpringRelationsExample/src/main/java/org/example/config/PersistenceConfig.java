package org.example.config;

import org.example.property.DatabaseProperties;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("org.example")
@EnableTransactionManagement // включает работу транзакций
@EnableJpaRepositories(basePackages = "org.example.repository")
public class PersistenceConfig { // конфигурация отвечает за настройку Hibernate

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("org.example.entity"); // Указываем пакеты, содержащие сущности

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // TODO после перехода на Spring Boot эти настройки можно просто указать в application.properties или application.yml
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update"); // Настройка ddl-auto update create
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); // Настройка диалекта
        properties.setProperty("hibernate.show_sql", "true"); // Настройка отображения запросов
        properties.setProperty("hibernate.format_sql", "true"); // Форматирование запросов или всё в одну строку
        properties.setProperty("hibernate.use_sql_comments", "true"); // Доп. комментарии к запросам

        em.setJpaProperties(properties);

        return em;
    }

    @Bean
    @DependsOn("databaseProperties")
    DataSource dataSource(DatabaseProperties databaseProperties) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseProperties.driverClassName());
        dataSource.setUrl(databaseProperties.url());
        dataSource.setUsername(databaseProperties.username());
        dataSource.setPassword(databaseProperties.password());
        return dataSource;
    }

    // Бин для автоматического управления тразакциями
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory(dataSource).getObject());
        return transactionManager;
    }
}
