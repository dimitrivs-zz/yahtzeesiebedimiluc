package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.User;

public class UserBean {
    private YahtzeeController yahtzeeController;
    private String username;

    public UserBean() {
    }

    public UserBean(YahtzeeController yahtzeeController, String username) {
        this.yahtzeeController = yahtzeeController;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        User user = yahtzeeController.findUser(username);
        return user.getUserId();
    }

    public String getName() {
        User user = yahtzeeController.findUser(username);
        return user.getFirstname() + " " + user.getSurname();
    }

    public String getSurname() {
        User user = yahtzeeController.findUser(username);
        return user.getSurname();
    }

    public String getFirstname() {
        User user = yahtzeeController.findUser(username);
        return user.getFirstname();
    }

    public String getPassword() {
        User user = yahtzeeController.findUser(username);
        return user.getPassword();
    }

    public String getEmail() {
        User user = yahtzeeController.findUser(username);
        return user.getPerson().getEmail();
    }

    public String getTelephone() {
        User user = yahtzeeController.findUser(username);
        return user.getPerson().getTelephone();
    }

    public String getStreet() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getStreet();
    }

    public String getNumber() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getNumber();
    }

    public String getZip() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getZip();
    }

    public String getCity() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getCity();
    }

    public String getCountry() {
        User user = yahtzeeController.findUser(username);
        return user.getAddress().getCountry();
    }

    public String getRole() {
        User user = yahtzeeController.findUser(username);
        return user.getRole().getName();
    }
}
