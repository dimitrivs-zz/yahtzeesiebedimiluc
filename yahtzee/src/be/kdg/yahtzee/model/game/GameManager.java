package be.kdg.yahtzee.model.game;

import be.kdg.yahtzee.model.chat.Chat;
import be.kdg.yahtzee.model.users.User;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameManager {
    private static Logger logger = Logger.getLogger(GameManager.class);
    private Set<Game> games;
    private Chat GlobalChat;


    public GameManager() {
        games = new HashSet<Game>();
        GlobalChat = new Chat();
        //initLogger(Level.DEBUG);
        //logger.info("GameManger started");
    }
    /*
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
 }   */

    public boolean createGame(String gameName, int maxPlayer, User user) {
        if (!checkGameExists(gameName)) {
            //logger.debug("Game : " + gameName + " kon niet worden gemaakt reden: het spel bestaat al");
            return false;
        }
        if (!checkUserAlreadyInAgame(user)) {
            //logger.debug("Game : " + gameName + " kon niet worden gemaakt reden: de user doet al mee aan een ander spel");
            return false;
        }
        Game game = new Game(gameName, maxPlayer, user);
        games.add(game);
        //logger.info("Game : " + gameName + " was created");
        return true;
    }

    public Set<Game> getGames() {
        return Collections.unmodifiableSet(games);
    }

    public Set<User> getUsersOfGame(String gameName) {
        for (Game game : games) {
            if (game.getGameName().equals(gameName)) {
                return game.getUsers();
            }
        }
        return null;
    }
    /*
    public List<Game> test(){
        List<Game> gamesAjax = new ArrayList<Game>();
        Iterator it = games.iterator();
        while(it.hasNext()){
            Game game = (Game)it.next();
            gamesAjax.add(game);
        }
        return gamesAjax;
    } */

    public boolean joinGame(String gameName, User user) {
        for (Game game : games) {
            if (checkUserAlreadyInAgame(user)) {
                if (game.getState().equals("Full") || game.getState().equals("Bezig")) {
                    return false;
                } else {
                    if (game.getGameName().equals(gameName)) {
                        //logger.info("User : " + user.getUsername() + " joined game: " + gameName);
                        game.joinGame(user);
                        if (game.getNumberOfPlayers() == game.getMaxPlayer()) {
                            game.setState(EnumState.VOL);
                        }
                        return true;
                    }
                }
            } else {
                //logger.info("The user is already in the game");
                return false;
            }
        }
        return false;
    }

    public void leaveGame(String gameName, User user) {
        for (Game game : games) {
            if (game.getGameName().equals(gameName)) {
                game.leaveGame(user);
                if (game.getNumberOfPlayers() == 0) {
                    game.setState(EnumState.LEEG);
                } else {
                    game.setState(EnumState.WACHTEN);
                }
            }
        }
        //logger.info("User : " + user.getUsername() + " left game: " + gameName);
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

    public User getActivePlayer(String gameName) {
        Game game = getGame(gameName);
        return game.getActivePlayer();
    }

    /*public List<Integer> getTotals(String gameName) {
        Game game = getGame(gameName);
        List<Integer> totals = new ArrayList<Integer>();
        totals.add(0, game.getScore().getUpperHalf());
        totals.add(1, game.getScore().getTotalUpperHalf());
        totals.add(2, game.getScore().getTotalLowerHalf());
        totals.add(3, game.getScore().getTotalScore());
        return totals;
    }*/

    public Score selectScore(String gameName, String scoreChoice) {
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

    public int getNumberOfGames() {
        return games.size();
    }

    public void addGlobalMessage(String text) {
        GlobalChat.addMessage(text);
    }

    public List getGlobalMessages() {
        return GlobalChat.getMessages();
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
    public void removeGame(String gamename) {
        Game game = getGame(gamename);
        games.remove(game);
    }
}
