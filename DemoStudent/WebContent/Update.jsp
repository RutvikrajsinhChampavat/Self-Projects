<%@page import="com.student.model.Register"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student</title>
</head>
<body>
	<%Register r = (Register)request.getAttribute("student");%>
	<h1>Update Student</h1>
	<form action="RegisterStudentServlet" method="post">
		<input type="hidden" name="sid" value="<%=r.getSid()%>">
		Student Name <input type="text" name="sname" value="<%=r.getSname() %>"><br>
		Standard <select name="std">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
				</select><br>
		Class <select name="class">
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="C">C</option>
			</select><br>
		Roll Number <input type="text" name="rno" value="<%=r.getRno()%>"><br>
		Enrollment Number <input type="text" name="eno" value="<%=r.getEno()%>"> (Standard + Class + Roll number)<br>
		Password <input type="password" name="pword" value="<%=r.getPword()%>"><br>
		<input type="submit" name="register" value="Update">
	</form>	
</body>
</html>