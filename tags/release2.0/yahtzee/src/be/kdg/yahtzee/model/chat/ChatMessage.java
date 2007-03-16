/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.chat;

/**
 * This class represents a chat message in the chat application.
 */
public class ChatMessage {
    private String text;

    /**
     * Constructor for a new chat message.
     * Only the 256 first characters are saved.
     *
     * @param newtext String containing the text of the message.
     */
    public ChatMessage(String newtext) {
        text = newtext;
        if (text.length() > 256) {
            text = text.substring(0, 256);
        }
    }

    /**
     * Method for getting the text of the message.
     *
     * @return String containing the text of the message.
     */
    public String getText() {
        return text;
    }
}

