<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.vbc.servlet.management.model.Book" %>
<!DOCTYPE html>
<html>
<head>
  <title>Update Book</title>
</head>
<body>
<h2>Update Book</h2>

<%
Book book = (Book) request.getAttribute("book");
if (book != null) {
%>
<form action="<%= request.getContextPath() %>/BookController?action=updateBook" method="post">
  <input type="hidden" name="bid" value="<%= book.getBid() %>">

  <label for="title">Title:</label>
  <input type="text" id="title" name="title" value="<%= book.getTitle() %>" required><br>

  <label for="author">Author:</label>
  <input type="text" id="author" name="author" value="<%= book.getAuthor() %>" required><br>

  <button type="submit">Update Book</button>
</form>
<%
} else {
%>
<p style="color:red;">Book not found.</p>
<%
}
%>

<br>
<button onclick="location.href='<%= request.getContextPath() %>/BookController?action=viewBooks'">Back to Book List</button>
</body>
</html>
