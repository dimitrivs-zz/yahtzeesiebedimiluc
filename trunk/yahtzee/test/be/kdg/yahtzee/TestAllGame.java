package be.kdg.yahtzee;

public class TestAllGame {
    public static void main(String args[]) {
        org.junit.runner.JUnitCore.main(
                "be.kdg.yahtzee.game.TestChat",
                "be.kdg.yahtzee.game.TestGameRoom",
                "be.kdg.yahtzee.game.TestLeaveGame",
                "be.kdg.yahtzee.game.TestRemoveGame",
                "be.kdg.yahtzee.game.TestNewGame",
                "be.kdg.yahtzee.game.TestChat",
                "be.kdg.yahtzee.game.TestUserInGame");
    }
}
