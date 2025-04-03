package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.Book;
import com.vbc.servlet.management.service.BookService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ViewBookController extends HttpServlet {
    private static final BookService bookService = new BookService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        List<Book> books = bookService.getAllBooks();

        if (books == null || books.isEmpty()) {
            request.setAttribute("message", "No books available in the system.");
        } else {
            request.setAttribute("books", books);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/view-books.jsp");
        dispatcher.forward(request, response);
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------- Inside the service() method ---------");
        doGet(request, response);
    }

    public void destroy() {
        System.out.println("------- Inside the destroy() method ---------");
    }
}
