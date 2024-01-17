package com.taras.pojo;

import com.taras.interfaces.EmailNotificationService;

public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Override
    public void sendEmail(String email, String message) {
        System.out.println("Sending email on: " + email + " with message: " + message);
    }
}
