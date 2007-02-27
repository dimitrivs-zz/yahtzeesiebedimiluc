/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

import be.kdg.yahtzee.dao.HighscoreDao;
import be.kdg.yahtzee.model.chat.Chat;
import be.kdg.yahtzee.model.users.User;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

import java.util.*;

/**
 * Manager class for creating, deleting, managing games.
 */
public class GameManager {
    private static Logger logger = Logger.getLogger(GameManager.class);

    static final String FILENAME = "GameManagerLog.txt";

    private HighscoreDao highscoreDao;
    private Set<Highscore> highscores = new HashSet<Highscore>();
    private Set<Game> games;
    private Chat GlobalChat;

    /**
     * Constructor for Gamemanager class
     */
    public GameManager() {
        games = new HashSet<Game>();
        GlobalChat = new Chat();
        initLogger(Level.DEBUG);
        logger.info("GameManger started");
    }

    /**
     * Method for setting the highscoreDao
     *
     * @param highscoreDao HighScoreDao object
     */
    public void setHighscoreDao(HighscoreDao highscoreDao) {
        this.highscoreDao = highscoreDao;

        for (Object o : highscoreDao.getHighscores()) {
            Highscore highscore = (Highscore) o;
            highscores.add(highscore);
        }
    }

    /**
     * Method for getting all highscores.
     *
     * @return List with all highscores.
     */
    public List<Highscore> getHighscores() {
        return highscoreDao.getSortedHighscores();
    }

    /**
     * Method for getting top 10 highscores.
     *
     * @return List with top 10 highscores.
     */
    public List<Highscore> getTop10Highscores() {
        List<Highscore> top10 = new ArrayList<Highscore>();

        List<Highscore> allHighscores = highscoreDao.getSortedHighscores();

        for (int i = 0; i < 10; i++) {
            top10.add(allHighscores.get(i));
        }

        return top10;
    }

    /**
     * Method for initializing logger.
     *
     * @param level Level object loggin level.
     */
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

    /**
     * Method for getting all games.
     *
     * @return Set with all games.
     */
    public Set<Game> getGames() {
        return Collections.unmodifiableSet(games);
    }

    /**
     * Method for getting users of a game.
     *
     * @param gameName String name of the game.
     * @return Set with all users in a game.
     */
    public Set<User> getUsersOfGame(String gameName) {
        Game game = getGame(gameName);
        return game.getUsers();
    }

    /**
     * Method for getting a game object.
     *
     * @param gameName name of the game.
     * @return Game object.
     */
    public Game getGame(String gameName) {
        for (Game game : games) {
            if (checkGameEqualsGameName(game, gameName)) {
                return game;
            }
        }
        return null;
    }

    /**
     * Method for creating a game.
     *
     * @param gameName  String name of the game.
     * @param maxPlayer Integer maximum number of players.
     * @param user      User object creator of the game.
     * @return boolean value of success.
     */
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

    /**
     * Method for joining a user in a Game.
     *
     * @param gameName String name of the game to join.
     * @param user     User object to join the game.
     * @return boolean value of success.
     */
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

    /**
     * Method for starting a game.
     *
     * @param gamename String name of game to start.
     * @return String state of game.
     */
    public String startGame(String gamename) {
        Game game = getGame(gamename);
        game.startGame();
        return game.getState();
    }

    /**
     * Method for leaving a game.
     *
     * @param gameName String name of game to leave.
     * @param user     User object
     */
    public void leaveGame(String gameName, User user) {
        Game game = getGame(gameName);
        game.leaveGame(user);
        updateState(game);
        logger.info("User : " + user.getUsername() + " left game: " + gameName);
    }

    /**
     * Method for removing a game.
     *
     * @param gamename String game to remove.
     */
    public void removeGame(String gamename) {
        Game game = getGame(gamename);
        games.remove(game);
    }

    /**
     * Chat method to add a message.
     *
     * @param text     String Message to add
     * @param gameName String game to chat.
     */
    public void addMessage(String text, String gameName) {
        Game game = getGame(gameName);
        game.getChat().addMessage(text);
    }

    /**
     * Method for getting the messages of a chat in a game.
     *
     * @param gameName String name of game.
     * @return List with chatMessages of a game.
     */
    public List getMessages(String gameName) {
        Game game = getGame(gameName);
        return game.getChat().getMessages();
    }

    /**
     * Chat method to add a message.
     *
     * @param text String Message to add
     */
    public void addGlobalMessage(String text) {
        GlobalChat.addMessage(text);
    }

