<%@page import="java.util.Iterator"%>
<%@page import="com.item.model.ItemRegister"%>
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
		ArrayList<ItemRegister> r = (ArrayList)request.getAttribute("list");
	%>
	
	<table>
		<tr>
			<td>Item Id</td>
			<td>Item Name</td>
			<td>Item Price</td>
			<td>Company Name</td>
		</tr>
		
		<%
			for(Iterator<ItemRegister> iterator = r.iterator(); iterator.hasNext();){
				ItemRegister ir = (ItemRegister) iterator.next();
		%>
		
		<tr>
			<td><%=ir.getIid() %></td>
			<td><%=ir.getIname() %></td>
			<td><%=ir.getIprice() %></td>
			<td><%=ir.getCname() %></td>
			<td><a href = "ItemUpdateServlet?Iid=<%=ir.getIid()%>">Update Item</a></td>
		</tr>
		
		<%
			}
		%>
	</table>
</body>
</html>