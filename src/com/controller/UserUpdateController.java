package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

@WebServlet("/UserUpdateController")
public class UserUpdateController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		int userId = Integer.parseInt(request.getParameter("userId"));
		UserBean userBean = new UserBean();
		userBean.setFirstName(firstName);
		userBean.setLastName(lastName);
		userBean.setEmail(email);
		userBean.setPassword(password);
		userBean.setGender(gender);
		userBean.setUserId(userId);
		UserDao userDao = new UserDao();
		if(userDao.updateUser(userBean)) {
			request.setAttribute("Msg", "<font color='green'>Updated Successfully</font>");
		}else {
			request.setAttribute("Msg","<font color='red'>SMW in UpdateUsers<font>");
		}
		request.getRequestDispatcher("ListUserController").forward(request, response);
	}
}
