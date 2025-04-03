package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.Book;
import com.vbc.servlet.management.service.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateBookController extends HttpServlet {
    private static final BookService bookService = new BookService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bid"));
        Book book = bookService.getBookById(bookId);

        if (book != null) {
            request.setAttribute("book", book);
            request.getRequestDispatcher("/views/update-book.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/ViewBookController?error=book_not_found");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                response.sendRedirect(request.getContextPath() + "/ViewBookController?updated=true");
            } else {
                request.setAttribute("errorMessage", "Book update failed");
                request.getRequestDispatcher("/views/update-book.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/ViewBookController?error=invalid_id");
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("------- Inside UpdateBookController service() method ---------");
        super.service(request, response);
    }

    public void destroy() {
        System.out.println("------- Inside UpdateBookController destroy() method ---------");
        super.destroy();
    }
}
