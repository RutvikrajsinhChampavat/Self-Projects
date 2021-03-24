<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ItemRegisterServlet" method = "post">
		Item Name<input type="text" name="iname"><br>
		Item Price<input type="text" name="iprice"><br>
		Company Name<input type="text" name="cname"><br>
		<input type="submit" name="register" value="Register">
	</form>
	
	<a href="ViewItem">View Item</a>
	
	<%
		if(request.getParameter("msg")  != "")
		{
	%>
		<h3><%=request.getParameter("msg") %></h3>
	<%
		}
	%>
</body>
</html>