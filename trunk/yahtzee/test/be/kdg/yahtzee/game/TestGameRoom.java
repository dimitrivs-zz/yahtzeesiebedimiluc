package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.game.EnumState;
import be.kdg.yahtzee.model.game.Game;
import be.kdg.yahtzee.model.game.GameManager;
import be.kdg.yahtzee.model.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestGameRoom extends TestCase {
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
    public void testJoinGame() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);

        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        assertTrue("Een user die nog niet aan een spel deelneemt mag joinen", gameManager.joinGame("testGame", user2));
    }

    @Test
    public void testJoinGameUserExist() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);

        assertFalse("De user die game mag niet zijn eigen spel joinen", gameManager.joinGame("testGame", user1));
    }

    @Test
    public void testJoinGameUserExistsOtherGame() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);

        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        assertTrue("Een user die nog niet aan een spel deelneemt mag joinen", gameManager.joinGame("testGame", user2));

        User user3 = new User("testUser3", "testUser3", "testUser3", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame1", 3, user3);

        assertFalse("Een user kan nadat hij een spel gejoint heeft aan geen enkel spel deelnemen", gameManager.joinGame("testGame1", user2));
    }

    @Test
    public void testStatus() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        Game game = new Game("testGame", 3, user1);

        game.setState(EnumState.LEEG);
        assertEquals("De status moet <Empty> zijn", "Empty", game.getState());

        game.setState(EnumState.IDLE);
        assertEquals("De status moet <Idle> zijn", "Idle", game.getState());

        game.setState(EnumState.WACHTEN);
        assertEquals("De status moet <Waiting> zijn", "Waiting", game.getState());

        game.setState(EnumState.BEZIG);
        assertEquals("De status moet <Busy> zijn", "Busy", game.getState());

        game.setState(EnumState.VOL);
        assertEquals("De status moet <Full> zijn", "Full", game.getState());
    }

    @Test
    public void testGameFull() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 2, user1);

        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        User user4 = new User("testUser4", "testUser4", "testUser4", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        assertTrue("Deze user kan nog joinen", gameManager.joinGame("testGame", user2));

        assertFalse("De game is <Full> en kan dus niet gejoined worden", gameManager.joinGame("testGame", user4));
    }

    @Test
    public void testGameBusy() {
        User user = new User("testUser3", "testUser3", "testUser3", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        User user2 = new User("testUser2", "testUser2", "testUser2", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        gameManager.createGame("testGame1", 3, user);

        assertFalse("Een andere player kan de game niet starten", gameManager.startGame("testGame1", user2));

        assertTrue("De creator kan de game starten", gameManager.startGame("testGame1", user));

        assertFalse("De game is <Busy> en kan dus niet gejoined worden", gameManager.joinGame("testGame1", user2));
    }
}
