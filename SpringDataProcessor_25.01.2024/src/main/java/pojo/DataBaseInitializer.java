package pojo;

public class DataBaseInitializer {

    public DataBaseInitializer() {
        initializeDataBase();
    }

    public void initializeDataBase(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Database is initialized.");
    }
}