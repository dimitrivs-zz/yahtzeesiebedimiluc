package be.kdg.yahtzee.model.game;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 3-feb-2007
 * Time: 17:46:16
 * To change this template use File | Settings | File Templates.
 */
public enum EnumState {
    LEEG(0), WACHTEN(1), IDLE(2), VOL(3);

    private final int waarde;

    EnumState(int waarde) {
        this.waarde = waarde;
    }

    public int getWaarde() {
        return waarde;
    }
}
