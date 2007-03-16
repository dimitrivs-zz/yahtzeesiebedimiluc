/**
 * ScoreAspect.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.remoteObjects.game;

public class ScoreAspect implements java.io.Serializable {
    private java.lang.String description;

    private boolean fixed;

    private int points;

    public ScoreAspect() {
    }

    public ScoreAspect(
            java.lang.String description,
            boolean fixed,
            int points) {
        this.description = description;
        this.fixed = fixed;
        this.points = points;
    }


    /**
     * Gets the description value for this ScoreAspect.
     *
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this ScoreAspect.
     *
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }


    /**
     * Gets the fixed value for this ScoreAspect.
     *
     * @return fixed
     */
    public boolean isFixed() {
        return fixed;
    }


    /**
     * Sets the fixed value for this ScoreAspect.
     *
     * @param fixed
     */
    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }


    /**
     * Gets the points value for this ScoreAspect.
     *
     * @return points
     */
    public int getPoints() {
        return points;
    }


    /**
     * Sets the points value for this ScoreAspect.
     *
     * @param points
     */
    public void setPoints(int points) {
        this.points = points;
    }

    private java.lang.Object __equalsCalc = null;

    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ScoreAspect)) return false;
        ScoreAspect other = (ScoreAspect) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.description == null && other.getDescription() == null) ||
                        (this.description != null &&
                                this.description.equals(other.getDescription()))) &&
                this.fixed == other.isFixed() &&
                this.points == other.getPoints();
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
        if (getDescription() != null) {
            _hashCode += getDescription().hashCode();
        }
        _hashCode += (isFixed() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += getPoints();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(ScoreAspect.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://game.remoteObjects.yahtzee.kdg.be", "ScoreAspect"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("description");
        elemField.setXmlName(new javax.xml.namespace.QName("", "description"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fixed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fixed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("points");
        elemField.setXmlName(new javax.xml.namespace.QName("", "points"));
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
