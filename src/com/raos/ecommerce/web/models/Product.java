package com.raos.ecommerce.web.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@NamedQuery(name = "Product.findAll", query = "from Product")
public class Product {

	private String name;
	
	@Id
	private String productID; // UUID in string form
	
	@PrePersist
	public void init() {
		productID = UUID.randomUUID().toString();
	}
	
	// TODO: Work and create an archiving system rather than delete
	//@Column(name = "is_archived")
	//private boolean archived = false;
	
	@Lob
	private String description;

	private double price;
	
	@Column(name = "number_in_stock")
	private long numberInStock;
	
	private String image;
	
	// TODO: one to many review, if sql likes maps or hibernate has a mapping for it
	
	// TODO: many to many orders

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getNumberInStock() {
		return numberInStock;
	}

	public void setNumberInStock(long numberInStock) {
		this.numberInStock = numberInStock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

//	public boolean isArchived() {
//		return archived;
//	}
//
//	public void setArchived(boolean archived) {
//		this.archived = archived;
//	}
	

}
