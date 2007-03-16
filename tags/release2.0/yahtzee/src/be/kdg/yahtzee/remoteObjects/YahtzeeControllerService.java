/**
 * YahtzeeControllerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package be.kdg.yahtzee.remoteObjects;

public interface YahtzeeControllerService extends javax.xml.rpc.Service {
    public java.lang.String getyahtzeeAddress();

    public be.kdg.yahtzee.remoteObjects.YahtzeeController getyahtzee() throws javax.xml.rpc.ServiceException;

    public be.kdg.yahtzee.remoteObjects.YahtzeeController getyahtzee(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
