<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.vbc.servlet.management.model.User" %>
<!DOCTYPE html>
<html>
<head>
  <title>Update User</title>
</head>
<body>
<h2>Update User</h2>

<%
User user = (User) request.getAttribute("user");
if (user != null) {
%>
<form action="<%= request.getContextPath() %>/UserController?action=updateUser" method="post">
  <input type="hidden" name="uid" value="<%= user.getUid() %>">

  <label for="uname">Name:</label>
  <input type="text" id="uname" name="uname" value="<%= user.getUname() %>" required><br>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" value="<%= user.getEmail() %>" required><br>

  <button type="submit">Update User</button>
</form>
<%
} else {
%>
<p style="color:red;">User not found.</p>
<%
}
%>

<br>
<button onclick="location.href='<%= request.getContextPath() %>/UserController?action=viewUsers'">Back to User List</button>
</body>
</html>
