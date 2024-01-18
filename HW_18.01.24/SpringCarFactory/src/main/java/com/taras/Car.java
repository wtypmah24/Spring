package com.taras;

import com.taras.interfaces.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    Engine engine;
    @Autowired
    public Car(@Qualifier("legEngine") Engine engine) {
        this.engine = engine;
    }
    public Engine getEngine() {
        return engine;
    }
}
