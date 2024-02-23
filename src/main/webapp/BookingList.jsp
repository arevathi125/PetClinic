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
<%List<DoctorClinic> bookings = (List<DoctorClinic>)request.getAttribute("BookingList"); %>
 <tr> 
<th>Owner Name</th>
<th>Pet Name</th>
<th>Doctor Name</th>
<th>Booking Status</th>
</tr>
<%for(DoctorClinic list: bookings){ %>

 <tr><td><%= list.getOwnerName() %></td>
 <td><%= list.getPetName() %></td> 
 <td><%= list.getDoctorName() %></td>
 <td>Booked</td>
</tr>
<%} %>
</table>
</body>
</html>