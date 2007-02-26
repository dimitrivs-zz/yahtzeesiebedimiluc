/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

import static be.kdg.util.ScorePoints.BONUS;
import static be.kdg.util.ScorePoints.YAHTZEEBONUS;

/**
 * Class representing a Score in the yahtzee game.
 */
public class Score {
    private ScoreAspect ones;
    private ScoreAspect twos;
    private ScoreAspect threes;
    private ScoreAspect fours;
    private ScoreAspect fives;
    private ScoreAspect sixes;
    private ScoreAspect threeOfAKind;
    private ScoreAspect carre;
    private ScoreAspect fullHouse;
    private ScoreAspect smallStreet;
    private ScoreAspect largeStreet;
    private ScoreAspect yahtzee;
    private ScoreAspect chance;

    private int upperHalfWithoutBonus;
    private int upperHalfBonus;
    private int totalUpperHalf;

    private int totalLowerHalf;
    private int yahtzeeBonus;
    private int totalScore;

    /**
     * Constructor for a Score object.
     * All aspects of a yahtzee score are added.
     */
    public Score() {
        ones = new ScoreAspect("ones");
        twos = new ScoreAspect("twos");
        threes = new ScoreAspect("threes");
        fours = new ScoreAspect("fours");
        fives = new ScoreAspect("fives");
        sixes = new ScoreAspect("sixes");

        threeOfAKind = new ScoreAspect("threeOfAKind");
        carre = new ScoreAspect("carre");
        fullHouse = new ScoreAspect("fullHouse");
        smallStreet = new ScoreAspect("smallStreet");
        largeStreet = new ScoreAspect("largeStreet");
        yahtzee = new ScoreAspect("yahtzee");
        chance = new ScoreAspect("chance");

        upperHalfWithoutBonus = 0;
        totalUpperHalf = 0;
        totalLowerHalf = 0;
        totalScore = 0;
    }

    /**
     * Method to set the points for Ones aspect.
     *
     * @param onesPoints Integer value representing the points for the Ones aspect.
     */
    public void setOnes(int onesPoints) {
        ones.setPoints(onesPoints);
        ones.setFixed(true);
    }

    /**
     * Method to get the points for the Ones aspect.
     *
     * @return Integer value representing the points for the Ones aspect.
     */
    public int getOnes() {
        return ones.getPoints();
    }

    /**
     * Method to see if the Ones are fixed or not.
     *
     * @return boolean value representing the fixing of the Ones.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isOnesFixed() {
        return ones.isFixed();
    }

    /**
     * Method to set the points for Twos aspect.
     *
     * @param twosPoints Integer value representing the points for the Twos aspect.
     */
    public void setTwos(int twosPoints) {
        twos.setPoints(twosPoints);
        twos.setFixed(true);
    }

    /**
     * Method to get the points for the Twos aspect.
     *
     * @return Integer value representing the points for the Twos aspect.
     */
    public int getTwos() {
        return twos.getPoints();
    }

    /**
     * Method to see if the Twos are fixed or not.
     *
     * @return boolean value representing the fixing of the Twos.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isTwosFixed() {
        return twos.isFixed();
    }

    /**
     * Method to set the points for Threes aspect.
     *
     * @param threesPoints Integer value representing the points for the Threes aspect.
     */
    public void setThrees(int threesPoints) {
        threes.setPoints(threesPoints);
        threes.setFixed(true);
    }

    /**
     * Method to get the points for the Threes aspect.
     *
     * @return Integer value representing the points for the Threes aspect.
     */
    public int getThrees() {
        return threes.getPoints();
    }

    /**
     * Method to see if the Threes are fixed or not.
     *
     * @return boolean value representing the fixing of the Threes.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isThreesFixed() {
        return threes.isFixed();
    }

    /**
     * Method to set the points for Fours aspect.
     *
     * @param foursPoints Integer value representing the points for the Fours aspect.
     */
    public void setFours(int foursPoints) {
        fours.setPoints(foursPoints);
        fours.setFixed(true);
    }

    /**
     * Method to get the points for the Fours aspect.
     *
     * @return Integer value representing the points for the Fours aspect.
     */
    public int getFours() {
        return fours.getPoints();
    }

