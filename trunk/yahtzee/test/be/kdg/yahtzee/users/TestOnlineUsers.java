package be.kdg.yahtzee.users;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 9:24:37
 * To change this template use File | Settings | File Templates.
 */
public class TestOnlineUsers extends TestCase {
    YahtzeeController yahtzeeController;

    @Before
    public void setUp() {
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
    public void testUserOnline() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        yahtzeeController.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = yahtzeeController.findUser("bla");

        user.setOnline(true);

        List<User> onlineUsers = new ArrayList<User>();

        java.lang.Object[] allUsers = yahtzeeController.getUsers();

        for (int i = 0; i < allUsers.length; i++) {
            System.out.println(allUsers[i]);
            if (((User) allUsers[i]).isOnline()) {
                onlineUsers.add((User) allUsers[i]);
            }
        }

        assertEquals("user <bla> moet <online> zijn", "bla", onlineUsers.get(0).getUsername());
    }

    @Test
    public void testUserOffline() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        yahtzeeController.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        yahtzeeController.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user1 = yahtzeeController.findUser("haha");
        User user2 = yahtzeeController.findUser("bla");

        user1.setOnline(true);
        user2.setOnline(false);

        List<User> onlineUsers = new ArrayList<User>();

        java.lang.Object[] allUsers = yahtzeeController.getUsers();

        for (int i = 0; i < allUsers.length; i++) {
            System.out.println(allUsers[i]);
            if (((User) allUsers[i]).isOnline()) {
                onlineUsers.add((User) allUsers[i]);
            }
        }

        assertEquals("user <haha> moet <online> zijn", "haha", onlineUsers.get(0).getUsername());
        assertTrue("Dit moet true teruggeven", onlineUsers.get(1).isOnline());
    }
}
