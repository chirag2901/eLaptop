package com.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.bean.UserBean;
import com.util.DBConnection;

public class UserDao {
	public void insertUser(UserBean userBean) {
			try {
				Connection conn = DBConnection.getConnection();

				PreparedStatement pstmt = conn.prepareStatement("insert into userdata (firstname,lastname,email,password,gender,usertype) values (?,?,?,?,?,?)");
				pstmt.setString(1,userBean.getFirstName());
				pstmt.setString(2, userBean.getLastName());
				pstmt.setString(3, userBean.getEmail());
				pstmt.setString(4,userBean.getPassword());
				pstmt.setString(5, userBean.getGender());
				pstmt.setString(6, userBean.getUserType());
				int records = pstmt.executeUpdate();
				
				System.out.println(records+"Record Inserted");
			} catch (SQLException e) {
				System.out.println("SMW in insertUser() in UserDao");
				e.printStackTrace();
			}
	}
	public ArrayList<UserBean> getAllUsers() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			Connection connection = DBConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from userdata");
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				UserBean bean = new UserBean();
				bean.setUserId(rs.getInt("userid"));
				bean.setFirstName(rs.getString("firstname"));
				bean.setLastName(rs.getString("lastname"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setGender(rs.getString("gender"));
				users.add(bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
		
	}
	public UserBean login(String email,String password){
				UserBean userBean  = null;
			try {
				Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement("select * from userdata where email = ? and password = ?");
				pstmt.setString(1,email);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					userBean = new UserBean();
					userBean.setUserId(rs.getInt("userid"));
					userBean.setFirstName(rs.getString("firstname"));
					userBean.setUserType(rs.getString("usertype"));
					userBean.setLastName(rs.getString("lastname"));
					userBean.setEmail(rs.getString("email"));
					userBean.setGender(rs.getString("gender"));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userBean;
		
		}
	public UserBean getUserById(int userId) {
		UserBean userBean = null;

		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from userdata where userid = ?");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userBean = new UserBean();
				userBean.setUserId(userId);
				userBean.setFirstName(rs.getString("firstname"));
				userBean.setLastName(rs.getString("lastname"));
				userBean.setEmail(rs.getString("email"));
				userBean.setPassword(rs.getString("password"));
				userBean.setGender(rs.getString("gender"));
			}
		}catch (Exception e) {
			System.out.println("SMW in catch getallUserById");
		}
		return userBean;
		
	}
	public boolean updateUser(UserBean userBean) {
		boolean flag = false;
		try(	Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("update userdata set firstname = ?,lastname = ?,gender = ?,email=?,password=? where userid = ?");
				){
				pstmt.setString(1, userBean.getFirstName());
				pstmt.setString(2, userBean.getLastName());
				pstmt.setString(3, userBean.getGender());
				pstmt.setString(4, userBean.getEmail());
				pstmt.setString(5, userBean.getPassword());
				pstmt.setInt(6, userBean.getUserId());
				int updateCount = pstmt.executeUpdate();
				if(updateCount==1){
					flag = true;
					System.out.println("Updated");
				}
		}catch (Exception e) {
			System.out.println("SMW in updateuser");
			e.printStackTrace();
		}
		return flag;
		
	}
	public boolean deleteUser(int userId) {
		boolean flag = false;
		try(Connection conn = DBConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("delete from userdata where userid = ?");){
					pstmt.setInt(1, userId);
					int deleterow = pstmt.executeUpdate();
					if(deleterow==1) {
						flag = true;
					}
			
		}catch (Exception e) {
			System.out.println("SMW in Delete User");
		}
		return flag;
	}
}
