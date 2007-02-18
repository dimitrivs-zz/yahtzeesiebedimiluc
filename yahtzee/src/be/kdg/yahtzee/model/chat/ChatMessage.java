/*
Exeption handeling: OK
Logging: te kleine klasse om te loggen
Java 5: OK
Refacorting: OK
Testen: OK
 */

package be.kdg.yahtzee.model.chat;

public class ChatMessage {
    private String text;

    public ChatMessage(String newtext) {
        text = newtext;
        if (text.length() > 256) {
            text = text.substring(0, 256);
        }
    }

    public String getText() {
        return text;
    }
}

