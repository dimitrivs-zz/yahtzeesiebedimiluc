package be.kdg.yahtzee.users;

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
 * Date: 18-feb-2007
 * Time: 18:33:30
 * To change this template use File | Settings | File Templates.
 */
public class TestChangeProfile extends TestCase {
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
    public void testChangeProfile() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        yahtzeeController.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        User user1 = yahtzeeController.findUser("admin");

        yahtzeeController.changeUser(user1, "admin", "istrator", "admin@admin.com", "O498/24.36.43", address, user1.getRole());

        assertEquals("Het resultaat moet <admin@admin.com> zijn", "admin@admin.com", user1.getPerson().getEmail());
    }
}
