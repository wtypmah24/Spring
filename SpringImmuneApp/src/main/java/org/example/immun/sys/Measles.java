package org.example.immun.sys;

import org.springframework.stereotype.Component;

@Component
public class VaccinationImpl implements Vaccination{
    @Override
    public void printName() {
        System.out.println(VaccinationImpl.class.getSimpleName() + " is used");
    }
}