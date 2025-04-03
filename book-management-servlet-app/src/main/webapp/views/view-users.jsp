<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.vbc.servlet.management.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Users</title>
</head>
<body>
    <h2>User List</h2>

    <%
        String message = (String) request.getAttribute("message");
        List<User> users = (List<User>) request.getAttribute("users");

        if (message != null) {
    %>
        <p style="color:red;"><%= message %></p>
    <%
        } else if (users != null && !users.isEmpty()) {
    %>
        <table border="1" width="30%" cellspacing="0" cellpadding="3">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
            </tr>
            <%
                for (User user : users) {
            %>
            <tr>
                <td><%= user.getUid() %></td>
                <td><%= user.getUname() %></td>
                <td><%= user.getEmail() %></td>
            </tr>
            <%
                }
            %>
        </table>
    <%
        }
    %>

    <br>
    <div>
        <button onclick="location.href='index.html'">Back to Home</button>
    </div>
</body>
</html>
