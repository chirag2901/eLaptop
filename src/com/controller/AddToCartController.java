package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.CartBean;
import com.dao.CartDao;

@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productid"));
		HttpSession httpSession =  request.getSession();
		int userId = (Integer)httpSession.getAttribute("userId");
		CartBean bean = new CartBean();
		bean.setProductId(productId);
		bean.setUserId(userId);
		CartDao cartDao = new CartDao();
		cartDao.addToCart(bean);
		response.sendRedirect("CustomerListProductController");
	}
}
