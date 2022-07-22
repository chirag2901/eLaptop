<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
	<%
	String firstName = (String)request.getAttribute("firstNameValue");
	String lastName = (String)request.getAttribute("lastNameValue"); 
	String email = (String)request.getAttribute("emailValue");
	String password = (String)request.getAttribute("passwordValue");
	String gender = (String)request.getAttribute("genderValue");
	%>
		
		
		
	FirstName : <%=firstName%><br>
	LastName : <%=lastName %><br>
	Email : <%=email %><br>
	Gender : <%=gender %><br>
</body>
</html>