package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.game.Game;
import be.kdg.yahtzee.model.game.GameManager;
import be.kdg.yahtzee.model.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 21-feb-2007
 * Time: 18:34:08
 * To change this template use File | Settings | File Templates.
 */
public class TestLeaveGame extends TestCase {
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
    public void testLeaveGameEmpty() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);

        gameManager.leaveGame("testGame", user1);

        Game game = gameManager.getGame("testGame");

        assertEquals("De status moet <Empty> zijn", "Empty", game.getState());
    }

    @Test
    public void testLeaveGameWaiting() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);

        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        gameManager.joinGame("testGame", user2);

        gameManager.leaveGame("testGame", user1);

        Game game = gameManager.getGame("testGame");

        assertEquals("De status moet <Waiting> zijn", "Waiting", game.getState());
    }
}
