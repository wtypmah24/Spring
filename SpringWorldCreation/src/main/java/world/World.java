package world;

public class World {
    private String worldName;

    public World(String worldName) {
        System.out.println("Creation of the world! " + worldName);
        this.worldName = worldName;
    }


    @Override
    public String toString() {
        return "World{" +
                "worldName='" + worldName + '\'' +
                '}';
    }
    public void declareCivilization(){
        System.out.println("Rise of the Civilization!");
    }
    public void declareEnd(){
        System.out.println("End of time!");
    }
}
