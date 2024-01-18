package com.taras.engine.types;

import com.taras.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component("legEngine")
public class LegEngine implements Engine {
    @Override
    public void moveCar() {
        System.out.println("Make car movable with legs.");
    }
}