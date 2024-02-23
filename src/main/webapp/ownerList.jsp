<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.example.demo.pojo.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owner List Page</title>
</head>
<body>
<table border="1">
<%List<Owner> owner = (List<Owner>)request.getAttribute("list"); %>
 <tr> 
<th>Owner Name</th>
<th>Pet Name</th>
<th>Pet Type</th>
<th>Pet Id</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%for(Owner list: owner){ %>

 <tr><td><%= list.getOwner_name() %></td> 
 <td><%= list.getPets().get(0).getPet_name() %></td>
<td><%= list.getPets().get(0).getPet_type() %></td>
<td><%= list.getPets().get(0).getPet_id() %></td>

<td><a href = "edit.jsp?id=<%= list.getId() %>">Edit</a></td> 
<td><a href = "delete?id=<%= list.getId() %>">Delete</a></td>
</tr>
<%} %>
</table>
</body>
</html>