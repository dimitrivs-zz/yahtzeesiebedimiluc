package be.kdg.yahtzee.users;

import be.kdg.util.Security;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 5-feb-2007
 * Time: 21:33:11
 * To change this template use File | Settings | File Templates.
 */
public class TestLogin extends TestCase {
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
    public void testLogInAdministrator() throws Exception {
        boolean loginOK = false;
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        yahtzeeController.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        User user = yahtzeeController.findUser("admin");
        String password = "administrator";
        password = Security.getInstance().encrypt(password);

        yahtzeeController.unblockUser("admin");

        if (user.getUsername().equals("admin")) {
            loginOK = user.getPassword().equals(password) && !user.isBlocked();
        }

        assertTrue("De authenticatie moet <true> zijn", loginOK);
    }

    @Test
    public void testLogInPlayer() throws Exception {
        boolean loginOK = false;
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        yahtzeeController.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = yahtzeeController.findUser("bla");
        String password = "blablabla";
        password = Security.getInstance().encrypt(password);
        yahtzeeController.unblockUser("bla");

        if (user.getUsername().equals("bla")) {
            loginOK = user.getPassword().equals(password) && !user.isBlocked();
        }

        assertTrue("De authenticatie moet <true> zijn", loginOK);
    }

    @Test
    public void testLogInFail() throws Exception {
        boolean loginOK = false;

        User user = yahtzeeController.findUser("qsdf");
        String password = "blablabla";
        password = Security.getInstance().encrypt(password);

        if (user.getUsername().equals("bla")) {
            loginOK = user.getPassword().equals(password) && !user.isBlocked();
        }

        assertFalse("De authenticatie moet <false> zijn", loginOK);

        User user1 = yahtzeeController.findUser("bla");
        String password1 = "blabla";
        password1 = Security.getInstance().encrypt(password1);

        if (user1.getUsername().equals("bla")) {
            loginOK = user1.getPassword().equals(password1) && !user1.isBlocked();
        }

        assertFalse("De authenticatie moet <false> zijn", loginOK);

        User user2 = yahtzeeController.findUser("bla");
        String password2 = "blablabla";
        password2 = Security.getInstance().encrypt(password2);
        yahtzeeController.blockUser("bla");

        if (user2.getUsername().equals("bla")) {
            loginOK = user2.getPassword().equals(password2) && !user.isBlocked();
        }

        assertFalse("De authenticatie moet <true> zijn", loginOK);
        yahtzeeController.unblockUser("bla");

    }

    @Test
    public void testGetNullUser() throws Exception {
        User user = yahtzeeController.findUser("qdfaerazer");

        assertEquals("Dit moet <username> geven", "username", user.getUsername());
    }
}
