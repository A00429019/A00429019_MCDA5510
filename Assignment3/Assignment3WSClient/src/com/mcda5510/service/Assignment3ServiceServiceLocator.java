/**
 * Assignment3ServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mcda5510.service;

public class Assignment3ServiceServiceLocator extends org.apache.axis.client.Service implements com.mcda5510.service.Assignment3ServiceService {

    public Assignment3ServiceServiceLocator() {
    }


    public Assignment3ServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Assignment3ServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Assignment3Service
    private java.lang.String Assignment3Service_address = "http://localhost:8080/Assignment3WS/services/Assignment3Service";

    public java.lang.String getAssignment3ServiceAddress() {
        return Assignment3Service_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Assignment3ServiceWSDDServiceName = "Assignment3Service";

    public java.lang.String getAssignment3ServiceWSDDServiceName() {
        return Assignment3ServiceWSDDServiceName;
    }

    public void setAssignment3ServiceWSDDServiceName(java.lang.String name) {
        Assignment3ServiceWSDDServiceName = name;
    }

    public com.mcda5510.service.Assignment3Service getAssignment3Service() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Assignment3Service_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAssignment3Service(endpoint);
    }

    public com.mcda5510.service.Assignment3Service getAssignment3Service(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.mcda5510.service.Assignment3ServiceSoapBindingStub _stub = new com.mcda5510.service.Assignment3ServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getAssignment3ServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAssignment3ServiceEndpointAddress(java.lang.String address) {
        Assignment3Service_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.mcda5510.service.Assignment3Service.class.isAssignableFrom(serviceEndpointInterface)) {
                com.mcda5510.service.Assignment3ServiceSoapBindingStub _stub = new com.mcda5510.service.Assignment3ServiceSoapBindingStub(new java.net.URL(Assignment3Service_address), this);
                _stub.setPortName(getAssignment3ServiceWSDDServiceName());
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
        if ("Assignment3Service".equals(inputPortName)) {
            return getAssignment3Service();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.mcda5510.com", "Assignment3ServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.mcda5510.com", "Assignment3Service"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Assignment3Service".equals(portName)) {
            setAssignment3ServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
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
