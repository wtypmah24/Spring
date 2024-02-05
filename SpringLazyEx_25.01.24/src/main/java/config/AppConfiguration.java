package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import pojo.CertificateReceiver;

@Configuration
public class AppConfiguration {
    @Bean
    @Lazy
    public CertificateReceiver certificateReceiver(){
        return  new CertificateReceiver();
    }
}