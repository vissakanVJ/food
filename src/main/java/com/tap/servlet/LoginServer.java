package com.tap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.daoimp.UserDaoImp;
import com.tap.model.User;

/**
 * Servlet implementation class LoginServer
 */
@WebServlet("/loginn")
public class LoginServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		UserDaoImp userimp = new UserDaoImp();
		User user = userimp.getUser(email);
		if(user == null) {
			request.setAttribute("error","Invalid Email." );
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			String p = user.getPassword();
			if(password.equals(p)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", user.getName());
				session.setAttribute("userid", user.getId());
				request.getRequestDispatcher("homepage").forward(request, response);
			}else {
				request.setAttribute("error","Invalid Password." );
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
	
	

}
