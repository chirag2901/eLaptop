package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

@WebServlet("/UpdateProductController")
public class UpdateProductController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		int productId = Integer.parseInt(request.getParameter("productId"));
		int price =Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		ProductBean productBean = new ProductBean();
		productBean.setProductId(productId);
		productBean.setProductName(productName);
		productBean.setPrice(price);
		productBean.setQuantity(quantity);
		ProductDao productDao = new ProductDao();
		if(productDao.updateProduct(productBean)) {
			request.setAttribute("Msg", "<font color='green'>Product Updated Successfully</font>");
		}else {
			request.setAttribute("Msg", "<font color='red'>Something Occured in Update product Controller</font>");
		}
		request.getRequestDispatcher("ListProductController").forward(request, response);
	}
}
