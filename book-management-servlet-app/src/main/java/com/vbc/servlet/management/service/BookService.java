package com.vbc.servlet.management.service;

import com.vbc.servlet.management.dao.BookDAO;
import com.vbc.servlet.management.model.Book;

import java.util.List;

public class BookService {
    private static final BookDAO bookDAO = new BookDAO();

    public boolean addBook(Book book) {
        return bookDAO.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    public boolean deleteBook(int bookId) {
        return bookDAO.deleteBook(bookId);
    }

    public Book getBookById(int bookId) {
        return bookDAO.getBookById(bookId);
    }

    public boolean updateBook(Book book) {
        try {
            return bookDAO.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
