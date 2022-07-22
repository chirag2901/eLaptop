<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<%-- <jsp:include page="UserMenu.jsp"></jsp:include> --%>
<jsp:include page="UserMenu.jsp"></jsp:include>
<%	
	
	UserBean user = (UserBean)request.getAttribute("users");

%>
<table class="table">
<h2>Profile</h2>
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
      <th scope="row"><%=user.getUserId() %></th>
      <td><%=user.getFirstName() %></td>
      <td><%=user.getLastName()%></td>
      <td><%=user.getEmail()%></td>
      <td><%=user.getGender()%></td>
    </tr>
      
</thead>

</table>
</body>
</html>