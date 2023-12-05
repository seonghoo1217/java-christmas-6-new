package christmas.contoller;


import christmas.config.ApplicationRunner;
import christmas.db.InMemoryDBManager;
import christmas.domain.menu.Menu;

public class Application {
    public static void main(String[] args) {
        InMemoryDBManager inMemoryDBManager = inMemoryDBManager();
        initializeDB(inMemoryDBManager);
        MainController mainController = new MainController(inMemoryDBManager);
        mainController.run();
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
