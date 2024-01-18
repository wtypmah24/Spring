package org.example.suit.impl;

import org.example.suit.interfaces.Jacket;
import org.springframework.stereotype.Component;

@Component
public class JacketImpl implements Jacket {
    @Override
    public void wear() {
        System.out.println("Пиджак наделся.");
    }
}
