package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.OrderBean;
import com.dao.OrderDao;

/**
 * Servlet implementation class CheckoutController
 */
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		int userId = (Integer) httpSession.getAttribute("userId");
		//order
		OrderDao dao = new OrderDao();
		dao.placeOrder(userId);
		
		response.sendRedirect("OrderSuccessPlace.jsp");
	}

}
