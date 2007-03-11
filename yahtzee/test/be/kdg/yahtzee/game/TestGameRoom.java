package be.kdg.yahtzee.game;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import be.kdg.yahtzee.model.remoteObjects.users.Person;
import be.kdg.yahtzee.model.remoteObjects.users.Role;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestGameRoom extends TestCase {
    YahtzeeController yahtzeeController;

    @Before
    public void setUp() throws Exception {
        YahtzeeControllerServiceLocator serviceLocator = new YahtzeeControllerServiceLocator();
        try {
            yahtzeeController = serviceLocator.getyahtzee();
        } catch (javax.xml.rpc.ServiceException e) {

        }
    }

    @After
    protected void tearDown() throws Exception {
        yahtzeeController = null;
    }

    @Test
    public void testJoinGame() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        Person person = new Person(address, "eamil", "qsdf", "qsdf", "qsdf");
        User user1 = new User(address, false, "testuser", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser");
        yahtzeeController.createGame("testGame", 3, user1);

        User user2 = new User(address, false, "testuser2", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser2");

        assertTrue("Een user die nog niet aan een spel deelneemt mag joinen", yahtzeeController.joinGame("testGame", user2));
    }

    @Test
    public void testJoinGameUserExist() throws Exception {

        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        Person person = new Person(address, "eamil", "qsdf", "qsdf", "qsdf");
        User user1 = new User(address, false, "testuser", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser");
        yahtzeeController.createGame("testGame", 3, user1);

        assertFalse("De user die game mag niet zijn eigen spel joinen", yahtzeeController.joinGame("testGame", user1));
    }

    @Test
    public void testJoinGameUserExistsOtherGame() throws Exception {

        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        Person person = new Person(address, "eamil", "qsdf", "qsdf", "qsdf");
        User user1 = new User(address, false, "testuser", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser");

        yahtzeeController.createGame("testGame", 3, user1);

        User user2 = new User(address, false, "testuser2", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser2");

        assertTrue("Een user die nog niet aan een spel deelneemt mag joinen", yahtzeeController.joinGame("testGame", user2));

        User user3 = new User(address, false, "testuser2", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser3");

        yahtzeeController.createGame("testGame1", 3, user3);

        assertFalse("Een user kan nadat hij een spel gejoint heeft aan geen enkel spel deelnemen", yahtzeeController.joinGame("testGame1", user2));
    }
    /*
 @Test
 public void testStatus()  throws Exception{
     User user1 = new User(null, false,"testuser", false, "test", null, null, "test", "qdf",333,"testuser");

     yahtzeeController.createGame("testGame", 3, user1);

     Game game = yahtzeeController.getGame("testGame");

     game.setState(EnumState.LEEG);
     assertEquals("De status moet <Empty> zijn", "Empty", game.getState());

     game.setState(EnumState.IDLE);
     assertEquals("De status moet <Idle> zijn", "Idle", game.getState());

     game.setState(EnumState.WACHTEN);
     assertEquals("De status moet <Waiting> zijn", "Waiting", game.getState());

     game.setState(EnumState.BEZIG);
     assertEquals("De status moet <Busy> zijn", "Busy", game.getState());

     game.setState(EnumState.VOL);
     assertEquals("De status moet <Full> zijn", "Full", game.getState());
 }   */

    @Test
    public void testGameFull() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        Person person = new Person(address, "eamil", "qsdf", "qsdf", "qsdf");
        User user1 = new User(address, false, "testuser", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser");
        yahtzeeController.createGame("testGame", 2, user1);

        User user2 = new User(address, false, "testuser", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser2");

        User user4 = new User(address, false, "testuser", false, "test", person, new Role("admin", 88), "test", "qdf", 333, "testuser4");

        assertTrue("Deze user kan nog joinen", yahtzeeController.joinGame("testGame", user2));

        assertFalse("De game is <Full> en kan dus niet gejoined worden", yahtzeeController.joinGame("testGame", user4));
    }
    /*
 @Test
 public void testGameBusy()  throws Exception{
     User user1 = new User(null, false,"testuser", false, "test", null, null, "test", "qdf",333,"testuser");
     User user2 = new User(null, false,"testuser", false, "test", null, null, "test", "qdf",333,"testuser2");

     yahtzeeController.createGame("testGame1", 3, user1);

     assertEquals("De creator kan de game starten", "Busy", yahtzeeController.s("testGame1"));

     assertFalse("De game is <Busy> en kan dus niet gejoined worden", yahtzeeController.joinGame("testGame1", user2));
 }   */
}
