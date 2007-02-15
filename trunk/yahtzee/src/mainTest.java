import be.kdg.yahtzee.model.game.Game;
import be.kdg.yahtzee.model.game.Die;
import be.kdg.yahtzee.model.game.ScoreAspect;
import be.kdg.yahtzee.model.game.Score;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.Address;


import java.util.List;


public class mainTest {
    private Game game;
    private List<Die> diceList;
    private List<ScoreAspect> scorePossibilities;


    public mainTest() {
        Role role = new Role("testRole");
        Address address = new Address("straatje", "666", "1234", "teststad", "testland");
        User player1 = new User("player1", "pw1", "Test", "User1", "test@test.com", "1234567890", role, address);
        User player2 = new User("player2", "pw2", "Test", "User2", "test@test.com", "1234567890", role, address);
        User player3 = new User("player3", "pw3", "Test", "User3", "test@test.com", "1234567890", role, address);
        User player4 = new User("player4", "pw4", "Test", "User4", "test@test.com", "1234567890", role, address);

        game = new Game("testgamenaam", 3, player1);
        System.out.println("Game " + game.getGameName() + " started by: " + player1.getUsername());
        game.joinGame(player2);
        System.out.println("player " + player2.getUsername() + " joined");
        game.joinGame(player3);
        System.out.println("player " + player3.getUsername() + " joined");
        game.joinGame(player4);
        System.out.println("player " + player4.getUsername() + " joined");

        game.playRound();
        diceList = game.getDiceList();
        game.fixDie(diceList.get(0).getDieId());
        game.fixDie(diceList.get(1).getDieId());
        game.fixDie(diceList.get(2).getDieId());
        game.playRound();
        scorePossibilities = game.getScorePossibilities();
        for (ScoreAspect sa : scorePossibilities) {
            System.out.println(sa.getDescription() + " / " + sa.getPoints());
        }
        game.selectScore("sixes");

        displayScore();

        game.playRound();
        game.getNextPlayer();

        displayScore();


    }

    private void displayScore() {
        System.out.println(game.getScore().getOnes());
        System.out.println(game.getScore().getTwos());
        System.out.println(game.getScore().getThrees());
        System.out.println(game.getScore().getFours());
        System.out.println(game.getScore().getFives());
        System.out.println(game.getScore().getSixes() + "\n---");
        System.out.println(game.getScore().getTotalUpperHalf() + "\n");
        System.out.println(game.getScore().getThreeOfAKind());
        System.out.println(game.getScore().getCarre());
        System.out.println(game.getScore().getFullHouse());
        System.out.println(game.getScore().getSmallStreet());
        System.out.println(game.getScore().getLargeStreet());
        System.out.println(game.getScore().getYahtzee());
        System.out.println(game.getScore().getYahtzeeBonus());
        System.out.println(game.getScore().getChance() + "\n---");
        System.out.println(game.getScore().getTotalLowerHalf() + "\n\n---");
        System.out.println(game.getScore().getTotalScore());
    }
}
