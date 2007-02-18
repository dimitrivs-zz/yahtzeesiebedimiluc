/*
Exeption handeling: OK
Logging: te kleine klasse om te loggen
Java 5: OK
Refacorting: OK
Testen: OK
 */

package be.kdg.yahtzee.model.users;

public class Address {
    public static final Address NULL_ADDRESS = new Address("no address", "", "", "", "");

    private String street;
    private String number;
    private String zip;
    private String city;
    private String country;

    Address() {
    }

    public Address(String street, String number, String zip, String city, String country) {
        this.street = street;
        this.number = number;
        this.zip = zip;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return street + " " + number + ", " + zip + " " + city + "(" + country + ")";
    }
}
