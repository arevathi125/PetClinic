<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "insertDoctor">
<table>
<h2>Appointment Booking Page</h2>
<tr><td>Doctor Name</td><td><input type = "text" name = "doctorName"></td></tr><br>
<tr><td>Availability Status</td><td><input type = "text" name = "availability"></td></tr><br>
<tr><td>Cost</td><td><input type = "text" name = "cost"></td></tr><br>
<tr><td></td><td><input type="submit" value="Add Doctor"></td></tr>
</table>
</form>
</body>
</html>