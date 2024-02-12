package pojo;

import java.util.concurrent.ThreadLocalRandom;

public class Terminator {
    private final int health;

    public Terminator() {
        this.health = ThreadLocalRandom.current().nextInt(1,11);
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Terminator{" +
                "health=" + health +
                '}';
    }
}
