<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="UserMenu.jsp"></jsp:include>


<%-- <h2>Customer Details</h2>
<h3>${users.firstName }</h3>
<h3>${users.lastName }</h3> --%>
<table class="table">
<h2>Customer Details</h2>
<thead>
	<tr>
	 <th scope="col">userId</th>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Email</th>
      <th scope="col">Gender</th>
	</tr>
	 <tbody>
    <tr>
      <th scope="row">${users.userId }</th>
      <td>${users.firstName }</td>
      <td>${users.lastName }</td>
      <td>${users.email }</td>
      <td>${users.gender }</td>
    </tr>
      
</thead>

</table>
	
</body>
</html>