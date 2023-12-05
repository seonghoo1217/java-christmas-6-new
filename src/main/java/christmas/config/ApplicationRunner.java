package christmas.config;

import christmas.db.InMemoryDBManager;
import christmas.domain.menu.Menu;

import java.util.concurrent.ConcurrentHashMap;

public class ApplicationRunner {
    public ConcurrentHashMap<Integer, Menu> menuInitialize(InMemoryDBManager inMemoryDBManager){
        for (OriginalMenus o : OriginalMenus.values()){
            inMemoryDBManager.saveMenu(1,o.registerMenu());
        }
        return inMemoryDBManager.getMenuDB();
    }
}
