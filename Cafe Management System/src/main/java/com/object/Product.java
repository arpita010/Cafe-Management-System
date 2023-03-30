package com.object;

public class Product {
	String PID;
	String name;
	String category;
	String price;
	String description;
	String cID;
	public String getPID() {
		return PID;
	}
	public String getName() {
		return name;
	}
	public String getCategory() {
		return category;
	}
	public String getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public String getcID() {
		return cID;
	}
	public void setPID(String pID) {
		PID = pID;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setcID(String cID) {
		this.cID = cID;
	}
}
