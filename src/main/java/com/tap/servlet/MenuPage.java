package com.tap.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.tap.daoimp.MenuDaoImp;
import com.tap.model.Menu;

/**
 * Servlet implementation class MenuPage
 */
@WebServlet("/menu")
public class MenuPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Menu> list = new ArrayList<Menu>();
		int res = Integer.parseInt(request.getParameter("res"));
		MenuDaoImp menu = new MenuDaoImp();
		list = menu.getAllMenu(res);
		HttpSession session = request.getSession();
		session.setAttribute("menu", list);
		response.sendRedirect("menu.jsp");
	}

	

}
