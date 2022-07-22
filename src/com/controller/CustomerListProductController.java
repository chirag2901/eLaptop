package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

@WebServlet("/CustomerListProductController")
public class CustomerListProductController extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ProductDao productDao  = new ProductDao();
			ArrayList<ProductBean> products = productDao.getAllProducts();
			request.setAttribute("products",products);
			System.out.println("In CustomerListProduct Controller");
			RequestDispatcher rs = request.getRequestDispatcher("AllProducts.jsp");
			rs.forward(request, response);
		}
}
