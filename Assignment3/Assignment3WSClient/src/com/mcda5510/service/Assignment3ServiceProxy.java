package com.mcda5510.service;

public class Assignment3ServiceProxy implements com.mcda5510.service.Assignment3Service {
  private String _endpoint = null;
  private com.mcda5510.service.Assignment3Service assignment3Service = null;
  
  public Assignment3ServiceProxy() {
    _initAssignment3ServiceProxy();
  }
  
  public Assignment3ServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAssignment3ServiceProxy();
  }
  
  private void _initAssignment3ServiceProxy() {
    try {
      assignment3Service = (new com.mcda5510.service.Assignment3ServiceServiceLocator()).getAssignment3Service();
      if (assignment3Service != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)assignment3Service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)assignment3Service)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (assignment3Service != null)
      ((javax.xml.rpc.Stub)assignment3Service)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.mcda5510.service.Assignment3Service getAssignment3Service() {
    if (assignment3Service == null)
      _initAssignment3ServiceProxy();
    return assignment3Service;
  }
  
  public java.lang.String insertTrxns(int ID, java.lang.String nameOnCard, java.lang.String cardNumber, double unitPrice, int qty, double totalPrice, java.lang.String expDate) throws java.rmi.RemoteException{
    if (assignment3Service == null)
      _initAssignment3ServiceProxy();
    return assignment3Service.insertTrxns(ID, nameOnCard, cardNumber, unitPrice, qty, totalPrice, expDate);
  }
  
  public java.lang.String selectTrxns() throws java.rmi.RemoteException{
    if (assignment3Service == null)
      _initAssignment3ServiceProxy();
    return assignment3Service.selectTrxns();
  }
  
  public java.lang.String removeTrxns(java.lang.String ID) throws java.rmi.RemoteException{
    if (assignment3Service == null)
      _initAssignment3ServiceProxy();
    return assignment3Service.removeTrxns(ID);
  }
  
  public java.lang.String updateTrxns(java.lang.String ID, java.lang.String nameOnCard, java.lang.String cardNumber, java.lang.String unitPrice, java.lang.String qty, java.lang.String totalPrice, java.lang.String expDate) throws java.rmi.RemoteException{
    if (assignment3Service == null)
      _initAssignment3ServiceProxy();
    return assignment3Service.updateTrxns(ID, nameOnCard, cardNumber, unitPrice, qty, totalPrice, expDate);
  }
  
  
}