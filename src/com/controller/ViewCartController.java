package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartProductBean;
import com.dao.CartDao;

/**
 * Servlet implementation class ViewCartController
 */
public class ViewCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession = request.getSession();
		int userId = (Integer) httpSession.getAttribute("userId");
		CartDao cartDao = new CartDao();
		
		ArrayList<CartProductBean> carts = cartDao.getAllCartItem(userId);
		request.setAttribute("carts", carts);
		request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
		
	}


	
}
