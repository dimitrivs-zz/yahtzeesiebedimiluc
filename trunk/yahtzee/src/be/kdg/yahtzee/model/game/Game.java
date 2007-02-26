/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

import static be.kdg.util.ScorePoints.*;
import be.kdg.yahtzee.model.chat.Chat;
import be.kdg.yahtzee.model.users.User;

import java.util.*;

/**
 * Class representing one Game in the yahtzee application.
 */
public class Game {
    private String gameName;
    private int maxPlayer;
    private User creator;
    private Set<User> users;
    private EnumState state;
    private Chat chat;
    private List<Die> diceList = new ArrayList<Die>();
    private List<Integer> diceValueList;
    private List<Integer> diceValueListWithoutDoubles;
    private DiceGenerator diceGen;
    private int points;
    private User activePlayer;
    private Map<String, Score> scores;
    private List<User> userList;
    private Map<String, Integer> possibleScores;
    private int numberOfRolls;

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
        creator = user;
        diceGen = new DiceGenerator();
        possibleScores = new HashMap<String, Integer>();
        numberOfRolls = 0;
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
        if (user.getUsername().equals(activePlayer.getUsername())) {
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
        diceValueList.clear();
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

            System.out.println("");
            System.out.println("Roll Statistics");
            System.out.println("---------------");

            for (Die die : diceList) {
                System.out.print(die.getValue() + " ");
            }
            System.out.println("\n---------------");

            calculateScores();
        }
        return diceList;
    }

    /**
     * Method for filling a List with dice values.
     */
    private void fillDiceValues() {
        diceValueList = new ArrayList<Integer>();

        for (Die die : diceList) {
            diceValueList.add(die.getValue());
        }
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
        for (String s : possibleScores.keySet()) {
            scorePossibilities.add(new ScoreAspect(s, possibleScores.get(s)));
        }
        return scorePossibilities;
    }

    /**
     * Calculate the yahtzee scores.
     */
    private void calculateScores() {
        fillDiceValues();
        Collections.sort(diceValueList);

        System.out.println(diceValueList);

        calculateOnes();
        calculateTwos();
        calculateThrees();
        calculateFours();
        calculateFives();
        calculateSixes();

        calculateThreeOfAKind();
        calculateCarre();
        calculateFullHouse();
        calculateSmallStreet();
        calculateLargeStreet();
        calculateYahtzee();
        calculateYahtzeeBonus();
        calculateChance();
    }

    /**
     * Calculate Ones score.
     */
    private void calculateOnes() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isOnesFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 1) {
                    points += 1;
                }
            }
            possibleScores.put("ones", points);
        }
    }

    /**
     * Calculate Twos score.
     */
    private void calculateTwos() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isTwosFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 2) {
                    points += 2;
                }
            }
            possibleScores.put("twos", points);
        }
    }

    /**
     * Calculate Threes score.
     */
    private void calculateThrees() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isThreesFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 3) {
                    points += 3;
                }
            }
            possibleScores.put("threes", points);
        }
    }

    /**
     * Calculate Fours score.
     */
    private void calculateFours() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isFoursFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 4) {
                    points += 4;
                }
            }
            possibleScores.put("fours", points);
        }
    }

    /**
     * Calculate Fives score.
     */
    private void calculateFives() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isFivesFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 5) {
                    points += 5;
                }
            }
            possibleScores.put("fives", points);
        }
    }

    /**
     * Calculate Sixes score.
     */
    private void calculateSixes() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isSixesFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 6) {
                    points += 6;
                }
            }
            possibleScores.put("sixes", points);
        }
    }


    /**
     * Calculate ThreeOfAKind score.
     */
    private void calculateThreeOfAKind() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isThreeOfAKindFixed()) {
            if (diceValueList.get(0) == diceValueList.get(1) &&
                    diceValueList.get(1) == diceValueList.get(2)) {
                points = countAll();
            } else {
                if (diceValueList.get(1) == diceValueList.get(2) &&
                        diceValueList.get(2) == diceValueList.get(3)) {
                    points = countAll();
                } else {
                    if (diceValueList.get(2) == diceValueList.get(3) &&
                            diceValueList.get(3) == diceValueList.get(4)) {
                        points = countAll();
                    }
                }
            }
            possibleScores.put("threeOfAKind", points);
        }
    }

    /**
     * Calculate Carre score.
     */
    private void calculateCarre() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isCarreFixed()) {
            if (diceValueList.get(0) == diceValueList.get(1) &&
                    diceValueList.get(1) == diceValueList.get(2) &&
                    diceValueList.get(2) == diceValueList.get(3)) {
                points = countAll();
            } else {
                if (diceValueList.get(1) == diceValueList.get(2) &&
                        diceValueList.get(2) == diceValueList.get(3) &&
                        diceValueList.get(3) == diceValueList.get(4)) {
                    points = countAll();
                }
            }
            possibleScores.put("carre", points);
        }
    }

    /**
     * Calculate FullHouse score.
     */
    private void calculateFullHouse() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isFullHouseFixed()) {
            if (diceValueList.get(0) == diceValueList.get(1) &&
                    diceValueList.get(1) == diceValueList.get(2) &&
                    diceValueList.get(3) == diceValueList.get(4)) {
                points = FULLHOUSEPOINTS;
            }
            if (diceValueList.get(0) == diceValueList.get(1) &&
                    diceValueList.get(2) == diceValueList.get(3) &&
                    diceValueList.get(3) == diceValueList.get(4)) {
                points = FULLHOUSEPOINTS;
            }
            possibleScores.put("fullHouse", points);
        }
    }

    /**
     * Calculate SmallStreet score.
     */
    private void calculateSmallStreet() {
        points = 0;
        removeDoubles();
        if (!scores.get(activePlayer.getUsername()).isSmallStreetFixed()) {
            if (diceValueListWithoutDoubles.size() >= 4) {
                if (diceValueListWithoutDoubles.get(0) + 1 == diceValueListWithoutDoubles.get(1) &&
                        diceValueListWithoutDoubles.get(1) + 1 == diceValueListWithoutDoubles.get(2) &&
                        diceValueListWithoutDoubles.get(2) + 1 == diceValueListWithoutDoubles.get(3)) {
                    points = SMALLSTREETPOINTS;
                }
            }
            if (diceValueListWithoutDoubles.size() == 5) {
                if (diceValueListWithoutDoubles.get(1) + 1 == diceValueListWithoutDoubles.get(2) &&
                        diceValueListWithoutDoubles.get(2) + 1 == diceValueListWithoutDoubles.get(3) &&
                        diceValueListWithoutDoubles.get(3) + 1 == diceValueListWithoutDoubles.get(4)) {
                    points = SMALLSTREETPOINTS;
                }
            }
            possibleScores.put("smallStreet", points);
        }
    }

    /**
     * Calculate LargeStreet score.
     */
    private void calculateLargeStreet() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isLargeStreetFixed()) {
            if (diceValueList.get(0) + 1 == diceValueList.get(1) &&
                    diceValueList.get(1) + 1 == diceValueList.get(2) &&
                    diceValueList.get(2) + 1 == diceValueList.get(3) &&
                    diceValueList.get(3) + 1 == diceValueList.get(4)) {
                points = LARGESTREETPOINTS;
            }

            possibleScores.put("largeStreet", points);
        }
    }

    /**
     * Calculate Yahtzee score.
     */
    private void calculateYahtzee() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isYahtzeeFixed()) {
            if (matchDice(0, 1) && matchDice(1, 2) && matchDice(2, 3) && matchDice(3, 4)) {
                points = YAHTZEEPOINTS;
            }
            possibleScores.put("yahtzee", points);
        }
    }

    /**
     * Calculate YahtzeeBonus score.
     */
    private void calculateYahtzeeBonus() {
        points = 0;
        if (scores.get(activePlayer.getUsername()).isYahtzeeFixed() && scores.get(activePlayer.getUsername()).getYahtzee() != 0) {
            if (matchDice(0, 1) && matchDice(1, 2) && matchDice(2, 3) && matchDice(3, 4)) {
                points = YAHTZEEBONUS;
            }
            Score score = scores.get(activePlayer.getUsername());
            score.addyahtzee();
        }
    }

    /**
     * Calculate Chance score.
     */
    private void calculateChance() {
        points = 0;
        if (!scores.get(activePlayer.getUsername()).isChanceFixed()) {
            points = countAll();
            possibleScores.put("chance", points);
        }
    }

    /**
     * Method for counting all dice values.
     *
     * @return Integer value with dice values.
     */
    private int countAll() {
        for (Die die : diceList) {
            points += die.getValue();
        }
        return points;
    }

    /**
     * Method for matching two dice.
     *
     * @param aDieId Die 1
     * @param bDieId Die 2
     * @return boolean value if equal.
     */
    private boolean matchDice(int aDieId, int bDieId) {
        Die aDie = getDie(aDieId);
        Die bDie = getDie(bDieId);

        return aDie.getValue() == bDie.getValue();
    }

    /**
     * Method for removing doubles in a diceValueList.
     */
    private void removeDoubles() {
        diceValueListWithoutDoubles = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {
            if (diceValueList.get(i) != diceValueList.get(i + 1)) {
                diceValueListWithoutDoubles.add(diceValueList.get(i));
            }
        }

        diceValueListWithoutDoubles.add(diceValueList.get(4));
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

        System.out.println("Score geregistreerd : " + scorePoints + " voor " + scoreChoice);
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
     * Method for getting the score of the active player.
     *
     * @return Score object of active player.
     */
    public Score getScore() {
        return scores.get(activePlayer.getUsername());
    }

    /**
     * Method for getting all the scores of all users.
     *
     * @return Map with all scores of all users in the game.
     */
    public Map getScores() {
        return scores;
    }
}
