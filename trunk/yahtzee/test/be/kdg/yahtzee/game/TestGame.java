package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.game.Die;
import be.kdg.yahtzee.model.game.Game;
import be.kdg.yahtzee.model.game.GameManager;
import be.kdg.yahtzee.model.game.ScoreAspect;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.User;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGame {
    private GameManager gameManager;
    private User testUser;
    private Game game;
    private List<Die> diceList;
    private List<ScoreAspect> possibleScores;
    private Die aDie;
    private Die bDie;
    private Die cDie;
    private Die dDie;
    private Die eDie;

    @Before
    public void setUp() {
        gameManager = new GameManager();

        Role role = new Role("Player");
        Address address = new Address("null", "null", "null", "null", "null");
        testUser = new User("TestUser", "TestUser", "TestUser", "TestUser", "TestUser", "TestUser", role, address);

        gameManager.createGame("TestGame", 1, testUser);

        aDie = new Die(0);
        bDie = new Die(1);
        cDie = new Die(2);
        dDie = new Die(3);
        eDie = new Die(4);

        diceList = new ArrayList<Die>();
        possibleScores = new ArrayList<ScoreAspect>();

        diceList.add(aDie);
        diceList.add(bDie);
        diceList.add(cDie);
        diceList.add(dDie);
        diceList.add(eDie);
    }

    @After
    public void tearDown() {
        gameManager = null;

        testUser = null;
        game = null;

        aDie = null;
        bDie = null;
        cDie = null;
        dDie = null;
        eDie = null;

        diceList = null;
        possibleScores = null;
    }

    public void fillDiceList(int a, int b, int c, int d, int e) {
        aDie.setValue(a);
        bDie.setValue(b);
        cDie.setValue(c);
        dDie.setValue(d);
        eDie.setValue(e);
    }

    @Test
    public void testCalculateOnes() {
        ScoreAspect ones = new ScoreAspect("null", 0);

        fillDiceList(1, 2, 5, 1, 1);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("ones")) {
                ones = score;
            }
        }

        assertEquals("De waarde van de enen moet <3> zijn", 3, ones.getPoints());
    }

    @Test
    public void testCalculateTwos() {
        ScoreAspect twos = new ScoreAspect("null", 0);

        fillDiceList(1, 2, 6, 1, 2);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("twos")) {
                twos = score;
            }
        }

        assertEquals("De waarde van de tweeën moet <4> zijn", 4, twos.getPoints());
    }

    @Test
    public void testCalculateThrees() {
        ScoreAspect threes = new ScoreAspect("null", 0);

        fillDiceList(3, 4, 3, 3, 3);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("threes")) {
                threes = score;
            }
        }

        assertEquals("De waarde van de drieën moet <12> zijn", 12, threes.getPoints());
    }

    @Test
    public void testCalculateFours() {
        ScoreAspect fours = new ScoreAspect("null", 0);

        fillDiceList(1, 4, 4, 1, 4);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("fours")) {
                fours = score;
            }
        }

        assertEquals("De waarde van de vieren moet <12> zijn", 12, fours.getPoints());
    }

    @Test
    public void testCalculateFives() {
        ScoreAspect fives = new ScoreAspect("null", 0);

        fillDiceList(5, 2, 5, 5, 5);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("fives")) {
                fives = score;
            }
        }

        assertEquals("De waarde van de vijven moet <20> zijn", 20, fives.getPoints());
    }


    @Test
    public void testCalculateSixes() {
        ScoreAspect sixes = new ScoreAspect("null", 0);

        fillDiceList(1, 2, 6, 1, 1);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("sixes")) {
                sixes = score;
            }
        }

        assertEquals("De waarde van de zessen moet <6> zijn", 6, sixes.getPoints());
    }


    @Test
    public void testCalculateThreeOfAKind() {
        ScoreAspect threeOfAKind = new ScoreAspect("null", 0);

        fillDiceList(1, 2, 5, 2, 2);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("threeOfAKind")) {
                threeOfAKind = score;
            }
        }

        assertEquals("De waarde van de Three of A Kind moet <12> zijn", 12, threeOfAKind.getPoints());
    }


    @Test
    public void testCalculateCarre() {
        ScoreAspect carre = new ScoreAspect("null", 0);

        fillDiceList(1, 1, 3, 1, 1);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("carre")) {
                carre = score;
            }
        }

        assertEquals("De waarde van de carre moet <7> zijn", 7, carre.getPoints());
    }


    @Test
    public void testCalculateFullHouse() {
        ScoreAspect fullHouse = new ScoreAspect("null", 0);

        fillDiceList(6, 6, 5, 5, 6);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("fullHouse")) {
                fullHouse = score;
            }
        }

        assertEquals("De waarde van de Full House moet <25> zijn", 25, fullHouse.getPoints());
    }

    @Test
    public void testCalculateSmallStreet() {
        ScoreAspect smallStreet = new ScoreAspect("null", 0);

        fillDiceList(6, 4, 5, 1, 3);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("smallStreet")) {
                smallStreet = score;
            }
        }

        assertEquals("De waarde van de Kleine Straat moet <30> zijn", 30, smallStreet.getPoints());
    }

    @Test
    public void testCalculateLargeStreet() {
        ScoreAspect largeStreet = new ScoreAspect("null", 0);

        fillDiceList(6, 4, 2, 1, 3);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("largeStreet")) {
                largeStreet = score;
            }
        }

        assertEquals("De waarde van de Grote Straat moet <0> zijn", 0, largeStreet.getPoints());
    }

    @Test
    public void testCalculateYahtzee() {
        ScoreAspect yahtzee = new ScoreAspect("null", 0);

        fillDiceList(2, 2, 2, 2, 2);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("yahtzee")) {
                yahtzee = score;
            }
        }

        assertEquals("De waarde van de Yahtzee moet <50> zijn", 50, yahtzee.getPoints());
    }

    @Test
    public void testCalculateChance() {
        ScoreAspect chance = new ScoreAspect("null", 0);

        fillDiceList(1, 2, 6, 2, 3);
        game.setDiceList(diceList);
        game.calculateScores();

        possibleScores = gameManager.getScorePossibilities(game.getGameName());

        for (ScoreAspect score : possibleScores) {
            if (score.getDescription().equals("chance")) {
                chance = score;
            }
        }

        assertEquals("De waarde van de Chance moet <14> zijn", 14, chance.getPoints());
    }

    @Test
    public void playNewRound() {
        game.playRound();

        diceList = game.getDiceList();

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
