package com.vbc.servlet.management.service;

import com.vbc.servlet.management.model.Book;
import com.vbc.servlet.management.dao.BookDAO;

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
}
