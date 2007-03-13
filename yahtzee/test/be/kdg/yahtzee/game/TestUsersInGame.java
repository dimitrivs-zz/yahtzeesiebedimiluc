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
 * Time: 21:20:50
 * To change this template use File | Settings | File Templates.
 */
public class TestUsersInGame extends TestCase {
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
    public void testUsersInGameJoin() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);

        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        assertEquals("De grootte moet <1> zijn", 1, gameManager.getUsersOfGame("testGame").size());

        gameManager.joinGame("testGame", user2);

        assertEquals("De grootte moet <2> zijn", 2, gameManager.getUsersOfGame("testGame").size());
    }

    @Test
    public void testUsersInGameLeave() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);

        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        assertEquals("De grootte moet <1> zijn", 1, gameManager.getUsersOfGame("testGame").size());

        gameManager.joinGame("testGame", user2);

        assertEquals("De grootte moet <2> zijn", 2, gameManager.getUsersOfGame("testGame").size());

        gameManager.leaveGame("testGame", user2);

        assertEquals("De grootte moet <1> zijn", 1, gameManager.getUsersOfGame("testGame").size());
    }
}
