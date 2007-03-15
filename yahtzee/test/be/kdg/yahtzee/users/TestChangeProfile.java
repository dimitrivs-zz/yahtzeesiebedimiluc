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
 * Time: 18:33:30
 * To change this template use File | Settings | File Templates.
 */
public class TestChangeProfile extends TestCase {
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
    public void testChangeProfile() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);
        User user1 = userManager.changeUser(user, "admin", "istrator", "admin@admin.com", "O498/24.36.43", address, user.getRole());

        assertEquals("Het resultaat moet <admin@admin.com> zijn", "admin@admin.com", user1.getPerson().getEmail());
    }
}
