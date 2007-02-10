package be.kdg.yahtzee.model.game;

import be.kdg.yahtzee.model.users.User;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.WriterAppender;

import java.io.FileOutputStream;
import java.util.*;

public class GameManager {
    private static Logger logger = Logger.getLogger(GameManager.class);
    private Set<Game> games;

    public GameManager() {
        games = new HashSet<Game>();
        initLogger(Level.DEBUG);
        logger.info("GameManger started");
    }

    private void initLogger(Level level) {
        HTMLLayout layout = new HTMLLayout();
        WriterAppender appender = null;
        try {
            FileOutputStream output = new FileOutputStream("gameManagerLog.html");
            appender = new WriterAppender(layout, output);
        } catch (Exception e) {
            // Empty catch block!
        }
        logger.addAppender(appender);
        logger.setLevel(level);
    }

    public boolean createGame(String gameName, int maxPlayer, User user) {
        if (!checkGameExists(gameName)) {
            logger.debug("Game : " + gameName + " kon niet worden gemaakt reden: het spel bestaat al");
            return false;
        }
        if (!checkUserAlreadyInAgame(user)) {
            logger.debug("Game : " + gameName + " kon niet worden gemaakt reden: de user doet al mee aan een ander spel");
            return false;
        }
        Game game = new Game(gameName, maxPlayer, user);
        games.add(game);
        logger.info("Game : " + gameName + " was created");
        return true;
    }

    public Collection getGames() {
        return Collections.unmodifiableSet(games);
    }

    public boolean joinGame(String gameName, User user) {
        for (Game game : games) {
            if (game.getGameName().equals(gameName)) {
                if (game.getNumberOfPlayers() < game.getMaxPlayer()) {
                    if (!checkUserAlreadyInAgame(user)) {
                        logger.debug("User : " + user.getUsername() + " kon de game: " + gameName + " niet joinen");
                        return false;
                    }
                    game.joinGame(user);
                }
            }
        }
        logger.info("User : " + user.getUsername() + " joined game: " + gameName);
        return true;
    }

    public void leaveGame(String gameName, User user) {
        for (Game game : games) {
            if (game.getGameName().equals(gameName)) {
                game.leaveGame(user);
            }
        }
        logger.info("User : " + user.getUsername() + " left game: " + gameName);
    }

    private boolean checkGameExists(String gameName) {
        for (Game game : games) {
            if (game.getGameName().equals(gameName)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkUserAlreadyInAgame(User user) {
        for (Game game : games) {
            for (User userInGame : game.getUsers()) {
                if (userInGame.getUsername().equals(user.getUsername())) {
                    return false;
                }
            }
        }
        return true;
    }

    public Game getGame(String gameName) {
        for (Game game : games) {
            if (game.getGameName().equals(gameName)) {
                return game;
            }
        }
        return null;
    }

    public List<Die> playRound(String gameName) {
        Game game = getGame(gameName);

        List<Die> diceList = game.playRound();

        return diceList;
    }

    public boolean fixDie(String gameName, int dieId) {
        Game game = getGame(gameName);

        return game.fixDie(dieId);
    }

    public boolean unfixDie(String gameName, int dieId) {
        Game game = getGame(gameName);

        return game.unfixDie(dieId);
    }

    /*public Map<String, Integer> getScorePossibilities(String gameName) {
        Game game = getGame(gameName);

        return game.getScorePossibilities();
    }*/

    public List<ScoreAspect> getScorePossibilities(String gameName) {
        Game game = getGame(gameName);
        return game.getScorePossibilities();
    }

    public boolean selectScore(String gameName, String scoreChoice) {
        Game game = getGame(gameName);

        return game.selectScore(scoreChoice);
    }

    public void addMessage(String text, String gameName) {
        Game game = getGame(gameName);
        game.getChat().addMessage(text);
    }

    public List getMessages(String gameName) {
        Game game = getGame(gameName);
        return game.getChat().getMessages();
    }
    /*
   public List<ChatMessage> addMessage(String text, String gameName)
{
   Game game = getGame(gameName);
   Chat chat = game.getChat();
   chat.addMessage(text);
   return game.getChat().getMessages();
}

public List getMessages(String gameName)
{
   Game game = getGame(gameName);
   Chat chat = game.getChat();
   return chat.getMessages();
}     */
}
