package be.kdg.yahtzee.game;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import be.kdg.yahtzee.model.game.GameManager;
import be.kdg.yahtzee.model.game.Game;
import be.kdg.yahtzee.model.game.EnumState;
import be.kdg.yahtzee.model.users.User;


public class TestGameRoom {
    private GameManager gameManager;

    @Before
    public void setUp(){
        gameManager = new GameManager();
    }

    @After
    public void tearDown(){
        gameManager = null;
    }

    @Test
    public void joinGame(){
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43",null, null);
        gameManager.createGame("testGame", 3, user1);

        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43",null, null);

        assertTrue("Een user die nog niet aan een spel deelneemt mag joinen", gameManager.joinGame("testGame", user2));
    }

    @Test
    public void joinGameUserExist(){
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43",null, null);
        gameManager.createGame("testGame", 3, user1);

        assertFalse("De user die game mag niet zijn eigen spel joinen", gameManager.joinGame("testGame", user1));
    }

    @Test
    public void joinGameUserExistsOtherGame(){
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43",null, null);
        gameManager.createGame("testGame", 3, user1);

        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43",null, null);

        assertTrue("Een user die nog niet aan een spel deelneemt mag joinen", gameManager.joinGame("testGame", user2));

        User user3 = new User("testUser3", "testUser3", "testUser3", "istrator", "admin@admin.be", "O498/24.36.43",null, null);
        gameManager.createGame("testGame1", 3, user3);

        assertFalse("Een user kan nadat hij een spel gejoint heeft aan geen enkel spel deelnemen", gameManager.joinGame("testGame1", user2));
    }

    @Test
    public void status(){
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43",null, null);

        Game game = new Game("testGame", 3, user1);

        game.setState(EnumState.LEEG);
        assertEquals("De status moet <Empty> zijn", "Empty",  game.getState());

        game.setState(EnumState.IDLE);
        assertEquals("De status moet <Idle> zijn", "Idle",  game.getState());

        game.setState(EnumState.WACHTEN);
        assertEquals("De status moet <Waiting> zijn", "Waiting",  game.getState());
    }

}
