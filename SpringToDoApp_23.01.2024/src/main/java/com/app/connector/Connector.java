package com.app.connector;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Connector {
    @PostConstruct
    public void connectToServer() {
        System.out.println("Connected to server.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
