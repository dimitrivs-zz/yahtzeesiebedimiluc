package be.kdg.yahtzee.users;


import be.kdg.yahtzee.model.remoteObjects.UserManager;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 9:37:07
 * To change this template use File | Settings | File Templates.
 */
public class TestRemoveUser extends TestCase {
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
    public void testRemoveUser() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        userManager.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        userManager.removeUser("haha");

        List<User> users = userManager.getUsers();

        assertEquals("De groote van de list moet <1> zijn", 1, users.size());
    }
}
