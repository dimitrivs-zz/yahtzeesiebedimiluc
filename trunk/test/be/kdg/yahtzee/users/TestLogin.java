package be.kdg.yahtzee.users;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.BeanFactory;
import be.kdg.yahtzee.model.users.UserManager;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.util.Security;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 5-feb-2007
 * Time: 21:33:11
 * To change this template use File | Settings | File Templates.
 */
public class TestLogin {
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
    public void logInAdministrator(){
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin" , "administrator", "administrator", address);

        Role role = userManager.getRole("Administrator");

        assertTrue("De authenticatie moet <true> zijn", userManager.isUserInRole(user, role));
    }

    @Test
    public void logInPlayer(){
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createPlayer("bla", "blablabla", "klant 1", address);

        Role role = userManager.getRole("Player");

        assertTrue("De authenticatie moet <true> zijn", userManager.isUserInRole(user, role));
    }

}
