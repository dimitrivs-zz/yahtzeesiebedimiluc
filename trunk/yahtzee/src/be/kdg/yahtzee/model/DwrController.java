/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */


package be.kdg.yahtzee.model;

import be.kdg.yahtzee.remoteObjects.YahtzeeControllerServiceLocator;
import be.kdg.yahtzee.remoteObjects.game.Die;
import be.kdg.yahtzee.remoteObjects.game.Game;
import be.kdg.yahtzee.remoteObjects.game.Score;
import be.kdg.yahtzee.remoteObjects.game.ScoreAspect;
import be.kdg.yahtzee.remoteObjects.users.User;

import java.rmi.RemoteException;
import java.util.*;


public class DwrController {
    be.kdg.yahtzee.remoteObjects.YahtzeeController yahtzeeController;

    public DwrController() {
        YahtzeeControllerServiceLocator serviceLocator = new YahtzeeControllerServiceLocator();
        try {
            yahtzeeController = serviceLocator.getyahtzee();
        } catch (javax.xml.rpc.ServiceException e) {

        }
    }

    // ----- global functions -----
    public Set<Game> getGames() throws RemoteException {
        Set<Game> allGamesList = new HashSet<Game>();

        java.lang.Object[] allGames = yahtzeeController.getGames();

        for (int i = 0; i < allGames.length; i++) {
            allGamesList.add((Game) allGames[i]);
        }

        return allGamesList;
    }

    public List<User> getOnlineUsers() throws RemoteException {
        List<User> allUsersList = new ArrayList<User>();

        java.lang.Object[] allUsers = yahtzeeController.getOnlineUsers();

        for (int i = 0; i < allUsers.length; i++) {
            allUsersList.add((User) allUsers[i]);
        }
        return allUsersList;
    }

    public List getGlobalMessages() throws RemoteException {
        List allGlobalMessagesList = new ArrayList();
        java.lang.Object[] allGlobalMessages = yahtzeeController.getGlobalMessages();
        for (int i = 0; i < allGlobalMessages.length; i++) {
            allGlobalMessagesList.add(allGlobalMessages[i]);
        }
        return allGlobalMessagesList;
    }

    public void addGlobalMessage(String text) throws RemoteException {
        yahtzeeController.addGlobalMessage(text);
    }

    // ----- game functions -----
    public String getCreator(String gameName) throws RemoteException {
        return yahtzeeController.getCreator(gameName);
    }

    public String getActivePlayer(String gameName) throws RemoteException {
        return yahtzeeController.getActivePlayer(gameName);
    }

    public Set<User> getUsersOfGame(String gameName) throws RemoteException {
        Set<User> allUsersList = new HashSet<User>();
        java.lang.Object[] allUsersArray = yahtzeeController.getUsersOfGame(gameName);
        for (int i = 0; i < allUsersArray.length; i++) {
            allUsersList.add((User) allUsersArray[i]);
        }
        return allUsersList;
    }

    public String getGameState(String gameName) throws RemoteException {
        return yahtzeeController.getGameState(gameName);
    }

    public String startGame(String gameName) throws RemoteException {
        return yahtzeeController.startGame(gameName);
    }

    public List<Die> getDiceList(String gameName) throws RemoteException {
        List<Die> allDiceList = new ArrayList<Die>();
        java.lang.Object[] allDie = yahtzeeController.getDiceList(gameName);
        for (int i = 0; i < allDie.length; i++) {
            allDiceList.add((Die) allDie[i]);
        }
        return allDiceList;
    }

    public List<Die> playRound(String gameName) throws RemoteException {
        List<Die> allDiceList = new ArrayList<Die>();
        java.lang.Object[] allDie = yahtzeeController.playGameRound(gameName);
        for (int i = 0; i < allDie.length; i++) {
            allDiceList.add((Die) allDie[i]);
        }
        return allDiceList;
    }

    public List<ScoreAspect> getScorePossibilities(String gameName) throws RemoteException {
        List<ScoreAspect> allScoreList = new ArrayList<ScoreAspect>();
        java.lang.Object[] allScore = yahtzeeController.getScorePossibilities(gameName);
        for (int i = 0; i < allScore.length; i++) {
            allScoreList.add((ScoreAspect) allScore[i]);
        }
        return allScoreList;
    }

    public Score selectScore(String gameName, String scoreChoice) throws RemoteException {
        return yahtzeeController.selectScore(gameName, scoreChoice);
    }

    public void fixDie(String gameName, int dieId) throws RemoteException {
        yahtzeeController.fixDie(gameName, dieId);
    }

    public void unfixDie(String gameName, int dieId) throws RemoteException {
        yahtzeeController.unfixDie(gameName, dieId);
    }

    public Map getScores(String gameName) throws RemoteException {
        Map<String, Score> scores = new HashMap<String, Score>();
        Set<User> users = getUsersOfGame(gameName);
        for (User user : users) {
            scores.put(user.getUsername(), yahtzeeController.getScore(gameName, user.getUsername()));
        }
        return scores;
    }

    public boolean isGameFinished(String gameName) throws RemoteException {
        return yahtzeeController.gameFinished(gameName);
    }

    public void leaveGame(String gameName, String username) throws RemoteException {
        User user = yahtzeeController.findUser(username);
        yahtzeeController.leaveGame(gameName, user);
    }

    public void addMessage(String text, String gameName) throws RemoteException {
        yahtzeeController.addMessage(text, gameName);
    }

    /**
     * Method for getting the messages of a chat in a game.
     *
     * @param gameName String name of game.
     * @return List with chatMessages of a game.
     */
    public List getMessages(String gameName) throws RemoteException {
        List allMessagesList = new ArrayList();
        java.lang.Object[] allMessages = yahtzeeController.getMessages(gameName);
        for (int i = 0; i < allMessages.length; i++) {
            allMessagesList.add(allMessages[i]);
        }
        return allMessagesList;
    }


}
