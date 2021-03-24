package com.innominds.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="orderservice")

public class Order {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	private String name;
	private String quantity;
	private String price;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Order() {
		super();
	}
	/*public Order(OrderDocument orderdoc) {
		super();
		this.id = orderdoc.getId();
		this.name = orderdoc.getName();
		this.quantity = orderdoc.getQuantity();
		this.price = orderdoc.getPrice();
	}*/
	public Order(String id, String name, String quantity, String price) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	

}
