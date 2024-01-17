package com.taras.interfaces;

public interface SmsNotificationService {
    void sendSms(String phoneNumber, String message);
}
