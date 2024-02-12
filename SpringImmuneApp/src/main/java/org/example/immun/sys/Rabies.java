package org.example.immun.sys;

import org.springframework.stereotype.Component;

@Component
public class Rabies implements Vaccination{
    @Override
    public void printName() {
        System.out.println(Measles.class.getSimpleName() + " is used");
    }
}
