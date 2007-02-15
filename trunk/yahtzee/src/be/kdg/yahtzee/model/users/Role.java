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

    public String toString() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (roleId != role.roleId) return false;
        if (!name.equals(role.name)) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = roleId;
        result = 31 * result + name.hashCode();
        return result;
    }
}
