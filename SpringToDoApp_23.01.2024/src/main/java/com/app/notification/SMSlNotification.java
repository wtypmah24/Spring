package com.app.notification;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sms")
public class SMSlNotification implements NotificationService {
    @Override
    public void sendNotification(String message) {
        System.out.println("Send message: " + message + " via SMS");
    }
}
