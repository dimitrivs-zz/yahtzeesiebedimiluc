/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a generator for creating 5 dice for the yahtzee application.
 */
public class DiceGenerator {
    private List<Die> diceList;

    /**
     * Constructor for the dice generator.
     * Creates a new List for storing the dice and fills the list with 5 new dice.
     */
    public DiceGenerator() {
        diceList = new ArrayList<Die>();

        fillDiceList();
    }

    /**
     * Method for getting the list of dice.
     *
     * @return List containing the generated dice.
     */
    public List<Die> getDice() {
        return diceList;
    }

    /**
     * Method for rolling the dice.
     */
    public void rollDice() {
        for (Die die : diceList) {
            die.roll();
        }
    }

    /**
     * Method for fixing a die, so it will not change when the dices are rolled.
     *
     * @param dieToFix Die object to fix
     * @return boolean value
     *         true if fixing has succeeded
     */
    public boolean fixDie(Die dieToFix) {
        int dieIndex = diceList.indexOf(dieToFix);
        Die die = diceList.get(dieIndex);
        die.setDiceFixed(true);
        System.out.println("DIE FIXED with value " + die.getValue());
        return true;
    }

    /**
     * Method for unfixing a die, so it can change when the dices are rolled.
     *
     * @param dieToUnfix Die object to unfix
     * @return boolean value
     *         true if unfixing has succeeded
     */
    public boolean unfixDie(Die dieToUnfix) {
        int dieIndex = diceList.indexOf(dieToUnfix);
        Die die = diceList.get(dieIndex);
        die.setDiceFixed(false);
        System.out.println("DIE UNFIXED with value " + die.getValue());
        return true;
    }

    /**
     * Method for resetting the dicegenerator.
     * The list is cleared and filled with new dices.
     *
     * @return boolean value
     *         true if reset has succeeded
     */
    public boolean resetDiceGenerator() {
        diceList.clear();
        fillDiceList();
        return true;
    }

    /**
     * Method for filling the dicelist with 5 new dices.
     */
    private void fillDiceList() {
        for (int i = 0; i < 5; i++) {
            diceList.add(new Die(i));
        }
    }
}
