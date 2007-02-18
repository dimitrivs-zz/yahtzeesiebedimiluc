package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.game.Die;
import be.kdg.yahtzee.model.game.Game;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestGame {
    private Game game;
    private List<Die> diceList;

    @Before
    public void setUp() {
        game = new Game();
    }

    @After
    public void tearDown() {
        game = null;
    }

    @Test
    public void playNewRound() {
        game.playRound();

        //diceList = game.getDiceList();

        int aDiceValueBefore = diceList.get(2).getValue();

        game.fixDie(2);
        game.fixDie(4);

        game.unfixDie(4);

        game.playRound();

        int aDiceValueAfter = diceList.get(2).getValue();

        assertEquals("Aantal dobbelstenen moet <5> zijn", 5, diceList.size());
        assertTrue("Fixed dobbelsteen moet <True> teruggeven", diceList.get(2).isDieFixed());
        assertEquals("Fixed dobbelsteen moet zelfde waarde hebben als vorige beurt", aDiceValueBefore, aDiceValueAfter);
    }
}
