package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.UserDao;

@WebServlet("/UserDeleteController")
public class UserDeleteController extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int userId = Integer.parseInt(request.getParameter("userid"));
			UserDao dao= new UserDao();
			if(dao.deleteUser(userId)) {
				request.setAttribute("Msg", "<font color = 'green'>Data Deleted</font>");
			}else {
				request.setAttribute("Msg", "<font color = 'red'>SMW in Delete Controller</font>");
			}
			request.getRequestDispatcher("ListUserController").forward(request, response);
	}
}
