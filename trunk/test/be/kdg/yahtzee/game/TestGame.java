package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.game.Game;
import be.kdg.yahtzee.model.game.Die;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.List;

public class TestGame {
    private Game game;
    private List<Die> diceList;

    @Before
    public void setUp(){
        game = new Game();
    }

    @After
    public void tearDown(){
        game = null;
    }

    @Test
    public void playNewRound(){
        game.playRound();

        diceList = game.getDiceList();

        int aDiceValueBefore = diceList.get(2).getValue();

        game.fixDie(diceList.get(2));
        game.fixDie(diceList.get(4));

        game.unfixDie(diceList.get(4));   

        game.playRound();

        int aDiceValueAfter = diceList.get(2).getValue();

        assertEquals("Aantal dobbelstenen moet <5> zijn", 5, diceList.size());
        assertTrue("Fixed dobbelsteen moet <True> teruggeven", diceList.get(2).isDiceFixed());
        assertEquals("Fixed dobbelsteen moet zelfde waarde hebben als vorige beurt", aDiceValueBefore, aDiceValueAfter);
    }
}
