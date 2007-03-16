/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

import be.kdg.yahtzee.model.chat.Chat;
import be.kdg.yahtzee.model.users.User;

import java.util.*;

/**
 * Class representing one Game in the yahtzee application.
 */
public class Game {
    public static final Game NULL_Game = new Game("null");

    private String gameName;
    private int maxPlayer;
    private User creator;
    private Set<User> users;
    private EnumState state;
    private Chat chat;
    private List<Die> diceList = new ArrayList<Die>();
    private DiceGenerator diceGen;
    private User activePlayer;
    private Map<String, Score> scores;
    private List<User> userList;
    private Map<String, Integer> possibleScores;
    private int numberOfRolls;
    private Map<String, Integer> numberTurns;

    private ScoreCalculator scoreCalculator;

    public Game(String nullGame) {
        this.gameName = "gameName";
        this.maxPlayer = 0;
        this.activePlayer = User.NULL_USER;
    }

    //Nodig voor testGame - tijdelijk

    /**
     * Constructor for a yahtzee game.
     *
     * @param gameName  String name of the game.
     * @param maxPlayer Integer value maximum number of players.
     * @param user      User object creator of the game.
     */

    public Game(String gameName, int maxPlayer, User user) {
        this.gameName = gameName;
        this.maxPlayer = maxPlayer;
        if (maxPlayer == 1) {
            this.state = EnumState.VOL;
        } else {
            this.state = EnumState.WACHTEN;
        }
        this.chat = new Chat();
        creator = user;
        users = new HashSet<User>();
        users.add(user);
        userList = new ArrayList<User>();
        scores = new HashMap<String, Score>();
        scores.put(user.getUsername(), new Score());
        activePlayer = user;
        userList.add(user);
        numberTurns = new HashMap<String, Integer>();
        numberTurns.put(user.getUsername(), 0);
        creator = user;
        diceGen = new DiceGenerator();
        possibleScores = new HashMap<String, Integer>();
        numberOfRolls = 0;
        scoreCalculator = new ScoreCalculator();
    }

    /**
     * Method for getting the creator of this game.
     *
     * @return User object representing the creator of this game.
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Method for getting the name of this game.
     *
     * @return String representing the name of the game.
     */
    public String getGameName() {
        return gameName;
    }

    /**
     * Method for getting the state of this game.
     *
     * @return String representing the state of the game.
     */
    public String getState() {
        switch (state) {
            case LEEG:
                return "Empty";
            case WACHTEN:
                return "Waiting";
            case VOL:
                return "Full";
            case IDLE:
                return "Idle";
            case BEZIG:
                return "Busy";
            default:
                return "Unknown state";
        }
    }

    /**
     * Method for setting the state of the game.
     *
     * @param state EnumState state of the game.
     */
    public void setState(EnumState state) {
        this.state = state;
    }

    /**
     * Method for getting the list with dices.
     *
     * @return List with the dices.
     */
    public List<Die> getDiceList() {
        return diceList;
    }

    /**
     * Method for setting the list with dices.
     *
     * @param diceList List with the dices.
     */
    public void setDiceList(List<Die> diceList) {
        this.diceList = diceList;
    }

    /**
     * Method for getting the chat object.
     *
     * @return Chat object for this game.
     */
    public Chat getChat() {
        return chat;
    }

    /**
     * Method for getting the players in this game.
     *
     * @return Set with players in this game.
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * Method for getting the currently playing user.
     *
     * @return User object representing currently active player.
     */
    public User getActivePlayer() {
        return activePlayer;
    }

    /**
     * Method for starting the game.
     * State is set to Busy.
     */
    public void startGame() {
        setState(EnumState.BEZIG);
    }

    /**
     * Method to add a user to this game.
     *
     * @param user User object representing new player.
     */
    public void joinGame(User user) {
        users.add(user);
        userList.add(user);
        numberTurns.put(user.getUsername(), 0);
        scores.put(user.getUsername(), new Score());
    }

