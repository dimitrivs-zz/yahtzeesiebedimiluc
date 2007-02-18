/*
Exeption handeling: OK
Logging: te kleine klasse om te loggen
Java 5: OK
Refacorting: OK
Testen: OK
 */

package be.kdg.yahtzee.model.chat;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private List<ChatMessage> chatMessages;

    public Chat() {
        chatMessages = new ArrayList<ChatMessage>();
    }

    public void addMessage(String text) {
        if (text != null) {
            chatMessages.add(new ChatMessage(text));
        }
    }

    public List getMessages() {
        return chatMessages;
    }
}