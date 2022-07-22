<%@page import="com.bean.OrderBean"%>
<%@page import="com.dao.OrderDao"%>
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

	<jsp:include page="UserMenu.jsp"></jsp:include>

<%
	ArrayList<OrderBean> orders = (ArrayList<OrderBean>) request.getAttribute("orders");

%>
<div class="container-fluid">
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
<table id="orders" class="hover" style="width:100%">
		<thead>
			<tr>
			<th>OrderId</th>
			<th>Amount</th>
			<th>PaymentMode</th>
			<th>PaymentStatus</th>
			<th>OrderStatus</th>
		</tr>
		</thead>
					<tbody>	
			

	<%
			for (OrderBean order : orders) {
		%>	
			<tr>
			<td><%=order.getOrderId()%></td>
			<td><%=order.getAmount()%></td>
			<td><%=order.getPaymentMode()%></td>
			<td><%=order.getPaymentStatus()%></td>
			<td><%=order.getOrderStatus()%></td>
			<td><a href="MyOrderDetailController?orderid=<%=order.getOrderId()%>">View Details</a></td>
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
	    $('#orders').DataTable();
	});</script>

</body>
</html>