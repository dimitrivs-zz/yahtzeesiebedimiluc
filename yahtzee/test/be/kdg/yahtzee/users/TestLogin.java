package be.kdg.yahtzee.users;


import be.kdg.yahtzee.model.remoteObjects.UserManager;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;


/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 5-feb-2007
 * Time: 21:33:11
 * To change this template use File | Settings | File Templates.
 */
public class TestLogin extends TestCase {
    private UserManager userManager;

    @Before
    public void setUp() throws RemoteException {
        userManager = new UserManager(true);
    }

    @After
    protected void tearDown() throws Exception {
        userManager = null;
    }

    @Test
    public void testLogInAdministrator() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        Role role = userManager.getRole("Administrator");

        assertTrue("De authenticatie moet <true> zijn", userManager.isUserInRole(user.getUsername(), "admin"));
    }

    @Test
    public void testLogInPlayer() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        Role role = userManager.getRole("Player");

        assertTrue("De authenticatie moet <true> zijn", userManager.isUserInRole(user.getUsername(), "player"));
    }

    @Test
    public void testGetNullUser() throws Exception {
        User user = userManager.getUser("qdfaerazer");

        assertEquals("Dit moet <username> geven", "username", user.getUsername());
    }
}
