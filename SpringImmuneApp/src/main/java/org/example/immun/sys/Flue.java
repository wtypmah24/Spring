package org.example.immun.sys;

public class Corona implements Vaccination{
    @Override
    public void printName() {
        System.out.println(Measles.class.getSimpleName() + " is used");
    }
}
