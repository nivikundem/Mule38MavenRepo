/**
 * BpLoadType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.nivi.www.BPSWS;

public class BpLoadType  implements java.io.Serializable {
    private java.lang.String dateGenerated;

    private com.nivi.www.BPSWS.BpLoadListType BPLoadList;

    public BpLoadType() {
    }

    public BpLoadType(
           java.lang.String dateGenerated,
           com.nivi.www.BPSWS.BpLoadListType BPLoadList) {
           this.dateGenerated = dateGenerated;
           this.BPLoadList = BPLoadList;
    }


    /**
     * Gets the dateGenerated value for this BpLoadType.
     * 
     * @return dateGenerated
     */
    public java.lang.String getDateGenerated() {
        return dateGenerated;
    }


    /**
     * Sets the dateGenerated value for this BpLoadType.
     * 
     * @param dateGenerated
     */
    public void setDateGenerated(java.lang.String dateGenerated) {
        this.dateGenerated = dateGenerated;
    }


    /**
     * Gets the BPLoadList value for this BpLoadType.
     * 
     * @return BPLoadList
     */
    public com.nivi.www.BPSWS.BpLoadListType getBPLoadList() {
        return BPLoadList;
    }


    /**
     * Sets the BPLoadList value for this BpLoadType.
     * 
     * @param BPLoadList
     */
    public void setBPLoadList(com.nivi.www.BPSWS.BpLoadListType BPLoadList) {
        this.BPLoadList = BPLoadList;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BpLoadType)) return false;
        BpLoadType other = (BpLoadType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dateGenerated==null && other.getDateGenerated()==null) || 
             (this.dateGenerated!=null &&
              this.dateGenerated.equals(other.getDateGenerated()))) &&
            ((this.BPLoadList==null && other.getBPLoadList()==null) || 
             (this.BPLoadList!=null &&
              this.BPLoadList.equals(other.getBPLoadList())));
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
        if (getDateGenerated() != null) {
            _hashCode += getDateGenerated().hashCode();
        }
        if (getBPLoadList() != null) {
            _hashCode += getBPLoadList().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BpLoadType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.nivi.com/BPSWS/", "bpLoadType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateGenerated");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DateGenerated"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BPLoadList");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BPLoadList"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.nivi.com/BPSWS/", "bpLoadListType"));
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
          new  org.apache.axis.encoding.ser.BeanSerializer(
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
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
