package com.cg.onlinefooddelivery.app.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
@Entity
public class Item {

	/**
	 * id of item
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	/**
	 * name of item
	 */
	@NotBlank(message = "Name Required")
	private String itemName;
//	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
//	@JoinColumn(name="category_id")
//	private Category category;
	/**
	 * quantity of item
	 */
	private int quantity;
//	public Category getCategory() {
//		return category;
//	}
//	public void setCategory(Category category) {
//		this.category = category;
//	}
	
	//Many to one relationship
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cart_id", updatable = false, nullable = false)
	private FoodCart foodCart;
	/**
	 * cost of item
	 */
	private double cost;
	

	
	public FoodCart getFoodCart() {
		return foodCart;
	}
	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
