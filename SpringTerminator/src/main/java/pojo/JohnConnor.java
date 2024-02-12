package pojo;

public class JohnConnor {
    private int health;

    public JohnConnor() {
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }
    public int destroyTerminator(Terminator terminator){
       return health -= terminator.getHealth();
    }

    @Override
    public String toString() {
        return "JohnConnor{" +
                "health=" + health +
                '}';
    }
}