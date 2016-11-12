/**
 * BPSWS_Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nivi.www.BPSWS;

public interface BPSWS_Service extends javax.xml.rpc.Service {
    public java.lang.String getBPSPortAddress();

    public com.nivi.www.BPSWS.BPSWS_PortType getBPSPort() throws javax.xml.rpc.ServiceException;

    public com.nivi.www.BPSWS.BPSWS_PortType getBPSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
