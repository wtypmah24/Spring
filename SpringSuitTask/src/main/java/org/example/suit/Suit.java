package org.example.suit;

import org.example.suit.interfaces.Jacket;
import org.example.suit.interfaces.Shirt;
import org.example.suit.interfaces.Tie;
import org.example.suit.interfaces.Trousers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Suit {
    private Jacket jacket;
    private Shirt shirt;
    private Trousers trousers;
    private Tie tie;

    @Autowired
    public Suit(Jacket jacket, Shirt shirt, Trousers trousers, @Qualifier("bowTie") Tie tie) {
        this.jacket = jacket;
        this.shirt = shirt;
        this.trousers = trousers;
        this.tie = tie;
    }

    public Jacket getJacket() {
        return jacket;
    }

    public Shirt getShirt() {
        return shirt;
    }

    public Trousers getTrousers() {
        return trousers;
    }

    public Tie getTie() {
        return tie;
    }
}