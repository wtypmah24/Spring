package org.example.suit.impl;

import org.example.suit.interfaces.Shirt;
import org.springframework.stereotype.Component;

@Component
public class ShirtImpl implements Shirt {
    @Override
    public void iron() {
        System.out.println("Рубашка гладится.");
    }
}