    /**
     * Method for getting the global messages.
     *
     * @return List with global chatMessages.
     */
    public List getGlobalMessages() {
        return GlobalChat.getMessages();
    }

    /**
     * Method to check if a user is the creator of a game.
     *
     * @param game String game name.
     * @param user User object to check.
     * @return boolean value of success.
     */
    private boolean isCreator(Game game, User user) {
        return game.getCreator().getUsername().equals(user.getUsername());
    }

    /**
     * Method for getting the creator of a game.
     *
     * @param gameName String game name.
     * @return String username of user that created the game.
     */
    public String getCreator(String gameName) {
        Game game = getGame(gameName);
        return game.getCreator().getUsername();
    }

    /**
     * Method for upadting the state of a game.
     *
     * @param game Sring game name.
     */
    private void updateState(Game game) {
        if (game.getNumberOfPlayers() == 0) {
            game.setState(EnumState.LEEG);
        } else {
            if (!game.getState().equals("Busy")) {
                game.setState(EnumState.WACHTEN);
            }
        }
    }

    /**
     * Method to check if a User is already in a game.
     *
     * @param user User thta want to join.
     * @return boolean value if a user is already in a game.
     */
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

    /**
     * Method to change status uf game to full.
     *
     * @param game String game name.
     * @return boolean value to check.
     */
    private boolean checkChangeStatusToFull(Game game) {
        return game.getNumberOfPlayers() == game.getMaxPlayer() - 1;
    }

    /**
     * Method to check game object and game name.
     *
     * @param game     Game object
     * @param gameName String gamename.
     * @return boolean value if equal
     */
    private boolean checkGameEqualsGameName(Game game, String gameName) {
        return game.getGameName().equals(gameName);
    }

    /**
     * Method to check if a game is full or busy
     *
     * @param game String game name
     * @return boolean value game full or busy
     */
    private boolean checkGameFullBusy(Game game) {
        return game.getState().equals("Full") || game.getState().equals("Busy");
    }

    /**
     * Method for playing a game round.
     *
     * @param gameName String game name.
     * @return List with dice.
     */
    public List<Die> playRound(String gameName) {
        Game game = getGame(gameName);
        List<Die> diceList = game.playRound();
        return diceList;
    }

    /**
     * Method for fixing a die.
     *
     * @param gameName String gamename.
     * @param dieId    Integer id of die.
     * @return boolean value if fixed
     */
    public boolean fixDie(String gameName, int dieId) {
        Game game = getGame(gameName);
        return game.fixDie(dieId);
    }

    /**
     * Method for unfixing a die.
     *
     * @param gameName String gamename.
     * @param dieId    Integer id of die.
     * @return boolean value if unfixed
     */
    public boolean unfixDie(String gameName, int dieId) {
        Game game = getGame(gameName);
        return game.unfixDie(dieId);
    }

    /**
     * Method for gettting the possible scores of yahtzee.
     *
     * @param gameName String game name.
     * @return List possible scoreaspects
     */
    public List<ScoreAspect> getScorePossibilities(String gameName) {
        Game game = getGame(gameName);
        return game.getScorePossibilities();
    }

    /**
     * Method for getting active player in a game
     *
     * @param gameName String game name
     * @return String username of active player
     */
    public String getActivePlayer(String gameName) {
        Game game = getGame(gameName);
        return game.getActivePlayer().getUsername();
    }

    /**
     * Method for selecting a score in a game.
     *
     * @param gameName    String game name
     * @param scoreChoice String score choise to select
     * @return Score object of active player
     */
    public Score selectScore(String gameName, String scoreChoice) {
        Game game = getGame(gameName);
        return game.selectScore(scoreChoice);
    }

    /**
     * Method for getting all scores of all users in a game
     *
     * @param gameName String game name
     * @return Map with scores of all users in a game.
     */
    public Map getScores(String gameName) {
        Game game = getGame(gameName);
        return game.getScores();
    }

    /**
     * Method for getting the state of a game.
     *
     * @param gamename String game name
     * @return String state of a game
     */
    public String getGameState(String gamename) {
        Game game = getGame(gamename);
        return game.getState();
    }

    /**
     * Method for getting the dices in a game
     *
     * @param gameName String game name
     * @return List with dices in a game.
     */
    public List getDiceList(String gameName) {
        Game game = getGame(gameName);
        return game.getDiceList();
    }
}
