<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Owner Page</title>
</head>
<body>
<form action="update">
 Owner Id<input type="text" readonly name="id" value="<%=request.getParameter("id") %>"><br> 
 Owner Name to be updated<input type="text"  name="ownerName" ><br>
 <input type="submit" value="update">
</form>

</body>
</html>