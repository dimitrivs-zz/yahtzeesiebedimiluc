/**
 * YahtzeeControllerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.model.remoteObjects;

public class YahtzeeControllerServiceLocator extends org.apache.axis.client.Service implements be.kdg.yahtzee.model.remoteObjects.YahtzeeControllerService {

    public YahtzeeControllerServiceLocator() {
    }


    public YahtzeeControllerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public YahtzeeControllerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for yahtzee
    private java.lang.String yahtzee_address = "http://localhost:8080/axis/services/yahtzee";

    public java.lang.String getyahtzeeAddress() {
        return yahtzee_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String yahtzeeWSDDServiceName = "yahtzee";

    public java.lang.String getyahtzeeWSDDServiceName() {
        return yahtzeeWSDDServiceName;
    }

    public void setyahtzeeWSDDServiceName(java.lang.String name) {
        yahtzeeWSDDServiceName = name;
    }

    public be.kdg.yahtzee.model.remoteObjects.YahtzeeController getyahtzee() throws javax.xml.rpc.ServiceException {
        java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(yahtzee_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getyahtzee(endpoint);
    }

    public be.kdg.yahtzee.model.remoteObjects.YahtzeeController getyahtzee(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            be.kdg.yahtzee.model.remoteObjects.YahtzeeSoapBindingStub _stub = new be.kdg.yahtzee.model.remoteObjects.YahtzeeSoapBindingStub(portAddress, this);
            _stub.setPortName(getyahtzeeWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setyahtzeeEndpointAddress(java.lang.String address) {
        yahtzee_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (be.kdg.yahtzee.model.remoteObjects.YahtzeeController.class.isAssignableFrom(serviceEndpointInterface)) {
                be.kdg.yahtzee.model.remoteObjects.YahtzeeSoapBindingStub _stub = new be.kdg.yahtzee.model.remoteObjects.YahtzeeSoapBindingStub(new java.net.URL(yahtzee_address), this);
                _stub.setPortName(getyahtzeeWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("yahtzee".equals(inputPortName)) {
            return getyahtzee();
        } else {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "YahtzeeControllerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://remoteObjects.model.yahtzee.kdg.be", "yahtzee"));
        }
        return ports.iterator();
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {

        if ("yahtzee".equals(portName)) {
            setyahtzeeEndpointAddress(address);
        } else { // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
     * Set the endpoint address for the specified port name.
     */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
