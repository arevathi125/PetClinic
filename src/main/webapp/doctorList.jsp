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
<%List<DoctorClinic> doctor = (List<DoctorClinic>)request.getAttribute("list"); %>
 <tr> 
 <th>Doctor Id</th>
<th>Doctor Name</th>
<th>Availability Status</th>
<th>Cost</th>
<th>Book</th>
</tr>
<%for(DoctorClinic list: doctor){ %>

 <tr><td><%= list.getDoctorId() %></td>
 <td><%= list.getDoctorName() %></td> 
 <td><%= list.getAvailabilityStatus() %></td>
<td><%= list.getCost() %></td>

 <td><a href = "book.jsp?id=<%= list.getDoctorId() %>">Book</a></td> 

</tr>
<%} %>
</table>
</body>
</html>