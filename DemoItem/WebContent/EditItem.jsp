<%@page import="com.item.model.ItemRegister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% ItemRegister ir = (ItemRegister)request.getAttribute("item");%>
	
	<form action="ItemRegisterServlet" method = "post">
		<input type="hidden" name="iid" value="<%=ir.getIid()%>">
		Item Name<input type="text" name="iname" value="<%=ir.getIname() %>"><br>
		Item Price<input type="text" name="iprice" value="<%=ir.getIprice() %>"><br>
		Company Name<input type="text" name="cname" value="<%=ir.getCname()%>"><br>
		<input type="submit" name="register" value="Update">
	</form>
</body>
</html>