package com.taras.factory;

import com.taras.transport.Bicycle;
import com.taras.transport.Car;
import com.taras.transport.Motorcycle;
import com.taras.transport.Transport;

public class TransportFactory {
    public Transport createTransport(String type){
        return switch(type){
            case "Car" -> new Car();
            case "Bicycle" -> new Bicycle();
            case "Motorcycle" -> new Motorcycle();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}