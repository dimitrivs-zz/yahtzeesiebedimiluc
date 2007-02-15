package be.kdg.yahtzee.model.game;

public enum EnumState {
    LEEG(0), WACHTEN(1), IDLE(2), VOL(3);

    private final int waarde;

    EnumState(int waarde) {
        this.waarde = waarde;
    }
}
