<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="container-fluid">
<div class="row">
	<div class="col-md-4"></div>
	<div  class="col-md-4">
	<h2>Login</h2>
	<form action="LoginController" method="post">
	<div class="form-group">
	Email :  <input type="text" name="email" class="form-control" value="${email}"/>${emailError }
	</div>
	<div class="form-group">
	Password : <input type="password" name="password" class="form-control" value="${password}"/>${passwordError }
	</div>
	<input type="submit" value="Login" class="btn btn-primary"/>
	</form> 
	<div>
		<a href="SignUp.jsp">New user?</a>
	</div>
	<div>
		<a href="ForgotPassword.jsp">Forgot Password?</a>
	</div>
	<span class = "text-danger" >${errorMsg }</span><br>
	<span class = "text-danger" >${eMsg }</span>
		</div>
	</div>
</div>
	

 </form>
</body>
</html>