/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.game;

public class Die {
    private int dieId;
    private int value;
    private boolean dieFixed;

    public Die(int dieId) {
        this.dieId = dieId;
        dieFixed = false;
    }


    public void roll() {
        if (!dieFixed) {
            value = (int) (Math.random() * 6) + 1;
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isDieFixed() {
        return dieFixed;
    }

    public int getDieId() {
        return dieId;
    }

    public void setDiceFixed(boolean dieFixed) {
        this.dieFixed = dieFixed;
    }
}
