package com.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="restaurants")
public class Restaurant {
	@Id
	@Column(name="restaurantid")
	private int restaurantId;
	@Column(name="restaurantname")
	private String restaurantName;
	@Column(name="deliverytime")
	private int deliveryTime;
	@Column(name="cuisinetype")
	private String cuisineType;
	@Column(name="address")
	private String address;
	@Column(name="rating")
	private double rating;
	@Column(name="isactive")
	private int isActive;
	@Column(name="adminid")
	private int adminId;
	@Column(name="imagepath")
	private String imagePath;
	
	public Restaurant(int restaurantId, String restaurantName, int deliveryTime, String cuisineType, String address, double rating,
			int isActive, int adminId, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.adminId = adminId;
		this.imagePath = imagePath;
	}
	
	public Restaurant(String restaurantName, int deliveryTime, String cuisineType, String address, double rating,
			int isActive, int adminId, String imagePath) {
		super();
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.adminId = adminId;
		this.imagePath = imagePath;
	}
	
	public Restaurant() {
		
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int isActive() {
		return isActive;
	}

	public void setActive(int isActive) {
		this.isActive = isActive;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	
	
	
	
	
}
