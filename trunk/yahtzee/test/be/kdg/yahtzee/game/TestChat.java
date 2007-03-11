package be.kdg.yahtzee.game;

import junit.framework.TestCase;


/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 18-feb-2007
 * Time: 15:31:58
 * To change this template use File | Settings | File Templates.
 */
public class TestChat extends TestCase {
    /*
    YahtzeeController yahtzeeController;

    @Before
    public void setUp() throws Exception{
        YahtzeeControllerServiceLocator serviceLocator = new YahtzeeControllerServiceLocator();
        try{
            yahtzeeController = serviceLocator.getyahtzee();
        }   catch (javax.xml.rpc.ServiceException e){

        }
    }

    @After
    protected void tearDown() throws Exception {
        yahtzeeController = null;
    }

    @Test
    public void testAddChatMessage()throws Exception {
        //User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);

        User user = yahtzeeController.findUser("bla");

        yahtzeeController.createGame("testGame" , 3, user);
        yahtzeeController.addMessage("Hallo", "testGame");

        ChatMessage chatMessage = (ChatMessage) yahtzeeController.getMessages("testGame").get(0);

        assertEquals("De message moet <Hallo> zijn", "Hallo", chatMessage.getText());
    }

    @Test
    public void testAddMessageLarger256() throws Exception{
        User user1 = new User("testUser1", "testUser1", "testUser", "istrator", "admin@admin.be", "O498/24.36.43", null, null);
        yahtzeeController.createGame("testGame", 3, user1);
        yahtzeeController.addMessage("123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789psiebe", "testGame");

        ChatMessage chatMessage = (ChatMessage) yahtzeeController.getMessages("testGame").get(0);

        assertEquals("De message moet <een substring worden> zijn", "123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456789p123456", chatMessage.getText());
    }

    @Test
    public void testAddGlobalChatMessage() throws Exception{
        yahtzeeController.addGlobalMessage("Hallo");

        ChatMessage chatMessage = (ChatMessage) yahtzeeController.getGlobalMessages().get(0);

        assertEquals("De message moet <Hallo> zijn", "Hallo", chatMessage.getText());
    }   */
}
