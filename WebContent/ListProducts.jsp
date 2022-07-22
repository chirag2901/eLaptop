<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListProducts</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	<link rel="stylesheet"  
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">

</head>
<body>

<jsp:include page="AdminHeader.jsp"></jsp:include>
${Msg }
<%
	ArrayList<ProductBean> products = (ArrayList<ProductBean>) request.getAttribute("products");

%>
<div class="container-fluid">
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
<table id="products" class="hover" style="width:100%">
		<thead>
			<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Action</th>
		</tr>
		</thead>
					<tbody>	
			

	<%
			for (ProductBean product : products) {
		%>	
			<tr>
			<td><%=product.getProductId()%></td>
			<td><%=product.getProductName()%></td>
			<td><%=product.getPrice()%></td>
			<td><%=product.getQuantity()%></td>
			<td><a href="DeleteProductController?productid=<%=product.getProductId()%>" class="btn btn-outline-danger btn-sm" >Delete</a>
			<a href="EditProductController?productid=<%=product.getProductId()%>" class="btn btn-outline-success btn-sm">Update</a></td>
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
	    $('#products').DataTable();
	});</script>

</body>
</html>