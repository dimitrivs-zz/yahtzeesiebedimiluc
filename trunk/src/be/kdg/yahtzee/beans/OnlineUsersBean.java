package be.kdg.yahtzee.beans;

import be.kdg.yahtzee.model.YahtzeeController;
import be.kdg.yahtzee.model.users.Address;
import be.kdg.yahtzee.model.users.User;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Eigenaar
 * Date: 30-jan-2007
 * Time: 21:03:03
 * To change this template use File | Settings | File Templates.
 */
public class OnlineUsersBean {
    private List<User> onlineUsers;

    public OnlineUsersBean() {
        onlineUsers = new ArrayList<User>();
    }

    public List<User> getUsers() {
        return onlineUsers;
    }

    public void addUser(User user) {
        onlineUsers.add(user)     ;
    }

    public void removeUser(User user) {
        onlineUsers.remove(user)     ;
    }

}

