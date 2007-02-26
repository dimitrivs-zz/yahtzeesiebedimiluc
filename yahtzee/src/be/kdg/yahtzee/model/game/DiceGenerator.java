/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

import java.util.ArrayList;
import java.util.List;

public class DiceGenerator {
    private List<Die> diceList;

    public DiceGenerator() {
        diceList = new ArrayList<Die>();

        fillDiceList();
    }

    public void rollDice() {
        for (Die die : diceList) {
            die.roll();
        }
    }

    public boolean fixDie(Die dieToFix) {
        int dieIndex = diceList.indexOf(dieToFix);
        Die die = diceList.get(dieIndex);
        die.setDiceFixed(true);
        System.out.println("DIE FIXED with value " + die.getValue());
        return true;
    }

    public boolean unfixDie(Die dieToUnfix) {
        int dieIndex = diceList.indexOf(dieToUnfix);
        Die die = diceList.get(dieIndex);
        die.setDiceFixed(false);
        System.out.println("DIE UNFIXED with value " + die.getValue());
        return true;
    }

    public List<Die> getDice() {
        return diceList;
    }

    public boolean resetDiceGenerator() {
        diceList.clear();
        fillDiceList();
        return true;
    }

    private void fillDiceList() {
        for (int i = 0; i < 5; i++) {
            diceList.add(new Die(i));
        }
    }
}
