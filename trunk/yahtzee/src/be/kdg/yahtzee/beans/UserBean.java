/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.model.remoteObjects.YahtzeeController;
import be.kdg.yahtzee.model.remoteObjects.users.Person;
import be.kdg.yahtzee.model.remoteObjects.users.Role;
import be.kdg.yahtzee.model.remoteObjects.users.User;

import java.rmi.RemoteException;

/**
 * Bean class for getting and passing user information between
 * servlets and jsp-pages.
 */
public class UserBean {
    private YahtzeeController yahtzeeController;
    private int userId;
    private Person person;
    private String username;
    private String password;
    private Role role;

    public UserBean() {
    }

    /**
     * Constructor for the Game bean.
     *
     * @param yahtzeeController Main controller.
     * @param username          Username of the user for which the bean needs to be created.
     */

    public UserBean(YahtzeeController yahtzeeController, int userID, String username, String encryptedPassword, Role role, Person person) {
        this.yahtzeeController = yahtzeeController;
        this.userId = userID;
        this.username = username;
        this.password = encryptedPassword;
        this.person = person;
        this.role = role;
    }

    /**
     * Getter for username.
     *
     * @return String containing username of the User.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter for user id.
     *
     * @return String containing id of the User.
     */

    public int getUserId() throws RemoteException {
        return userId;
    }

    /**
     * Getter for name of the User.
     *
     * @return String containing name of the User.
     */
    public String getName() throws RemoteException {
        return person.getFirstName() + " " + person.getSurname();
    }

    /**
     * Getter for surname.
     *
     * @return String containing surname of the User.
     */
    public String getSurname() throws RemoteException {
        return person.getSurname();
    }

    /**
     * Getter for firstname.
     *
     * @return String containing firstname of the User.
     */
    public String getFirstname() throws RemoteException {
        return person.getFirstName();
    }

    /**
     * Getter for password.
     *
     * @return String containing password of the User.
     */
    public String getPassword() throws RemoteException {
        return password;
    }

    /**
     * Getter for emailaddress.
     *
     * @return String containing emailaddress of the User.
     */
    public String getEmail() throws RemoteException {
        return person.getEmail();
    }

    /**
     * Getter for telephone.
     *
     * @return String containing telephone of the User.
     */
    public String getTelephone() throws RemoteException {
        return person.getTelephone();
    }

    /**
     * Getter for street.
     *
     * @return String containing street of the User.
     */
    public String getStreet() throws RemoteException {
        return person.getAddress().getStreet();
    }

    /**
     * Getter for number.
     *
     * @return String containing number of the User.
     */
    public String getNumber() throws RemoteException {
        return person.getAddress().getNumber();
    }

    /**
     * Getter for zipcode.
     *
     * @return String containing zipcode of the User.
     */
    public String getZip() throws RemoteException {
        return person.getAddress().getZip();
    }

    /**
     * Getter for city.
     *
     * @return String containing city of the User.
     */
    public String getCity() throws RemoteException {
        return person.getAddress().getCity();
    }

    /**
     * Getter for country.
     *
     * @return String containing country of the User.
     */
    public String getCountry() throws RemoteException {
        return person.getAddress().getCountry();
    }

    /**
     * Getter for rolename which the User is in.
     *
     * @return String containing rolename of the User.
     */
    public String getRole() throws RemoteException {
        return role.getName();
    }

    /**
     * Getter for highscore of the User.
     *
     * @return Integer containing highscore of the User.
     */
    public int getHighestScore() throws RemoteException {
        User user = yahtzeeController.findUser(username);
        return yahtzeeController.getHighestScore(user);
    }
}

