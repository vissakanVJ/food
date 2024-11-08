package com.tap.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimp.RestaurantDaoImp;
import com.tap.model.Restaurant;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/homepage")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		ArrayList<Restaurant> restaurantlist = new RestaurantDaoImp().getAllRestaurant();
		HttpSession session = request.getSession();
		session.setAttribute("restaurantlist", restaurantlist);
		System.out.print(session.getAttribute("username"));
		response.sendRedirect("Success.jsp");
	}


}
