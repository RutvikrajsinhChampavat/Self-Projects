<%@page import="com.student.model.Register"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Register r = (Register)request.getAttribute("student"); %>
	<form action="RegisterServlet" method = "post">
		Id<input type = "hidden" name="sid" value ="<%=r.getSid()%>">
		User Name<input type = "text" name = "username" value="<%=r.getUname() %>"><br>
		Password<input type="text" name="password" value="<%= r.getPassword() %>"><br>
		Email Address<input type="text" name="mail" value = "<%=r.getEmail()%>"><br>
		Contact Number<input type="text" name="cnumber" value = "<%=r.getCnumber()%>"><br>
		<input type="submit" name="register" value = "Update">
	
	</form>
</body>
</html>