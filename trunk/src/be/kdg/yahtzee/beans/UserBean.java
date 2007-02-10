package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 30-jan-2007
 * Time: 21:03:03
 * To change this template use File | Settings | File Templates.
 */
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

    public String getName() {
        User user = yahtzeeController.findUser(username);
        return user.getFirstname() + " " + user.getSurname();
    }

    public String getAddressAsHtml() {
        StringBuffer addressBuffer = new StringBuffer();
        Address address = yahtzeeController.getAddressOfUser(username);
        addressBuffer.append("<address>");
        addressBuffer.append(address.getStreet());
        addressBuffer.append(" ");
        addressBuffer.append(address.getNumber());
        addressBuffer.append("<br/>");
        addressBuffer.append(address.getZip());
        addressBuffer.append(" ");
        addressBuffer.append(address.getCity());
        addressBuffer.append("</address>");
        return addressBuffer.toString();
    }
}

