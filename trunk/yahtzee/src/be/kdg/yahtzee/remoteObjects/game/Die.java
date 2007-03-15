/**
 * Die.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.remoteObjects.game;

public class Die implements java.io.Serializable {
    private boolean diceFixed;

    private boolean dieFixed;

    private int dieId;

    private int value;

    public Die() {
    }

    public Die(
            boolean diceFixed,
            boolean dieFixed,
            int dieId,
            int value) {
        this.diceFixed = diceFixed;
        this.dieFixed = dieFixed;
        this.dieId = dieId;
        this.value = value;
    }


    /**
     * Gets the diceFixed value for this Die.
     *
     * @return diceFixed
     */
    public boolean isDiceFixed() {
        return diceFixed;
    }


    /**
     * Sets the diceFixed value for this Die.
     *
     * @param diceFixed
     */
    public void setDiceFixed(boolean diceFixed) {
        this.diceFixed = diceFixed;
    }


    /**
     * Gets the dieFixed value for this Die.
     *
     * @return dieFixed
     */
    public boolean isDieFixed() {
        return dieFixed;
    }


    /**
     * Sets the dieFixed value for this Die.
     *
     * @param dieFixed
     */
    public void setDieFixed(boolean dieFixed) {
        this.dieFixed = dieFixed;
    }


    /**
     * Gets the dieId value for this Die.
     *
     * @return dieId
     */
    public int getDieId() {
        return dieId;
    }


    /**
     * Sets the dieId value for this Die.
     *
     * @param dieId
     */
    public void setDieId(int dieId) {
        this.dieId = dieId;
    }


    /**
     * Gets the value value for this Die.
     *
     * @return value
     */
    public int getValue() {
        return value;
    }


    /**
     * Sets the value value for this Die.
     *
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Die)) return false;
        Die other = (Die) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                this.diceFixed == other.isDiceFixed() &&
                this.dieFixed == other.isDieFixed() &&
                this.dieId == other.getDieId() &&
                this.value == other.getValue();
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
        _hashCode += (isDiceFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isDieFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getDieId();
        _hashCode += getValue();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(Die.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://game.remoteObjects.yahtzee.kdg.be", "Die"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("diceFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "diceFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dieFixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dieFixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dieId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dieId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
