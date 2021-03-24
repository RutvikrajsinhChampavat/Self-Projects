<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		User Name <input type="text" name="username"><br> 
		Password <input type="password" name="password"><br> 
		Email Address <input type="text" name="email"><br> 
		Contact Number <input type="text" name="cnumber"><br> 
		<input type="submit" name="register" value="Register">
	</form>

	<a href="ViewStudent">View Data</a>

	<%
		if(request.getParameter("msg") != ""){
	%>

	<h3><%=request.getParameter("msg")  %></h3>
	<% 		
		}
	%>
	
</body>
</html>