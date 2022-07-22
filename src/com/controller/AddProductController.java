package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

@WebServlet("/AddProductController")
public class AddProductController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String productName = request.getParameter("productName");
				String eprice = request.getParameter("price");
				String equantity = request.getParameter("quantity");
				ProductBean productBean = new ProductBean();
				int price = 0;
				int quantity = 0;
				
				boolean isError = false;
				if(productName == null || productName.trim().length()==0) {
					isError = true;
					request.setAttribute("productNameError","<font color = 'red'>Please Enter Product Name</font>");
				}else {
					request.setAttribute("productName", productName);
				}
				if(eprice==null || eprice.trim().length()==0) {
					
					isError = true;
					 request.setAttribute("priceError","<font color = 'red'>Please Enter Product Price</font>");

				}
				else {
					
					 price = Integer.parseInt(eprice);
						request.setAttribute("price", price);

				}
				if(equantity==null || equantity.trim().length()==0) {
					
					isError = true;
					request.setAttribute("quantityError","<font color = 'red'>Please Enter Product Quantity</font>");

					 
				}
				else {
					 quantity = Integer.parseInt(equantity);
						request.setAttribute("quantity", quantity);

				}
//				if(price == null || price.trim().length()==0) {
//					isError = true;
//					request.setAttribute("priceError","<font color = 'red'>Please Enter Product Price</font>");
//				}else {
//					request.setAttribute("price", price);
//				}
//				if(quantity == null || quantity.trim().length()==0) {
//					isError = true;
//					request.setAttribute("quantityError","<font color = 'red'>Please Enter Product Quantity</font>");
//				}else {
//					request.setAttribute("quantity", quantity);
//				}
				RequestDispatcher rs = null;
				if(isError) {
					rs = request.getRequestDispatcher("AddProduct.jsp");
				}else {
					ProductDao productDao = new ProductDao();
					productBean.setProductName(productName);
					productBean.setPrice(price);
					productBean.setQuantity(quantity);
					productDao.insertProduct(productBean);
					rs = request.getRequestDispatcher("ListProductController");
				}
				rs.forward(request, response);
	}		
	
}
