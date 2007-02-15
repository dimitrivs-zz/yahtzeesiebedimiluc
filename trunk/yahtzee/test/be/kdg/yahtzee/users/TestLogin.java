package be.kdg.yahtzee.users;

import static org.junit.Assert.assertTrue;
import org.springframework.test.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import be.kdg.yahtzee.model.users.UserManager;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.servlets.YahtzeeServlet;


/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 5-feb-2007
 * Time: 21:33:11
 * To change this template use File | Settings | File Templates.
 */
public class TestLogin extends AbstractDependencyInjectionSpringContextTests   {
    private UserManager userManager;
    /*
    public void setUp() {
        userManager = new UserManager();
        UserDao userDao = new UserDaoImpl();
        RoleDao roleDao = new RoleDaoImpl();
        userManager.setUserDao(userDao);
        userManager.setRoleDao(roleDao);
    } */

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

       /*
    protected void onSetUp() throws Exception {
        YahtzeeServlet yahtzeeServlet = new YahtzeeServlet() ;
        YahtzeeController yahtzeeController = yahtzeeServlet.findYahtzeeController();
    }    */

    public void testLogInAdministrator() throws Exception{
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        Role role = userManager.getRole("Administrator");

        assertTrue("De authenticatie moet <true> zijn", userManager.isUserInRole(user, role));
    }

    public void testLogInPlayer() throws Exception{
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        Role role = userManager.getRole("Player");

        assertTrue("De authenticatie moet <true> zijn", userManager.isUserInRole(user, role));
    }

    protected String[] getConfigLocations() {
        return new String[] {"classpath:*/WEB-INF/appcontext.xml"};
    }

    /*
 public void setUp() throws Exception {
     sessionFactory = (SessionFactory) findSessionFactory();
     Session s = sessionFactory.openSession();
     TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
 }   */
    /*
 @After
 public void tearDown() {
     userManager = null;
 }   */



}
