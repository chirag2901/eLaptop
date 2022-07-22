package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CartBean;
import com.bean.CartProductBean;
import com.util.DBConnection;

public class CartDao {
	public void addToCart(CartBean cartBean){
		try(Connection conn =  DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("insert into cart(userid,productid) values(?,?)");) {
				pstmt.setInt(1, cartBean.getUserId());
				pstmt.setInt(2, cartBean.getProductId());
				pstmt.executeUpdate();
				
			
		}catch (Exception e) {
			System.out.println("SMW in cath of cartDao");		
			e.printStackTrace();
		}
	}
	public ArrayList<CartProductBean>  getAllCartItem(int userId) {
			ArrayList<CartProductBean> carts = new ArrayList<CartProductBean>();
			try(Connection con = DBConnection.getConnection();
					PreparedStatement pstmt = con.prepareStatement("select p.productname,p.price,p.productid,c.userid,c.cartid from productdata p ,cart c where c.userid = ? and c.productid  = p.productid");
						
					){
				pstmt.setInt(1, userId);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					CartProductBean cartProductBean = new CartProductBean();
					cartProductBean.setProductName(rs.getString("productname"));
					cartProductBean.setPrice(rs.getInt("price"));
					cartProductBean.setProductId(rs.getInt("productid"));
					cartProductBean.setUserId(rs.getInt("userid"));
					cartProductBean.setCartId(rs.getInt("cartid"));
					carts.add(cartProductBean);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return carts;
			
	}
	public boolean deleteProduct(int cartId) {
		boolean flag = false;
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from cart where cartid = ? ");){
				pstmt.setInt(1, cartId);
				int deleteProduct = pstmt.executeUpdate();
				if(deleteProduct==1) {
					flag = true;
					System.out.println("Cart Deleted");
				}
		}catch (Exception e) {
			System.out.println("SMW in delete Cart Catch");
			e.printStackTrace();
		}
		return flag;
		
	}
	public void emptyCart(int userId) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from cart where userid = ? ");
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW CartDao::emptyCart()");
			e.printStackTrace();
		}
	}
}
	
