package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.OrderBean;
import com.dao.OrderDao;

/**
 * Servlet implementation class MyOrdersController
 */
public class MyOrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDao orderDao = new OrderDao();
		HttpSession httpSession = request.getSession();
		int userId = (Integer)httpSession.getAttribute("userId");
		ArrayList<OrderBean> orders = orderDao.getMyorders(userId);
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("MyOrders.jsp").forward(request, response);
	}

	
}
