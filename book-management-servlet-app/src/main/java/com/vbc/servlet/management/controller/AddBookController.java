package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.Book;
import com.vbc.servlet.management.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AddBookController extends HttpServlet {
    private static final BookService bookService = new BookService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("------- Inside the service() method ---------");
        this.doPost(request, response);
    }

    public void destroy() {
        System.out.println("------- Inside the destroy() method ---------");
    }
}
