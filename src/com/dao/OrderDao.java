package com.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CartProductBean;
import com.bean.OrderBean;
import com.bean.OrderDetailBean;
import com.util.DBConnection;

public class OrderDao {
	public void placeOrder(int userId)
	{
		CartDao cartDao = new CartDao();
		ArrayList<CartProductBean> carts = cartDao.getAllCartItem(userId);
		int total = 0;
		for(CartProductBean bean : carts) {
			total = total + bean.getPrice();
		}
		try{
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into orders (userid,amount,orderstatus,paymentmode,paymentstatus) values(?,?,?,?,?)",java.sql.Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, total);
			pstmt.setString(3, "placed");
			pstmt.setString(4, "COD");
			pstmt.setString(5, "pending");
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			rs.next();
			int orderId = rs.getInt("orderid");
			System.out.println("OrderId=> "+orderId);
			cartDao.emptyCart(carts.get(0).getUserId());
			System.out.println("Cart doubt "+carts.get(0).getUserId());
			
			OrderDetailDao orderDetailDao = new OrderDetailDao();
			for(CartProductBean cartProductBean:carts) {
				OrderDetailBean orderDetailBean = new OrderDetailBean();
				orderDetailBean.setProductId(cartProductBean.getProductId());
				orderDetailBean.setOrderId(orderId);
				orderDetailBean.setPrice(cartProductBean.getPrice());
				orderDetailDao.addOrderDetail(orderDetailBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<OrderBean> getMyorders(int userId){
		
		ArrayList<OrderBean> orders = new ArrayList<OrderBean>();
		
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from orders where userid = ?")){
			pstmt.setInt(1, userId);
			ResultSet rs  = pstmt.executeQuery();
			while(rs.next()) {
				OrderBean orderBean = new OrderBean();
				orderBean.setUserId(rs.getInt("userid"));
				orderBean.setAmount(rs.getInt("amount"));
				orderBean.setOrderId(rs.getInt("orderid"));
				orderBean.setOrderStatus(rs.getString("orderstatus"));
				orderBean.setPaymentStatus(rs.getString("paymentstatus"));
				orderBean.setPaymentMode(rs.getString("paymentmode"));
				orders.add(orderBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
		
	}
}
