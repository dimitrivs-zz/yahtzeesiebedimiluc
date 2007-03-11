package be.kdg.yahtzee.users;


import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerServiceLocator;
import be.kdg.yahtzee.model.remoteObjects.users.Address;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 9:37:07
 * To change this template use File | Settings | File Templates.
 */
public class TestRemoveUser extends TestCase {
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
    public void testRemoveUser() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        yahtzeeController.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        yahtzeeController.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        yahtzeeController.removeUser("haha");

        assertEquals("De groote van de list moet <4> zijn", 4, yahtzeeController.getUsers().length);
    }
}
