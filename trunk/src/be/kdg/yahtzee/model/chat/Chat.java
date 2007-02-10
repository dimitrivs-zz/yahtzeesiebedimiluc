package be.kdg.yahtzee.model.chat;

import java.util.List;
import java.util.ArrayList;

public class Chat{
    private List<ChatMessage> chatMessages;

    public Chat() {
        chatMessages = new ArrayList<ChatMessage>();
    }

    public void addMessage(String text)
    {
        chatMessages.add(new ChatMessage(text)) ;
    }

    public List getMessages()
    {
        return chatMessages;
    }
}