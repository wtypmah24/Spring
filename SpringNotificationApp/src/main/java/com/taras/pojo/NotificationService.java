package com.taras.pojo;

import com.taras.interfaces.EmailNotificationService;
import com.taras.interfaces.SmsNotificationService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class NotificationService {
    private final SmsNotificationService smsNotificationService;
    private final EmailNotificationService emailNotificationService;

    public NotificationService(SmsNotificationService smsNotificationService, EmailNotificationService emailNotificationService) {
        this.smsNotificationService = smsNotificationService;
        this.emailNotificationService = emailNotificationService;
    }

    public void sendSpam(Customer customer) {
        if (isMoreThan30daysFromNow(customer.getDateOfLastNotification())) {
            if (customer.getPhone() != null) smsNotificationService.sendSms(customer.getPhone(), "Notification");
            if (customer.getEmail() != null) emailNotificationService.sendEmail(customer.getEmail(), "notification");
        }
    }
    private boolean isMoreThan30daysFromNow(LocalDate localDate) {
        return ChronoUnit.DAYS.between(localDate, LocalDate.now()) > 30;
    }
}