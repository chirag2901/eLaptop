<%@page import="com.bean.UserBean"%>
<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>
	<%UserBean user = (UserBean)request.getAttribute("users"); %>
		<h2>Admin Dashboard</h2>
	<h4>Welcome <%=user.getFirstName()%>  in the Admin desk</h4>
	

</body>
</html>