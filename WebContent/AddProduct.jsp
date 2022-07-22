<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddProduct</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
</head>
<body>
<jsp:include page="AdminHeader.jsp"></jsp:include>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-4"></div>
				<div class="col-md-4">
					<h2>AddProduct</h2>
	<form action="AddProductController" method="post">
		<div class="form-group">
			ProductName:<input type="text" name = "productName" class="form-control" value="${productName }"/>${productNameError }
		 </div>
		 <div class="form-group">
			Price:<input type="text" name = "price" class="form-control" value="${price }"/>${priceError}
		 </div>
		 <div class="form-group">
			Quantity:<input type="text" name = "quantity" class="form-control" value="${quantity }"/>${quantityError }
		 </div>
		 <button class="btn btn-primary" type="submit" >Submit</button>
<input type="reset" class="btn btn-danger" value="Reset"/>
	</form>
		</div>
	</div>
</div>
</body>
</html>