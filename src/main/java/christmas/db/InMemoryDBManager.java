package christmas.db;

import christmas.domain.menu.Menu;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryDBManager {
    public static final ConcurrentHashMap<Integer, Menu> menuDB = new ConcurrentHashMap<>();

    public ConcurrentHashMap<Integer, Menu> saveMenu(Integer menuKeys, Menu menu){
        if (menuDB.containsKey(menuKeys)){
            menuKeys++;
            saveMenu(menuKeys, menu);
        }
        menuDB.put(menuKeys, menu);
        return menuDB;
    }


}
