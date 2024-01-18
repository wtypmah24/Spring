package org.example.suit.impl;

import org.example.suit.interfaces.Trousers;
import org.springframework.stereotype.Component;

@Component
public class TrousersImpl implements Trousers {
    @Override
    public void winkle() {
        System.out.println("Брюки помялись.");
    }
}
