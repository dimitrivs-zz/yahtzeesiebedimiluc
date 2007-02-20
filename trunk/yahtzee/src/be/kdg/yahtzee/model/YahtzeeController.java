package be.kdg.yahtzee.model;

import be.kdg.yahtzee.model.game.Die;
import be.kdg.yahtzee.model.game.Game;
import be.kdg.yahtzee.model.game.GameManager;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.Role;
import be.kdg.yahtzee.model.users.User;
import be.kdg.yahtzee.model.users.UserManager;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public class YahtzeeController {
    private UserManager userManager;
    private GameManager gameManager;

    public YahtzeeController() {
    }

    public void setGameManager(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public User findUser(String username) {
        return userManager.getUser(username);
    }
    /*
    public Address getAddressOfUser(String username) {
        return userManager.getAddressOfUser(username);
    } */

    public void blockUser(String username) {
        userManager.blockUser(username);
    }

    public void unblockUser(String username) {
        userManager.unblockUser(username);
    }

    public boolean isPlayer(String username) {
        User user = userManager.getUser(username);
        Role role = userManager.getRole("Player");
        return userManager.isUserInRole(user, role);
        //return true;
    }

    public boolean isAdministrator(String username) {
        User user = userManager.getUser(username);
        Role role = userManager.getRole("Administrator");
        return userManager.isUserInRole(user, role);
        //return false;
    }

    public boolean isLastAdministrator() {
        return userManager.isLastAdministrator();
    }

    public List getUsers() {
        return userManager.getUsers();
    }

    public void createPlayer(String username, String password, String surname, String firstName, String email, String telephone, Address address) {
        userManager.createPlayer(username, password, surname, firstName, email, telephone, address);
    }

    public void createAdministrator(String username, String password, String surname, String firstName, String email, String telephone, Address address) {
        userManager.createAdministrator(username, password, surname, firstName, email, telephone, address);
    }

    public User changeUser(User user, String surname, String firstName, String email, String telephone, Address address, Role role) {
        return userManager.changeUser(user, surname, firstName, email, telephone, address, role);
    }

    public boolean changePassWord(User user, String orgPass, String password, String password2) {
        return userManager.changePassword(user, orgPass, password, password2);
    }

    /*
   public void changePassWord(User user, String orgPass, String password, String password2) {
       userManager.changePassword(user, orgPass, password, password2);
   } */
    /*
 public int getNumberOfUsers() {
     return userManager.getNumberOfUsers();
 }
    */
    public boolean createGame(String gameName, int number, User user) {
        return gameManager.createGame(gameName, number, user);
    }

    public Collection getGames() {
        return gameManager.getGames();
    }

    public boolean joinGame(String gameName, User user) {
        return gameManager.joinGame(gameName, user);
    }

    public Game getGame(String gameName) {
        return gameManager.getGame(gameName);
    }

    public void leaveGame(String gameName, User user) {
        gameManager.leaveGame(gameName, user);
    }

    public List<Die> playGameRound(String gameName) {
        return gameManager.playRound(gameName);
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

    public boolean selectScore(String gameName, String scoreChoice) {
        gameManager.selectScore(gameName, scoreChoice);
        return true;
    }

    public void removeUser(String username) {
        userManager.removeUser(username);
    }

    public void removeGame(String gamename) {
        gameManager.removeGame(gamename);
    }

    public List<User> findUsersByKeyword(String keyword) {
        return userManager.getUsersByKeyword(keyword);
    }

    public Map<String, Role> getRoles() {
        return userManager.getRoles();
    }
}
