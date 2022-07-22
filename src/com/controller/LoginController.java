package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			UserDao dao  = new UserDao();
			UserBean user = dao.login(email, password);
			RequestDispatcher rs = null;
			if(email == null || email.trim().length()==0) {
				request.setAttribute("emailError","<font color = 'red'>Please Enter Email</font>");
			}else {
				request.setAttribute("email", email);
			}
			if(password == null || password.trim().length()==0) {
				request.setAttribute("passwordError","<font color = 'red'>Please Enter Password</font>");
			}else {
				request.setAttribute("password", password);
			}
			if(user==null) {
				request.setAttribute("errorMsg", "Invaliid Credentials ");
				request.setAttribute("eMsg", "Please Enter Correct Email && Password....");
					rs = request.getRequestDispatcher("Login.jsp");
					
			}
			else {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("userId", user.getUserId());
				httpSession.setAttribute("users", user);
				if(user.getUserType().equals("customer")) {
//					request.setAttribute("firstname", user.getFirstName());
//					request.setAttribute("lastname", user.getLastName());
//					request.setAttribute("email", user.getEmail());
					request.setAttribute("users", user);
					rs = request.getRequestDispatcher("CustDash.jsp");
				}else if (user.getUserType().equals("admin")) {
					request.setAttribute("users", user);
					rs = request.getRequestDispatcher("Dashboard.jsp");
				}
				else {
					rs = request.getRequestDispatcher("404.jsp");
				}
			}
			rs.forward(request, response);
	}
}
