package com.tap.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class DbUtil {
	public static Connection myConnect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","vissakan");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
