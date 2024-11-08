package com.tap.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.dao.RestaurantDao;
import com.tap.dbutil.DbUtil;
import com.tap.model.Restaurant;

//restaurantid, restaurantname, deliverytime, cuisinetype, address, rating, isactive, adminid, imagepath

public class RestaurantDaoImp implements RestaurantDao {
	
	private static final String ADD_RESTAURANT_QUERY = "insert into restaurants (restaurantname, "
   + "deliverytime, cuisinetype, address, rating, isactive, adminid, imagepath) values(?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String GET_ALL_RESTAURANTS = "select * from restaurants";
	private static final String GET_RESTAURANT = "select * from restaurants where restaurantname = ? ";
	
	private static final String UPDATE_RESTAURANT = " update restaurants set deliverytime = ?, cuisinetype = ?,"
			+ " address = ?, rating = ?, isactive = ?, adminid = ?, imagepath = ? where restaurantname = ?";
	
	private static final String DELETE_RESTAURANT = "delete from restaurants where restaurantname = ?";
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	
	public RestaurantDaoImp() {
		try {
			con = DbUtil.myConnect();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public int addRestaurant(Restaurant r) {
		try {
			pstmt = con.prepareStatement(ADD_RESTAURANT_QUERY);
			pstmt.setString(1, r.getRestaurantName());
			pstmt.setInt(2, r.getDeliveryTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setString(4, r.getAddress());
			pstmt.setDouble(5, r.getRating());
			pstmt.setInt(6, r.isActive());
			pstmt.setInt(7, r.getAdminId());
			pstmt.setString(8, r.getImagePath());
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Restaurant> getAllRestaurant() {
		try {
			stmt = con.createStatement();
			 res = stmt.executeQuery(GET_ALL_RESTAURANTS);
			 while(res.next()) {
				 restaurantList.add(new Restaurant(res.getInt("restaurantid"),
						 res.getString("restaurantname"),
						 res.getInt("deliverytime"),
						 res.getString("cuisinetype"),
						 res.getString("address"),
						 res.getFloat("rating"),
						 res.getInt("isactive"),
						 res.getInt("adminid"),
						 res.getString("imagepath")
						 ));
			 }
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return restaurantList;
	}

	@Override
	public Restaurant getRestaurant(String restaurantName) {
		try {
			 pstmt = con.prepareStatement(GET_RESTAURANT);
			 pstmt.setString(1, restaurantName);
			 res = pstmt.executeQuery();
			 res.next();
			 return new Restaurant(res.getInt("restaurantid"),
					 res.getString("restaurantname"),
					 res.getInt("deliverytime"),
					 res.getString("cuisinetype"),
					 res.getString("address"),
					 res.getFloat("rating"),
					 res.getInt("isactive"),
					 res.getInt("adminid"),
					 res.getString("imagepath")
					 );
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateRestaurant(Restaurant r) {
		try {
			pstmt = con.prepareStatement(UPDATE_RESTAURANT);
			pstmt.setInt(1, r.getDeliveryTime());
			pstmt.setString(2, r.getCuisineType());
			pstmt.setString(3, r.getAddress());
			pstmt.setDouble(4, r.getRating());
			pstmt.setInt(5, r.isActive());
			pstmt.setInt(6, r.getAdminId());
			pstmt.setString(7, r.getImagePath());
			pstmt.setString(8, r.getRestaurantName());
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(String restaurantName) {
		try {
			pstmt = con.prepareStatement(DELETE_RESTAURANT);
			pstmt.setString(1,restaurantName );
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
