package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.ProductBean;
import com.bean.UserBean;
import com.util.DBConnection;

public class ProductDao {
	public void insertProduct(ProductBean productBean) {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into productdata (productname,price,quantity) values (?,?,?)");
			pstmt.setString(1, productBean.getProductName());
			pstmt.setInt(2, productBean.getPrice());
			pstmt.setInt(3, productBean.getQuantity());
			int records = pstmt.executeUpdate();
			
			System.out.println(records+" records inserted");
		} catch (SQLException e) {
			System.out.println("SMW in catch insertdao ");
			e.printStackTrace();
		}
				
	}
	public ArrayList<ProductBean> getAllProducts() {
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
			try {
				Connection conn= DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from productdata");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					ProductBean productBean = new ProductBean();
					productBean.setProductId(rs.getInt("productid"));
					productBean.setProductName(rs.getString("productname"));
					productBean.setPrice(rs.getInt("price"));
					productBean.setQuantity(rs.getInt("quantity"));
					productBean.setImgUrl(rs.getString("imgurl"));
					products.add(productBean);
				}
			}
			catch (Exception e) {
				System.out.println("SWM in catch of getallproduct");
				e.printStackTrace();
			}
			return products;
	}
	public boolean deleteProduct(int productId) {
		boolean flag = false;
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from productdata where productid = ? ");){
				pstmt.setInt(1, productId);
				int deleteProduct = pstmt.executeUpdate();
				if(deleteProduct==1) {
					flag = true;
					System.out.println("Product Deleted");
				}
		}catch (Exception e) {
			System.out.println("SMW in delete Product Catch");
			e.printStackTrace();
		}
		return flag;
		
	}
	public ProductBean getAllProductById(int productId) {
		ProductBean productBean = null;
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from productdata where productid=?");){
			pstmt.setInt(1, productId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				productBean = new ProductBean();
				productBean.setProductId(productId);
				productBean.setProductName(rs.getString("productname"));
				productBean.setPrice(rs.getInt("price"));
				productBean.setQuantity(rs.getInt("quantity"));
			}
		} catch (Exception e) {
			System.out.println("SMW in GetAllProduct");
			e.printStackTrace();
		}
		return productBean;
		
	}
	public boolean updateProduct(ProductBean productBean) {
		boolean flag = false;
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("update productdata set productname=?,price=?,quantity=? where productid=?");){
			pstmt.setString(1, productBean.getProductName());
			pstmt.setInt(2, productBean.getPrice());
			pstmt.setInt(3, productBean.getQuantity());
			pstmt.setInt(4, productBean.getProductId());
			int updaterecord = pstmt.executeUpdate();
			if(updaterecord==1) {
				flag = true;
			}
		} catch (Exception e) {
			System.out.println("Smw in update product");
			e.printStackTrace();
		}
		return flag;
		
	}
}
