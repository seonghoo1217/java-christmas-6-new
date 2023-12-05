package christmas.db;

import christmas.config.ApplicationRunner;
import christmas.domain.menu.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;


public class DBTest {
    private static ApplicationRunner applicationRunner;
    private static InMemoryDBManager inMemoryDBManager;

    @BeforeEach
    public void initializeDependency(){
        applicationRunner = new ApplicationRunner();
        inMemoryDBManager = new InMemoryDBManager();
    }

    @Test
    public void 메뉴_초기메뉴_DB초기화_작업_테스트(){
        //given
        ConcurrentHashMap<Integer, Menu> menuDB = applicationRunner.menuInitialize(inMemoryDBManager);

        //when
        int size = menuDB.values().size();

        //then
        assertThat(size).isEqualTo(12);
    }
}
