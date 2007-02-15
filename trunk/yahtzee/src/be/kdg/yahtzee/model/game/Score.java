package be.kdg.yahtzee.model.game;

import static be.kdg.util.ScorePoints.BONUS;
import static be.kdg.util.ScorePoints.YAHTZEEBONUS;

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

    public void setOnes(int onesPoints) {
        ones.setPoints(onesPoints);
        ones.setFixed(true);
    }

    public int getOnes() {
        return ones.getPoints();
    }

    public boolean isOnesFixed() {
        return ones.isFixed();
    }

    public void setTwos(int twosPoints) {
        twos.setPoints(twosPoints);
        twos.setFixed(true);
    }

    public int getTwos() {
        return twos.getPoints();
    }

    public boolean isTwosFixed() {
        return twos.isFixed();
    }

    public void setThrees(int threesPoints) {
        threes.setPoints(threesPoints);
        threes.setFixed(true);
    }

    public int getThrees() {
        return threes.getPoints();
    }

    public boolean isThreesFixed() {
        return threes.isFixed();
    }

    public void setFours(int foursPoints) {
        fours.setPoints(foursPoints);
        fours.setFixed(true);
    }

    public int getFours() {
        return fours.getPoints();
    }

    public boolean isFoursFixed() {
        return fours.isFixed();
    }

    public void setFives(int fivesPoints) {
        fives.setPoints(fivesPoints);
        fives.setFixed(true);
    }

    public int getFives() {
        return fives.getPoints();
    }

    public boolean isFivesFixed() {
        return fives.isFixed();
    }

    public void setSixes(int sixesPoints) {
        sixes.setPoints(sixesPoints);
        sixes.setFixed(true);
    }

    public int getSixes() {
        return sixes.getPoints();
    }

    public boolean isSixesFixed() {
        return sixes.isFixed();
    }

    public void setThreeOfAKind(int threeOfAKindPoints) {
        threeOfAKind.setPoints(threeOfAKindPoints);
        threeOfAKind.setFixed(true);
    }

    public int getThreeOfAKind() {
        return threeOfAKind.getPoints();
    }

    public boolean isThreeOfAKindFixed() {
        return threeOfAKind.isFixed();
    }

    public void setCarre(int carrePoints) {
        carre.setPoints(carrePoints);
        carre.setFixed(true);
    }

    public int getCarre() {
        return carre.getPoints();
    }

    public boolean isCarreFixed() {
        return carre.isFixed();
    }

    public void setFullHouse(int fullHousePoints) {
        fullHouse.setPoints(fullHousePoints);
        fullHouse.setFixed(true);
    }

    public int getFullHouse() {
        return fullHouse.getPoints();
    }

    public boolean isFullHouseFixed() {
        return fullHouse.isFixed();
    }

    public void setSmallStreet(int smallStreetPoints) {
        smallStreet.setPoints(smallStreetPoints);
        smallStreet.setFixed(true);
    }

    public int getSmallStreet() {
        return smallStreet.getPoints();
    }

    public boolean isSmallStreetFixed() {
        return smallStreet.isFixed();
    }

    public void setLargeStreet(int largeStreetPoints) {
        largeStreet.setPoints(largeStreetPoints);
        largeStreet.setFixed(true);
    }

    public int getLargeStreet() {
        return largeStreet.getPoints();
    }

    public boolean isLargeStreetFixed() {
        return largeStreet.isFixed();
    }

    public void setYahtzee(int yahtzeePoints) {
        yahtzee.setPoints(yahtzeePoints);
        yahtzee.setFixed(true);
    }

    public int getYahtzee() {
        return yahtzee.getPoints();
    }

    public boolean isYahtzeeFixed() {
        return yahtzee.isFixed();
    }

    public void setChance(int chancePoints) {
        chance.setPoints(chancePoints);
        chance.setFixed(true);
    }

    public int getChance() {
        return chance.getPoints();
    }

    public boolean isChanceFixed() {
        return chance.isFixed();
    }

    public int getYahtzeeBonus() {
        return yahtzeeBonus;
    }

    public void addyahtzee() {
        yahtzeeBonus += YAHTZEEBONUS;
    }

    public int getUpperHalf() {
        return upperHalfWithoutBonus = ones.getPoints() + twos.getPoints() + threes.getPoints() + fours.getPoints() + fives.getPoints() + sixes.getPoints();
    }

    public int getTotalUpperHalf() {
        getUpperHalf();

        if (upperHalfWithoutBonus > 62) {
            upperHalfBonus = BONUS;
        } else {
            upperHalfBonus = 0;
        }

        totalUpperHalf = upperHalfWithoutBonus + upperHalfBonus;

        return totalUpperHalf;
    }

    public int getTotalLowerHalf() {
        totalLowerHalf = threeOfAKind.getPoints() + carre.getPoints() + fullHouse.getPoints() + smallStreet.getPoints() + largeStreet.getPoints()
                + yahtzee.getPoints() + chance.getPoints() + yahtzeeBonus;

        return totalLowerHalf;
    }

    public int getTotalScore() {
        totalScore = getTotalLowerHalf() + getTotalUpperHalf();

        return totalScore;
    }


}