    /**
     * Method to see if the Fours are fixed or not.
     *
     * @return boolean value representing the fixing of the Fours.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isFoursFixed() {
        return fours.isFixed();
    }

    /**
     * Method to set the points for Fives aspect.
     *
     * @param fivesPoints Integer value representing the points for the Fives aspect.
     */
    public void setFives(int fivesPoints) {
        fives.setPoints(fivesPoints);
        fives.setFixed(true);
    }

    /**
     * Method to get the points for the Fives aspect.
     *
     * @return Integer value representing the points for the Fives aspect.
     */
    public int getFives() {
        return fives.getPoints();
    }

    /**
     * Method to see if the Fives are fixed or not.
     *
     * @return boolean value representing the fixing of the Fives.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isFivesFixed() {
        return fives.isFixed();
    }

    /**
     * Method to set the points for Sixes aspect.
     *
     * @param sixesPoints Integer value representing the points for the Sixes aspect.
     */
    public void setSixes(int sixesPoints) {
        sixes.setPoints(sixesPoints);
        sixes.setFixed(true);
    }

    /**
     * Method to get the points for the Sixes aspect.
     *
     * @return Integer value representing the points for the Sixes aspect.
     */
    public int getSixes() {
        return sixes.getPoints();
    }

    /**
     * Method to see if the Sixes are fixed or not.
     *
     * @return boolean value representing the fixing of the Sixes.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isSixesFixed() {
        return sixes.isFixed();
    }

    /**
     * Method to set the points for ThreeOfAKind aspect.
     *
     * @param threeOfAKindPoints Integer value representing the points for the ThreeOfAKind aspect.
     */
    public void setThreeOfAKind(int threeOfAKindPoints) {
        threeOfAKind.setPoints(threeOfAKindPoints);
        threeOfAKind.setFixed(true);
    }

    /**
     * Method to get the points for the ThreeOfAKind aspect.
     *
     * @return Integer value representing the points for the ThreeOfAKind aspect.
     */
    public int getThreeOfAKind() {
        return threeOfAKind.getPoints();
    }

    /**
     * Method to see if the ThreeOfAKind are fixed or not.
     *
     * @return boolean value representing the fixing of the ThreeOfAKind.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isThreeOfAKindFixed() {
        return threeOfAKind.isFixed();
    }

    /**
     * Method to set the points for Carre aspect.
     *
     * @param carrePoints Integer value representing the points for the Carre aspect.
     */
    public void setCarre(int carrePoints) {
        carre.setPoints(carrePoints);
        carre.setFixed(true);
    }

    /**
     * Method to get the points for the Carre aspect.
     *
     * @return Integer value representing the points for the Carre aspect.
     */
    public int getCarre() {
        return carre.getPoints();
    }

    /**
     * Method to see if the Carre are fixed or not.
     *
     * @return boolean value representing the fixing of the Carre.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isCarreFixed() {
        return carre.isFixed();
    }

    /**
     * Method to set the points for FullHouse aspect.
     *
     * @param fullHousePoints Integer value representing the points for the FullHouse aspect.
     */
    public void setFullHouse(int fullHousePoints) {
        fullHouse.setPoints(fullHousePoints);
        fullHouse.setFixed(true);
    }

    /**
     * Method to get the points for the FullHouse aspect.
     *
     * @return Integer value representing the points for the FullHouse aspect.
     */
    public int getFullHouse() {
        return fullHouse.getPoints();
    }

    /**
     * Method to see if the FullHouse are fixed or not.
     *
     * @return boolean value representing the fixing of the FullHouse.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isFullHouseFixed() {
        return fullHouse.isFixed();
    }

    /**
     * Method to set the points for SmallStreet aspect.
     *
     * @param smallStreetPoints Integer value representing the points for the SmallStreet aspect.
     */
    public void setSmallStreet(int smallStreetPoints) {
        smallStreet.setPoints(smallStreetPoints);
        smallStreet.setFixed(true);
    }

    /**
     * Method to get the points for the SmallStreet aspect.
     *
     * @return Integer value representing the points for the SmallStreet aspect.
     */
    public int getSmallStreet() {
        return smallStreet.getPoints();
    }

