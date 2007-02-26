/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

/**
 * Class representing a Die in the yahtzee game.
 */
public class Die {
    private int dieId;
    private int value;
    private boolean dieFixed;

    /**
     * Constructor for a Die object.
     *
     * @param dieId Integer id of the die.
     */
    public Die(int dieId) {
        this.dieId = dieId;
        dieFixed = false;
    }

    /**
     * Method for getting the id of the Die.
     *
     * @return Integer id of the Die.
     */
    public int getDieId() {
        return dieId;
    }

    /**
     * Method for getting the value of the Die.
     *
     * @return integer value of the Die.
     */
    public int getValue() {
        return value;
    }

    /**
     * Method for fixing the Die.
     *
     * @param dieFixed boolean value.
     *                 true to fix die.
     *                 false to unfix die.
     */
    public void setDiceFixed(boolean dieFixed) {
        this.dieFixed = dieFixed;
    }

    /**
     * Method for generating a random dice value.
     */
    public void roll() {
        if (!dieFixed) {
            value = (int) (Math.random() * 6) + 1;
        }
    }

    /**
     * Method to check if the die is fixed or not.
     *
     * @return boolean value.
     *         true if die is fixed.
     *         false if die is not fixed.
     */
    public boolean isDieFixed() {
        return dieFixed;
    }
}
