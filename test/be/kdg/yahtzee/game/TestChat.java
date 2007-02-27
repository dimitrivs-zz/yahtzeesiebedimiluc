package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.chat.ChatMessage;
import be.kdg.yahtzee.model.game.GameManager;
import be.kdg.yahtzee.model.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 18-feb-2007
 * Time: 15:31:58
 * To change this template use File | Settings | File Templates.
 */
public class TestChat extends TestCase {
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
    public void testAddChatMessage() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);
        gameManager.addMessage("Hallo", "testGame");

        ChatMessage chatMessage = (ChatMessage) gameManager.getMessages("testGame").get(0);

        assertEquals("De message moet <Hallo> zijn", "Hallo", chatMessage.getText());
    }

    @Test
    public void testAddMessageLarger256() {
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        gameManager.createGame("testGame", 3, user1);
        gameManager.addMessage("123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789psiebe", "testGame");

        ChatMessage chatMessage = (ChatMessage) gameManager.getMessages("testGame").get(0);

        assertEquals("De message moet <een substring worden> zijn", "123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456", chatMessage.getText());
    }

    @Test
    public void testAddGlobalChatMessage() {
        gameManager.addGlobalMessage("Hallo");

        ChatMessage chatMessage = (ChatMessage) gameManager.getGlobalMessages().get(0);

        assertEquals("De message moet <Hallo> zijn", "Hallo", chatMessage.getText());
    }
}
