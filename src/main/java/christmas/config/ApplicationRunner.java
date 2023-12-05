package christmas.config;

import christmas.domain.menu.Menu;

public class ApplicationRunner {
    public void menuInitialize(){
        for (OriginalMenus o : OriginalMenus.values()){
            o.registerMenu();
        }
    }
}
