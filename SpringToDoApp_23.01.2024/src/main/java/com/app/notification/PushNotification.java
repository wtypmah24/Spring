package com.app.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Qualifier("push")
public class PushNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Send message: " + message + " via PUSH");
    }
}
