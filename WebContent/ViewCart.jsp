<%@page import="com.bean.CartProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.ProductBean"%>
<%@page import="com.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carts</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
</head>
<body>

<jsp:include page="UserMenu.jsp"></jsp:include>
${Msg }
<%
	ArrayList<CartProductBean> carts = (ArrayList<CartProductBean>) request.getAttribute("carts");

%>
<div class="container-fluid">
<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6">
	<h2>My Cart</h2>
<table id="products" class="hover" style="width:100%">
		<thead>
			<tr>
			<th>ProductId</th>
			<th>ProductName</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		</thead>
					<tbody>	
			

	<%
		int total =0;
	
			for (CartProductBean cart : carts) {
				total = total + cart.getPrice();
		%>	
			<tr>
			<td><%=cart.getProductId()%></td>
			<td><%=cart.getProductName()%></td>
			<td><%=cart.getPrice()%></td>
			<td><a href="DeleteCartController?cartid=<%=cart.getCartId()%>" class="btn btn-outline-danger btn-sm" >Delete</a>
		</tr>
		
		<%
			}
		%>
		</tbody>
	</table>
	<h2>
		Total = <%=total %>
	</h2>
	<a href="CheckoutController" class="btn btn-success">CheckOut - Place order</a>
		</div>
   </div>
</div>


</body>
</html>