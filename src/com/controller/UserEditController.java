package com.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/UserEditController")
public class UserEditController extends HttpServlet{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		int userId = 0;
		if(!id.equals("") || !id.equals(null)) {
			userId = Integer.parseInt(id);
		}
		UserDao userDao = new UserDao();
		UserBean userBean = userDao.getUserById(userId);
		request.setAttribute("userBean", userBean);
		request.getRequestDispatcher("UserEdit.jsp").forward(request, response);
		
	}		
}
