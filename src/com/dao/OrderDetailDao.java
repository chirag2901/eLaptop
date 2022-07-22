package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.OrderDetailBean;
import com.bean.OrderDetailProductBean;
import com.util.DBConnection;

public class OrderDetailDao {
	public void addOrderDetail(OrderDetailBean orderDetailBean) {
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into orderdetails (orderid,productid,price) values (?,?,?)");){
				pstmt.setInt(1, orderDetailBean.getOrderId());
				pstmt.setInt(2, orderDetailBean.getProductId());
				pstmt.setInt(3, orderDetailBean.getPrice());
				pstmt.executeUpdate();
		}catch (Exception e) {
				System.out.println("SWM in OrderDetailDao::addOrderDetail()");		
				e.printStackTrace();
		}
	}
	public ArrayList<OrderDetailProductBean> getOrderDetails(int orderId){
			ArrayList<OrderDetailProductBean> detailProductBeans = new ArrayList<OrderDetailProductBean>();
			try(Connection connection = DBConnection.getConnection();
					PreparedStatement pstmt = connection.prepareStatement("select p.imgurl,p.productname,od.orderdetailid,od.orderid,od.price,p.productid from orderdetails od , productdata p where p.productid = od.productid and od.orderid = ?")){
				pstmt.setInt(1, orderId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					OrderDetailProductBean orderDetailProductBean = new OrderDetailProductBean();
					orderDetailProductBean.setImgUrl(rs.getString("imgurl"));
					orderDetailProductBean.setOrderDetailId(rs.getInt("orderdetailid"));
					orderDetailProductBean.setOrderId(rs.getInt("orderid"));
					orderDetailProductBean.setPrice(rs.getInt("price"));
					orderDetailProductBean.setProductId(rs.getInt("productid"));
					orderDetailProductBean.setProductName(rs.getString("productname"));
					detailProductBeans.add(orderDetailProductBean);
				}
			}catch (Exception e) {
				System.out.println("Swm in OrderDetailDao::getOrderDetails()");			
				e.printStackTrace();
			}
		return detailProductBeans;
		
	}
}
