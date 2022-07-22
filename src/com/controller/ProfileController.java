package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class ProfileController
 */
public class ProfileController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//List<UserBean> userList = new UserDao().getAllUsers();
		
//		request.setAttribute("userList", userList);	
		request.getRequestDispatcher("Profile.jsp").forward(request, response);
	
	}
}
