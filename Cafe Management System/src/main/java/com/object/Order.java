package com.object;

public class Order {
	String OrderID;
	String customerName;
	String ContactNumber;
	String Email;
	String paymentMode;
	String items;
	String total;
	String userID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getOrderID() {
		return OrderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getContactNumber() {
		return ContactNumber;
	}
	public String getEmail() {
		return Email;
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
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}
	public void setEmail(String email) {
		Email = email;
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
}
