package be.kdg.yahtzee.model.game;

import be.kdg.yahtzee.dao.HighscoreDao;
import be.kdg.yahtzee.model.chat.Chat;
import be.kdg.yahtzee.model.users.User;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.util.*;

public class GameManager {
    private static Logger logger = Logger.getLogger(GameManager.class);
    static final String FILENAME = "GameManagerLog.txt";

    private HighscoreDao highscoreDao;
    private Set<Highscore> highscores = new HashSet<Highscore>();

    private Set<Game> games;
    private Chat GlobalChat;

    public GameManager() {
        games = new HashSet<Game>();
        GlobalChat = new Chat();
        initLogger(Level.DEBUG);
        logger.info("GameManger started");
    }

    public void setHighscoreDao(HighscoreDao highscoreDao) {
        this.highscoreDao = highscoreDao;

        for (Object o : highscoreDao.getHighscores()) {
            Highscore highscore = (Highscore) o;
            highscores.add(highscore);
        }
    }

    public List<Highscore> getHighscores() {
        return highscoreDao.getSortedHighscores();
    }

    public List<Highscore> getTop10Highscores() {
        List<Highscore> top10 = new ArrayList<Highscore>();

        List<Highscore> allHighscores = highscoreDao.getSortedHighscores();

        for (int i = 0; i < 10; i++) {
            top10.add(allHighscores.get(i));
        }

        return top10;
    }

    private void initLogger(Level level) {
        SimpleLayout layout = new SimpleLayout();

        FileAppender appender = null;
        try {
            appender = new FileAppender(layout, FILENAME, false);
        } catch (Exception e) {
            // empty catch block!
        }

        logger.addAppender(appender);
        logger.setLevel(level);
    }

    // ------ get methoden

    public Set<Game> getGames() {
        return Collections.unmodifiableSet(games);
    }

    public Set<User> getUsersOfGame(String gameName) {
        Game game = getGame(gameName);
        return game.getUsers();
    }

    public Game getGame(String gameName) {
        for (Game game : games) {
            if (checkGameEqualsGameName(game, gameName)) {
                return game;
            }
        }
        return null;
    }

    // ------ Create, Join, Leave, Remove game methoden

    public boolean createGame(String gameName, int maxPlayer, User user) {
        if (getGame(gameName) != null) {
            logger.debug("Game : " + gameName + " kon niet worden gemaakt reden: het spel bestaat al");
            return false;
        }
        if (checkUserAlreadyInAgame(user)) {
            logger.debug("Game : " + gameName + " kon niet worden gemaakt reden: de user doet al mee aan een ander spel");
            return false;
        }
        Game game = new Game(gameName, maxPlayer, user);
        games.add(game);
        logger.info("Game : " + gameName + " was created");
        return true;
    }
    /*
    public boolean joinGame(String gameName, User user) {
        for (Game game : games) {
            if (checkUserAlreadyInAgame(user)) {
                if (checkGameFullBusy(game)) {
                    return false;
                } else {
                    if (checkGameEqualsGameName(game, gameName)) {
                        logger.info("User : " + user.getUsername() + " joined game: " + gameName);
                        game.joinGame(user);
                        if (checkChangeStatusToFull(game)) {
                            game.setState(EnumState.VOL);
                        }
                        return true;
                    }
                }
            } else {
                logger.info("The user is already in the game");
                return false;
            }
        }
        return false;
    } */

    public boolean joinGame(String gameName, User user) {
        Game game = getGame(gameName);
        if (checkUserAlreadyInAgame(user)) {
            return false;
        }
        if (checkGameFullBusy(game)) {
            return false;
        }
        if (checkChangeStatusToFull(game)) {
            game.setState(EnumState.VOL);
        }
        logger.info("User : " + user.getUsername() + " joined game: " + gameName);
        game.joinGame(user);
        return true;
    }

    public boolean startGame(String gameName, User user) {
        Game game = getGame(gameName);
        if (isCreator(game, user)) {
            game.setState(EnumState.BEZIG);
            return true;
        }
        return false;
    }

    public void leaveGame(String gameName, User user) {
        Game game = getGame(gameName);
        game.leaveGame(user);
        updateState(game);
        logger.info("User : " + user.getUsername() + " left game: " + gameName);
    }

    public void removeGame(String gamename) {
        Game game = getGame(gamename);
        games.remove(game);
    }

// ----- Chat methoden

// --- localChat methoden

    public void addMessage(String text, String gameName) {
        Game game = getGame(gameName);
        game.getChat().addMessage(text);
    }

    public List getMessages(String gameName) {
        Game game = getGame(gameName);
        return game.getChat().getMessages();
    }

// --- globalChat methoden

    public void addGlobalMessage(String text) {
        GlobalChat.addMessage(text);
    }

    public List getGlobalMessages() {
        return GlobalChat.getMessages();
    }

// --- andere methoden

    private boolean isCreator(Game game, User user) {
        return game.getCreator().getUsername().equals(user.getUsername());
    }

    private void updateState(Game game) {
        if (game.getNumberOfPlayers() == 0) {
            game.setState(EnumState.LEEG);
        } else {
            if (!game.getState().equals("Busy")) {
                game.setState(EnumState.WACHTEN);
            }
        }
    }

    private boolean checkUserAlreadyInAgame(User user) {
        for (Game game : games) {
            for (User userInGame : game.getUsers()) {
                if (userInGame.getUsername().equals(user.getUsername())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkChangeStatusToFull(Game game) {
        return game.getNumberOfPlayers() == game.getMaxPlayer() - 1;
    }

    private boolean checkGameEqualsGameName(Game game, String gameName) {
        return game.getGameName().equals(gameName);
    }

    private boolean checkGameFullBusy(Game game) {
        return game.getState().equals("Full") || game.getState().equals("Busy");
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
    /*
   public int getNumberOfGames() {
       return games.size();
   } */
}
