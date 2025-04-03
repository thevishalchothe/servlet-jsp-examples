package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteBookController extends HttpServlet {
    private static final BookService bookService = new BookService();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int bookId = Integer.parseInt(request.getParameter("bid"));
        boolean isDeleted = bookService.deleteBook(bookId);

        if (isDeleted) {
            // Redirect to ViewBookController with success parameter
            response.sendRedirect(request.getContextPath() + "/ViewBookController?deleted=true");
        } else {
            request.setAttribute("errorMessage", "Book not found or could not be deleted");
            request.getRequestDispatcher("/view-books.jsp").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("------- Inside DeleteBookController service() method ---------");
        super.service(request, response); // Let the parent handle the request method routing
    }

    public void destroy() {
        System.out.println("------- Inside DeleteBookController destroy() method ---------");
        super.destroy();
    }
}