package be.kdg.yahtzee.model.users;

public class User {
    private int userId;
    private Person person;
    private String username;
    private String password;
    private Role role;

    User() {
    }

    public User(String username, String encryptedPassword, String surname, String firstName, String email, String telephone, Role role, Address address) {
        this.person = new Person(surname, firstName, email, address, telephone);
        this.username = username;
        this.password = encryptedPassword;
        this.role = role;
    }

    public int getUserId() {
        return userId;
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

    public void setRole(Role role) {
        this.role = role;
    }
/*
    public boolean equals(Object o) {
        User test = (User)o;
        return username.equals(test.username);
    }

    public int hashCode() {
        int hash = 7;
        //hash = 31 * hash + userId;
        hash = 31 * hash + (null == username ? 0 : username.hashCode());
        return hash;
    }*/
    /*
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;

     User user = (User) o;

     if (userId != user.userId) return false;
     if (!username.equals(user.username)) return false;

     return true;
 }   */
    /*
public int hashCode() {
    int result;
    //result = ;
    result = 31 *  username.hashCode();
    return result;
}    */


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;

        return true;
    }

    public int hashCode() {
        return username.hashCode();
    }
}
