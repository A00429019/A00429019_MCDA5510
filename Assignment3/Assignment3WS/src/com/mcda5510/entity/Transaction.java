package com.mcda5510.entity;
public class Transaction {
	
	private Integer ID, qty;
	private Double UnitPrice, totalPrice;
	private String nameOnCard, cardNumber, ExpDate, createdBy, CreditCardType, createdOn;
	
	
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}	
	
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	
	
	public Double getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(Double UnitPrice) {
		this.UnitPrice = UnitPrice;
	}
	
	
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
	
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	public String getExpDate() {
		return ExpDate;
	}
	public void setExpDate(String ExpDate) {
		this.ExpDate = ExpDate;
	}
	
	
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}	
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}	
	
	
	public String getCreditCardType() {
		return CreditCardType;
	}
	public void setCreditCardType(String CreditCardType) {
		this.CreditCardType = CreditCardType;
	}

	
	public String toString(){
		
		String results = new String();
		
		results = "ID: " + ID + "\nNameOnCard: " + nameOnCard +"\nCardNumber: " + cardNumber + "\nUnitPrice: " + UnitPrice + "\nQuantity: " + qty + "\nTotalPrice: " + totalPrice + "\nExpDate: " + ExpDate + "\nCreatedOn: " + createdOn + "\nCreatedBy: " + createdBy + "\nCreditCardType: " + CreditCardType + "\n";
		return results;

	}
	
	
}
