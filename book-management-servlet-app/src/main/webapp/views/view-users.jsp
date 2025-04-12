<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.vbc.servlet.management.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Users</title>
    <script type="text/javascript">
        // Function to show status messages
        function showStatusMessage() {
            const urlParams = new URLSearchParams(window.location.search);
            if (urlParams.get('deleted') === 'true') {
                alert('User deleted successfully!');
                window.history.replaceState({}, document.title, window.location.pathname);
            }
            if (urlParams.get('updated') === 'true') {
                alert('User updated successfully!');
                window.history.replaceState({}, document.title, window.location.pathname);
            }
        }

        // Confirmation before delete action
        function confirmDelete(form) {
            if (confirm('Are you sure you want to delete this user?')) {
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

    // Display message if any
    if (message != null) {
%>
    <p style="color:red;"><%= message %></p>
<%
    } else if (users != null && !users.isEmpty()) {
%>
    <table border="1" width="60%" cellspacing="0" cellpadding="5">
        <tr style="background-color: #f2f2f2;">
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
        <%
            // Loop through the users and display them
            for (User user : users) {
        %>
        <tr>
            <td><%= user.getUid() %></td>
            <td><%= user.getUname() %></td>
            <td><%= user.getEmail() %></td>
            <td>
                <!-- Update (Edit User Form) -->
                <form action="UserController" method="get" style="display:inline;">
                    <input type="hidden" name="action" value="editUser">
                    <input type="hidden" name="uid" value="<%= user.getUid() %>">
                    <button type="submit">Update</button>
                </form>

                <!-- Delete (Simulated via POST) -->
                <form action="UserController" method="post" style="display:inline;" onsubmit="return confirmDelete(this)">
                    <input type="hidden" name="action" value="deleteUser">
                    <input type="hidden" name="uid" value="<%= user.getUid() %>">
                    <input type="hidden" name="_method" value="DELETE">
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
