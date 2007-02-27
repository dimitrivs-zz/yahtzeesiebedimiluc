/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.users;

public class Role {
    private int roleId;
    private String name;

    Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public int getRoleId() {
        return roleId;
    }

    private void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return name.equals(role.name);

    }
    /*
    @Override
    public int hashCode() {
        int result;
        result = roleId;
        result = 31 * result + name.hashCode();
        return result;
    } */
}
