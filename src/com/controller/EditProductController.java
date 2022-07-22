package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

@WebServlet("/EditProductController")
public class EditProductController extends HttpServlet{
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int productId = Integer.parseInt(request.getParameter("productid"));
			ProductDao dao = new ProductDao();
			ProductBean productBean = dao.getAllProductById(productId);
			request.setAttribute("productBean", productBean);
			request.getRequestDispatcher("EditProduct.jsp").forward(request, response);;
		}
}
