package com.taras.transport;

public class Car implements Transport{
    @Override
    public void drive() {
        System.out.println("Car drives");
    }
}
