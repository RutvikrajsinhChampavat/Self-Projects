<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<h1>Student Registration</h1>
	<form action="RegisterStudentServlet" method="post">
		Student Name <input type="text" name="sname"><br>
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
		Roll Number <input type="text" name="rno"><br>
		Enrollment Number <input type="text" name="eno"> (Standard + Class + Roll number)<br>
		Password <input type="password" name="pword"><br>
		<input type="submit" name="register" value="Register">
		<a href="Index.jsp">Login</a> 
	</form>
	
	<%
		if(request.getParameter("msg") != "")
		{
	%>
		<h3><%=request.getParameter("msg2") %></h3>
	<%
		}
	%>
</body>
</html>