<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container-fluid">
<%
/* String firstNameError = (String)request.getAttribute("firstNameError") */
String emailError = (String)request.getAttribute("emailError");
String passwordError = (String)request.getAttribute("passwordError");
String genderError = (String)request.getAttribute("genderError");
String genderValue = (String)request.getAttribute("genderValue");
%>
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
	<h2>Signup</h2>
<form method="post" action="SignUpController">
	<div class="form-group">
	FirstName:<input type="text" name="firstName" value="${firstNameValue }" class="form-control"/>${firstNameError }
		</div>
			<div class="form-group">
	LastName:<input type="text" name="lastName" value="${lastNameValue }" class="form-control"/>${lastNameError }
			</div>
		<div class="form-group">		
	Email:<input type="email" name="email" value="${emailValue }" class="form-control"/>
		<%=emailError == null ? "":emailError %>
	</div>
		<div class="form-group">
	Password:<input type="password" name="password" value="${passwordValue }" class="form-control"/>
	<%= passwordError == null?"":passwordError %>
	</div>
		<div class="form-group">
	Gender:
		Male<input type="radio" name="gender" value="male"  <%= genderValue!=null && genderValue.equals("male")?"checked":""%> />
		Female<input type="radio" name="gender" value="female" <%= genderValue!=null && genderValue.equals("female")?"checked":""%>/>
	
			<span>
			class="error">
			<%=genderError == null?"":genderError %>
			</span>
			</div>
	<input type="submit" value="Signup" class="btn btn-primary">	
	<input type="reset" class="btn btn-danger" value="Reset"/>
</form>
<div>
	<a href="Login.jsp">Already Registered?</a>
</div>`
		</div>
	</div>
</div>
</body>
</html>