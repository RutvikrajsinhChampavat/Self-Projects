<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Student Login</h1>
	
	<form action="LoginServlet" method="post">
		Enrollment Number <input type="text" name="eno"><br>
		Enter Password <input type="password" name="pword"><br>
		<input type="submit" name="submit" value="Login">
	</form>
	
	<%
		if(request.getParameter("msg") != "")
		{
	%>
		<h3><%=request.getParameter("msg") %></h3>
	<%
		}
	%>
</body>
</html>