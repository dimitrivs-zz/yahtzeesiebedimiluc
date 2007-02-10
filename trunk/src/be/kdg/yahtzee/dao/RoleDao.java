package be.kdg.yahtzee.dao;

import be.kdg.yahtzee.model.users.Role;

import java.util.List;

public interface RoleDao {

    public Role getRole(int roleId);

    public void saveRole(Role role);

    public void deleteRole(Role role);

    public List getRoles();

}
