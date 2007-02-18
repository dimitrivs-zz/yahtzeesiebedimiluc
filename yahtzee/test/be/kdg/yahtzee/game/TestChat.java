package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.chat.Chat;
import be.kdg.yahtzee.model.chat.ChatMessage;
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
    private Chat chat;

    @Before
    public void setUp() {
        chat = new Chat();
    }

    @After
    public void tearDown() {
        chat = null;
    }

    @Test
    public void testAddChatMessage() {
        chat.addMessage("Hallo");

        ChatMessage chatMessage = (ChatMessage) chat.getMessages().get(0);

        assertEquals("De message moet <Hallo> zijn", "Hallo", chatMessage.getText());
    }

    @Test
    public void testAddMessageLarger256() {
        chat.addMessage("123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789psiebe");

        ChatMessage chatMessage = (ChatMessage) chat.getMessages().get(0);

        assertEquals("De message moet <een substring worden> zijn", "123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456", chatMessage.getText());
    }
}
