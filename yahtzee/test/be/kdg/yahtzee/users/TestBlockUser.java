package be.kdg.yahtzee.users;


import be.kdg.yahtzee.model.remoteObjects.UserManager;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 9:40:55
 * To change this template use File | Settings | File Templates.
 */
public class TestBlockUser extends TestCase {
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
    public void testBlockUser() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        userManager.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        userManager.blockUser("haha");

        User blockedUser = userManager.getUser("haha");

        assertTrue("User <haha> moet geblokt zijn", blockedUser.isBlocked());

        userManager.unblockUser("haha");

        User unBlockedUser = userManager.getUser("haha");

        assertFalse("User <haha> moet unblocked zijn", unBlockedUser.isBlocked());
    }
}
