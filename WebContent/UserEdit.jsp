<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserEdit</title>
<style type="text/css">
.error {
	color: red;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<%
	UserBean user = (UserBean)request.getAttribute("userBean");
	String genderValue = user.getGender();
%>
<div class="container-fluid">

<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
	<h2>Edit User</h2>
<form method="post" action="UserUpdateController">
<div class="form-group">
	<input type="hidden" name="userId" value="${userBean.userId}" class="form-control"/>
		</div>
		 
	<div class="form-group">
	FirstName:<input type="text" name="firstName" value="${userBean.firstName}" class="form-control"/>
		</div>
			<div class="form-group">
	LastName:<input type="text" name="lastName" value="${userBean.lastName }" class="form-control"/>
			</div>
		<div class="form-group">		
	Email:<input type="email" name="email" value="${userBean.email }" class="form-control"/>
		
	</div>
		<div class="form-group">
	Password:<input type="password" name="password" value="${userBean.password}" class="form-control"/>
	
	</div>
		<div class="form-group">
	Gender:
		Male<input type="radio" name="gender" value="male"  <%= genderValue!=null && genderValue.equals("male")?"checked":""%> />
		Female<input type="radio" name="gender" value="female" <%= genderValue!=null && genderValue.equals("female")?"checked":""%>/>
	
		
			</div>
	<input type="submit" value="Update" class="btn btn-primary">	
	<input type="reset" class="btn btn-danger" value="Reset"/>
</form>

		</div>
	</div>
</div>
</body>
</html>