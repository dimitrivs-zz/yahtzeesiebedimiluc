/*
Exeption handeling: OK
Logging: te kleine klasse om te loggen
Java 5: OK
Refacorting: nullPerson
Testen: OK
 */

package be.kdg.yahtzee.model.users;

public class Person {
    public static final Person NULL_PERSON = new Person("null");

    private String surname;
    private String firstName;
    private String email;
    private Address address;
    private String telephone;

    Person() {
    }

    private Person(String nullPerson) {
        this.surname = "surname";
        this.firstName = "firstname";
        this.email = "email";
        this.telephone = "telephone";
        this.address = Address.NULL_ADDRESS;
    }

    public Person(String surname, String firstName, String email, Address address, String telephone) {
        this.surname = surname;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return firstName + " " + surname;
    }
}
