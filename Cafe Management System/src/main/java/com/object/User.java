package com.object;

public class User {
	String userID;
	String name;
	String contactNumber;
	String email;
	String password;
	String userType;
	String adminCard;
	public String getAdminCard() {
		return adminCard;
	}
	public void setAdminCard(String adminCard) {
		this.adminCard = adminCard;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getName() {
		return name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
