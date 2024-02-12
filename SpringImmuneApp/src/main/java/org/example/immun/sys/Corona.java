package org.example.immun.sys;

import org.springframework.stereotype.Component;

@Component
public class Corona implements Vaccination{
    @Override
    public void printName() {
        System.out.println(Measles.class.getSimpleName() + " is used");
    }
}
