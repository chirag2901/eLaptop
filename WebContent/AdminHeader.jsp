<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<style type="text/css">
.color{
	color: white;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="CustomerListProductController">AdminDash</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
        <li class="nav-item active">
        <a class="nav-link" href="SignUp.jsp">Add User<span class="sr-only">(current)</span></a>
      </li>
        <li class="nav-item active">
        <a class="nav-link" href="ListUserController">ListUsers<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="AddProduct.jsp">AddProduct<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="ListProductController">ListProducts<span class="sr-only">(current)</span></a>
      </li> 
     <li class="nav-item active">
        <a class="nav-link" href="LogoutController">Logout <span class="sr-only">(current)</span></a>
      </li>
      
     
    </ul>
    <form class="form-inline my-2 my-lg-0">
       	      <h4 class="color">Welcome ${users.firstName }<h4>
    
    </form>
  </div>
</nav>
</body>
</html>