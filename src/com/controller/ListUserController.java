package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/ListUserController")
public class ListUserController extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		ArrayList<UserBean> usersList = dao.getAllUsers();
		request.setAttribute("usersList", usersList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListUsers.jsp");
		dispatcher.forward(request, response);
	}
}
