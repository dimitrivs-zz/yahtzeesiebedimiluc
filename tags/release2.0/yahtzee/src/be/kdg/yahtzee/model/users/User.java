/*
 * Project Software Development
 * Karel de Grote-Hogeschool
 * 2006-2007
 *
 */

package be.kdg.yahtzee.model.users;


public class User {
    public static final User NULL_USER = new User("null");

    private int userId;
    private Person person;
    private String username;
    private String password;
    private Role role;
    private boolean online;
    private boolean blocked;

    User() {
    }

    public User(String nullUser) {
        this.person = Person.NULL_PERSON;
        this.username = "username";
        this.password = "password";
        this.role = new Role("no role");
        this.online = false;
        this.blocked = true;
    }

    public User(String username, String encryptedPassword, String surname, String firstName, String email, String telephone, Role role, Address address) {
        this.person = new Person(surname, firstName, email, address, telephone);
        this.username = username;
        this.password = encryptedPassword;
        this.role = role;
        blocked = false;
    }

    public int getUserId() {
        return userId;
    }


    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    private void setUserId(int userId) {
        this.userId = userId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSurname() {
        return this.getPerson().getSurname();
    }

    public void setSurname(String surname) {
        this.getPerson().setSurname(surname);
    }

    public String getFirstname() {
        return this.getPerson().getFirstName();
    }

    public void setFirstname(String firstName) {
        this.getPerson().setFirstName(firstName);
    }

    public Address getAddress() {
        return this.getPerson().getAddress();
    }

    public void setAddress(Address address) {
        this.person.setAddress(address);
    }

    public String getEmail() {
        return this.getPerson().getEmail();
    }

    public void setEmail(String mail) {
        this.person.setEmail(mail);
    }

    public String getTelephone() {
        return this.person.getTelephone();
    }

    public void setTelephone(String telephone) {
        this.person.setTelephone(telephone);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    public Role getRole() {
        return role;
    }

    public String toString() {
        return userId + " " + username;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return username.equals(user.username);

    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
