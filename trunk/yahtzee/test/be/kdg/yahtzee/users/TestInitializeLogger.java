package be.kdg.yahtzee.users;

import be.kdg.yahtzee.model.users.UserManager;
import junit.framework.TestCase;
import org.apache.log4j.Level;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 19-feb-2007
 * Time: 13:39:06
 * To change this template use File | Settings | File Templates.
 */
public class TestInitializeLogger extends TestCase {
    private UserManager userManager;

    @Before
    public void setUp() {
        userManager = new UserManager();
    }

    @After
    protected void tearDown() throws Exception {
        userManager = null;
    }

    @Test
    public void testLogInAdministrator() throws Exception {
        assertTrue("De logger moet succesvol initialiseren", userManager.initLogger(Level.DEBUG));
    }
}
