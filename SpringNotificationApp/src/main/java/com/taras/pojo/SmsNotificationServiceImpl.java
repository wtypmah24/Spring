package com.taras.pojo;

import com.taras.interfaces.SmsNotificationService;

public class SmsNotificationServiceImpl implements SmsNotificationService {
    @Override
    public void sendSms(String phoneNumber, String message) {
        System.out.println("Sending SMS on number: " + phoneNumber + " with message" + message);
    }
}