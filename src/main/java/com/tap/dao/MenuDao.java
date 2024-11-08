package com.tap.dao;

import java.util.ArrayList;

import com.tap.model.Menu;

public interface MenuDao {
	
	public abstract ArrayList<Menu> getAllMenu(int id);

}