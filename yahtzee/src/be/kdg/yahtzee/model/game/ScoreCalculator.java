package be.kdg.yahtzee.model.game;

import static be.kdg.util.ScorePoints.*;
import be.kdg.yahtzee.model.users.User;

import java.util.*;

public class ScoreCalculator {
    private int points;

    private List<Die> diceList;
    private Map<String, Score> scores;
    private User activePlayer;

    private List<Integer> diceValueList;
    private List<Integer> diceValueListWithoutDoubles;
    private Map<String, Integer> possibleScores;


    public ScoreCalculator() {
        diceValueList = new ArrayList<Integer>();
        diceValueListWithoutDoubles = new ArrayList<Integer>();
        possibleScores = new HashMap<String, Integer>();
    }

    /**
     * Calculate the yahtzee scores.
     */
    public Map<String, Integer> calculateScores(List<Die> diceList, Map<String, Score> scores, User activePlayer) {
        this.diceList = diceList;
        this.scores = scores;
        this.activePlayer = activePlayer;

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

        return possibleScores;
    }

    /**
     * Method for filling a List with dice values.
     */
    private void fillDiceValues() {
        diceValueList.clear();
        for (Die die : diceList) {
            diceValueList.add(die.getValue());
        }
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
                Score score = scores.get(activePlayer.getUsername());
                score.addyahtzee();
            }
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

    public void clearDiceValueList() {
        diceValueList.clear();
    }
}
