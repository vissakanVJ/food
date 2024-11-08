package com.tap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.dao.UserDao;
import com.tap.daoimp.UserDaoImp;
import com.tap.model.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/register")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("nm");
		String phone = request.getParameter("pn");
		String email = request.getParameter("em");
		String password = request.getParameter("ps");
		String address = request.getParameter("ad");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		session.setAttribute("phone", phone);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		session.setAttribute("address", address);
		
		User user = new User(username, email, phone, password, address);
		
		UserDao userdao  = new UserDaoImp();
		int status = userdao.addUser(user);
		
			if(status == 0) {
				response.sendRedirect("Fail.jsp");				
			}else {
				response.sendRedirect("login.jsp");				
			}
		
	}

}
