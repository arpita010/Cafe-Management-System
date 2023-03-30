package com.object;

public class Bill {
	String billNumber;
	String orderID;
	String customerName;
	String contactNumber;
	String email;
	String paymentMode;
	String items;
	String total;
	String userID;
	
	public String getBillNumber() {
		return billNumber;
	}
	public String getOrderID() {
		return orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public String getItems() {
		return items;
	}
	public String getTotal() {
		return total;
	}
	public String getUserID() {
		return userID;
	}
	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
