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


public class TestRegistratieUser extends TestCase {
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
    public void testCreateAdministrator() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        yahtzeeController.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        User user = yahtzeeController.findUser("admin");

        assertEquals("De username moet <admin> zijn", "admin", user.getUsername());
        assertEquals("Het adres moet < " + address.getStreet() + "> zijn", "Nationalestraat", user.getAddress().getStreet());
        assertEquals("De naam moet <istrator> zijn", "istrator", user.getFirstname());
        assertEquals("De naam moet <admin> zijn", "admin", user.getSurname());
        assertEquals("De naam moet <O498/24.36.43> zijn", "O498/24.36.43", user.getTelephone());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("administrator") + "> zijn", Security.getInstance().encrypt("administrator"), user.getPassword());
        assertEquals("De role name moet <Administrator> zijn", "Administrator", user.getRole().getName());
        assertEquals("De role toString moet <Administrator> zijn", "Administrator", user.getRole().getName());
        //assertEquals("De person toString moet <istrator admin> geven", "istrator admin", user.getPerson().toString());
    }

    @Test
    public void testCreatePlayer() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");

        yahtzeeController.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = yahtzeeController.findUser("bla");

        assertEquals("De username moet <bla> zijn", "bla", user.getUsername());
        assertEquals("Het adres moet < " + address.getStreet() + "> zijn", address.getCity(), user.getAddress().getStreet());
        assertEquals("De naam moet <JAA> zijn", "JAA", user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("blablabla") + "> zijn", Security.getInstance().encrypt("blablabla"), user.getPassword());
        assertEquals("De role name moet <Player> zijn", "Player", user.getRole().getName());
    }

    @Test
    public void testCreate2Player() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");

        yahtzeeController.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        yahtzeeController.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = yahtzeeController.findUser("bla");

        assertEquals("De username moet <bla> zijn", "bla", user.getUsername());
        assertEquals("Het adres moet < " + address.getStreet() + "> zijn", address.getCity(), user.getAddress().getStreet());
        assertEquals("De naam moet <JAA> zijn", "JAA", user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("blablabla") + "> zijn", Security.getInstance().encrypt("blablabla"), user.getPassword());
        assertEquals("De role name moet <Player> zijn", "Player", user.getRole().getName());
    }

}
