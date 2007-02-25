package be.kdg.yahtzee.model.game;

import static be.kdg.util.ScorePoints.*;
import be.kdg.yahtzee.model.chat.Chat;
import be.kdg.yahtzee.model.users.User;

import java.util.*;

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
    //private Score score;

    private User activePlayer;
    private Map<String, Score> scores;
    private List<User> userList;


    private Map<String, Integer> possibleScores;
    private int numberOfRolls;

    //Nodig voor testGame - tijdelijk
    public Game() {
        this.state = EnumState.LEEG;
        diceGen = new DiceGenerator();
        possibleScores = new HashMap<String, Integer>();
        numberOfRolls = 0;
        //score = new Score();
    }

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
        //score = new Score();
    }

    public User getCreator() {
        return creator;
    }

    public String getGameName() {
        return gameName;
    }

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

    public void setState(EnumState state) {
        this.state = state;
    }

    public List<Die> getDiceList() {
        return diceList;
    }

    public Chat getChat() {
        return chat;
    }

    public Set<User> getUsers() {
        return users;
    }

    public User getActivePlayer() {
        return activePlayer;
    }

    public void startGame() {
        setState(EnumState.BEZIG);
    }

    public void joinGame(User user) {
        users.add(user);


        userList.add(user);
        scores.put(user.getUsername(), new Score());


    }

    public void leaveGame(User user) {
        users.remove(user);
        userList.remove(user);
        scores.remove(user.getUsername());
    }

    public int getNumberOfPlayers() {
        return users.size();
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }
    /*
    public List<Die> getDiceList() {
        return diceList;
    }*/

    public int getNumberOfRolls() {
        return numberOfRolls;
    }

    private void resetRound() {
        numberOfRolls = 0;
        diceList.clear();
        diceValueList.clear();
        possibleScores.clear();
        diceGen.resetDiceGenerator();
    }

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

    private void fillDiceValues() {
        diceValueList = new ArrayList<Integer>();

        for (Die die : diceList) {
            diceValueList.add(die.getValue());
        }
    }

    public boolean fixDie(int dieId) {
        Die die = getDie(dieId);

        return diceGen.fixDie(die);
    }

    public boolean unfixDie(int dieId) {
        Die die = getDie(dieId);

        return diceGen.unfixDie(die);
    }

    public Die getDie(int dieId) {
        for (Die die : diceList) {
            if (die.getDieId() == dieId) {
                return die;
            }
        }
        return null;
    }

    /*public Map<String, Integer> getScorePossibilities() {
        return possibleScores;
    }*/

    public List<ScoreAspect> getScorePossibilities() {
        List<ScoreAspect> scorePossibilities = new ArrayList<ScoreAspect>();
        for (String s : possibleScores.keySet()) {
            scorePossibilities.add(new ScoreAspect(s, possibleScores.get(s)));
        }
        return scorePossibilities;
    }


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

    private void calculateOnes() {
        points = 0;
        //if (!score.isOnesFixed()) {
        if (!scores.get(activePlayer.getUsername()).isOnesFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 1) {
                    points += 1;
                }
            }
            possibleScores.put("ones", points);
        }
    }

    private void calculateTwos() {
        points = 0;
        //if (!score.isTwosFixed()) {
        if (!scores.get(activePlayer.getUsername()).isTwosFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 2) {
                    points += 2;
                }
            }
            possibleScores.put("twos", points);
        }
    }

    private void calculateThrees() {
        points = 0;
        //if (!score.isThreesFixed()) {
        if (!scores.get(activePlayer.getUsername()).isThreesFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 3) {
                    points += 3;
                }
            }
            possibleScores.put("threes", points);
        }
    }


    private void calculateFours() {
        points = 0;
        //if (!score.isFoursFixed()) {
        if (!scores.get(activePlayer.getUsername()).isFoursFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 4) {
                    points += 4;
                }
            }
            possibleScores.put("fours", points);
        }
    }

    private void calculateFives() {
        points = 0;
        //if (!score.isFivesFixed()) {
        if (!scores.get(activePlayer.getUsername()).isFivesFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 5) {
                    points += 5;
                }
            }
            possibleScores.put("fives", points);
        }
    }

    private void calculateSixes() {
        points = 0;
        //if (!score.isSixesFixed()) {
        if (!scores.get(activePlayer.getUsername()).isSixesFixed()) {
            for (Die die : diceList) {
                if (die.getValue() == 6) {
                    points += 6;
                }
            }
            possibleScores.put("sixes", points);
        }
    }

    private void calculateThreeOfAKind() {
        points = 0;
        //if (!score.isThreeOfAKindFixed()) {
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

    private void calculateCarre() {
        points = 0;
        //if (!score.isCarreFixed()) {
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

    private void calculateFullHouse() {
        points = 0;
        //if (!score.isFullHouseFixed()) {
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

    private void calculateSmallStreet() {
        points = 0;
        removeDoubles();

        //if (!score.isSmallStreetFixed()) {
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

    private void calculateLargeStreet() {
        points = 0;
        //if (!score.isLargeStreetFixed()) {
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

    private void calculateYahtzee() {
        points = 0;
        //if (!score.isYahtzeeFixed()) {
        if (!scores.get(activePlayer.getUsername()).isYahtzeeFixed()) {
            if (matchDice(0, 1) && matchDice(1, 2) && matchDice(2, 3) && matchDice(3, 4)) {
                points = YAHTZEEPOINTS;
            }
            possibleScores.put("yahtzee", points);
        }
    }

    private void calculateYahtzeeBonus() {
        points = 0;
        //if (score.isYahtzeeFixed()) {
        if (scores.get(activePlayer.getUsername()).isYahtzeeFixed() && scores.get(activePlayer.getUsername()).getYahtzee() != 0) {
            if (matchDice(0, 1) && matchDice(1, 2) && matchDice(2, 3) && matchDice(3, 4)) {
                Score score = scores.get(activePlayer.getUsername());
                score.addyahtzee();
            }
        }
    }

    private void calculateChance() {
        points = 0;
        //if (!score.isChanceFixed()) {
        if (!scores.get(activePlayer.getUsername()).isChanceFixed()) {
            points = countAll();
            possibleScores.put("chance", points);
        }
    }

    private int countAll() {
        for (Die die : diceList) {
            points += die.getValue();
        }
        return points;
    }

    private boolean matchDice(int aDieId, int bDieId) {
        Die aDie = getDie(aDieId);
        Die bDie = getDie(bDieId);

        return aDie.getValue() == bDie.getValue();
    }

    private void removeDoubles() {
        diceValueListWithoutDoubles = new ArrayList<Integer>();

        for (int i = 0; i < 4; i++) {
            if (diceValueList.get(i) != diceValueList.get(i + 1)) {
                diceValueListWithoutDoubles.add(diceValueList.get(i));
            }
        }

        diceValueListWithoutDoubles.add(diceValueList.get(4));
    }

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

    public Score getScore() {
        return scores.get(activePlayer.getUsername());
        //return score;
    }

    public Map getScores() {
        return scores;
    }
}
