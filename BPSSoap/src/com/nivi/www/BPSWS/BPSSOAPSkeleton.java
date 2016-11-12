/**
 * BPSSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nivi.www.BPSWS;

public class BPSSOAPSkeleton implements com.nivi.www.BPSWS.BPSWS_PortType, org.apache.axis.wsdl.Skeleton {
    private com.nivi.www.BPSWS.BPSWS_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "BPLoad"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.nivi.com/BPSWS/", "bpLoadType"), com.nivi.www.BPSWS.BpLoadType.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("sendBPSDetails", _params, new javax.xml.namespace.QName("", "bpsDetailsResponse"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.nivi.com/BPSWS/", "bpsDetailsType"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://www.nivi.com/BPSWS/", "sendBPSDetails"));
        _oper.setSoapAction("urn:SendBPSDetails");
        _myOperationsList.add(_oper);
        if (_myOperations.get("sendBPSDetails") == null) {
            _myOperations.put("sendBPSDetails", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("sendBPSDetails")).add(_oper);
    }

    public BPSSOAPSkeleton() {
        this.impl = new com.nivi.www.BPSWS.BPSSOAPImpl();
    }

    public BPSSOAPSkeleton(com.nivi.www.BPSWS.BPSWS_PortType impl) {
        this.impl = impl;
    }
    public com.nivi.www.BPSWS.BpsDetailsType sendBPSDetails(com.nivi.www.BPSWS.BpLoadType BPLoad) throws java.rmi.RemoteException
    {
        com.nivi.www.BPSWS.BpsDetailsType ret = impl.sendBPSDetails(BPLoad);
        return ret;
    }

}
