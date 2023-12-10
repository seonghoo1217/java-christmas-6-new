package christmas.contoller;

import christmas.db.InMemoryDBManager;

public class MainController {

    private final InMemoryDBManager inMemoryDBManager;

    private final InputController inputController;

    public MainController(InMemoryDBManager inMemoryDBManager, InputController inputController) {
        this.inMemoryDBManager = inMemoryDBManager;
        this.inputController = inputController;
    }

    public void openingRestaurant(){

    }
}
