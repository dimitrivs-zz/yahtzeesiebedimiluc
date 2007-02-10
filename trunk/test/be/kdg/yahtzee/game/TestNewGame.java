package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.game.GameManager;
import be.kdg.yahtzee.model.users.User;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestNewGame {
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
    public void createGame(){
        User user1 = new User("testUser1", "testUser1", "testUser", null, null);

        assertTrue("Deze game kan aangemaakt worden", gameManager.createGame("testGame", 3, user1));
        assertEquals("Het aantal games moet <1> zijn", 1, gameManager.getGames().size());
    }

    @Test
    public void createGameUserExist(){
        User user1 = new User("testUser1", "testUser1", "testUser", null, null);
        gameManager.createGame("testGame", 3, user1);

        assertFalse("Deze game kan niet aangemaakt worden", gameManager.createGame("testGame1", 3, user1));
    }
    
    @Test
    public void createGameGameExist(){
        User user1 = new User("testUser1", "testUser1", "testUser", null, null);
        gameManager.createGame("testGame", 3, user1);
        User user2 = new User("testUser2", "testUser2", "testUser", null, null);

        assertFalse("Deze game kan niet aangemaakt worden", gameManager.createGame("testGame", 3, user2));
    }
}
