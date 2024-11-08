package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.Restaurant;

public interface RestaurantDao {
	int addRestaurant(Restaurant r);
	ArrayList<Restaurant> getAllRestaurant();
	Restaurant getRestaurant(String restaurantName);
	int updateRestaurant(Restaurant r);
	int deleteUser(String restaurantName);
}
