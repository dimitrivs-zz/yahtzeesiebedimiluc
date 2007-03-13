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
 * Date: 18-feb-2007
 * Time: 18:33:49
 * To change this template use File | Settings | File Templates.
 */
public class TestChangePassword extends TestCase {
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
    public void testChangePassword() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        assertTrue("Dit moet true teruggeven ", userManager.changePassword(user, "administrator", "siebe123", "siebe123"));
    }

    @Test
    public void testChangePasswordFail() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        assertFalse("Dit moet false teruggeven ", userManager.changePassword(user, "administra", "siebe123", "siebe123"));
        assertFalse("Dit moet false teruggeven ", userManager.changePassword(user, "administrator", "siebe1234", "siebe123"));
        assertFalse("Dit moet false teruggeven ", userManager.changePassword(user, "administrator", "si", "si"));
    }
}
