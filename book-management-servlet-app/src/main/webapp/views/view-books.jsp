<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.vbc.servlet.management.model.Book" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Books</title>
</head>
<body>
    <h2>Book List</h2>

    <%
        String message = (String) request.getAttribute("message");
        List<Book> books = (List<Book>) request.getAttribute("books");

        if (message != null) {
    %>
        <p style="color:red;"><%= message %></p>
    <%
        } else if (books != null && !books.isEmpty()) {
    %>
        <table border="1" width="20%" cellspacing="0" cellpadding="3">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
            </tr>
            <%
                for (Book book : books) {
            %>
            <tr>
                <td><%= book.getBid() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
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
