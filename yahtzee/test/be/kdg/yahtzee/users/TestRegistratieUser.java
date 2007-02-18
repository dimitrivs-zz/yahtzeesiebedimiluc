package be.kdg.yahtzee.users;

import be.kdg.util.Security;
import be.kdg.yahtzee.dao.RoleDaoImpl;
import be.kdg.yahtzee.dao.UserDaoImpl;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.UserManager;
import junit.framework.TestCase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.HSQLDialect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TestRegistratieUser extends TestCase {
    private UserManager userManager;
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        userManager = new UserManager();
        UserDaoImpl userDao = new UserDaoImpl();
        RoleDaoImpl roleDao = new RoleDaoImpl();

        Configuration configuration = new Configuration();
        configuration.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        configuration.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/yahtzee");
        configuration.setProperty(Environment.USER, "yahtzee");
        configuration.setProperty(Environment.PASS, "yahtzee");
        configuration.setProperty(Environment.DIALECT, HSQLDialect.class.getName());
        configuration.setProperty(Environment.SHOW_SQL, "true");
        configuration.setProperty(Environment.HBM2DDL_AUTO, "create-drop");
        configuration.addClass(User.class);
        configuration.addClass(Role.class);

        this.sessionFactory = configuration.buildSessionFactory();

        userDao.setSessionFactory(sessionFactory);
        roleDao.setSessionFactory(sessionFactory);

        this.session = SessionFactoryUtils.getSession(sessionFactory, true);
        TransactionSynchronizationManager.bindResource(sessionFactory,
                new SessionHolder(session));

        userManager.setUserDao(userDao);
        userManager.setRoleDao(roleDao);
    }

    @After
    protected void tearDown() throws Exception {
        TransactionSynchronizationManager.unbindResource(sessionFactory);
        SessionFactoryUtils.releaseSession(session, sessionFactory);
    }

    @Test
    public void createAdministrator() {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        User user = userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        Role role = userManager.getRole("Administrator");

        assertEquals("De username moet <admin> zijn", "admin", user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address, user.getAddress());
        assertEquals("De naam moet <administrator> zijn", "administrator", user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("administrator") + "> zijn", Security.getInstance().encrypt("administrator"), user.getPassword());
        assertEquals("De role name moet <Administrator> zijn", role, userManager.getRole("Administrator"));
    }

    @Test
    public void createPlayer() {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");

        userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = userManager.getUser("bla");

        assertEquals("De username moet <bla> zijn", "bla", user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address, user.getAddress());
        assertEquals("De naam moet <klant 1> zijn", "klant 1", user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("blablabla") + "> zijn", Security.getInstance().encrypt("blablabla"), user.getPassword());
        assertEquals("De role name moet <Player> zijn", "Player", user.getRole().getName());
    }

    @Test
    public void create2Player() {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");

        userManager.createPlayer("haha", "hahahahahaha", "klant 2", "NEEEE", "klant2@klant.be", "2439479", address);
        userManager.createPlayer("bla", "blablabla", "klant 1", "JAA", "klant1@klant.be", "7832723", address);

        User user = userManager.getUser("bla");

        assertEquals("De username moet <bla> zijn", "bla", user.getUsername());
        assertEquals("Het adres moet < " + address + "> zijn", address, user.getAddress());
        assertEquals("De naam moet <klant 1> zijn", "klant 1", user.getFirstname());
        assertEquals("Het gencrypteerde passwoord moet <" + Security.getInstance().encrypt("blablabla") + "> zijn", Security.getInstance().encrypt("blablabla"), user.getPassword());
        assertEquals("De role name moet <Player> zijn", "Player", user.getRole().getName());
    }

    @Test
    public void removeUser() {
        Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
        userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);

        userManager.removeUser("admin");
    }

    /*
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
    */
    @Test
    public void searchInexistingUser() {
        assertNull(userManager.getUser("qsdfqsdfqsdf"));
    }
    /*
  @Test
  public void getUsers(){
      Address address = new Address("Nationalestraat", "5", "2000", "Antwerpen", "Belgium");
      userManager.createAdministrator("admin", "administrator", "admin", "istrator", "admin@admin.be", "O498/24.36.43", address);
      int amountPlayers = userManager.getNumberOfUsers();

      assertEquals("Aantal gebruikers moet <"+ amountPlayers +"> zijn", amountPlayers , userManager.getUsers().size());
  }  */
}
