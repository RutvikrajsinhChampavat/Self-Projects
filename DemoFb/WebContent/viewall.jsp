<%@page import="java.util.Iterator"%>
<%@page import="com.student.model.Register"%>
<%@page import="java.util.List"%>
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
	<%
	ArrayList<Register> r = (ArrayList) request.getAttribute("list");
	%>
	<table>
		<tr>
			<td>User Name</td>
			<td>Password</td>
			<td>Email Address</td>
			<td>Contact Number</td>
		</tr>

		<%
		for (Iterator<Register> iterator = r.iterator(); iterator.hasNext();) {
			Register register = (Register) iterator.next();
		%>
		<tr>
			<td><%=register.getSid()%></td>
			<td><%=register.getUname()%></td>
			<td><%=register.getPassword()%></td>
			<td><%=register.getEmail()%></td>
			<td><%=register.getCnumber()%></td>
			<td><a href = "UpdateServlet?sid=<%=register.getSid()%>">Update Students</a></td>

		</tr>
		<%
		}
		%>


	</table>
</body>
</html>