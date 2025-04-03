<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.vbc.servlet.management.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Users</title>
    <script type="text/javascript">
        function showStatusMessage() {
            const urlParams = new URLSearchParams(window.location.search);
            if(urlParams.has('deleted') && urlParams.get('deleted') === 'true') {
                alert('User deleted successfully!');
                window.history.replaceState({}, document.title, window.location.pathname);
            }
            if(urlParams.has('updated') && urlParams.get('updated') === 'true') {
                alert('User updated successfully!');
                window.history.replaceState({}, document.title, window.location.pathname);
            }
        }

        function confirmDelete(form) {
            if(confirm('Are you sure you want to delete this user?')) {
                form.submit();
            }
            return false;
        }
    </script>
</head>
<body onload="showStatusMessage()">
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
    <table border="1" width="50%" cellspacing="0" cellpadding="3">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        <%
            for (User user : users) {
        %>
        <tr>
            <td><%= user.getUid() %></td>
            <td><%= user.getUname() %></td>
            <td><%= user.getEmail() %></td>
            <td>
                <form action="UpdateUserController" method="get" style="display:inline;">
                    <input type="hidden" name="uid" value="<%= user.getUid() %>">
                    <button type="submit">Update</button>
                </form>
                <form action="DeleteUserController" method="post" style="display:inline;" onsubmit="return confirmDelete(this)">
                    <input type="hidden" name="uid" value="<%= user.getUid() %>">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
<%
    } else {
%>
    <p>No users available.</p>
<%
    }
%>

<br>
<div>
    <button onclick="location.href='index.html'">Back to Home</button>
</div>
</body>
</html>
