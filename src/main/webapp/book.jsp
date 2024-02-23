<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
</head>
<body>
<form action="displayBookingDetails">
Pet Owner Id<input type = "text" name = "ownerId"><br>
<input type="submit" value="Book">
<input type="hidden" name="doctorId" value ="<%=request.getParameter("id")%>">
</form>
</body>
</html>