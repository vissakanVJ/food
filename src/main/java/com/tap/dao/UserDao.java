package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.User;

public interface UserDao{
		

		int addUser(User u);
		ArrayList<User> getAllUser();
		User getUser(String email);
		int updateUser(User u);
		int deleteUser(String email);
	
	}
