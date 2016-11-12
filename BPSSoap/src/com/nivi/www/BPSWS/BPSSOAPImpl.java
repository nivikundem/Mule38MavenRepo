/**
 * BPSSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nivi.www.BPSWS;
//http://localhost:8080/BPSSoap/services/BPSPort?wsdl
public class BPSSOAPImpl implements com.nivi.www.BPSWS.BPSWS_PortType{
    public com.nivi.www.BPSWS.BpsDetailsType sendBPSDetails(com.nivi.www.BPSWS.BpLoadType BPLoad) throws java.rmi.RemoteException {
        com.nivi.www.BPSWS.BpLoadType bpl = BPLoad;     
        com.nivi.www.BPSWS.BpsDetailsType bdt = new BpsDetailsType();    
        System.out.println(bpl.getBPLoadList().getBP().getAmount());
        System.out.println(bpl.getBPLoadList().getBP().getFirstName());     
        bdt.setStatus("Processed");
        bdt.setTransactionNumber(bpl.getBPLoadList().getBP().getTransactionNumber());     
        
        return bdt;
    }

}
