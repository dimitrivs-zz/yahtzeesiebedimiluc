/**
 * User.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.remoteObjects.users;

public class User implements java.io.Serializable {
    private be.kdg.yahtzee.remoteObjects.users.Address address;

    private boolean blocked;

    private java.lang.String email;

    private java.lang.String firstname;

    private boolean online;

    private java.lang.String password;

    private be.kdg.yahtzee.remoteObjects.users.Person person;

    private be.kdg.yahtzee.remoteObjects.users.Role role;

    private java.lang.String surname;

    private java.lang.String telephone;

    private int userId;

    private java.lang.String username;

    public User() {
    }

    public User(
            be.kdg.yahtzee.remoteObjects.users.Address address,
            boolean blocked,
            java.lang.String email,
            java.lang.String firstname,
            boolean online,
            java.lang.String password,
            be.kdg.yahtzee.remoteObjects.users.Person person,
            be.kdg.yahtzee.remoteObjects.users.Role role,
            java.lang.String surname,
            java.lang.String telephone,
            int userId,
            java.lang.String username) {
        this.address = address;
        this.blocked = blocked;
        this.email = email;
        this.firstname = firstname;
        this.online = online;
        this.password = password;
        this.person = person;
        this.role = role;
        this.surname = surname;
        this.telephone = telephone;
        this.userId = userId;
        this.username = username;
    }


    /**
     * Gets the address value for this User.
     *
     * @return address
     */
    public be.kdg.yahtzee.remoteObjects.users.Address getAddress() {
        return address;
    }


    /**
     * Sets the address value for this User.
     *
     * @param address
     */
    public void setAddress(be.kdg.yahtzee.remoteObjects.users.Address address) {
        this.address = address;
    }


    /**
     * Gets the blocked value for this User.
     *
     * @return blocked
     */
    public boolean isBlocked() {
        return blocked;
    }


    /**
     * Sets the blocked value for this User.
     *
     * @param blocked
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }


    /**
     * Gets the email value for this User.
     *
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this User.
     *
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the firstname value for this User.
     *
     * @return firstname
     */
    public java.lang.String getFirstname() {
        return firstname;
    }


    /**
     * Sets the firstname value for this User.
     *
     * @param firstname
     */
    public void setFirstname(java.lang.String firstname) {
        this.firstname = firstname;
    }


    /**
     * Gets the online value for this User.
     *
     * @return online
     */
    public boolean isOnline() {
        return online;
    }


    /**
     * Sets the online value for this User.
     *
     * @param online
     */
    public void setOnline(boolean online) {
        this.online = online;
    }


    /**
     * Gets the password value for this User.
     *
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this User.
     *
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the person value for this User.
     *
     * @return person
     */
    public be.kdg.yahtzee.remoteObjects.users.Person getPerson() {
        return person;
    }


    /**
     * Sets the person value for this User.
     *
     * @param person
     */
    public void setPerson(be.kdg.yahtzee.remoteObjects.users.Person person) {
        this.person = person;
    }


    /**
     * Gets the role value for this User.
     *
     * @return role
     */
    public be.kdg.yahtzee.remoteObjects.users.Role getRole() {
        return role;
    }


    /**
     * Sets the role value for this User.
     *
     * @param role
     */
    public void setRole(be.kdg.yahtzee.remoteObjects.users.Role role) {
        this.role = role;
    }


    /**
     * Gets the surname value for this User.
     *
     * @return surname
     */
    public java.lang.String getSurname() {
        return surname;
    }


    /**
     * Sets the surname value for this User.
     *
     * @param surname
     */
    public void setSurname(java.lang.String surname) {
        this.surname = surname;
    }


    /**
     * Gets the telephone value for this User.
     *
     * @return telephone
     */
    public java.lang.String getTelephone() {
        return telephone;
    }


    /**
     * Sets the telephone value for this User.
     *
     * @param telephone
     */
    public void setTelephone(java.lang.String telephone) {
        this.telephone = telephone;
    }


    /**
     * Gets the userId value for this User.
     *
     * @return userId
     */
    public int getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this User.
     *
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }


    /**
     * Gets the username value for this User.
     *
     * @return username
     */
    public java.lang.String getUsername() {
        return username;
    }


    /**
     * Sets the username value for this User.
     *
     * @param username
     */
    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof User)) return false;
        User other = (User) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.address == null && other.getAddress() == null) ||
                        (this.address != null &&
                                this.address.equals(other.getAddress()))) &&
                this.blocked == other.isBlocked() &&
                ((this.email == null && other.getEmail() == null) ||
                        (this.email != null &&
                                this.email.equals(other.getEmail()))) &&
                ((this.firstname == null && other.getFirstname() == null) ||
                        (this.firstname != null &&
                                this.firstname.equals(other.getFirstname()))) &&
                this.online == other.isOnline() &&
                ((this.password == null && other.getPassword() == null) ||
                        (this.password != null &&
                                this.password.equals(other.getPassword()))) &&
                ((this.person == null && other.getPerson() == null) ||
                        (this.person != null &&
                                this.person.equals(other.getPerson()))) &&
                ((this.role == null && other.getRole() == null) ||
                        (this.role != null &&
                                this.role.equals(other.getRole()))) &&
                ((this.surname == null && other.getSurname() == null) ||
                        (this.surname != null &&
                                this.surname.equals(other.getSurname()))) &&
                ((this.telephone == null && other.getTelephone() == null) ||
                        (this.telephone != null &&
                                this.telephone.equals(other.getTelephone()))) &&
                this.userId == other.getUserId() &&
                ((this.username == null && other.getUsername() == null) ||
                        (this.username != null &&
                                this.username.equals(other.getUsername())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        _hashCode += (isBlocked() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getFirstname() != null) {
            _hashCode += getFirstname().hashCode();
        }
        _hashCode += (isOnline() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getPerson() != null) {
            _hashCode += getPerson().hashCode();
        }
        if (getRole() != null) {
            _hashCode += getRole().hashCode();
        }
        if (getSurname() != null) {
            _hashCode += getSurname().hashCode();
        }
        if (getTelephone() != null) {
            _hashCode += getTelephone().hashCode();
        }
        _hashCode += getUserId();
        if (getUsername() != null) {
            _hashCode += getUsername().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(User.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://users.remoteObjects.yahtzee.kdg.be", "User"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://users.remoteObjects.yahtzee.kdg.be", "Address"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blocked");
        elemField.setXmlName(new javax.xml.namespace.QName("", "blocked"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("online");
        elemField.setXmlName(new javax.xml.namespace.QName("", "online"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("person");
        elemField.setXmlName(new javax.xml.namespace.QName("", "person"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://users.remoteObjects.yahtzee.kdg.be", "Person"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("role");
        elemField.setXmlName(new javax.xml.namespace.QName("", "role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://users.remoteObjects.yahtzee.kdg.be", "Role"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("surname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "surname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("telephone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "telephone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("username");
        elemField.setXmlName(new javax.xml.namespace.QName("", "username"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanSerializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
            java.lang.String mechType,
            java.lang.Class _javaType,
            javax.xml.namespace.QName _xmlType) {
        return
                new org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

}
