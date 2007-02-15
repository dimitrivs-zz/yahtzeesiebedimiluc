package be.kdg.yahtzee;

public class TestAll {
    public static void main(String args[]) {
      org.junit.runner.JUnitCore.main(
              "be.kdg.yahtzee.game.TestScore",
              "be.kdg.yahtzee.game.TestGame",
              "be.kdg.yahtzee.game.TestNewGame",
              "be.kdg.yahtzee.game.TestGameRoom");
    }
}