    /**
     * Method to remove a player from a game.
     *
     * @param user User object representing player to remove.
     */
    public void leaveGame(User user) {
        users.remove(user);
        userList.remove(user);
        scores.remove(user.getUsername());
        numberTurns.remove(user.getUsername());
        if (user.getUsername().equals(activePlayer.getUsername()) && users.size() != 0) {
            resetRound();
            getNextPlayer();
        }
    }

    /**
     * Method for getting the number of players in this game.
     *
     * @return Integer value with the number of players.
     */
    public int getNumberOfPlayers() {
        return users.size();
    }

    /**
     * Method for getting the maximum number of players in this game.
     *
     * @return Integer value with the maximum number of players.
     */
    public int getMaxPlayer() {
        return maxPlayer;
    }

    /**
     * Method to reset the round.
     * Clear lists for generatiing new dice and the next trn to play.
     */
    private void resetRound() {
        numberOfRolls = 0;
        diceList.clear();
        scoreCalculator.clearDiceValueList();
        possibleScores.clear();
        diceGen.resetDiceGenerator();
    }

    /**
     * Method for playing a game round.
     * Roll dice and return them.
     * Max. 3 rolls per turn.
     *
     * @return List with rolled dices.
     */
    public List<Die> playRound() {
        if (numberOfRolls < 3) {
            numberOfRolls++;
            diceGen.rollDice();
            diceList = diceGen.getDice();

            calculateScores();
        }
        return diceList;
    }

    /**
     * Method for fixing a Die.
     *
     * @param dieId Integer id of the Die to fix.
     * @return boolean value representing success of fixing.
     */
    public boolean fixDie(int dieId) {
        Die die = getDie(dieId);
        return diceGen.fixDie(die);
    }

    /**
     * Method for unfixing a Die.
     *
     * @param dieId Integer id of the Die to unfix.
     * @return boolean value representing success of unfixing.
     */
    public boolean unfixDie(int dieId) {
        Die die = getDie(dieId);
        return diceGen.unfixDie(die);
    }

    /**
     * Method for getting one Die by id.
     *
     * @param dieId Integer id of the Die to get.
     * @return Die object representing wanted die.
     */
    public Die getDie(int dieId) {
        for (Die die : diceList) {
            if (die.getDieId() == dieId) {
                return die;
            }
        }
        return null;
    }

    /**
     * Method for getting the possible scoreAspect of yahtzee.
     *
     * @return List with possible scoreAspects
     */
    public List<ScoreAspect> getScorePossibilities() {
        List<ScoreAspect> scorePossibilities = new ArrayList<ScoreAspect>();
        int i = 0;
        if (possibleScores.containsKey("ones"))
            scorePossibilities.add(i++, new ScoreAspect("ones", possibleScores.get("ones")));
        if (possibleScores.containsKey("twos"))
            scorePossibilities.add(i++, new ScoreAspect("twos", possibleScores.get("twos")));
        if (possibleScores.containsKey("threes"))
            scorePossibilities.add(i++, new ScoreAspect("threes", possibleScores.get("threes")));
        if (possibleScores.containsKey("fours"))
            scorePossibilities.add(i++, new ScoreAspect("fours", possibleScores.get("fours")));
        if (possibleScores.containsKey("fives"))
            scorePossibilities.add(i++, new ScoreAspect("fives", possibleScores.get("fives")));
        if (possibleScores.containsKey("sixes"))
            scorePossibilities.add(i++, new ScoreAspect("sixes", possibleScores.get("sixes")));
        if (possibleScores.containsKey("threeOfAKind"))
            scorePossibilities.add(i++, new ScoreAspect("threeOfAKind", possibleScores.get("threeOfAKind")));
        if (possibleScores.containsKey("carre"))
            scorePossibilities.add(i++, new ScoreAspect("carre", possibleScores.get("carre")));
        if (possibleScores.containsKey("fullHouse"))
            scorePossibilities.add(i++, new ScoreAspect("fullHouse", possibleScores.get("fullHouse")));
        if (possibleScores.containsKey("smallStreet"))
            scorePossibilities.add(i++, new ScoreAspect("smallStreet", possibleScores.get("smallStreet")));
        if (possibleScores.containsKey("largeStreet"))
            scorePossibilities.add(i++, new ScoreAspect("largeStreet", possibleScores.get("largeStreet")));
        if (possibleScores.containsKey("yahtzee"))
            scorePossibilities.add(i++, new ScoreAspect("yahtzee", possibleScores.get("yahtzee")));
        if (possibleScores.containsKey("chance"))
            scorePossibilities.add(i++, new ScoreAspect("chance", possibleScores.get("chance")));
        /*for (String s : possibleScores.keySet()) {
            scorePossibilities.add(new ScoreAspect(s, possibleScores.get(s)));
        }*/
        return scorePossibilities;
    }