    /**
     * Method to see if the SmallStreet are fixed or not.
     *
     * @return boolean value representing the fixing of the SmallStreet.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isSmallStreetFixed() {
        return smallStreet.isFixed();
    }

    /**
     * Method to set the points for LargeStreet aspect.
     *
     * @param largeStreetPoints Integer value representing the points for the LargeStreet aspect.
     */
    public void setLargeStreet(int largeStreetPoints) {
        largeStreet.setPoints(largeStreetPoints);
        largeStreet.setFixed(true);
    }

    /**
     * Method to get the points for the LargeStreet aspect.
     *
     * @return Integer value representing the points for the LargeStreet aspect.
     */
    public int getLargeStreet() {
        return largeStreet.getPoints();
    }

    /**
     * Method to see if the LargeStreet are fixed or not.
     *
     * @return boolean value representing the fixing of the LargeStreet.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isLargeStreetFixed() {
        return largeStreet.isFixed();
    }

    /**
     * Method to set the points for Yahtzee aspect.
     *
     * @param yahtzeePoints Integer value representing the points for the Yahtzee aspect.
     */
    public void setYahtzee(int yahtzeePoints) {
        yahtzee.setPoints(yahtzeePoints);
        yahtzee.setFixed(true);
    }

    /**
     * Method to get the points for the Yahtzee aspect.
     *
     * @return Integer value representing the points for the Yahtzee aspect.
     */
    public int getYahtzee() {
        return yahtzee.getPoints();
    }

    /**
     * Method to see if the Yahtzee are fixed or not.
     *
     * @return boolean value representing the fixing of the Yahtzee.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isYahtzeeFixed() {
        return yahtzee.isFixed();
    }

    /**
     * Method to set the points for Chance aspect.
     *
     * @param chancePoints Integer value representing the points for the Chance aspect.
     */
    public void setChance(int chancePoints) {
        chance.setPoints(chancePoints);
        chance.setFixed(true);
    }

    /**
     * Method to get the points for the Chance aspect.
     *
     * @return Integer value representing the points for the Chance aspect.
     */
    public int getChance() {
        return chance.getPoints();
    }

    /**
     * Method to see if the Chance are fixed or not.
     *
     * @return boolean value representing the fixing of the Chance.
     *         true if fixed
     *         false if not fixed
     */
    public boolean isChanceFixed() {
        return chance.isFixed();
    }

    /**
     * Method for getting the yahtzeebonus.
     *
     * @return Integer value representing the yahtzee bonus points.
     */
    public int getYahtzeeBonus() {
        return yahtzeeBonus;
    }

    /**
     * Method for adding a yahtzeebonus.
     */
    public void addyahtzee() {
        yahtzeeBonus += YAHTZEEBONUS;
    }

    /**
     * Method for getting the upperhalf total score without the bonus.
     *
     * @return Integer value representing the upperhalf total score without the bonus.
     */
    public int getUpperHalfWithoutBonus() {
        return upperHalfWithoutBonus = ones.getPoints() + twos.getPoints() + threes.getPoints() + fours.getPoints() + fives.getPoints() + sixes.getPoints();
    }

    /**
     * Method for getting the upperhalf bonus score.
     *
     * @return Integer value representing the upperhalf bonus score.
     */
    public int getUpperHalfBonus() {
        if (upperHalfWithoutBonus > 62) {
            upperHalfBonus = BONUS;
        } else {
            upperHalfBonus = 0;
        }
        return upperHalfBonus;
    }

    /**
     * Method for getting the upperhalf total score with the bonus.
     *
     * @return Integer value representing the upperhalf total score with the bonus.
     */
    public int getTotalUpperHalf() {
        getUpperHalfWithoutBonus();
        getUpperHalfBonus();

        totalUpperHalf = upperHalfWithoutBonus + upperHalfBonus;

        return totalUpperHalf;
    }

    /**
     * Method for getting the lowerhalf total score.
     *
     * @return Integer value representing the lowerhalf total score.
     */
    public int getTotalLowerHalf() {
        totalLowerHalf = threeOfAKind.getPoints() + carre.getPoints() + fullHouse.getPoints() + smallStreet.getPoints() + largeStreet.getPoints()
                + yahtzee.getPoints() + chance.getPoints() + yahtzeeBonus;

        return totalLowerHalf;
    }

    /**
     * Method for getting the total score (uppper + lower half).
     *
     * @return Integer value representing the total score.
     */
    public int getTotalScore() {
        totalScore = getTotalLowerHalf() + getTotalUpperHalf();

        return totalScore;
    }
}
