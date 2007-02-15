package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.users.User;

import java.util.List;

public interface UserDao {
    
    public User getUser(int userId);

    public void saveUser(User user);

    public void deleteUser(User user);

    public List getUsers();
    
}