    /**
     * Calculate the yahtzee scores.
     */
    public void calculateScores() {
        possibleScores = scoreCalculator.calculateScores(diceList, scores, activePlayer);
    }

    /**
     * Method for selecting a score from the score possibilities.
     *
     * @param scoreChoice String score asprect to fix.
     * @return Score object, representing active player score.
     */
    public Score selectScore(String scoreChoice) {
        Score score = scores.get(activePlayer.getUsername());

        int scorePoints = possibleScores.get(scoreChoice);

        if (scoreChoice.equals("ones"))
            score.setOnes(scorePoints);
        if (scoreChoice.equals("twos"))
            score.setTwos(scorePoints);
        if (scoreChoice.equals("threes"))
            score.setThrees(scorePoints);
        if (scoreChoice.equals("fours"))
            score.setFours(scorePoints);
        if (scoreChoice.equals("fives"))
            score.setFives(scorePoints);
        if (scoreChoice.equals("sixes"))
            score.setSixes(scorePoints);
        if (scoreChoice.equals("threeOfAKind"))
            score.setThreeOfAKind(scorePoints);
        if (scoreChoice.equals("carre"))
            score.setCarre(scorePoints);
        if (scoreChoice.equals("fullHouse"))
            score.setFullHouse(scorePoints);
        if (scoreChoice.equals("smallStreet"))
            score.setSmallStreet(scorePoints);
        if (scoreChoice.equals("largeStreet"))
            score.setLargeStreet(scorePoints);
        if (scoreChoice.equals("yahtzee"))
            score.setYahtzee(scorePoints);
        if (scoreChoice.equals("chance"))
            score.setChance(scorePoints);

        int turns = numberTurns.get(activePlayer.getUsername());
        turns++;
        numberTurns.put(activePlayer.getUsername(), turns);
        resetRound();
        getNextPlayer();
        return score;
    }

    /**
     * Method for selecting next player in the game.
     */
    private void getNextPlayer() {
        int currentPlayerIndex = 0;
        for (User tUser : userList) {
            if (tUser == activePlayer) {
                currentPlayerIndex = userList.indexOf(tUser);
            }
        }
        if (currentPlayerIndex == userList.size() - 1) {
            currentPlayerIndex = 0;
        } else {
            currentPlayerIndex++;
        }
        activePlayer = userList.get(currentPlayerIndex);
    }

    /**
     * Method for getting the score of a player.
     *
     * @param username de username
     * @return Score object of a player.
     */
    public Score getScore(String username) {
        return scores.get(username);
    }

    /**
     * Method for getting all the scores of all users.
     *
     * @return Map with all scores of all users in the game.
     */
    public Map getScores() {
        return scores;
    }

    /**
     * Method for getting the scores of a certain user.
     *
     * @param user User object
     * @return score Integer value.
     */
    public int getPlayerScore(User user) {
        return scores.get(user.getUsername()).getTotalScore();
    }
}
