/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.chat;

import java.util.LinkedList;
import java.util.List;

public class Chat {
    private LinkedList<ChatMessage> chatMessages;

    public Chat() {
        chatMessages = new LinkedList<ChatMessage>();
    }

    public void addMessage(String text) {
        if (text != null) {
            chatMessages.addFirst(new ChatMessage(text));
        }
    }

    public List getMessages() {
        return chatMessages;
    }
}