<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.bean.UserBean"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</head>
<body>
<%
	UserBean user = (UserBean)request.getAttribute("user");
	String name  = user.getFirstName();
%>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="CustomerListProductController">eLaptop</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="SignUp.jsp">SignUp <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item active">
        <a class="nav-link" href="Login.jsp">Login <span class="sr-only">(current)</span></a>
      </li> 
       <li class="nav-item active">
        <a class="nav-link" href="LogoutController">Logout <span class="sr-only">(current)</span></a>
    <!--   </li> <li class="nav-item active">
        <a class="nav-link" href="ListProductController">Products <span class="sr-only">(current)</span></a>
      </li> -->
      <li class="nav-item dropdown">
      <!--   <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a> -->
     <!--   <div class="dropdown show">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Dropdown link
  </a>

  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
    <a class="dropdown-item" href="#">Action</a>
    <a class="dropdown-item" href="#">Another action</a>
    <a class="dropdown-item" href="#">Something else here</a>
  </div>
</div> -->
      </li>
     <!--  <li class="nav-item active">
        <a class="nav-link" href="ListUserController">ListUsers<span class="sr-only">(current)</span></a>
      </li>
          <li class="nav-item active">
        <a class="nav-link" href="ListProductController">ListProducts<span class="sr-only">(current)</span></a>
      </li> -->
    </ul>
    <form class="form-inline my-2 my-lg-0">
    	      <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><%=name %></button>
    	
      
    </form>
  </div>
</nav>
</body>
</html>