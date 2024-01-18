package org.example.suit.impl;

import org.example.suit.interfaces.Tie;
import org.springframework.stereotype.Component;

@Component
public class BowTie implements Tie {
    @Override
    public void tie() {
        System.out.println("Бабочка завязался.");
    }
}
