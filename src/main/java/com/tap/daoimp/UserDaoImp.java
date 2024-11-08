package com.tap.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.dao.UserDao;
import com.tap.dbutil.DbUtil;
import com.tap.model.User;

 public class UserDaoImp implements UserDao {
	
	private static final String ADD_USER_QUERY = "insert into user (username, email, phone, password, address)"
			+ " values(?, ?, ?, ?, ?)";
	private static final String GET_ALL_USERS = "select * from user";
	private static final String GET_USER = "select * from user where email = ? ";
	private static final String UPDATE_USER = " update user set username = ?,phone = ?,"
			+ "password = ?,address = ? where email = ?";
	private static final String DELETE_USER = "delete from user where email = ? ";
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private ArrayList<User> userList;
	int status;
	
	public UserDaoImp() {
		try {
			con = DbUtil.myConnect();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int addUser(User u) {
		
		try {
			pstmt = con.prepareStatement(ADD_USER_QUERY);
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getPhoneNumber());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getAddress());
			status =pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}

	@Override
	public ArrayList<User> getAllUser() {
	 try {
		 stmt = con.createStatement();
		 res = stmt.executeQuery(GET_ALL_USERS);
		 while(res.next()) {
			 userList.add(new User(res.getInt("userid"),
					 res.getString("username"),
					 res.getString("email"),
					 res.getString("phone"),
					 res.getString("password"),
					 res.getString("address")
					 ));
		 }
		 
	 } catch(Exception e) {
		 e.printStackTrace();
	 }
	 return userList;
		
	}

	@Override
	public User getUser(String email) {
		try {
			 pstmt = con.prepareStatement(GET_USER);
			 pstmt.setString(1, email);
			 res = pstmt.executeQuery();
			 res.next();
			 return new User(res.getInt("userid"),
					 res.getString("username"),
					 res.getString("email"),
					 res.getString("phone"),
					 res.getString("password"),
					 res.getString("address"));
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		return null;
		
	}

	@Override
	public int updateUser(User u) {
		try {
			 pstmt = con.prepareStatement(UPDATE_USER);
			 pstmt.setString(1, u.getName());
			 pstmt.setString(2, u.getPhoneNumber());
			 pstmt.setString(3, u.getPassword());
			 pstmt.setString(4, u.getAddress());
			 pstmt.setString(5, u.getEmail());      
			 return pstmt.executeUpdate();
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		return 0;
	}

	@Override
	public int deleteUser(String email) {
		try {
			 pstmt = con.prepareStatement(DELETE_USER);
			 pstmt.setString(1, email);
			 return pstmt.executeUpdate();
			 
		 } catch(Exception e) {
			 e.printStackTrace();
		 }
		return 0; 
	}

}
