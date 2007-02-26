/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.chat;

import java.util.LinkedList;
import java.util.List;

/**
 * This class provides chat functionality in the yahtzee application.
 */
public class Chat {
    private LinkedList<ChatMessage> chatMessages;

    /**
     * Constructor for chat application. Creates a linkedList in which the
     * chat messages are stored.
     */
    public Chat() {
        chatMessages = new LinkedList<ChatMessage>();
    }

    /**
     * Method for getting al the chat message stored in the linkedlist.
     *
     * @return List containing the chat messages.
     */
    public List getMessages() {
        return chatMessages;
    }

    /**
     * Method for adding a new chat message to the list.
     *
     * @param text String containing the message.
     */
    public void addMessage(String text) {
        if (text != null) {
            chatMessages.addFirst(new ChatMessage(text));
        }
    }
}