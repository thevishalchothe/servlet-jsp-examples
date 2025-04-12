package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.Book;
import com.vbc.servlet.management.service.BookService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BookController extends HttpServlet {
    private static final BookService bookService = new BookService();

    // Handles book creation
    private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        boolean isAdded = bookService.addBook(book);

        if (isAdded) {
            response.sendRedirect("views/add-book-success.html");
        } else {
            PrintWriter writer = response.getWriter();
            writer.println("<html><body><h2>Failed to add book. Try again.</h2>");
            writer.println("<button onclick=\"location.href='add-book.html'\">Back</button>");
            writer.println("</body></html>");
        }
    }

    // Display all books
    private void viewBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        if (books == null || books.isEmpty()) {
            request.setAttribute("message", "No books available in the system.");
        } else {
            request.setAttribute("books", books);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/view-books.jsp");
        dispatcher.forward(request, response);
    }

    // Load book to update form
    private void editBookForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bid"));
        Book book = bookService.getBookById(bookId);

        if (book != null) {
            request.setAttribute("book", book);
            request.getRequestDispatcher("/views/update-book.jsp").forward(request, response);
        } else {
            response.sendRedirect("BookController?action=viewBooks&error=book_not_found");
        }
    }

    // Update book details
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int bookId = Integer.parseInt(request.getParameter("bid"));
            String title = request.getParameter("title");
            String author = request.getParameter("author");

            Book book = new Book();
            book.setBid(bookId);
            book.setTitle(title);
            book.setAuthor(author);

            boolean isUpdated = bookService.updateBook(book);

            if (isUpdated) {
                response.sendRedirect("BookController?action=viewBooks&updated=true");
            } else {
                request.setAttribute("errorMessage", "Book update failed");
                request.getRequestDispatcher("/views/update-book.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("BookController?action=viewBooks&error=invalid_id");
        }
    }

    // Delete book
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bid"));
        boolean isDeleted = bookService.deleteBook(bookId);

        if (isDeleted) {
            response.sendRedirect("BookController?action=viewBooks&deleted=true");
        } else {
            request.setAttribute("errorMessage", "Book not found or could not be deleted");
            request.getRequestDispatcher("/views/view-books.jsp").forward(request, response);
        }
    }

    // Central dispatcher
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---------------- BookController in service..");

        String action = request.getParameter("action");
        String method = request.getMethod();

        if ("addBook".equals(action) && "POST".equalsIgnoreCase(method)) {
            this.addBook(request, response);
        } else if ("viewBooks".equals(action) && "GET".equalsIgnoreCase(method)) {
            this.viewBooks(request, response);
        } else if ("editBook".equals(action) && "GET".equalsIgnoreCase(method)) {
            this.editBookForm(request, response);
        } else if ("updateBook".equals(action) && "POST".equalsIgnoreCase(method)) {
            this.updateBook(request, response);
        } else if ("deleteBook".equals(action) && "POST".equalsIgnoreCase(method)) {
            this.deleteBook(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown action: " + action);
        }
    }

    public void destroy() {
        System.out.println("---------------- BookController destroyed..");
    }
}
