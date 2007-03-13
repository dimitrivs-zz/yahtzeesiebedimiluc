package be.kdg.yahtzee.users;


import be.kdg.util.Security;
import be.kdg.yahtzee.model.remoteObjects.UserManager;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.User;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

public class TestRegistratieUser extends TestCase {
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
    public void testCreateAdministrator() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        Role role = userManager.getRole("Administrator");

        assertEquals("De username moet <admin> zijn", "admin", user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address, user.getAddress());
        assertEquals("De naam moet <istrator> zijn", "istrator", user.getFirstname());
        assertEquals("De naam moet <admin> zijn", "admin", user.getSurname());
        assertEquals("De naam moet <O498/24.36.43> zijn", "O498/24.36.43", user.getTelephone());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("administrator") + "> zijn", Security.getInstance().encrypt("administrator"), user.getPassword());
        assertEquals("De role name moet <Administrator> zijn", role, userManager.getRole("Administrator"));
        assertEquals("De role toString moet <Administrator> zijn", "Administrator", user.getRole().toString());
        assertEquals("De person toString moet <istrator admin> geven", "istrator admin", user.getPerson().toString());
    }

    @Test
    public void testCreatePlayer() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");

        userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = userManager.getUser("bla");

        assertEquals("De username moet <bla> zijn", "bla", user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address, user.getAddress());
        assertEquals("De naam moet <JAA> zijn", "JAA", user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("blablabla") + "> zijn", Security.getInstance().encrypt("blablabla"), user.getPassword());
        assertEquals("De role name moet <Player> zijn", "Player", user.getRole().getName());
    }

    @Test
    public void testCreate2Player() throws Exception {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");

        userManager.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = userManager.getUser("bla");

        assertEquals("De username moet <bla> zijn", "bla", user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address, user.getAddress());
        assertEquals("De naam moet <JAA> zijn", "JAA", user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("blablabla") + "> zijn", Security.getInstance().encrypt("blablabla"), user.getPassword());
        assertEquals("De role name moet <Player> zijn", "Player", user.getRole().getName());
    }

}
