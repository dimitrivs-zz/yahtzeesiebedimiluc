package be.kdg.yahtzee.users;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.UserManager;
import be.kdg.yahtzee.model.users.Role;

import be.kdg.util.Security;

public class TestRegistratieUser {
    private UserManager userManager;

    @Before
    public void setUp() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("appContext.xml");
        BeanFactory beanFactory = (BeanFactory)applicationContext;
        userManager = (UserManager)beanFactory.getBean("userManager");
    }

    @After
    public void tearDown() {
        userManager = null;
    }

    @Test
    public void createAdministrator(){
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        Role role = userManager.getRole("Administrator");

        assertEquals("De username moet <admin> zijn", "admin" , user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address , user.getAddress());
        assertEquals("De naam moet <administrator> zijn", "administrator" , user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("administrator") + "> zijn", Security.getInstance().encrypt("administrator") , user.getPassword());
        assertEquals("De role name moet <Administrator> zijn", role,userManager.getRole("Administrator"));
    }

    @Test
    public void createPlayer(){
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");

        userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = userManager.getUser("bla");

        assertEquals("De username moet <bla> zijn", "bla" , user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address , user.getAddress());
        assertEquals("De naam moet <klant 1> zijn", "klant 1" , user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("blablabla") + "> zijn", Security.getInstance().encrypt("blablabla") , user.getPassword());
        assertEquals("De role name moet <Player> zijn" ,"Player", user.getRole().getName());
    }

    @Test
    public void create2Player(){
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");

        userManager.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = userManager.getUser("bla");

        assertEquals("De username moet <bla> zijn", "bla" , user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address , user.getAddress());
        assertEquals("De naam moet <klant 1> zijn", "klant 1" , user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("blablabla") + "> zijn", Security.getInstance().encrypt("blablabla") , user.getPassword());
        assertEquals("De role name moet <Player> zijn" ,"Player", user.getRole().getName());
    }

    @Test
    public void removeUser(){
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        userManager.removeUser("admin");
    }

    @Test
    public void userChangesAddress(){
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        assertEquals("Het adres moet < " + address + "> zijn", address , user.getAddress());

        Address newAddress = new Address("Groenplaats", "20", "2000", "Antwerpen", "Belgium");

        userManager.setAddressOfUser("admin", newAddress);

        assertEquals("Het adres moet < " + newAddress + "> zijn", newAddress , userManager.getAddressOfUser("admin"));
        assertNotSame("Het adres mag niet hetzelfde zijn als < " + address + "> zijn", address , user.getAddress());
    }

    @Test
    public void searchInexistingUser(){
        assertNull(userManager.getUser("qsdfqsdfqsdf"));
    }

    @Test
    public void getUsers(){
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);
        int amountPlayers = userManager.getNumberOfUsers();

        assertEquals("Aantal gebruikers moet <"+ amountPlayers +"> zijn", amountPlayers , userManager.getUsers().size());
    }
}
