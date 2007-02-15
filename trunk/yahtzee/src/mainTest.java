import be.kdg.yahtzee.model.game.*;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.Address;


import java.util.List;
import java.util.ArrayList;


public class mainTest {
    private Game game;
    private List<Die> diceList;
    private List<ScoreAspect> scorePossibilities = new ArrayList<ScoreAspect>();
    private GameManager gameManager;


    public mainTest() {
        Role role = new Role("testRole");
        Address address = new Address("straatje", "666", "1234", "teststad", "testland");
        User player1 = new User("player1", "pw1", "Test", "User1", "test@test.com", "1234567890", role, address);
        User player2 = new User("player2", "pw2", "Test", "User2", "test@test.com", "1234567890", role, address);
        User player3 = new User("player3", "pw3", "Test", "User3", "test@test.com", "1234567890", role, address);
        User player4 = new User("player4", "pw4", "Test", "User4", "test@test.com", "1234567890", role, address);

        gameManager = new GameManager();
        gameManager.createGame("testgamenaam", 3, player1);
        //game = new Game("testgamenaam", 3, player1);

        System.out.println("Game " + "testgamenaam" + " started by: " + player1.getUsername());
        gameManager.joinGame("testgamenaam", player2);
        System.out.println("player " + player2.getUsername() + " joined");
        gameManager.joinGame("testgamenaam", player3);
        System.out.println("player " + player3.getUsername() + " joined");
        gameManager.joinGame("testgamenaam", player4);
        System.out.println("player " + player4.getUsername() + " joined");

        diceList = gameManager.playRound("testgamenaam");

        gameManager.fixDie("testgamenaam", diceList.get(0).getDieId());
        gameManager.fixDie("testgamenaam", diceList.get(1).getDieId());
        gameManager.fixDie("testgamenaam", diceList.get(2).getDieId());

        diceList = gameManager.playRound("testgamenaam");

        scorePossibilities = gameManager.getScorePossibilities("testgamenaam");
        for (ScoreAspect sa : scorePossibilities) {
            System.out.println(sa.getDescription() + " / " + sa.getPoints());
        }
        System.out.println(gameManager.getActivePlayer("testgamenaam").getUsername());

        Score score = gameManager.selectScore("testgamenaam", "sixes");

        displayScore(score);

        diceList = gameManager.playRound("testgamenaam");
        System.out.println(gameManager.getActivePlayer("testgamenaam").getUsername());
    }

    private void displayScore(Score score) {
        System.out.println(gameManager.getActivePlayer("testgamenaam").getUsername());
        System.out.println(score.getOnes());
        System.out.println(score.getTwos());
        System.out.println(score.getThrees());
        System.out.println(score.getFours());
        System.out.println(score.getFives());
        System.out.println(score.getSixes() + "\n---");
        System.out.println(score.getTotalUpperHalf() + "\n");
        System.out.println(score.getThreeOfAKind());
        System.out.println(score.getCarre());
        System.out.println(score.getFullHouse());
        System.out.println(score.getSmallStreet());
        System.out.println(score.getLargeStreet());
        System.out.println(score.getYahtzee());
        System.out.println(score.getYahtzeeBonus());
        System.out.println(score.getChance() + "\n---");
        System.out.println(score.getTotalLowerHalf() + "\n\n---");
        System.out.println(score.getTotalScore());
    }
}
