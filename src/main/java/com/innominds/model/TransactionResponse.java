package com.innominds.model;

public class TransactionResponse {
	private Order order;
	private String price;
	private String paymentStatus;
	private String paymentThrough;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public TransactionResponse() {
		super();
	}
	public TransactionResponse(Order order, String price, String paymentStatus, String paymentThrough) {
		super();
		this.order = order;
		this.price = price;
		this.paymentStatus = paymentStatus;
		this.paymentThrough = paymentThrough;
	}
	
	

}
