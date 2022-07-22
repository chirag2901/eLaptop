package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CartDao;
import com.dao.ProductDao;

/**
 * Servlet implementation class DeleteCartController
 */
public class DeleteCartController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cartId = Integer.parseInt(request.getParameter("cartid"));
		CartDao cartDao = new  CartDao();
		if(cartDao.deleteProduct(cartId)) {
			request.setAttribute("Msg","<font color='green'>cart Deleted</font>");
		}else {
			request.setAttribute("Msg","<font color='red'>cart not Deleted</font>");
		}
		request.getRequestDispatcher("ViewCartController").forward(request, response);
	
	}

	

}
