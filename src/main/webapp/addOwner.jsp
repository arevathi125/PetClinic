<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Owner Page</title>
</head>
<body>
<form action = "insertOwner">
<table>
<h2>Owner Page</h2>
<tr><td>Owner Name</td><td><input type = "text" name = "ownerName"></td></tr><br>
<tr><td>Pet Name</td><td><input type = "text" name = "petName"></td></tr><br>
<tr><td>Pet Type: </td><td><select name="petType" id="petType"> 
  <option value="0">---</option>
  <option value="dog">Dog</option>
  <option value="cat">Cat</option>
  <option value="fish">Fish</option>
</select></td></tr><br>
         
<tr><td></td><td><input type="submit" value="Add Owner"></td></tr>
</table>
</form>
</body>
</html>