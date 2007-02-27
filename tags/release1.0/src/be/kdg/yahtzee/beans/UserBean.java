/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;

/**
 * Bean class for getting and passing user information between
 * servlets and jsp-pages.
 */
public class UserBean {
    private YahtzeeController yahtzeeController;
    private String username;

    public UserBean() {
    }

    /**
     * Constructor for the Game bean.
     *
     * @param yahtzeeController Main controller.
     * @param username          Username of the user for which the bean needs to be created.
     */
    public UserBean(YahtzeeController yahtzeeController, String username) {
        this.yahtzeeController = yahtzeeController;
        this.username = username;
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
    public int getUserId() {
        User user = yahtzeeController.findUser(username);
        return user.getUserId();
    }

    /**
     * Getter for name of the User.
     *
     * @return String containing name of the User.
     */
    public String getName() {
        User user = yahtzeeController.findUser(username);
        return user.getFirstname() + " " + user.getSurname();
    }

    /**
     * Getter for surname.
     *
     * @return String containing surname of the User.
     */
    public String getSurname() {
        User user = yahtzeeController.findUser(username);
        return user.getSurname();
    }

    /**
     * Getter for firstname.
     *
     * @return String containing firstname of the User.
     */
    public String getFirstname() {
        User user = yahtzeeController.findUser(username);
        return user.getFirstname();
    }

    /**
     * Getter for password.
     *
     * @return String containing password of the User.
     */
    public String getPassword() {
        User user = yahtzeeController.findUser(username);
        return user.getPassword();
    }

    /**
     * Getter for emailaddress.
     *
     * @return String containing emailaddress of the User.
     */
    public String getEmail() {
        User user = yahtzeeController.findUser(username);
        return user.getPerson().getEmail();
    }

    /**
     * Getter for telephone.
     *
     * @return String containing telephone of the User.
     */
    public String getTelephone() {
        User user = yahtzeeController.findUser(username);
        return user.getPerson().getTelephone();
    }

    /**
     * Getter for street.
     *
     * @return String containing street of the User.
     */
    public String getStreet() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getStreet();
    }

    /**
     * Getter for number.
     *
     * @return String containing number of the User.
     */
    public String getNumber() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getNumber();
    }

    /**
     * Getter for zipcode.
     *
     * @return String containing zipcode of the User.
     */
    public String getZip() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getZip();
    }

    /**
     * Getter for city.
     *
     * @return String containing city of the User.
     */
    public String getCity() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getCity();
    }

    /**
     * Getter for country.
     *
     * @return String containing country of the User.
     */
    public String getCountry() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getCountry();
    }

    /**
     * Getter for rolename which the User is in.
     *
     * @return String containing rolename of the User.
     */
    public String getRole() {
        User user = yahtzeeController.findUser(username);
        return user.getRole().getName();
    }
}

