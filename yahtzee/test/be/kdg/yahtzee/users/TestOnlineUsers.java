package be.kdg.yahtzee.users;


import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.remoteObjects.UserManager;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 9:24:37
 * To change this template use File | Settings | File Templates.
 */
public class TestOnlineUsers extends TestCase {
    private UserManager userManager;

    @Before
    public void setUp() throws RemoteException {
        userManager = new UserManager();

    }

    @After
    protected void tearDown() throws Exception {
        userManager = null;
    }

    @Test
    public void testUserOnline() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);
        user.setOnline(true);

        User onlineUser = userManager.getOnlineUsers().get(0);

        assertEquals("user <bla> moet <online> zijn", "bla", onlineUser.getUsername());
    }

    @Test
    public void testUserOffline() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user1 = userManager.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        User user2 = userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);
        user1.setOnline(true);
        user2.setOnline(false);

        User onlineUser = userManager.getOnlineUsers().get(0);

        assertEquals("user <haha> moet <online> zijn", "haha", onlineUser.getUsername());
        assertTrue("Dit moet true teruggeven", onlineUser.isOnline());
    }
}
