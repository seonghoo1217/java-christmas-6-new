package christmas.config;

import christmas.db.InMemoryDBManager;
import christmas.domain.menu.Menu;

public class ApplicationRunner {
    public void menuInitialize(InMemoryDBManager inMemoryDBManager){
        for (OriginalMenus o : OriginalMenus.values()){
            inMemoryDBManager.saveMenu(1,o.registerMenu());
        }
    }
}
