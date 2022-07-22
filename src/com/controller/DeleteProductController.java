package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductDao;

@WebServlet("/DeleteProductController")
public class DeleteProductController extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int productId = Integer.parseInt(request.getParameter("productid"));
			ProductDao productDao = new ProductDao();
			if(productDao.deleteProduct(productId)) {
				request.setAttribute("Msg","<font color='green'>product Deleted</font>");
			}else {
				request.setAttribute("Msg","<font color='red'>product not Deleted</font>");
			}
			request.getRequestDispatcher("ListProductController").forward(request, response);
	}
}
