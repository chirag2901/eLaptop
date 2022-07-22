<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListUsers</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<link rel="stylesheet"  
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>

<%
	ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("usersList");

%>
${Msg }
<div class="container-fluid">
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
<table id="users" class="hover" style="width:100%">
		<thead>
			<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
			<th>Action</th>
		</tr>
		</thead>
				<tbody>

	<%
			for (UserBean user : users) {
		%>	
			<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getLastName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getGender()%></td>
			<td><a href="UserEditController?userid=<%=user.getUserId()%>" class="link-secondary">Update</a>
			<a href="UserDeleteController?userid=<%=user.getUserId()%>" class="link-secondary">Delete</a>
			</td>
		
	
 </tr>
		
		<%
			}
		%>
		</tbody>
	</table>
		</div>
   </div>
</div>
	<script type="text/javascript" 
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript" 
	src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
	$(document).ready(function () {
	    $('#users').DataTable();
	});</script>
</body>
</html>