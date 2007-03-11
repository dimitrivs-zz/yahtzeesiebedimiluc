package be.kdg.yahtzee.users;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;
import be.kdg.yahtzee.model.remoteObjects.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 18-feb-2007
 * Time: 18:33:49
 * To change this template use File | Settings | File Templates.
 */
public class TestChangePassword extends TestCase {
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
    public void testChangePassword() throws Exception {
        //Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        //yahtzeeController.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        User user = yahtzeeController.findUser("admin");

        assertTrue("Dit moet true teruggeven ", yahtzeeController.changePassWord(user, "administrator", "siebe123", "siebe123"));
    }

    @Test
    public void testChangePasswordFail() throws Exception {
        //Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        //yahtzeeController.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        User user = yahtzeeController.findUser("admin");

        assertFalse("Dit moet false teruggeven ", yahtzeeController.changePassWord(user, "administra", "siebe123", "siebe123"));
        assertFalse("Dit moet false teruggeven ", yahtzeeController.changePassWord(user, "administrator", "siebe1234", "siebe123"));
        assertFalse("Dit moet false teruggeven ", yahtzeeController.changePassWord(user, "administrator", "si", "si"));
    }
}
