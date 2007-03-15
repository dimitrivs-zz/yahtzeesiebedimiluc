/**
 * Highscore.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.remoteObjects.game;

public class Highscore implements java.io.Serializable {
    private int highscoreId;

    private int score;

    private java.util.Calendar timestamp;

    private be.kdg.yahtzee.remoteObjects.users.User user;

    public Highscore() {
    }

    public Highscore(
            int highscoreId,
            int score,
            java.util.Calendar timestamp,
            be.kdg.yahtzee.remoteObjects.users.User user) {
        this.highscoreId = highscoreId;
        this.score = score;
        this.timestamp = timestamp;
        this.user = user;
    }


    /**
     * Gets the highscoreId value for this Highscore.
     *
     * @return highscoreId
     */
    public int getHighscoreId() {
        return highscoreId;
    }


    /**
     * Sets the highscoreId value for this Highscore.
     *
     * @param highscoreId
     */
    public void setHighscoreId(int highscoreId) {
        this.highscoreId = highscoreId;
    }


    /**
     * Gets the score value for this Highscore.
     *
     * @return score
     */
    public int getScore() {
        return score;
    }


    /**
     * Sets the score value for this Highscore.
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }


    /**
     * Gets the timestamp value for this Highscore.
     *
     * @return timestamp
     */
    public java.util.Calendar getTimestamp() {
        return timestamp;
    }


    /**
     * Sets the timestamp value for this Highscore.
     *
     * @param timestamp
     */
    public void setTimestamp(java.util.Calendar timestamp) {
        this.timestamp = timestamp;
    }


    /**
     * Gets the user value for this Highscore.
     *
     * @return user
     */
    public be.kdg.yahtzee.remoteObjects.users.User getUser() {
        return user;
    }


    /**
     * Sets the user value for this Highscore.
     *
     * @param user
     */
    public void setUser(be.kdg.yahtzee.remoteObjects.users.User user) {
        this.user = user;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Highscore)) return false;
        Highscore other = (Highscore) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.highscoreId == other.getHighscoreId() &&
                this.score == other.getScore() &&
                ((this.timestamp == null && other.getTimestamp() == null) ||
                        (this.timestamp != null &&
                                this.timestamp.equals(other.getTimestamp()))) &&
                ((this.user == null && other.getUser() == null) ||
                        (this.user != null &&
                                this.user.equals(other.getUser())));
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
        _hashCode += getHighscoreId();
        _hashCode += getScore();
        if (getTimestamp() != null) {
            _hashCode += getTimestamp().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Highscore.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://game.remoteObjects.yahtzee.kdg.be", "Highscore"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("highscoreId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "highscoreId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("score");
        elemField.setXmlName(new javax.xml.namespace.QName("", "score"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timestamp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timestamp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "user"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://users.remoteObjects.yahtzee.kdg.be", "User"));
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
