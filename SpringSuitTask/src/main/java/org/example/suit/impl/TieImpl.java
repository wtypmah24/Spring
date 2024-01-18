package org.example.suit.impl;

import org.example.suit.interfaces.Tie;
import org.springframework.stereotype.Component;

@Component
public class TieImpl implements Tie {
    @Override
    public void tie() {
        System.out.println("Галстук завязался.");
    }
}
