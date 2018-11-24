/**
 * Assignment3Service.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.mcda5510.service;

public interface Assignment3Service extends java.rmi.Remote {
    public java.lang.String insertTrxns(int ID, java.lang.String nameOnCard, java.lang.String cardNumber, double unitPrice, int qty, double totalPrice, java.lang.String expDate) throws java.rmi.RemoteException;
    public java.lang.String selectTrxns() throws java.rmi.RemoteException;
    public java.lang.String removeTrxns(java.lang.String ID) throws java.rmi.RemoteException;
    public java.lang.String updateTrxns(java.lang.String ID, java.lang.String nameOnCard, java.lang.String cardNumber, java.lang.String unitPrice, java.lang.String qty, java.lang.String totalPrice, java.lang.String expDate) throws java.rmi.RemoteException;
}
