package com.tap.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tap.dao.MenuDao;
import com.tap.dbutil.DbUtil;
import com.tap.model.Menu;

public class MenuDaoImp implements MenuDao {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	
	public MenuDaoImp() {
		 this.con =  DbUtil.myConnect();
	}

	public ArrayList<Menu> getAllMenu(int id) {
		ArrayList<Menu> list = new ArrayList<Menu>();
		try {
			
			pstmt = con.prepareStatement("select * from menu where restaurantid = ?");
			pstmt.setInt(1, id);
			res = pstmt.executeQuery();
			while(res.next()) {
				list.add(new Menu(res.getInt("menuid"), res.getInt("restaurantid"), res.getString("itemname"), res.getString("description"), res.getInt("price"), false));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
}
