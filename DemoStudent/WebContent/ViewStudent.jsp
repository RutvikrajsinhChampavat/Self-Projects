<%@page import="java.util.Iterator"%>
<%@page import="com.student.model.Register"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Data</title>
</head>
<body>
	
	<%ArrayList<Register> r = (ArrayList)request.getAttribute("list");%>
	
	<table>
		<tr>
			
			<td>Student Name</td>
			<td>Standard</td>
			<td>Class</td>
			<td>Roll Number</td>
			<td>Enrollment Number</td>
			<td>Password</td>
		</tr>
		<%
			for(Iterator<Register> iterator = r.iterator(); iterator.hasNext();){
				Register reg = (Register) iterator.next();
		%>
		<tr>
			<td><%=reg.getSname()%></td>
			<td><%=reg.getStd() %></td>
			<td><%=reg.getCls() %></td>
			<td><%=reg.getRno() %></td>
			<td><%=reg.getEno() %></td>
			<td><%=reg.getPword() %></td>
			<td><a href = "StudentUpdateServlet?Sid=<%=reg.getSid()%>">Update Student</a></td>
		</tr>
		
		<% } %>
	</table>
	
</body>
</html>