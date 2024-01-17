package com.taras.pojo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Customer {
    private long id;
    private String name;
    private LocalDate dateOfLastNotification;
    private String phone;
    private String email;
}
