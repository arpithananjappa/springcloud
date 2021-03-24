package com.innominds.model;

import javax.persistence.Id;


public class Payment {
	//@Id
	private String id;
	private String paymentStatus;
	private String paymentThrough;
	private String price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentThrough() {
		return paymentThrough;
	}
	public void setPaymentThrough(String paymentThrough) {
		this.paymentThrough = paymentThrough;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Payment() {
		super();
	}
	public Payment(String id, String paymentStatus, String paymentThrough, String price) {
		super();
		this.id = id;
		this.paymentStatus = paymentStatus;
		this.paymentThrough = paymentThrough;
		this.price = price;
	}
	
	
	

}
