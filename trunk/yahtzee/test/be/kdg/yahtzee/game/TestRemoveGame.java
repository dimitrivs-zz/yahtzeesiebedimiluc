package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.remoteObjects.GameManager;
import be.kdg.yahtzee.model.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 21-feb-2007
 * Time: 21:08:00
 * To change this template use File | Settings | File Templates.
 */
public class TestRemoveGame extends TestCase {
    private GameManager gameManager;

    @Before
    public void setUp() {
        gameManager = new GameManager();
    }

    @After
    public void tearDown() {
        gameManager = null;
    }

    @Test
    public void testRemoveGame() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);

        assertEquals("Het aantal games moet <1> zijn", 1, gameManager.getGames().size());

        gameManager.removeGame("testGame");

        assertEquals("Het aantal games moet <0> zijn", 0, gameManager.getGames().size());
    }
}
