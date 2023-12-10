package christmas.contoller;


import christmas.config.ApplicationRunner;
import christmas.db.InMemoryDBManager;

public class Application {
    public static void main(String[] args) {
        InMemoryDBManager inMemoryDBManager = inMemoryDBManager();
        initializeDB(inMemoryDBManager);
        MainController mainController = new MainController(inMemoryDBManager);
        mainController.openingRestaurant();
    }

    static void initializeDB(InMemoryDBManager inMemoryDBManager){
        applicationRunner().menuInitialize(inMemoryDBManager);
    }

    static ApplicationRunner applicationRunner(){
        return new ApplicationRunner();
    }

    static InMemoryDBManager inMemoryDBManager(){
        return new InMemoryDBManager();
    }
}
