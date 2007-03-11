/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model;

import be.kdg.yahtzee.model.game.*;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.UserManager;

import java.util.*;


public class YahtzeeController {
    private UserManager userManager;
    private GameManager gameManager;

    public YahtzeeController() {
        userManager = new UserManager();
        gameManager = new GameManager();
    }

    // ---- User Methoden

    // --- create methoden

    public void createPlayer(String username, String password, String surname, String firstName, String email, String telephone, Address address) {
        userManager.createPlayer(username, password, surname, firstName, email, telephone, address);
    }

    public void createAdministrator(String username, String password, String surname, String firstName, String email, String telephone, Address address) {
        userManager.createAdministrator(username, password, surname, firstName, email, telephone, address);
    }

    // --- change methoden

    public User changeUser(User user, String surname, String firstName, String email, String telephone, Address address, Role role) {
        return userManager.changeUser(user, surname, firstName, email, telephone, address, role);
    }

    public boolean changePassWord(User user, String orgPass, String password, String password2) {
        return userManager.changePassword(user, orgPass, password, password2);
    }

    public void changePassWord(User orgUser, String password, String password2) {
        userManager.changePassword(orgUser, password, password2);
    }

    // --- remove methoden

    public void removeUser(String username) {
        userManager.removeUser(username);
    }

    // --- get methoden

    public User findUser(String username) {
        return userManager.getUser(username);
    }

    public List getUsers() {
        return userManager.getUsers();
    }

    public List<User> findUsersByKeyword(String keyword) {
        return userManager.getUsersByKeyword(keyword);
    }

    public List<User> getOnlineUsers() {
        return userManager.getOnlineUsers();
    }

    // --- controle methoden

    public boolean isPlayer(String username) {
        return userManager.isUserInRole(username, "player");
        //return true;
    }

    public boolean isAdministrator(String username) {
        return userManager.isUserInRole(username, "admin");
        //return false;
    }

    public boolean isLastAdministrator() {
        return userManager.isLastAdministrator();
    }

    // --- block methoden

    public void blockUser(String username) {
        userManager.blockUser(username);
    }

    public void unblockUser(String username) {
        userManager.unblockUser(username);
    }

    // --- role methoden

    public Map<String, Role> getRoles() {
        return userManager.getRoles();
    }

    /*
   public Address getAddressOfUser(String username) {
       return userManager.getAddressOfUser(username);
   } */

    /*
   public void changePassWord(User user, String orgPass, String password, String password2) {
       userManager.changePassword(user, orgPass, password, password2);
   } */
    /*
 public int getNumberOfUsers() {
     return userManager.getNumberOfUsers();
 }
    */

    // ------ gameManager methoden

    // --- create methoden

    public boolean createGame(String gameName, int number, User user) {
        return gameManager.createGame(gameName, number, user);
    }

    // --- remove methoden

    public void removeGame(String gamename) {
        gameManager.removeGame(gamename);
    }

    // --- get methoden

    public Game getGame(String gameName) {
        return gameManager.getGame(gameName);
    }

    public String getCreator(String gameName) {
        return gameManager.getCreator(gameName);
    }

    public Collection getGames() {
        return gameManager.getGames();
    }

    public Set<User> getUsersOfGame(String gameName) {
        return gameManager.getUsersOfGame(gameName);
    }

    // --- join leave start methode

    public String startGame(String gamename) {
        return gameManager.startGame(gamename);
    }

    public boolean joinGame(String gameName, User user) {
        return gameManager.joinGame(gameName, user);
    }

    public void leaveGame(String gameName, User user) {
        gameManager.leaveGame(gameName, user);
    }

    // --- play game methode

    public List<Die> playGameRound(String gameName) {
        return gameManager.playRound(gameName);
    }

    public List getDiceList(String gameName) {
        return gameManager.getDiceList(gameName);
    }

    public boolean fixDie(String gameName, int dieId) {
        return gameManager.fixDie(gameName, dieId);
    }

    public boolean unfixDie(String gameName, int dieId) {
        return gameManager.unfixDie(gameName, dieId);
    }

    /*public Map<String, Integer> getScorePossibilities(String gameName) {
        return gameManager.getScorePossibilities(gameName);
    }*/

    public String getActivePlayer(String gameName) {
        return gameManager.getActivePlayer(gameName);
    }

    public String getGameState(String gamename) {
        return gameManager.getGameState(gamename);
    }

    public Score selectScore(String gameName, String scoreChoice) {
        return gameManager.selectScore(gameName, scoreChoice);
    }

    public Map getScores(String gameName) {
        return gameManager.getScores(gameName);
    }

    public int getPlayerScore(User user, String gameName) {
        return gameManager.getPlayerScore(user, gameName);
    }

    public List<ScoreAspect> getScorePossibilities(String gameName) {
        return gameManager.getScorePossibilities(gameName);
    }

    // --- highscore methoden

    public List<Highscore> getHighscores() {
        return gameManager.getHighscores();
    }

    public List<Highscore> getTop10Highscores() {
        return gameManager.getTop10Highscores();
    }

    public void saveHighscore(User user, int score, Date timestamp) {
        gameManager.saveHighscore(user, score, timestamp);
    }

    public int getHighestScore(User user) {
        return gameManager.getHighestScore(user);
    }

    // --- game chat methoden

    public void addMessage(String text, String gameName) {
        gameManager.addMessage(text, gameName);
    }

    public List getMessages(String gameName) {
        return gameManager.getMessages(gameName);
    }

    // --- global chat methoden

    public void addGlobalMessage(String text) {
        gameManager.addGlobalMessage(text);
    }

    public List getGlobalMessages() {
        return gameManager.getGlobalMessages();
    }

    // ----- game methoden
}
